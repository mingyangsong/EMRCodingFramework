package edu.cmu.lti.uima.rules.hieratical;

import java.io.IOException;
import java.util.LinkedList;
import java.io.Serializable;

public class hieraticalRule implements Serializable {
  int maxUser = 100;
  int currentUser = 0;
  int changeCode = 0;
  String seqNumsLock = "";
  ruleGroups groups;
  ruleGroups cgroups;
  snowMedPool pool;
  LinkedList<Integer> avaliableSeqNum;
  hieraticalRule(){
    groups = new ruleGroups();
    pool = new snowMedPool();
    cgroups = new ruleGroups();
    avaliableSeqNum = new LinkedList<Integer>();
    for(int i=0;i<maxUser;i++){
      avaliableSeqNum.add(i);
    }
  }
  Object getChecker(){
    synchronized(this.seqNumsLock){
      if(!avaliableSeqNum.isEmpty()){
        snowMedchecker checker = new snowMedchecker();
        checker.setSeqNum(avaliableSeqNum.getFirst());
        avaliableSeqNum.removeFirst();
        return checker;
      }else
      return null;  
    } 
  }
  void readRulesThroughFile(String path) throws IOException{
    int numOfRules = 0;
    mapReader ruleParser = new mapReader(path);
    oneRowRule oneRow = new oneRowRule();
    int currentGroup = 0;
    String currentConcepId = "";
    ruleGroup group = null;
    int maxleft = 0;
    while(ruleParser.readOneLine(oneRow)){
      if (oneRow.extraleftDesc.size()>maxleft)
        maxleft = oneRow.extraleftside.size();
      //System.out.println(oneRow.conceptId+" "+oneRow.ruleId);
     
      if (!pool.doesContainsSnowmed(oneRow.conceptId)){
        snowMed m = new snowMed();
        m.setConceptId(oneRow.conceptId);
        m.setDescription(oneRow.conceptDesc);
        pool.addSnowMed(m);
      }
      
      for(int i=0;i<oneRow.extraleftside.size();i++){
        if (!pool.doesContainsSnowmed(oneRow.extraleftside.get(i))){
          snowMed m = new snowMed();
          m.setConceptId(oneRow.extraleftside.get(i));
          //System.out.println(oneRow.extraleftside.get(i));  
          m.setDescription(oneRow.extraleftDesc.get(i));
          pool.addSnowMed(m);
        }
      }
      
      if(currentGroup!=oneRow.group||!currentConcepId.equals(oneRow.conceptId)){
        groups.addRuleGroup(group);
        group = new ruleGroup(oneRow.conceptId);
        currentGroup = oneRow.group; 
        currentConcepId = oneRow.conceptId;
        if(!pool.addMappingGroup(currentConcepId,group)){
          System.out.println("error g");
        }
        
      }
      
      rule newRule = new rule();
      numOfRules++;
      //oneRow.extraleftSide.add(oneRow.conceptId);
      //oneRow.extraleftDesc.add(oneRow.c)
      newRule.addLeftsideSnow(oneRow.conceptId);
      newRule.addLeftsideSnows(oneRow.extraleftside);
      //newRule.setLeftside(oneRow.extraleftside);
      newRule.setRightside(oneRow.rightside);
      newRule.setRightsideDesc(oneRow.rightDesc);
      newRule.setThrehold(1 + oneRow.extraleftside.size());
      newRule.setPriority(oneRow.priority);
      newRule.setRuleId(oneRow.ruleId);
      newRule.setTimeRelatedSnowMed(oneRow.conceptId);//FIX ME current only think all center snow is time related
      newRule.setTimespec(oneRow.onset);
      newRule.setDescription(oneRow.ruleDesc);
      newRule.group = group;
      group.addRule(newRule);
      if (oneRow.onset!=null){
        if(!pool.addtimeRleatedMappingRule(newRule.timeRelatedSnowMed,newRule))
          System.out.println("error r2");
      }else{
        if(!pool.addMappingRule(newRule.timeRelatedSnowMed,newRule))
          System.out.println("error r2");
      }

      for(String m:newRule.leftside){
        //System.out.println(m);
        if(!m.equals(newRule.timeRelatedSnowMed)){
          if(!pool.addMappingRule(m,newRule))
            System.out.println("error r2");
        }
      }
    }
    pool.print();
    System.out.println("input: "+numOfRules+" rules");
    System.out.println("input: "+pool.size()+" snowMeds");
    System.out.println("intput: "+groups.size()+" groups");
    System.out.println("input: maxleftextra:"+maxleft);
    
  }
  ruleGroups getValidRuleGroups(Object ch){
    if (ch.getClass()!=snowMedchecker.class){
      System.out.println("error Class");
      return null;
    }
    snowMedchecker checker = (snowMedchecker)ch;
    ruleGroups rgs = new ruleGroups();
    for(ruleGroup g:checker.candidateGroups){
      rgs.addRuleGroup(g.getValidRuleGroup(checker));
    }
    clearCheck(checker);
    return rgs;
  }
  ruleGroups getValidRuleGroupsWithOnset(Object ch){
    if (ch.getClass()!=snowMedchecker.class){
      System.out.println("error Class");
      return null;
    }
    snowMedchecker checker = (snowMedchecker)ch;
    ruleGroups rgs = new ruleGroups();
    for(ruleGroup g:checker.candidateGroups){
      rgs.addRuleGroup(g.getValidRuleGroupWithOnset(checker));
    }
    clearCheck(checker);
    return rgs;
  }
  boolean checkSnowMed(snowMed snow,Object ch){
    if (ch.getClass()!=snowMedchecker.class){
      System.out.println("error Class");
      return false;
    }
    snowMedchecker checker = (snowMedchecker)ch;
    return pool.checkSnowMed(snow, checker);
  }
  
  void clearCheck(Object ch){
    if (ch.getClass()!=snowMedchecker.class){
      System.out.println("error Class");
      return;
    }
    snowMedchecker checker = (snowMedchecker)ch;
    synchronized(this.seqNumsLock){
      this.avaliableSeqNum.addLast(checker.getSeqNum());  
    }
    for(rule r:checker.relatedRules){
      r.usrClear(checker.getSeqNum());
    }
    for(snowMed m:checker.relatedSnowmeds){
      m.usrRelatedClear(checker.getSeqNum());
    }
    for(ruleGroup g:checker.candidateGroups){
      g.usrCandidateClear(checker.getSeqNum());
    }
  }
  boolean checkSnowMed(String conceptId){
    
    return true;
  }
  
  
}
