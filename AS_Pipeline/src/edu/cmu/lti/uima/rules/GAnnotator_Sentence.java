package edu.cmu.lti.uima.rules;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;
import com.aliasi.sentences.MedlineSentenceModel;
import com.aliasi.sentences.SentenceModel;
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import com.aliasi.tokenizer.Tokenizer;
import com.aliasi.tokenizer.TokenizerFactory;
import com.aliasi.util.AbstractExternalizable;

import edu.cmu.lti.uima.types.Sentence;

/**/
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
public class GAnnotator_Sentence extends JCasAnnotator_ImplBase{

  TokenizerFactory TOKENIZER_FACTORY;
  SentenceModel SENTENCE_MODEL;


  /** 
   *Annotates the document associated with the CAS object.
   *
   * @param casObj    The JCAS object which is to be annotated.
   */
  @Override
public void process(JCas jcasObj) throws AnalysisEngineProcessException {
    
   // System.out.println("Hello");
    String documentLine = jcasObj.getDocumentText();
  //  System.out.println("DOCUMENT "+documentLine);
   // int indexSpace = documentLine.indexOf(' ');
   // String docID = documentLine.substring(0, indexSpace);
    String text = documentLine;
   // text=text.toLowerCase();
    List<String> tokenList = new ArrayList<String>();
    List<String> whiteList = new ArrayList<String>();
    Tokenizer tokenizer = TOKENIZER_FACTORY.tokenizer(text.toCharArray(),0,text.length());
    tokenizer.tokenize(tokenList,whiteList);
    
    String[] tokens = new String[tokenList.size()];
    String[] whites = new String[whiteList.size()];
    tokenList.toArray(tokens);
    whiteList.toArray(whites);
    int[] sentenceBoundaries = SENTENCE_MODEL.boundaryIndices(tokens,whites);
    
    int sentStartTok = 0;
    int sentEndTok = 0;
    int startIndex=0;
    for (int i = 0; i < sentenceBoundaries.length; ++i) {
        sentEndTok = sentenceBoundaries[i];
   //     System.out.println("SENTENCE "+(i+1)+": ");
        String sentence="";
        for (int j=sentStartTok; j<=sentEndTok; j++) {
          sentence=sentence+tokens[j]+whites[j+1];
          //System.out.print(tokens[j]+whites[j+1]);
        }
        Sentence tokenObj = new Sentence(jcasObj);

        int indexSent = documentLine.indexOf(sentence);
        int indexSentEnd=indexSent+sentence.length()-1;
        tokenObj.setBegin(indexSent);
        tokenObj.setEnd(indexSentEnd);
        //System.out.println(indexSent+":"+indexSentEnd);
        tokenObj.setTag(sentence);
    //    System.out.println("Input"+sentence);
        sentStartTok = sentEndTok+1;
      //  System.out.println("hello");
        tokenObj.addToIndexes();
    }
    
    
       
      //  tokenObj.setTag(token.tag());
        
     // }
      //  }
     
  }
    
    
  /*public void process(JCas jcasObj) throws AnalysisEngineProcessException {
    
    System.out.println("Hello");
    String documentLine = jcasObj.getDocumentText();
    int indexSpace = documentLine.indexOf(' ');
    String docID = documentLine.substring(0, indexSpace);
    String document = documentLine.substring(indexSpace + 1);
    
    
    Chunker extractor = null;
    try {
      extractor = (Chunker) AbstractExternalizable.readObject(modelFile);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new AnalysisEngineProcessException();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      throw new AnalysisEngineProcessException();
    }
    Chunking entities = extractor.chunk(document);
    for (Chunk ne : entities.chunkSet()) {
      // Annotations
      NamedEntity annotateNE = new NamedEntity(jcasObj);
      annotateNE.setDocID(docID);
      annotateNE.setBegin(docID.length() + ne.start() + 1);
      annotateNE.setEnd(docID.length() + ne.end()+1);
      annotateNE.addToIndexes();
    }
  }
*/
    
 
  /** 
   *Initializes the Annotator class with path of the model file.
   *
   * @param context    UIMA Context.
   */
  @Override
  public void initialize(UimaContext context) throws ResourceInitializationException{
    super.initialize(context);
    TOKENIZER_FACTORY = IndoEuropeanTokenizerFactory.INSTANCE;
    SENTENCE_MODEL  = new MedlineSentenceModel();
  }

}
