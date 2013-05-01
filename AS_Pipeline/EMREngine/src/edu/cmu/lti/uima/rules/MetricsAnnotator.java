package edu.cmu.lti.uima.rules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.IntegerArray;
import org.apache.uima.jcas.cas.NonEmptyFSList;

import edu.cmu.lti.uima.types.*;
//import com.precyse.freedom.uima.types.ICD10DC;

public class MetricsAnnotator extends JCasAnnotator_ImplBase {
	
	@Override
	public void process( JCas jcas ) throws AnalysisEngineProcessException {
		Type type = jcas.getTypeSystem().getType( "edu.cmu.lti.uima.types.ICD10DC" );
		AnnotationIndex<?> index = jcas.getAnnotationIndex( type);
		FSIterator<?> iterator = index.iterator();
		List<ICD10DC> goldLabels = new ArrayList<ICD10DC>();
		List<ICD10DC> testLabels = new ArrayList<ICD10DC>();
    List<ICD10DC> weightedTestLabels = new ArrayList<ICD10DC>();
    HashMap<String,Boolean> gsChecker = new HashMap<String, Boolean>();
    HashMap<String,Boolean> testChecker = new HashMap<String, Boolean>();
    HashMap<String,Integer> testWeight = new HashMap<String, Integer>();
		while ( iterator.hasNext() ) {
			ICD10DC c = (ICD10DC)iterator.next();
			if ( c.getSource() != null && c.getSource().equals( "GS" ) ) {
			  //System.out.println("GS "+ c.getCode());
				if(gsChecker.get(c.getCode())==null){
				  gsChecker.put(c.getCode(), true);
				  goldLabels.add( c );
				}
			} else if ( c.getSource() != null && c.getSource().equals( "DRG" ) ) {
				 if(testWeight.containsKey(c.getCode())){
				   testWeight.put(c.getCode(), testWeight.get(c.getCode())+1);
				 }else
				   testWeight.put(c.getCode(),1);
	       if(testChecker.get(c.getCode())==null){
	          testChecker.put(c.getCode(), true);
	          testLabels.add( c );
	        }
	       weightedTestLabels.add( c );
			}
		}
    /*System.out.print("GS:");
    for(ICD10DC icd:goldLabels){
      System.out.print(icd.getCode()+" ");
    }
    System.out.println();*/
		//System.out.println();
		ArrayList<Double> weights = new ArrayList<Double>();
		for (ICD10DC icd:testLabels){
		  weights.add(1.0*testWeight.get(icd.getCode())/testLabels.size());
		}
		double precision = EvalUtils.calculatePrecision( testLabels , goldLabels );
		double recall = EvalUtils.calculateRecall( testLabels , goldLabels );
		
		System.out.println( "Precision: " + precision+" |Recall: "+ recall );
   /* precision = EvalUtils.calculatePrecision( weightedTestLabels , goldLabels );
    recall = EvalUtils.calculateRecall( weightedTestLabels , goldLabels );
    System.out.println( "weighted precision: " + precision+" |Recall: "+ recall );*/
    //precision = EvalUtils.calculateFuzzyPrecision( testLabels , goldLabels );
    //recall = EvalUtils.calculateFuzzyRecall( testLabels , goldLabels );
    //System.out.print(  precision+" "+recall );
    //System.out.print("GS:");
		
		
		
		
		
		
    /*for(ICD10DC icd:goldLabels){
      System.out.print(icd.getCode()+" ");
    }
    System.out.println();*/
   /* System.out.print("test:");
    for(ICD10DC icd:testLabels){
     System.out.print(icd.getCode()+" ");
    }*/
    //System.out.println();
    //System.out.println( "Weighted Precision: " + precision+" |Weighted Recall: "+ recall );
		/*System.out.println("-------------checking group");
    AnnotationIndex<?> smIndex = jcas.getAnnotationIndex(ICD10DCGROUP.type);
    FSIterator<?> it = smIndex.iterator();
    while(it.hasNext()){
      System.out.println("---------------");
      ICD10DCGROUP group = (ICD10DCGROUP)it.next();
      NonEmptyFSList ruleList = group.getICD10DC_List();
      IntegerArray priorites = group.getPriorityList();
      for(int i=0;i<priorites.size();i++){
        ICD10DC icd = (ICD10DC)ruleList.getNthElement(i);
        System.out.println("icd: "+icd.getCode()+"| p:"+priorites.get(i)); 
      }

    }*/
		
    
  /*  List<SNOMED> snowGolds = new ArrayList<SNOMED>();
    List<SNOMED> snowTests = new ArrayList<SNOMED>();
    goldLabels.clear();
    testLabels.clear();
    type = jcas.getTypeSystem().getType( "edu.cmu.lti.uima.types.SNOMED" );
    index = jcas.getAnnotationIndex( type);
    iterator = index.iterator();
    while(iterator.hasNext()){
      SNOMED s = (SNOMED)iterator.next();
      if(s.getSource().equals("FstSnowMed"))
        snowTests.add(s);
      else
        snowGolds.add(s);
    }
    
    System.out.print("gold:");
    for(SNOMED icd:snowGolds){
      System.out.print(icd.getConceptID()+" ");
    }
    System.out.print("test:");
    for(SNOMED icd:snowTests){
     System.out.print(icd.getConceptID()+" ");
    }
    
    System.out.println();
    
    precision = EvalUtils.calculateSnoMedPrecision( snowTests , snowGolds );
    recall = EvalUtils.calculateSnoMedRecall( snowTests , snowGolds );
    
    System.out.println( "Precision: " + precision+" |Recall: "+ recall );*/
    
		
	}

}
