package edu.cmu.lti.uima.rules.hierarchical;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SnowMed implements Serializable {

    boolean found;
    String conceptId;
    String description;
    int startPos;
    int endPos;
    //HashMap<period,List<rule>> timeinfo;
    List<Period> timeinfo = null;
    List<Rule> relatedRules = null;
    List<Rule> timeRelatedRules = null;
    List<RuleGroup> relatedGroups = null;
    Map<Integer,SnoMedUserCheckInfo> userInfoList = null;
    ArrayList<Integer> starts;
    ArrayList<Integer> ends;
    public boolean isFound() {
      return found;
    }
    public void setFound(boolean found) {
      this.found = found;
    }

    public String getConceptId() {
      return conceptId;
    }
    public void setConceptId(String conceptId) {
      this.conceptId = conceptId;
    }
    public String getDescription() {
      return description;
    }
    
    public Map<Integer, SnoMedUserCheckInfo> getUserInfoList() {//fix me possible concurent failure
      if(userInfoList==null){
        synchronized(this){
          if(userInfoList==null)
            userInfoList = new TreeMap<Integer, SnoMedUserCheckInfo>();
        }
      }
      return userInfoList;
    }
    public void setDescription(String description) {
      this.description = description;
    }
    public List<Period> getTimeinfo() {
      return timeinfo;
    }
    public void setTimeinfo(List<Period> timeinfo) {
      
      this.timeinfo = timeinfo;
    }
    public void addTime(Period timeinfo) {
      if(this.timeinfo==null)
        this.timeinfo = new ArrayList<Period>();
        this.timeinfo.add(timeinfo);
    }

    public void addTimes(List<Period> t) {
      for(int i=0;i<t.size();i++){
        this.addTime(t.get(i));
      }
    }
    public List<Rule> getRelatedRules() {
      return relatedRules;
    }
    public void setRelatedRules(List<Rule> relatedRules) {
      this.relatedRules = relatedRules;
    }
    public void addRelatedRule(Rule relatedRule) {
      if (relatedRules == null)
        relatedRules = new ArrayList<Rule>();
      this.relatedRules.add(relatedRule);
    }
    public void addtimeRelatedRule(Rule relatedRule) {
      if (timeRelatedRules == null)
        timeRelatedRules = new ArrayList<Rule>();
      this.timeRelatedRules.add(relatedRule);
    }
    public void addRelatedGroup(RuleGroup g) {
      if (relatedGroups == null)
        relatedGroups = new ArrayList<RuleGroup>();
      this.relatedGroups.add(g);
    }
    public void checkSelf(List<Period> onsets,SnowMedchecker checker,int start, int end){
      SnoMedUserCheckInfo snowInfo = this.getUserInfoList().get(checker.getSeqNum());
      if(snowInfo==null){
        synchronized(this){
          snowInfo = new SnoMedUserCheckInfo();
          this.getUserInfoList().put(checker.getSeqNum(), snowInfo);
        }
      }
      snowInfo.getUserStartPos().add(start);
      snowInfo.getUserEndPos().add(end);
        
      if (snowInfo.found==false){
        snowInfo.found = true;
        checker.relatedSnowmeds.add(this);
        if(relatedRules!=null){
          for(Rule r:relatedRules){
            int currentNum = r.addFound(checker.getSeqNum(),this);
            if(currentNum==r.threhold){            
              r.group.addUserCandidateRule(r,checker.getSeqNum());
            } 
          }
        }

        if(timeRelatedRules!=null){
          for(Rule r:timeRelatedRules){
            int currentNum = r.addFound(checker.getSeqNum(),this);
            if(currentNum==r.threhold){            
              r.group.addUserCandidateRule(r,checker.getSeqNum());
            } 
          }
        }
        checker.addCandidateGroups(this.relatedGroups);
      }
      if (onsets!=null){
        for(Period t:onsets){
          for(Rule r:this.timeRelatedRules){
            if(r.timespec.contains(t))
              r.timeFound(checker.getSeqNum());
          }
        }
      }
      
    }
    void usrRelatedClear(int seq){
      if(this.userInfoList.remove(seq)==null){
        System.out.println("error usrRelatedClear in snowMed");
      };
    }
    SnowMed getCopy(SnowMedchecker c){
      SnowMed s = new SnowMed();
      s.conceptId = this.conceptId;
      s.description = this.description;
      s.ends = (ArrayList<Integer>) this.userInfoList.get(c.getSeqNum()).userEndPos;
      s.starts = (ArrayList<Integer>) this.userInfoList.get(c.getSeqNum()).userStartPos;
      if (s.ends==null||s.starts==null)
        System.out.println("error in snowmed getCopy");
      return s;
    }
    
}
