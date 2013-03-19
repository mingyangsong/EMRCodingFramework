package edu.cmu.lti.uima.rules.hieratical;

import java.util.ArrayList;
import java.util.List;

import edu.cmu.lti.uima.server.StandardOutput;

public class test3 implements Runnable {
	private static StandardOutput stdOut = StandardOutput.getInstance();
	List<snowMed> snow = null;
	hieraticalRule hr = null;

	test3(hieraticalRule hr) {
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
				stdOut.setString(r.ruleId + "" + r.rightside + " " + r.priority);
			}
		}

	}

}
