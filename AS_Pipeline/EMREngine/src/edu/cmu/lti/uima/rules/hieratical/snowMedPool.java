package edu.cmu.lti.uima.rules.hieratical;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class snowMedPool implements Serializable {
  HashMap<String,snowMed> pool;
  snowMedPool(){
    pool = new HashMap<String,snowMed>();
  }
  int size(){   
    return pool.size();
  }
  
  void print(){
    Iterator it = pool.entrySet().iterator();
    int max = 0;
    int sum=0;
    int count = 0;
    //System.out.println("begin");
    while (it.hasNext()) {
        Map.Entry pairs = (Map.Entry)it.next();
        snowMed m = (snowMed)pairs.getValue();
        if((m.timeRelatedRules!=null)){
          //System.out.println(m.timeRelatedRules.size());
          sum+=m.timeRelatedRules.size();
          count++;
          if(max<m.timeRelatedRules.size()){
            max = m.timeRelatedRules.size();
          }   
        }
        //System.out.println(pairs.getKey() + " = " + m.relatedRules.get(0).getLeftside() );
        // avoids a ConcurrentModificationException
    }
        System.out.println("maxTimeRelatedRules: "+max);
        System.out.println("avgTimeRelatedRules: "+1.0*sum/pool.size());
        System.out.println("count: "+count);
    
  }
  
  void addSnowMed(snowMed med){
      pool.put(med.getConceptId(), med);
  }
  boolean doesContainsSnowmed(String code){
    return pool.containsKey(code);
  }
  boolean addMappingRule(String code,rule r){
    snowMed m = pool.get(code);
    if (m==null){
      return false;
    }
    m.addRelatedRule(r);
    return true;
  }
  
  boolean addtimeRleatedMappingRule(String code,rule r){
    snowMed m = pool.get(code);
    if (m==null){
      return false;
    }
    m.addtimeRelatedRule(r);
    return true;
  }
  
  boolean addMappingGroup(String code,ruleGroup g){
    snowMed m = pool.get(code);
    if (m==null)
      return false;
    m.addRelatedGroup(g);
    return true;
  }
  
  boolean addTime(String code,period t){
    snowMed m = pool.get(code);
    if (m==null)
      return false;
    m.addTime(t);
    return true;
  }
  
  boolean checkSnowMed(snowMed med,snowMedchecker checker){
    snowMed m = pool.get(med.conceptId);
    if(m==null)
      return false;
    m.checkSelf(med.timeinfo,checker);
    return true;
  }
}
