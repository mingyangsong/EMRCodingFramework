package edu.cmu.lti.uima.tools;

import java.util.ArrayList;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.EmptyFSList;
import org.apache.uima.jcas.cas.IntegerArray;
import org.apache.uima.jcas.cas.NonEmptyFSList;

import edu.cmu.lti.uima.rules.hierarchical.Rule;
import edu.cmu.lti.uima.types.EVIDENCE;
import edu.cmu.lti.uima.types.ICD10DC;
import edu.cmu.lti.uima.types.ICD10DCGROUP;

public class GeneralTool {
  static public NonEmptyFSList createICD10FsList(ArrayList<ICD10DC> icd10dcs,JCas jcas){
    NonEmptyFSList icd10List = new NonEmptyFSList(jcas);
    NonEmptyFSList head = icd10List;
    for (int i = 0; i < icd10dcs.size(); i++) {
      head.setHead(icd10dcs.get(i));
      if (i != icd10dcs.size() - 1) {
        head.setTail(new NonEmptyFSList(jcas));
        head = (NonEmptyFSList) head.getTail();
      } else {
        head.setTail(new EmptyFSList(jcas));
      }
    }
    return icd10List;
  }
}
/**
  icd10group = new ICD10DCGROUP(jcas);
      NonEmptyFSList icd10List = new NonEmptyFSList(jcas);
      IntegerArray priorities = new IntegerArray(jcas,rg.qualifiedRules.size());
      NonEmptyFSList head = icd10List;
      //System.out.println("HIERRule group:");
      for (int i = 0; i < rg.qualifiedRules.size(); i++) {
        
        Rule r = rg.qualifiedRules.get(i);
        if (r.rightside.equals(""))
          continue;
        priorities.set(i, r.priority);
        ICD10DC icd10 = new ICD10DC(jcas);
        icd10.setCode(r.rightside);
        EVIDENCE evi = new EVIDENCE(jcas);
        //System.out.println("HIERRule rule: "+r.description);
        evi.setDescription(r.description);
        icd10.setEvidence(evi);
        icd10.setSource(SOURCE_COMPONENT);// FIXME maybe should consider gs
        head.setHead(icd10);
        icd10.addToIndexes();
        if (i != rg.rules.size() - 1) {
          head.setTail(new NonEmptyFSList(jcas));
          head = (NonEmptyFSList) head.getTail();
        } else {
          head.setTail(new EmptyFSList(jcas));
        }
      }
 */