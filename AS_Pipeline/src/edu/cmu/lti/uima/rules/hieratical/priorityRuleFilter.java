package edu.cmu.lti.uima.rules.hieratical;

import java.util.ArrayList;
import java.util.List;

public class priorityRuleFilter extends candidateRuleFilter {
  int priority = 0;
  priorityRuleFilter(int p){
    priority = p;
  }
  priorityRuleFilter(){
  }
  @Override
  ruleGroups selectCandidateRule(ruleGroups gs) {
    // TODO Auto-generated method stub
    ruleGroups fgs = new ruleGroups();
    ruleGroup fg = null;
    for(ruleGroup g:gs.RuleGroups){
      List<rule> rs = null;
      if(priority==0){
        rs = new ArrayList<rule>(); 
        int index = 0;
        int min = Integer.MAX_VALUE;
         for(int i=0;i<g.rules.size();i++){ 
            if (g.rules.get(i).priority <= min){
              min = g.rules.get(i).priority;
              index = i;
            }
          }
        rs.add(g.rules.get(index));
      }
      else{
        for(rule r:g.rules){
          
          if (r.priority <= priority){
            if(rs ==null)
               rs = new ArrayList<rule>(); 
            rs.add(r);
          }
        }
      }

      if (rs!=null){
        fg = new ruleGroup(g.centerSnowMed);
        fg.rules = rs;
        fgs.addRuleGroup(fg);
      }  
    }
    return fgs;
  }

}
