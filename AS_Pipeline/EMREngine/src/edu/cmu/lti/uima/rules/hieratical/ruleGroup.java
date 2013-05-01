package edu.cmu.lti.uima.rules.hieratical;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ruleGroup implements Serializable{
  List<rule> rules = null;
  Map<Integer,List<rule>> userCandidateRules = null;
  String centerSnowMed = null;
  
  ruleGroup(String concepId){
    centerSnowMed = new String(concepId);//may need to be changed to deep copy
    rules = new ArrayList<rule>();    
  }

  void addRule(rule r){
    rules.add(r);
  }

  void addUserCandidateRule(rule r,int seq){
    if(userCandidateRules==null){
      synchronized(this){
        if(userCandidateRules==null){
          userCandidateRules = new TreeMap<Integer,List<rule>>();
        } 
      }  
    }  
    List<rule> rs = userCandidateRules.get(seq);
    if(rs==null){
      rs = new ArrayList<rule>();
      userCandidateRules.put(seq, rs);
    }
    rs.add(r);
  }
  void usrCandidateClear(int seq){
    if(this.userCandidateRules==null)
      return;
    this.userCandidateRules.remove(seq);
  }

  ruleGroup getValidRuleGroupWithOnset(snowMedchecker checker){
    List<rule> rs = this.userCandidateRules.get(checker.getSeqNum());
    if(rs==null)
      return null;
    ruleGroup validGroup =  null;
    for(rule r:rs){
      if(r.userCheckList.get(checker.getSeqNum()).timeFound){
        if(validGroup==null){
          validGroup = new ruleGroup(this.centerSnowMed);
        }
        validGroup.addRule(r);
      }
      
    }
    return validGroup;
  }
  ruleGroup getValidRuleGroup(snowMedchecker checker){
    if(userCandidateRules==null)
      return null;
    List<rule> rs = this.userCandidateRules.get(checker.getSeqNum());
    if(rs==null)
      return null;
    ruleGroup validGroup = new ruleGroup(this.centerSnowMed);
    for(rule r:rs){
        validGroup.addRule(r);
    }
    return validGroup;
  }

}
