package edu.cmu.lti.uima.rules.hierarchical;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SnowMedPool implements Serializable {
  HashMap<String,SnowMed> pool;
  SnowMedPool(){
    pool = new HashMap<String,SnowMed>();
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
        SnowMed m = (SnowMed)pairs.getValue();
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
  
  void addSnowMed(SnowMed med){
      pool.put(med.getConceptId(), med);
  }
  boolean doesContainsSnowmed(String code){
    return pool.containsKey(code);
  }
  boolean addMappingRule(String code,Rule r){
    SnowMed m = pool.get(code);
    if (m==null){
      return false;
    }
    m.addRelatedRule(r);
    return true;
  }
  
  boolean addtimeRleatedMappingRule(String code,Rule r){
    SnowMed m = pool.get(code);
    if (m==null){
      return false;
    }
    m.addtimeRelatedRule(r);
    return true;
  }
  
  boolean addMappingGroup(String code,RuleGroup g){
    SnowMed m = pool.get(code);
    if (m==null)
      return false;
    m.addRelatedGroup(g);
    return true;
  }
  
  boolean addTime(String code,Period t){
    SnowMed m = pool.get(code);
    if (m==null)
      return false;
    m.addTime(t);
    return true;
  }
  
  boolean checkSnowMed(SnowMed med,SnowMedchecker checker){
    SnowMed m = pool.get(med.conceptId);
    if(m==null)
      return false;
    m.checkSelf(med.timeinfo,checker,med.startPos,med.endPos);
    return true;
  }
  boolean checkSnowMed(String conceptId,int start,int end,List<Period> onset,SnowMedchecker checker){
    SnowMed m = pool.get(conceptId);
    if(m==null)
      return false;
    m.checkSelf(onset,checker,start,end);
    return true;
  }
}
