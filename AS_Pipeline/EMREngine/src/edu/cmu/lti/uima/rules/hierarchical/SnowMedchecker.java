package edu.cmu.lti.uima.rules.hierarchical;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SnowMedchecker {
   private int seqNum;
   private boolean used =false;
   List<Rule> relatedRules;
   List<SnowMed> relatedSnowmeds;
   List<RuleGroup> candidateGroups;
   SnowMedchecker(){
     relatedRules = new ArrayList<Rule>();
     relatedSnowmeds = new ArrayList<SnowMed>();
     
   }
  public int getSeqNum() {
    return seqNum;
  }
  public void addCandidateGroups(List<RuleGroup> gs){
    if(candidateGroups==null){
      candidateGroups = new ArrayList<RuleGroup>();
    }
    for(RuleGroup g:gs){
      candidateGroups.add(g);
    }
  }
  public void setSeqNum(int seqNum) {
    if(!used){
      this.seqNum = seqNum;
      used = true;
    }
  }
  
}
