package edu.cmu.lti.uima.rules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import uima.regex.instance.AnnotationClassLabel;
import uima.regex.instance.AnnotationString;
import uima.regex.util.AnnotationStringFactory;

import edu.cmu.lti.uima.types.*;

/*import com.precyse.freedom.uima.types.ICD10DC;
 import com.precyse.freedom.uima.types.SNOMED;
 */
public class RegexBasedPruner extends JCasAnnotator_ImplBase {

  public void process(JCas jcas) throws AnalysisEngineProcessException {

    /*
    AnnotationIndex<?> tokIndex = jcas.getAnnotationIndex(ICD10DC.type);
    FSIterator<?> tokIterator = tokIndex.iterator();
    while (tokIterator.hasNext()) {
      ICD10DC t = (ICD10DC) tokIterator.next();
      System.out.println(t.getCoveredText());
    }
    */
    
    AnnotationIndex<?> icdIndex = jcas.getAnnotationIndex(ICD10DC.type);
    FSIterator<?> iterator = icdIndex.iterator();
    List<ICD10DC> allICDs = new ArrayList<ICD10DC>();

    while (iterator.hasNext()) {
      ICD10DC c = (ICD10DC) iterator.next();
      if (c.getSource() != "GS")
        allICDs.add(c);
    }

    String originTokenClassName = "edu.cmu.lti.uima.types.Token";
    String shortTokenClassName = "sent";
    AnnotationClassLabel tokenLabelObj = new AnnotationClassLabel(originTokenClassName,
            shortTokenClassName);
    List<AnnotationClassLabel> classList = new ArrayList<AnnotationClassLabel>();
    classList.add(tokenLabelObj);
    AnnotationStringFactory asf = new AnnotationStringFactory(classList);

    Pattern nowPattern = Pattern.compile("(&[^&]*((normal)|(Normal))[^&]*&)");

    for (ICD10DC icdCode : allICDs) {
      AnnotationString nowAnnoStr = asf.getAnnotationString(icdCode, jcas);
      nowAnnoStr.setMatcher(nowPattern);
      //System.out.println(icdCode.getCoveredText());
      if (nowAnnoStr.find()) {
        //System.out.println(nowAnnoStr.toString());
        icdCode.removeFromIndexes();
      }
    }

  }
}