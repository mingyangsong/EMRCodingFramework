package edu.cmu.lti.uima.rules.hieratical;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ruleGroups implements Serializable {
  List<ruleGroup> RuleGroups;
  
  ruleGroups(){
    RuleGroups = new ArrayList<ruleGroup>();
  }
  int size(){
    return RuleGroups.size();
  }
  void addRuleGroup(ruleGroup group){
    if(group!=null)
      RuleGroups.add(group);
  }
  
  ruleGroups getValidRuleGroups(){
    
    return null;
  }
  
}
