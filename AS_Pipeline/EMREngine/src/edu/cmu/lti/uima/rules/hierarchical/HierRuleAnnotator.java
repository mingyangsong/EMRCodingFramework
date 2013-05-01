package edu.cmu.lti.uima.rules.hierarchical;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.EmptyFSList;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.IntegerArray;
import org.apache.uima.jcas.cas.NonEmptyFSList;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.uima.tools.GeneralTool;
import edu.cmu.lti.uima.types.*;

/*import com.precyse.freedom.uima.types.ICD10DC;
 import com.precyse.freedom.uima.types.SNOMED;*/

public class HierRuleAnnotator extends JCasAnnotator_ImplBase {

  Map<List<String>, List<String>> s2iMap;

  String[] ruleSources;

  static HierarchicalRule hierRules = null;

  Object checker;

  private static String SOURCE_COMPONENT = "HierRuleAnnotator";

  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    super.initialize(aContext);
    //System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
    String tabFilePath = (String) aContext.getConfigParameterValue("tabRulePath");
    ruleSources = (String[]) aContext.getConfigParameterValue("ruleSources");
    if(hierRules==null)
      hierRules = new HierarchicalRule();
    try {
      hierRules.readRulesThroughFile(tabFilePath);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }

  public void process(JCas jcas) throws AnalysisEngineProcessException {
    checker = hierRules.getChecker();
    AnnotationIndex<?> smIndex = jcas.getAnnotationIndex(SNOMED.type);
    FSIterator<?> iterator = smIndex.iterator();
    //System.out.println("snoMed:");
    while (iterator.hasNext()) {
      
      SNOMED c = (SNOMED) iterator.next();
      String id = c.getConceptID();
      //System.out.print(id+", ");
     if(c.getSource().equals("TextToSNOMED"))
        this.hierRules.checkSnowMed(id,c.getBegin(),c.getEnd(), null, checker);
    }
    //System.out.println("");
    ICD10DCGROUP icd10group;
    //RuleGroups rgs = this.hierRules.getValidRuleGroupsWithOnset(checker);
    //RuleGroups rgs = this.hierRules.getValidRuleGroupsWithOnset(checker);
    RuleGroups rgs = this.hierRules.getFuzzyValidRuleGroups(checker);
    PriorityRuleFilter filter = new PriorityRuleFilter();
    if(rgs==null)
      return;
    for (RuleGroup rg : rgs.RuleGroups) {
      if (rg.qualifiedRules==null)
        continue;
      icd10group = new ICD10DCGROUP(jcas);
      NonEmptyFSList icd10List;
      IntegerArray priorities = new IntegerArray(jcas,rg.qualifiedRules.size());
      ArrayList<ICD10DC> icd10dcs = new ArrayList<ICD10DC>();
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
      /*  FSArray snoMedArray = new FSArray(jcas,r.snowMedFound.size());
        for(int j=0;j<snoMedArray.size();j++){
          SNOMED snow = new SNOMED(jcas);
          SnowMed s = r.snowMedFound.get(i);
          IntegerArray bs = new IntegerArray(jcas,s.starts.size());
          IntegerArray es = new IntegerArray(jcas,s.ends.size());
          for(int k=0;k<s.starts.size();k++){
            bs.set(k, s.starts.get(i));
            es.set(k, s.ends.get(i));
          }
          snow.setBeginPositions(bs);
          snow.setEndPositions(es);
          snow.setConceptID(s.conceptId);
          snow.setFullySpecifiedName(s.description);
          snoMedArray.set(j, snow);
          //snoMedArray.set(j, v);
        }
        evi.setSupportSnomeds(snoMedArray);
        
        //createmissingsnomed
        Set<String> a = new HashSet<String>(r.leftside);
        for(SnowMed s:r.snowMedFound){
          if(a.contains(s.conceptId)){
            a.remove(s.conceptId);
          }
        }
        FSArray missSnow = new FSArray(jcas,a.size());
        {
          int j=0;
          for(String s:a){
            SNOMED sn = new SNOMED(jcas);
            sn.setConceptID(s);
            missSnow.set(j, sn);
            j++;
          }
        }
        evi.setMissingSnomeds(missSnow);*/
        icd10.setEvidence(evi);
        icd10.setSource(SOURCE_COMPONENT);// FIXME maybe should consider gs
        icd10dcs.add(icd10);
        icd10.addToIndexes();
      }
      icd10List = GeneralTool.createICD10FsList(icd10dcs,jcas);
      
      
      
      //GeneralTool.createICD10FsList
      icd10group.setICD10DC_List(icd10List);
      icd10group.setPriorityList(priorities);
      // icd10group.setSourceSnowmed(rg.centerSnowMed); FIXME centered snowmed
      icd10group.addToIndexes();
    }
  }
}