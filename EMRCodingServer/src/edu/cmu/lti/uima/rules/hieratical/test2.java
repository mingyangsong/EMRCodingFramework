package edu.cmu.lti.uima.rules.hieratical;

import java.util.ArrayList;
import java.util.List;

import edu.cmu.lti.uima.server.StandardOutput;

public class test2 implements Runnable {
	private static StandardOutput stdOut = StandardOutput.getInstance();
	List<snowMed> snow = null;
	hieraticalRule hr = null;

	test2(hieraticalRule hr) {
		snow = new ArrayList<snowMed>();
		this.hr = hr;
	}

	void addSnowMed(snowMed m) {
		this.snow.add(m);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Object checker = hr.getChecker();
		for (snowMed m : snow) {
			hr.checkSnowMed(m, checker);
		}
		ruleGroups gs = hr.getValidRuleGroups(checker);
		priorityRuleFilter p = new priorityRuleFilter();
		gs = p.selectCandidateRule(gs);
		for (ruleGroup g : gs.RuleGroups) {
			for (rule r : g.rules) {
				if (!r.rightside.equals(""))
					stdOut.setString(r.timeRelatedSnowMed + "  " + r.ruleId
							+ "  " + r.rightside + "  " + r.priority);
				else
					stdOut.setString(r.timeRelatedSnowMed + "  " + r.ruleId
							+ "  No avalibale Rule priority:" + "  "
							+ r.priority);
			}
		}

	}

}
