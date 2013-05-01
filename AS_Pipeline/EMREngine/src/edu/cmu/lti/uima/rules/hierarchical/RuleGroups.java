package edu.cmu.lti.uima.rules.hierarchical;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class RuleGroups implements Serializable {
  List<RuleGroup> RuleGroups;
  
  RuleGroups(){
    RuleGroups = new ArrayList<RuleGroup>();
  }
  int size(){
    return RuleGroups.size();
  }
  void addRuleGroup(RuleGroup group){
    if(group!=null)
      RuleGroups.add(group);
  }
  
  RuleGroups getValidRuleGroups(){
    
    return null;
  }
  
}
