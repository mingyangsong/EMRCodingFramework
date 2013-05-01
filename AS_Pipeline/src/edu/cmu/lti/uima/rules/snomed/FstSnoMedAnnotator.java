package edu.cmu.lti.uima.rules.snomed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.uima.types.*;
//import com.precyse.freedom.uima.types.SNOMED;

public class FstSnoMedAnnotator  extends JCasAnnotator_ImplBase {
	
  FstTree fstTree;
  int numOfwildCard;
	@Override
  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    // TODO Auto-generated method stub
    super.initialize(aContext);
 /*   fstTree = new FstTree();
    String termListPath = (String) aContext.getConfigParameterValue( "snowMedTermList" );
    numOfwildCard = 2;//(Integer) aContext.getConfigParameterValue( "numOfwildCard" );
    try {
      fstTree.loadSnomedDescriptions(termListPath);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }*/
    
  }

  private static String SOURCE_COMPONENT = "FstSnowMed";
	
	public void annotateSM( JCas jcas , String text , String pattern , String id ) {
		Pattern p = Pattern.compile( pattern );
		Matcher m = p.matcher( text );
		
		
		
		while ( m.find() ) {
			SNOMED a = new SNOMED( jcas , m.start(), m.end() );
			a.setSource( SOURCE_COMPONENT );
			a.setConceptID( id );
			a.addToIndexes();
		}
	}

	@Override
	public void process( JCas jcas ) throws AnalysisEngineProcessException {
	/*	String text = jcas.getDocumentText();
		Annotator annote = new Annotator(fstTree);
		HashMap<String,ArrayList<String>> result = annote.annotateArticleWild(text, this.numOfwildCard);
		
		for(String s:result.keySet()){
      SNOMED a = new SNOMED( jcas , 0, 1 );
      a.setSource( SOURCE_COMPONENT );
      a.setConceptID( s );
      a.addToIndexes();  
		}///FIXME
		*/
	}
	
	
}
