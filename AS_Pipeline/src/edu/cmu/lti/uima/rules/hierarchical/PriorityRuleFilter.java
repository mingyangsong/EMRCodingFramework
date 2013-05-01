package edu.cmu.lti.uima.rules.hierarchical;

import java.util.ArrayList;
import java.util.List;

public class PriorityRuleFilter extends CandidateRuleFilter {
  int priority = 0;
  PriorityRuleFilter(int p){
    priority = p;
  }
  PriorityRuleFilter(){
  }
  @Override
  RuleGroups selectCandidateRule(RuleGroups gs) {
    // TODO Auto-generated method stub
    RuleGroups fgs = new RuleGroups();
    RuleGroup fg = null;
    for(RuleGroup g:gs.RuleGroups){
      List<Rule> rs = null;
      if(priority==0){
        rs = new ArrayList<Rule>(); 
        int index = 0;
        int min = Integer.MAX_VALUE;
        //if(g.rules.size()>1)
          //System.out.println("hehe");
        if(g.qualifiedRules==null)
          continue;
         for(int i=0;i<g.qualifiedRules.size();i++){ 
            if (g.qualifiedRules.get(i).priority <= min){
              min = g.qualifiedRules.get(i).priority;
              index = i;
            }
          }
        rs.add(g.qualifiedRules.get(index));
      }
      else{
        for(Rule r:g.qualifiedRules){
          
          if (r.priority <= priority){
            if(rs ==null)
               rs = new ArrayList<Rule>(); 
            rs.add(r);
          }
        }
      }

        fg = new RuleGroup(g.centerSnowMed);
        fg.qualifiedRules = rs;
        fg.rules = g.rules;
        fgs.addRuleGroup(fg);
        
    }
    return fgs;
  }

}
