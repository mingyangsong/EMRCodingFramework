package edu.cmu.lti.uima.rules;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.uima.types.*;

/*import com.precyse.freedom.uima.types.ICD10DC;
 import com.precyse.freedom.uima.types.SNOMED;
 */
public class WordHitsBasedPruner extends JCasAnnotator_ImplBase {

  HashMap<String, String> icdDescriptions;
  int maxIcds;
  HashSet<String> stopWords = new HashSet<String>();

  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    super.initialize(aContext);
    
    maxIcds = (Integer) aContext.getConfigParameterValue("maxIcds");
    
    icdDescriptions = new HashMap<String, String>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("data/resources/IcdList.txt"));
      String line = "";
      while ((line = reader.readLine()) != null) {
        String[] splitLine = line.split("\t");
        icdDescriptions.put(splitLine[0], splitLine[1]);
      }
      reader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void process(JCas jcas) throws AnalysisEngineProcessException {

    AnnotationIndex<?> smIndex = jcas.getAnnotationIndex(ICD10DC.type);
    FSIterator<?> iterator = smIndex.iterator();
    List<ICD10DC> icdCodes = new ArrayList<ICD10DC>();
    while (iterator.hasNext()) {
      ICD10DC c = (ICD10DC) iterator.next();
      if (!c.getSource().equals("GS"))
      icdCodes.add(c);
    }
    
    String text = jcas.getDocumentText();
    List<String> tokens = Tokenizer.tokenizeDoc(text);
    HashSet<String> tokenHash = new HashSet<String>();
    HashSet<String> stopWords = getStopWords();
    for (String token : tokens) {
      if (!stopWords.contains(token))
        tokenHash.add(token);
    }
    
    setRankedIcdList(icdCodes, tokenHash);

  }

  public void setRankedIcdList(List<ICD10DC> icdCodes, HashSet<String> tokenHash) {

    TreeMap<Integer, HashSet<ICD10DC>> rankedListOfICDs = new TreeMap<Integer, HashSet<ICD10DC>>();

    for (ICD10DC i10id : icdCodes) {
      
      String description = icdDescriptions.get(i10id.getCode());
      if (description==null)
        description =";";
      int wordMatches = getWordMatches(tokenHash, description);
      if (rankedListOfICDs.containsKey(wordMatches))
        rankedListOfICDs.get(wordMatches).add(i10id);
      else {
        HashSet<ICD10DC> newHash = new HashSet<ICD10DC>();
        newHash.add(i10id);
        rankedListOfICDs.put(wordMatches, newHash);
      }
    }

    NavigableMap<Integer, HashSet<ICD10DC>> descKeys = rankedListOfICDs.descendingMap();
    int count = 0;
    for (Integer hits : descKeys.keySet()) {
      // System.out.println("Hits:" + hits);
      for (ICD10DC icd : descKeys.get(hits)) {
        count++;
        if (count > maxIcds) {
          icd.removeFromIndexes();
        }
      }
    }
  }

  private static int getWordMatches(HashSet<String> tokenHash, String icdDescription) {
    List<String> icdTokens = Tokenizer.tokenizeDoc(icdDescription);
    int matches = 0;
    for (String token : icdTokens)
      if (tokenHash.contains(token))
        matches++;
    return matches;
  }
  
  public HashSet<String> getStopWords() {

    if (stopWords.size() == 0) {

      Scanner sc = null;
      try {
        sc = new Scanner(new File("data/resources/StopWords"));
      } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      String allWords = sc.next();

      String[] wordsArray = allWords.split(",");
      
      for(int i=0; i<wordsArray.length; i++){
        stopWords.add(wordsArray[i]);
      }
    }
    
    return stopWords;
  }

}