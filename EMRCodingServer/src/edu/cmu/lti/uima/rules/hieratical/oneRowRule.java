package edu.cmu.lti.uima.rules.hieratical;

import java.util.ArrayList;
import java.util.List;

public class oneRowRule {
  public String ruleId;
  public String conceptId;
  public String conceptDesc;
  public Integer group;
  public Integer priority;
  public List<String> extraleftside;
  public List<String> extraleftDesc;
  public String ruleDesc;
  public String rightside;
  public String rightDesc;
  public period onset = null;
  oneRowRule(){
    extraleftside = new ArrayList<String>();
    extraleftDesc = new ArrayList<String>();
  }
}
