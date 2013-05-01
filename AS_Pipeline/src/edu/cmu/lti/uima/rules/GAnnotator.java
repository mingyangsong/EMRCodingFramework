package edu.cmu.lti.uima.rules;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;
import com.aliasi.util.AbstractExternalizable;


import edu.cmu.lti.uima.types.PersonalInformation;
import edu.cmu.lti.uima.types.Sentence;
import edu.cmu.lti.uima.types.Sentence_ExpandedNE;
import edu.cmu.lti.uima.types.Token;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

/**
*  The class is the code-part of the Annotator component of the UIMA Framework. The class extends the JCasAnnotator_ImplBase
* 
* @author      Anika Gupta
* @since       1.0
*/
public class GAnnotator extends JCasAnnotator_ImplBase{

  File modelFile=null;
  private StanfordCoreNLP pipeline;
  File expandedNEFile=null;
  HashMap<String, String> expandNP;
  /** 
   *Annotates the document associated with the CAS object.
   *
   * @param casObj    The JCAS object which is to be annotated.
   */
  @Override
public void process(JCas jcasObj) throws AnalysisEngineProcessException {
    
   // System.out.println("Hello");
    AnnotationIndex<?> index = jcasObj.getAnnotationIndex( Sentence.type );
    FSIterator<?> iterator = index.iterator();
    
    while ( iterator.hasNext() ) {
      Sentence c = (Sentence)iterator.next();
      String document = c.getTag();
      Annotation annotatedDocument = new Annotation(document);
      pipeline.annotate(annotatedDocument);
      
      addPersonalInformation(document,jcasObj);
      
      Sentence_ExpandedNE sentenceExpandObj = new Sentence_ExpandedNE(jcasObj);
      String expandedSentence = getExpandedText(document);
      sentenceExpandObj.setTag(expandedSentence);
      
      List<CoreMap> sentences = annotatedDocument.get(SentencesAnnotation.class);
      for (CoreMap sentence : sentences) {
     //   List<CoreLabel> candidate = new ArrayList<CoreLabel>();
        for (CoreLabel token : sentence.get(TokensAnnotation.class)) {
          String pos = token.get(PartOfSpeechAnnotation.class);
          String expandedNE = getExpanded(token.originalText());
          Token tokenObj = new Token(jcasObj);
          tokenObj.setBegin(c.getBegin()+token.beginPosition());
          tokenObj.setEnd(c.getBegin()+token.endPosition());
          tokenObj.setTag(token.tag());
          tokenObj.setText(token.originalText());
          tokenObj.setExpanded(expandedNE);
          tokenObj.addToIndexes();
     //     System.out.println("Token:"+token.originalText());
        }
          }
      sentenceExpandObj.addToIndexes();
    }
    
    
    
     
  }
  public void addPersonalInformation(String line, JCas jcasObj){
    line=line.toLowerCase();
    Pattern p = Pattern.compile("([0-9]+?)[ |-]year[ |-]old (.*)ale");
    Matcher matcher = p.matcher(line);
  //  System.out.println(matcher.find()+":"+line);
    if(matcher.find()){
      PersonalInformation personalObj = new PersonalInformation(jcasObj);
      int age = Integer.parseInt(matcher.group(1));
      String gender = matcher.group(2)+"ale";
      personalObj.setAge(age);
      personalObj.setGender(gender);
      personalObj.addToIndexes();
    }
    
  }
  public String getExpandedText(String text){
   // System.out.println("SIZE"+expandNP.size());
    for(String NP : expandNP.keySet()){
      text= text.replace(" "+NP+" "," "+expandNP.get(NP)+" ");
    }
    return text;
    
  }
  public String getExpanded(String text){
    if(expandNP.containsKey(text))
      return expandNP.get(text);
    return "";
  }
    
 
  /** 
   *Initializes the Annotator class with path of the model file.
   *
   * @param context    UIMA Context.
   */
  @Override
  public void initialize(UimaContext context) throws ResourceInitializationException{
    super.initialize(context);
    Properties props = new Properties();
    props.put("annotators", "tokenize, ssplit, pos");
    pipeline = new StanfordCoreNLP(props);
    String model = (String)context.getConfigParameterValue("TrainedModel"); 
    modelFile = new File(model); 
    expandNP = new HashMap<String, String>();
    String expandedNE = (String)context.getConfigParameterValue("ExpandedFile");
    expandedNEFile = new File(expandedNE);
    storeInHashMap(expandedNEFile);
    
  }
  public void storeInHashMap(File file){
    BufferedReader bufRead = null;
    try {
      bufRead = new BufferedReader(new FileReader(expandedNEFile));
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    String line=null;
    try {
      while((line=bufRead.readLine())!=null){
        expandNP.put(line.split("\t")[0], line.split("\t")[1]);
      }
      bufRead.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }

}
