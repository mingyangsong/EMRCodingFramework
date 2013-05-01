package edu.cmu.lti.uima.rules.snomed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.uima.rules.snomed.Annotator;
import edu.cmu.lti.uima.rules.snomed.Annotator.Match;
import edu.cmu.lti.uima.rules.snomed.FstTree;
import edu.cmu.lti.uima.types.SNOMED;

public class TextToSNOMEDWithFST extends JCasAnnotator_ImplBase {

  FstTree snomedFST;

  Annotator snomedMatcher;

  private static String SOURCE_COMPONENT = "TextToSNOMED";

  private String rulesFile;

  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    super.initialize(aContext);

    rulesFile = (String) aContext.getConfigParameterValue("rulesFile");

    snomedFST = new FstTree();
    try {
      snomedFST.loadSnomedDescriptions(rulesFile);
      snomedMatcher = new Annotator(snomedFST);
      System.out.println("Loaded the SNOMED FST");
      //snomedFST.levelOrderTraverse("data/output/fst");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    String text = jcas.getDocumentText();
    annotateSMWithSNOMEDFST(jcas, text);
  }


  public void annotateSMWithSNOMEDFST(JCas jcas, String text) {

    /*
     * making the text words with single white spaces in between
     */
    ArrayList<String> tokenizedText = tokenizeDoc(text);
    StringBuffer buffer = new StringBuffer();
    for (String token : tokenizedText) {
      buffer.append(token);
      buffer.append(" ");
    }
    
    text = buffer.toString();
    int snomedsAdded = 0;
    HashMap<String, ArrayList<Match>> matches = snomedMatcher.annotateArticleWild(text, 2);
    for (String snomedCode : matches.keySet()) {
      for (Match m : matches.get(snomedCode)) {
        SNOMED SM = new SNOMED(jcas, m.getStart(), m.getEnd());
        SM.setSource(SOURCE_COMPONENT);
        SM.setConceptID(snomedCode);
        SM.addToIndexes();
        snomedsAdded++;
      }
    }
    System.out.println("No. of snomeds added:" + snomedsAdded);
  }


  public static String myTokenizer(String text) {
    text = text.toLowerCase();
    text = text.replaceFirst("\\(finder\\)", "");
    text = text.replaceFirst("\\(disorder\\)", "");
    for (int i = 0; i < text.length(); i++) {
      // System.out.println(text.charAt(i)+"ANIKA");
      if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {

      } else {// System.out.println("hello");
        text = text.replace(text.charAt(i), ' ');
      }
    }
    return text;
  }

  static ArrayList<String> tokenizeDoc(String cur_doc) {
    cur_doc = myTokenizer(cur_doc);
    ArrayList<String> returnTokens = new ArrayList<String>();
    String[] strArr = cur_doc.split("\\W+");
    for (int j = 0; j < strArr.length; j++) {
      if (strArr[j].equals(" ") || strArr[j].equals(""))
        continue;
      String token = strArr[j];
      returnTokens.add(token);
    }
    return returnTokens;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
