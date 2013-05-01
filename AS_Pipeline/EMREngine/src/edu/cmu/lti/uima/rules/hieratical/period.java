package edu.cmu.lti.uima.rules.hieratical;

import java.io.Serializable;

public class period implements Serializable{
  int lowerBound =-1;
  int higherBound = Integer.MAX_VALUE;
  @Override public boolean equals(Object other){
    if (other.getClass()!=period.class)
      return false;
    period tmp = (period) other;
     
    return tmp.lowerBound==lowerBound&&tmp.higherBound==higherBound;
  }
  @Override public int hashCode() {
    String a = String.valueOf(lowerBound)+String.valueOf(higherBound);
    return a.hashCode();
  }
  public boolean contains(period t){
    if(lowerBound>t.lowerBound)
      return false;
    if(higherBound<t.higherBound)
      return false;
    return true;
  }
}
