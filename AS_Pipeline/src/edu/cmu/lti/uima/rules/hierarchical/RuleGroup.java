package edu.cmu.lti.uima.rules.hierarchical;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RuleGroup implements Serializable{
  List<Rule> rules = null;
  Map<Integer,List<Rule>> userCandidateRules = null;
  String centerSnowMed = null;
  List<Rule> qualifiedRules = null;
  
  RuleGroup(String concepId){
    centerSnowMed = new String(concepId);//may need to be changed to deep copy
    rules = new ArrayList<Rule>();    
  }

  void addRule(Rule r){
    rules.add(r);
  }

  void addUserCandidateRule(Rule r,int seq){
    if(userCandidateRules==null){
      synchronized(this){
        if(userCandidateRules==null){
          userCandidateRules = new TreeMap<Integer,List<Rule>>();
        } 
      }  
    }  
    List<Rule> rs = userCandidateRules.get(seq);
    if(rs==null){
      rs = new ArrayList<Rule>();
      userCandidateRules.put(seq, rs);
    }
    rs.add(r);
  }
  void usrCandidateClear(int seq){
    if(this.userCandidateRules==null)
      return;
    this.userCandidateRules.remove(seq);
  }

  RuleGroup getValidRuleGroupWithOnset(SnowMedchecker checker){
    List<Rule> rs = this.userCandidateRules.get(checker.getSeqNum());
    if(rs==null)
      return null;
    RuleGroup validGroup =  null;
    for(Rule r:rs){
      if(r.timespec==null||r.userCheckList.get(checker.getSeqNum()).timeFound){
        if(validGroup==null){
          validGroup = new RuleGroup(this.centerSnowMed);
        }
        validGroup.addRule(r);
      }
      
    }
    return validGroup;
  }
  RuleGroup getValidRuleGroup(SnowMedchecker checker){
    if(userCandidateRules==null)
      return null;
    List<Rule> rs = this.userCandidateRules.get(checker.getSeqNum());
    if(rs==null)
      return null;
    RuleGroup validGroup = new RuleGroup(this.centerSnowMed);
    for(Rule r:rs){
        validGroup.addRule(r);
    }
    return validGroup;
  }
  
  RuleGroup getFuzzyValidRuleGroup(SnowMedchecker checker){
    if(userCandidateRules==null)
      return null;
    RuleGroup validGroup = new RuleGroup(this.centerSnowMed);
    validGroup.qualifiedRules = this.userCandidateRules.get(checker.getSeqNum());
    for(Rule r:this.rules){
        validGroup.addRule(r.getCopyForUser(checker));
    }
    return validGroup;
  }
  

}
