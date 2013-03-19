package edu.cmu.lti.uima.rules.hieratical;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import edu.cmu.lti.uima.server.StandardOutput;

public class snowMed implements Serializable {
	private static StandardOutput stdOut = StandardOutput.getInstance();
	boolean found;
	String conceptId;
	String description;
	// HashMap<period,List<rule>> timeinfo;
	List<period> timeinfo;
	List<rule> relatedRules = null;
	List<rule> timeRelatedRules = null;
	List<ruleGroup> relatedGroups = null;
	Map<Integer, Boolean> founds = null;

	public boolean isFound() {
		return found;
	}

	public void setFound(boolean found) {
		this.found = found;
	}

	public String getConceptId() {
		return conceptId;
	}

	public void setConceptId(String conceptId) {
		this.conceptId = conceptId;
	}

	public String getDescription() {
		return description;
	}

	public Map<Integer, Boolean> getFounds() {// fix me possible concurent
												// failure
		if (founds == null) {
			synchronized (this) {
				if (founds == null)
					founds = new TreeMap<Integer, Boolean>();
			}
		}
		return founds;
	}

	public void setFounds(Map<Integer, Boolean> founds) {
		this.founds = founds;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<period> getTimeinfo() {
		return timeinfo;
	}

	public void setTimeinfo(List<period> timeinfo) {

		this.timeinfo = timeinfo;
	}

	public void addTime(period timeinfo) {
		if (this.timeinfo == null)
			this.timeinfo = new ArrayList<period>();
		this.timeinfo.add(timeinfo);
	}

	public void addTimes(List<period> t) {
		for (int i = 0; i < t.size(); i++) {
			this.addTime(t.get(i));
		}
	}

	public List<rule> getRelatedRules() {
		return relatedRules;
	}

	public void setRelatedRules(List<rule> relatedRules) {
		this.relatedRules = relatedRules;
	}

	public void addRelatedRule(rule relatedRule) {
		if (relatedRules == null)
			relatedRules = new ArrayList<rule>();
		this.relatedRules.add(relatedRule);
	}

	public void addtimeRelatedRule(rule relatedRule) {
		if (timeRelatedRules == null)
			timeRelatedRules = new ArrayList<rule>();
		this.timeRelatedRules.add(relatedRule);
	}

	public void addRelatedGroup(ruleGroup g) {
		if (relatedGroups == null)
			relatedGroups = new ArrayList<ruleGroup>();
		this.relatedGroups.add(g);
	}

	public void checkSelf(List<period> onsets, snowMedchecker checker) {
		Boolean f = this.getFounds().get(checker.getSeqNum());
		if (f == null || f == false) {
			synchronized (this) {
				founds.put(checker.getSeqNum(), true);
			}
			checker.relatedSnowmeds.add(this);
			if (relatedRules != null) {
				for (rule r : relatedRules) {
					int currentNum = r.addFound(checker.getSeqNum());
					if (currentNum == r.threhold) {
						r.group.addUserCandidateRule(r, checker.getSeqNum());
					}
				}
			}
			if (timeRelatedRules != null) {
				for (rule r : timeRelatedRules) {
					int currentNum = r.addFound(checker.getSeqNum());
					if (currentNum == r.threhold) {
						r.group.addUserCandidateRule(r, checker.getSeqNum());
					}
				}
			}
		}

		if (onsets != null) {
			for (period t : onsets) {
				for (rule r : this.timeRelatedRules) {
					if (r.timespec.contains(t))
						r.timeFound(checker.getSeqNum());
				}
			}
		}
		checker.addCandidateGroups(this.relatedGroups);
	}

	void usrRelatedClear(int seq) {
		if (this.founds.remove(seq) == null) {
			stdOut.setString("error usrRelatedClear in snowMed");
		}
		;
	}
}
