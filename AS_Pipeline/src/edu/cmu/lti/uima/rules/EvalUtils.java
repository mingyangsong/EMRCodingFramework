package edu.cmu.lti.uima.rules;

import java.util.List;
import edu.cmu.lti.uima.types.*;
//import com.precyse.freedom.uima.types.ICD10DC;

public class EvalUtils {
	public static double calculateRecall ( List<ICD10DC> test , List<ICD10DC> gold ) {
		double total = (double)gold.size();
		if ( total == 0 ) return 1.0d;
		double totalFound = 0.0d;
		for ( ICD10DC a : gold )
			if ( findAnnotation( a , test ) ) totalFound++;
		return totalFound / total ;
	}
	 public static double calculateSnoMedRecall ( List<SNOMED> test , List<SNOMED> gold ) {
	    double total = (double)gold.size();
	    if ( total == 0 ) return 1.0d;
	    double totalFound = 0.0d;
	    for ( SNOMED a : gold )
	      if ( findAnnotation( a , test ) ) totalFound++;
	    return totalFound / total ;
	  }
	 public static double calculateFuzzyRecall ( List<ICD10DC> test , List<ICD10DC> gold ) {
	    double total = (double)gold.size();
	    if ( total == 0 ) return 1.0d;
	    double totalFound = 0.0d;
	    for ( ICD10DC a : gold )
	      if ( findFuzzyAnnotation( a , test ) ) totalFound++;
	    return totalFound / total ;
	  }
	  public static double calculateFuzzyPrecision ( List<ICD10DC> test , List<ICD10DC> gold ) {
	    double total = (double)test.size();
	    if ( total == 0 ) return 1.0d;
	    double totalCorrect = 0.0d;
	    for ( ICD10DC a : test )
	      if ( findFuzzyAnnotation( a , gold ) ) totalCorrect++;
	    return totalCorrect / total;
	  }
	public static double calculatePrecision ( List<ICD10DC> test , List<ICD10DC> gold ) {
		double total = (double)test.size();
		if ( total == 0 ) return 1.0d;
		double totalCorrect = 0.0d;
		for ( ICD10DC a : test )
			if ( findAnnotation( a , gold ) ) totalCorrect++;
		return totalCorrect / total;
	}
	
	 public static double calculateSnoMedPrecision ( List<SNOMED> test , List<SNOMED> gold ) {
	    double total = (double)test.size();
	    if ( total == 0 ) return 1.0d;
	    double totalCorrect = 0.0d;
	    for ( SNOMED a : test )
	      if ( findAnnotation( a , gold ) ) totalCorrect++;
	    return totalCorrect / total;
	  }
	
	 
	 public static double calculateWeightedPrecision ( List<ICD10DC> test , List<ICD10DC> gold ,List<Double> weights) {
	    double total = 0;
	    for(double d:weights){
	      total+=d;
	    }
	    if ( total == 0 ) return 1.0d;
	    double totalCorrect = 0.0d;
	    for(int i=0;i<test.size();i++){
	      ICD10DC a = test.get(i);
	      double w = weights.get(i);
	      if ( findAnnotation( a , gold ) ) totalCorrect+=w;
	    }      
	    return totalCorrect / total;
	  }
	public static boolean findAnnotation( ICD10DC a , List<ICD10DC> aList ) {
		for ( ICD10DC tag : aList ) 
		  //if ( tag.getCode().contains(a.getCode())||a.getCode().contains(tag.getCode()))
			if ( tag.getCode().equals( a.getCode() ) )
				return true;
		return false;			
	}
	
	 public static boolean findAnnotation( SNOMED a , List<SNOMED> aList ) {
	    for ( SNOMED tag : aList ) 
	      //if ( tag.getCode().contains(a.getCode())||a.getCode().contains(tag.getCode()))
	      if ( tag.getConceptID().equals( a.getConceptID() ) )
	        return true;
	    return false;     
	  }
	
	
	 public static boolean findFuzzyAnnotation( ICD10DC a , List<ICD10DC> aList ) {
	    for ( ICD10DC tag : aList ) 
	      //if ( tag.getCode().contains(a.getCode())||a.getCode().contains(tag.getCode()))
	      if ( tag.getCode().substring(0, 2).equals( a.getCode().substring(0, 2) ) )
	        return true;
	    return false;     
	  }
	 
	 
	 

	  public static double calculateRecall_SM ( List<SNOMED> test , List<SNOMED> gold ) {
	    double total = (double)gold.size();
	    if ( total == 0 ) return 1.0d;
	    double totalFound = 0.0d;
	    for ( SNOMED a : gold )
	      if ( findAnnotation_SM( a , test ) ) totalFound++;
	    return totalFound / total ;
	  }

	  public static double calculatePrecision_SM ( List<SNOMED> test , List<SNOMED> gold ) {
	    double total = (double)test.size();
	    if ( total == 0 ) return 1.0d;
	    double totalCorrect = 0.0d;
	    for ( SNOMED a : test )
	      if ( findAnnotation_SM( a , gold ) ) totalCorrect++;
	    return totalCorrect / total;
	  }


	  public static boolean findAnnotation_SM( SNOMED a , List<SNOMED> aList ) {
	    for ( SNOMED tag : aList ) 
	      if ( tag.getConceptID().equals( a.getConceptID() ) )
	        return true;
	    return false;     
	  }
	 
	 
	 
	 
}
