package edu.cmu.lti.uima.rules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.uima.types.*;

//import com.precyse.freedom.uima.types.ICD10DC;

public class DRGAnnotator extends JCasAnnotator_ImplBase {
  double countFilterk;
  class ICD10_Count {
    ICD10DC icd;

    double count;

    ICD10_Count(ICD10DC icd, double count) {
      this.icd = icd;
      this.count = count;
    }
  }

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    AnnotationIndex<?> index = jcas.getAnnotationIndex(ICD10DC.type);
    FSIterator<?> iterator = index.iterator();
    List<ICD10DC> goldStandard = new ArrayList<ICD10DC>();
    List<ICD10DC> testLabels = new ArrayList<ICD10DC>();
    HashMap<String, ICD10_Count> ICD10andCount = new HashMap<String, ICD10_Count>();
    ;
    while (iterator.hasNext()) {
      ICD10DC c = (ICD10DC) iterator.next();
      if (c.getSource() != null && c.getSource().equals("GS")) {
        goldStandard.add(c);
      } else {
        //System.out.println( "Source: " + c.getSource() + " Output Code: " + c.getCode() );
        if (ICD10andCount.containsKey(c.getCode())) {
          ICD10andCount.get(c.getCode()).count++;
        } else {
          ICD10andCount.put(c.getCode(), new ICD10_Count(c, 1.0));
        }
        testLabels.add(c);
      }
    }
    // Simple algorithm: All non-GS labels are output as DRG.
  for (ICD10DC a : testLabels) {
      ICD10DC output = new ICD10DC(jcas, a.getBegin(), a.getEnd());
      output.setSource("DRG");
      output.setCode(a.getCode());
      output.addToIndexes();
    }
    //countThresholdThenClustDRG(ICD10andCount,jcas);
    //weightThresholdDRG(ICD10andCount,jcas);
    //countThresholdDRG(ICD10andCount,jcas);
  
  }

  
  @Override
  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    // TODO Auto-generated method stub
    super.initialize(aContext);
    countFilterk = (Float) aContext.getConfigParameterValue( "thresholdK" );    
  }

  

  void countThresholdThenClustDRG(HashMap<String, ICD10_Count> ICD10andCount, JCas jcas){
   
    List<String> highConfICD = new ArrayList<String>();
    double mean = 0;
    for (ICD10_Count icd : ICD10andCount.values()) {
      mean += icd.count;
    }
    mean /= ICD10andCount.values().size();
    double std = 0;
    for (ICD10_Count icd : ICD10andCount.values()) {
      std += (icd.count - mean) * (icd.count - mean);
    }
    std /= ICD10andCount.values().size();
    std = Math.pow(std, 0.5);
    for (ICD10_Count icd : ICD10andCount.values()) {
      if (icd.count >= mean - 0.25 * std) {
        highConfICD.add(icd.icd.getCode());
      }
    }
    for (ICD10_Count icd : ICD10andCount.values()) {
      if (getSimilarity(icd.icd.getCode(), highConfICD) >= 0.8&&icd.count/(mean*ICD10andCount.values().size())>=0.1) {
        ICD10DC a = icd.icd;
        ICD10DC output = new ICD10DC(jcas, a.getBegin(), a.getEnd());
        output.setSource("DRG");
        output.setCode(a.getCode());
        output.addToIndexes();
      }
    }
  }
  
  void weightThresholdDRG(HashMap<String, ICD10_Count> ICD10andCount, JCas jcas) {
    double total = 0;
    for (ICD10_Count icd : ICD10andCount.values()) {
      total += icd.count;
    }
    for (ICD10_Count icd : ICD10andCount.values()) {
      icd.count/=total;
    }
    for (ICD10_Count icd : ICD10andCount.values()) {
      if (icd.count >= 0.1) {
        ICD10DC a = icd.icd;
        ICD10DC output = new ICD10DC(jcas, a.getBegin(), a.getEnd());
        output.setSource("DRG");
        output.setCode(a.getCode());
        output.addToIndexes();
      }

    }
  }
  
  
  void countThresholdDRG(HashMap<String, ICD10_Count> ICD10andCount, JCas jcas) {
    double mean = 0;
    for (ICD10_Count icd : ICD10andCount.values()) {
      mean += icd.count;
    }
    mean /= ICD10andCount.values().size();
    double std = 0;
    for (ICD10_Count icd : ICD10andCount.values()) {
      std += (icd.count - mean) * (icd.count - mean);
    }
    std /= ICD10andCount.values().size();
    std = Math.pow(std, 0.5);
    for (ICD10_Count icd : ICD10andCount.values()) {
      if (icd.count >= mean+this.countFilterk*std) {
        ICD10DC a = icd.icd;
        ICD10DC output = new ICD10DC(jcas, a.getBegin(), a.getEnd());
        output.setSource("DRG");
        output.setCode(a.getCode());
        output.addToIndexes();
      }

    }
  }

  Double getSimilarity(String test, List<String> golds) {
    double MaxScore = 0.0;
    for (String s : golds) {
      double score = getSimilartiry(test, s);
      if (score > MaxScore)
        MaxScore = score;
    }
    return MaxScore;
  }

  Double getSimilartiry(String test, String gold) {
    int length;
    if (test.length() > gold.length())
      length = gold.length();
    else
      length = test.length();
    double score = 0.0;
    for (int i = 0; i < length; i++) {
      if (test.charAt(i) == gold.charAt(i))
        score++;
    }
    score /= gold.length();
    return score;
  }
  
  void assignConfidence(HashMap<String, ICD10_Count> ICD10andCount, JCas jcas){
    double mean = 0;
    for (ICD10_Count icd : ICD10andCount.values()) {
      mean += icd.count;
    }
    mean /= ICD10andCount.values().size();
    double std = 0;
    for (ICD10_Count icd : ICD10andCount.values()) {
      std += (icd.count - mean) * (icd.count - mean);
    }
    std /= ICD10andCount.values().size();
    std = Math.pow(std, 0.5);
    for (ICD10_Count icd : ICD10andCount.values()) {
      icd.icd.setConfidence((icd.count - mean)/std);
      if (icd.count >= mean+this.countFilterk*std) {
        ICD10DC a = icd.icd;
        ICD10DC output = new ICD10DC(jcas, a.getBegin(), a.getEnd());
        output.setSource("DRG");
        output.setCode(a.getCode());
        output.addToIndexes();
      }
    }
  }
}
