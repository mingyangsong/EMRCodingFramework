package edu.cmu.lti.uima.rules.hierarchical;

import java.util.ArrayList;
import java.util.List;

public class test2 implements Runnable{
  List<SnowMed> snow = null;
  HierarchicalRule hr =null;
  test2(HierarchicalRule hr){
    snow = new ArrayList<SnowMed>();
    this.hr =hr;
  }
  void addSnowMed(SnowMed m){
    this.snow.add(m);
  }
  @Override
  public void run() {
    // TODO Auto-generated method stub
    Object checker = hr.getChecker();
    for(SnowMed m:snow){
      hr.checkSnowMed(m,checker);
    }
    RuleGroups gs = hr.getValidRuleGroups(checker);
    PriorityRuleFilter p = new PriorityRuleFilter();
    gs= p.selectCandidateRule(gs);
    for(RuleGroup g: gs.RuleGroups){
      for(Rule r:g.rules){
        if(!r.rightside.equals(""))
          System.out.println(r.ruleId+" "+r.rightside+" priority:"+r.priority);
        else
          System.out.println(r.ruleId+" No avalibale Rule priority:"+r.priority);
      }
    }
  }

}
