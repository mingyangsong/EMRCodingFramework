package edu.cmu.lti.uima.rules.hierarchical;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Rule implements Serializable{
  int priority;
  List<String> leftside;
  String rightside;
  String rightsideDesc;
  String description;
  String ruleId;
  int howManyFound = 0;
  int threhold;
  String timeRelatedSnowMed;
  Period timespec;
  boolean timeFound = false;
  RuleGroup group;
  Map<Integer,RuleCheckInfo> userCheckList;
  List<SnowMed> snowMedFound = null;
  Rule(){
    leftside = new ArrayList<String>();
  }
  public Map<Integer, RuleCheckInfo> getUserCheckList() {
    if(userCheckList==null)
      userCheckList = new TreeMap<Integer,RuleCheckInfo>();
    return userCheckList;
  }
  void usrClear(int seq){
    if(this.getUserCheckList().remove(seq)==null)
      System.out.println("error usrClear in rule");
  }


  public String getRightsideDesc() {
    return rightsideDesc;
  }

  public void setRightsideDesc(String rightsideDesc) {
    this.rightsideDesc = rightsideDesc;
  }

  public int getPriority() {
    return priority;
  }
  public void setPriority(int priority) {
    this.priority = priority;
  }
  public List<String> getLeftside() {
    return leftside;
  }
  public void addLeftsideSnow(String snow) {
    this.leftside.add(snow);
  }
  public void addLeftsideSnows(List<String> snows) {
    for(String snow:snows){
      this.leftside.add(snow);  
    }
  }
  public void setLeftside(List<String> leftside) {
    this.leftside = leftside;
  }
  public String getRightside() {
    return rightside;
  }
  public void setRightside(String rightside) {
    this.rightside = rightside;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public String getRuleId() {
    return ruleId;
  }
  public void setRuleId(String ruleId) {
    this.ruleId = ruleId;
  }
  public int getHowManyFound() {
    return howManyFound;
  }
  public void setHowManyFound(int howManyFound) {
    this.howManyFound = howManyFound;
  }
  public int getThrehold() {
    return threhold;
  }
  public void setThrehold(int threhold) {
    this.threhold = threhold;
  }
  public String getTimeRelatedSnowMed() {
    return timeRelatedSnowMed;
  }
  public void setTimeRelatedSnowMed(String timeRelatedSnowMed) {
    this.timeRelatedSnowMed = timeRelatedSnowMed;
  }
  public Period getTimespec() {
    return timespec;
  }
  public void setTimespec(Period timespec) {
    this.timespec = timespec;
  }
  public int  addFound(int seq,SnowMed snow){
    RuleCheckInfo check = this.getUserCheckList().get(seq);
    if(check==null){
      check = new RuleCheckInfo();
      userCheckList.put(seq,check );
    }
    check.howManyFound++;
    check.getSnowMedFoundList().add(snow);
    return check.howManyFound;
  }
  public void  timeFound(int seq){
    RuleCheckInfo check = this.getUserCheckList().get(seq);
    check.timeFound = true;
  }
  
  Rule getCopyForUser(SnowMedchecker c){
    Rule r = new Rule();
    r.description = this.description;
    r.leftside = this.leftside;
    r.rightside = this.rightside;
    r.priority = this.priority;
    r.ruleId = this.ruleId;
    r.threhold = this.threhold;
    r.timespec = this.timespec;
    r.timeFound = this.timeFound;
    r.timeRelatedSnowMed = this.timeRelatedSnowMed;
    if(this.userCheckList!=null){
      RuleCheckInfo ri = this.userCheckList.get(c.getSeqNum());
      if(ri!=null)
        r.snowMedFound = ri.getSnowMedFoundList(); 
      ArrayList<SnowMed> ss = new ArrayList<SnowMed>();
        if(r.snowMedFound!=null){
          for(int i=0; i<r.snowMedFound.size();i++){
            ss.add(r.snowMedFound.get(i).getCopy(c)) ; 
            
            //r.snowMedFound.set(i, ss);
            // r.snowMedFound.set(i,r.snowMedFound.get(i).getCopy(c))  ;    
           }
          r.snowMedFound = ss;
          
        }

    }
    return r;
  }
  
}
