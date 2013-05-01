package edu.cmu.lti.uima.rules.hierarchical;

import java.io.Serializable;

public class Period implements Serializable{
  int lowerBound =-1;
  int higherBound = Integer.MAX_VALUE;
  @Override public boolean equals(Object other){
    if (other.getClass()!=Period.class)
      return false;
    Period tmp = (Period) other;
     
    return tmp.lowerBound==lowerBound&&tmp.higherBound==higherBound;
  }
  @Override public int hashCode() {
    String a = String.valueOf(lowerBound)+String.valueOf(higherBound);
    return a.hashCode();
  }
  public boolean contains(Period t){
    if(lowerBound>t.lowerBound)
      return false;
    if(higherBound<t.higherBound)
      return false;
    return true;
  }
}
