package edu.cmu.lti.uima.rules.hierarchical;

import java.util.ArrayList;
import java.util.List;

public class SnoMedUserCheckInfo {
  boolean found = false;
  ArrayList<Integer> userStartPos = null;
  ArrayList<Integer> userEndPos = null;
  public List<Integer> getUserStartPos() {
    if(userStartPos==null)
      userStartPos = new ArrayList<Integer>();
    return userStartPos;
  }

  public List<Integer> getUserEndPos() {
    if(userEndPos==null)  
      userEndPos = new ArrayList<Integer>();
    return userEndPos;
  }
}
