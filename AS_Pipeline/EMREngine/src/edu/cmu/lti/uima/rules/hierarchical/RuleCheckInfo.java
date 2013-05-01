package edu.cmu.lti.uima.rules.hierarchical;

import java.util.ArrayList;
import java.util.List;

public class RuleCheckInfo {
  boolean timeFound = false;
  int howManyFound = 0;
  List<SnowMed> snowMedFoundList = null;
  List<SnowMed> getSnowMedFoundList(){
    if(snowMedFoundList==null)
      this.snowMedFoundList = new ArrayList<SnowMed>();
    return this.snowMedFoundList;
  }
}
