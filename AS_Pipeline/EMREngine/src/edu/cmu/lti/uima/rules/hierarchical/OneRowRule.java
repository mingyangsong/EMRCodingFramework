package edu.cmu.lti.uima.rules.hierarchical;

import java.util.ArrayList;
import java.util.List;

public class OneRowRule {
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
  public Period onset = null;
  OneRowRule(){
    extraleftside = new ArrayList<String>();
    extraleftDesc = new ArrayList<String>();
  }
}
