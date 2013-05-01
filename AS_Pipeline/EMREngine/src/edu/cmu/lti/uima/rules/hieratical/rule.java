package edu.cmu.lti.uima.rules.hieratical;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class rule implements Serializable{
  int priority;
  List<String> leftside;
  String rightside;
  String rightsideDesc;
  String description;
  String ruleId;
  int howManyFound = 0;
  int threhold;
  String timeRelatedSnowMed;
  period timespec;
  boolean timeFound = false;
  ruleGroup group;
  Map<Integer,ruleCheckInfo> userCheckList;
  rule(){
    leftside = new ArrayList<String>();
  }
  public Map<Integer, ruleCheckInfo> getUserCheckList() {
    if(userCheckList==null)
      userCheckList = new TreeMap<Integer,ruleCheckInfo>();
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
  public period getTimespec() {
    return timespec;
  }
  public void setTimespec(period timespec) {
    this.timespec = timespec;
  }
  public int  addFound(int seq){
    ruleCheckInfo check = this.getUserCheckList().get(seq);
    if(check==null){
      check = new ruleCheckInfo();
      userCheckList.put(seq,check );
    }
    check.howManyFound++;
    return check.howManyFound;
  }
  public void  timeFound(int seq){
    ruleCheckInfo check = this.getUserCheckList().get(seq);
    check.timeFound = true;
  }
}
