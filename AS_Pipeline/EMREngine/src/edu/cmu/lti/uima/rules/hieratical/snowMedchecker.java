package edu.cmu.lti.uima.rules.hieratical;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class snowMedchecker {
   private int seqNum;
   private boolean used =false;
   List<rule> relatedRules;
   List<snowMed> relatedSnowmeds;
   List<ruleGroup> candidateGroups;
   snowMedchecker(){
     relatedRules = new ArrayList<rule>();
     relatedSnowmeds = new ArrayList<snowMed>();
     
   }
  public int getSeqNum() {
    return seqNum;
  }
  public void addCandidateGroups(List<ruleGroup> gs){
    if(candidateGroups==null){
      candidateGroups = new ArrayList<ruleGroup>();
    }
    for(ruleGroup g:gs){
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
