
/* First created by JCasGen Mon Feb 11 16:10:18 EST 2013 */
package edu.cmu.lti.uima.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Fri Apr 26 22:51:47 EDT 2013
 * @generated */
public class SNOMED_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (SNOMED_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = SNOMED_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new SNOMED(addr, SNOMED_Type.this);
  			   SNOMED_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new SNOMED(addr, SNOMED_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = SNOMED.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.uima.types.SNOMED");
 
  /** @generated */
  final Feature casFeat_ConceptID;
  /** @generated */
  final int     casFeatCode_ConceptID;
  /** @generated */ 
  public String getConceptID(int addr) {
        if (featOkTst && casFeat_ConceptID == null)
      jcas.throwFeatMissing("ConceptID", "edu.cmu.lti.uima.types.SNOMED");
    return ll_cas.ll_getStringValue(addr, casFeatCode_ConceptID);
  }
  /** @generated */    
  public void setConceptID(int addr, String v) {
        if (featOkTst && casFeat_ConceptID == null)
      jcas.throwFeatMissing("ConceptID", "edu.cmu.lti.uima.types.SNOMED");
    ll_cas.ll_setStringValue(addr, casFeatCode_ConceptID, v);}
    
  
 
  /** @generated */
  final Feature casFeat_ConceptStatus;
  /** @generated */
  final int     casFeatCode_ConceptStatus;
  /** @generated */ 
  public int getConceptStatus(int addr) {
        if (featOkTst && casFeat_ConceptStatus == null)
      jcas.throwFeatMissing("ConceptStatus", "edu.cmu.lti.uima.types.SNOMED");
    return ll_cas.ll_getIntValue(addr, casFeatCode_ConceptStatus);
  }
  /** @generated */    
  public void setConceptStatus(int addr, int v) {
        if (featOkTst && casFeat_ConceptStatus == null)
      jcas.throwFeatMissing("ConceptStatus", "edu.cmu.lti.uima.types.SNOMED");
    ll_cas.ll_setIntValue(addr, casFeatCode_ConceptStatus, v);}
    
  
 
  /** @generated */
  final Feature casFeat_IsPrimitive;
  /** @generated */
  final int     casFeatCode_IsPrimitive;
  /** @generated */ 
  public boolean getIsPrimitive(int addr) {
        if (featOkTst && casFeat_IsPrimitive == null)
      jcas.throwFeatMissing("IsPrimitive", "edu.cmu.lti.uima.types.SNOMED");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_IsPrimitive);
  }
  /** @generated */    
  public void setIsPrimitive(int addr, boolean v) {
        if (featOkTst && casFeat_IsPrimitive == null)
      jcas.throwFeatMissing("IsPrimitive", "edu.cmu.lti.uima.types.SNOMED");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_IsPrimitive, v);}
    
  
 
  /** @generated */
  final Feature casFeat_id;
  /** @generated */
  final int     casFeatCode_id;
  /** @generated */ 
  public String getId(int addr) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "edu.cmu.lti.uima.types.SNOMED");
    return ll_cas.ll_getStringValue(addr, casFeatCode_id);
  }
  /** @generated */    
  public void setId(int addr, String v) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "edu.cmu.lti.uima.types.SNOMED");
    ll_cas.ll_setStringValue(addr, casFeatCode_id, v);}
    
  
 
  /** @generated */
  final Feature casFeat_FullySpecifiedName;
  /** @generated */
  final int     casFeatCode_FullySpecifiedName;
  /** @generated */ 
  public String getFullySpecifiedName(int addr) {
        if (featOkTst && casFeat_FullySpecifiedName == null)
      jcas.throwFeatMissing("FullySpecifiedName", "edu.cmu.lti.uima.types.SNOMED");
    return ll_cas.ll_getStringValue(addr, casFeatCode_FullySpecifiedName);
  }
  /** @generated */    
  public void setFullySpecifiedName(int addr, String v) {
        if (featOkTst && casFeat_FullySpecifiedName == null)
      jcas.throwFeatMissing("FullySpecifiedName", "edu.cmu.lti.uima.types.SNOMED");
    ll_cas.ll_setStringValue(addr, casFeatCode_FullySpecifiedName, v);}
    
  
 
  /** @generated */
  final Feature casFeat_PreferedTermId;
  /** @generated */
  final int     casFeatCode_PreferedTermId;
  /** @generated */ 
  public int getPreferedTermId(int addr) {
        if (featOkTst && casFeat_PreferedTermId == null)
      jcas.throwFeatMissing("PreferedTermId", "edu.cmu.lti.uima.types.SNOMED");
    return ll_cas.ll_getIntValue(addr, casFeatCode_PreferedTermId);
  }
  /** @generated */    
  public void setPreferedTermId(int addr, int v) {
        if (featOkTst && casFeat_PreferedTermId == null)
      jcas.throwFeatMissing("PreferedTermId", "edu.cmu.lti.uima.types.SNOMED");
    ll_cas.ll_setIntValue(addr, casFeatCode_PreferedTermId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_PreferedTermDesc;
  /** @generated */
  final int     casFeatCode_PreferedTermDesc;
  /** @generated */ 
  public String getPreferedTermDesc(int addr) {
        if (featOkTst && casFeat_PreferedTermDesc == null)
      jcas.throwFeatMissing("PreferedTermDesc", "edu.cmu.lti.uima.types.SNOMED");
    return ll_cas.ll_getStringValue(addr, casFeatCode_PreferedTermDesc);
  }
  /** @generated */    
  public void setPreferedTermDesc(int addr, String v) {
        if (featOkTst && casFeat_PreferedTermDesc == null)
      jcas.throwFeatMissing("PreferedTermDesc", "edu.cmu.lti.uima.types.SNOMED");
    ll_cas.ll_setStringValue(addr, casFeatCode_PreferedTermDesc, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Symptoms;
  /** @generated */
  final int     casFeatCode_Symptoms;
  /** @generated */ 
  public int getSymptoms(int addr) {
        if (featOkTst && casFeat_Symptoms == null)
      jcas.throwFeatMissing("Symptoms", "edu.cmu.lti.uima.types.SNOMED");
    return ll_cas.ll_getRefValue(addr, casFeatCode_Symptoms);
  }
  /** @generated */    
  public void setSymptoms(int addr, int v) {
        if (featOkTst && casFeat_Symptoms == null)
      jcas.throwFeatMissing("Symptoms", "edu.cmu.lti.uima.types.SNOMED");
    ll_cas.ll_setRefValue(addr, casFeatCode_Symptoms, v);}
    
   /** @generated */
  public String getSymptoms(int addr, int i) {
        if (featOkTst && casFeat_Symptoms == null)
      jcas.throwFeatMissing("Symptoms", "edu.cmu.lti.uima.types.SNOMED");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_Symptoms), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_Symptoms), i);
  return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_Symptoms), i);
  }
   
  /** @generated */ 
  public void setSymptoms(int addr, int i, String v) {
        if (featOkTst && casFeat_Symptoms == null)
      jcas.throwFeatMissing("Symptoms", "edu.cmu.lti.uima.types.SNOMED");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_Symptoms), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_Symptoms), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_Symptoms), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_Source;
  /** @generated */
  final int     casFeatCode_Source;
  /** @generated */ 
  public String getSource(int addr) {
        if (featOkTst && casFeat_Source == null)
      jcas.throwFeatMissing("Source", "edu.cmu.lti.uima.types.SNOMED");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Source);
  }
  /** @generated */    
  public void setSource(int addr, String v) {
        if (featOkTst && casFeat_Source == null)
      jcas.throwFeatMissing("Source", "edu.cmu.lti.uima.types.SNOMED");
    ll_cas.ll_setStringValue(addr, casFeatCode_Source, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Confidence;
  /** @generated */
  final int     casFeatCode_Confidence;
  /** @generated */ 
  public double getConfidence(int addr) {
        if (featOkTst && casFeat_Confidence == null)
      jcas.throwFeatMissing("Confidence", "edu.cmu.lti.uima.types.SNOMED");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_Confidence);
  }
  /** @generated */    
  public void setConfidence(int addr, double v) {
        if (featOkTst && casFeat_Confidence == null)
      jcas.throwFeatMissing("Confidence", "edu.cmu.lti.uima.types.SNOMED");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_Confidence, v);}
    
  
 
  /** @generated */
  final Feature casFeat_BeginPositions;
  /** @generated */
  final int     casFeatCode_BeginPositions;
  /** @generated */ 
  public int getBeginPositions(int addr) {
        if (featOkTst && casFeat_BeginPositions == null)
      jcas.throwFeatMissing("BeginPositions", "edu.cmu.lti.uima.types.SNOMED");
    return ll_cas.ll_getRefValue(addr, casFeatCode_BeginPositions);
  }
  /** @generated */    
  public void setBeginPositions(int addr, int v) {
        if (featOkTst && casFeat_BeginPositions == null)
      jcas.throwFeatMissing("BeginPositions", "edu.cmu.lti.uima.types.SNOMED");
    ll_cas.ll_setRefValue(addr, casFeatCode_BeginPositions, v);}
    
   /** @generated */
  public int getBeginPositions(int addr, int i) {
        if (featOkTst && casFeat_BeginPositions == null)
      jcas.throwFeatMissing("BeginPositions", "edu.cmu.lti.uima.types.SNOMED");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getIntArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_BeginPositions), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_BeginPositions), i);
  return ll_cas.ll_getIntArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_BeginPositions), i);
  }
   
  /** @generated */ 
  public void setBeginPositions(int addr, int i, int v) {
        if (featOkTst && casFeat_BeginPositions == null)
      jcas.throwFeatMissing("BeginPositions", "edu.cmu.lti.uima.types.SNOMED");
    if (lowLevelTypeChecks)
      ll_cas.ll_setIntArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_BeginPositions), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_BeginPositions), i);
    ll_cas.ll_setIntArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_BeginPositions), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_EndPositions;
  /** @generated */
  final int     casFeatCode_EndPositions;
  /** @generated */ 
  public int getEndPositions(int addr) {
        if (featOkTst && casFeat_EndPositions == null)
      jcas.throwFeatMissing("EndPositions", "edu.cmu.lti.uima.types.SNOMED");
    return ll_cas.ll_getRefValue(addr, casFeatCode_EndPositions);
  }
  /** @generated */    
  public void setEndPositions(int addr, int v) {
        if (featOkTst && casFeat_EndPositions == null)
      jcas.throwFeatMissing("EndPositions", "edu.cmu.lti.uima.types.SNOMED");
    ll_cas.ll_setRefValue(addr, casFeatCode_EndPositions, v);}
    
   /** @generated */
  public int getEndPositions(int addr, int i) {
        if (featOkTst && casFeat_EndPositions == null)
      jcas.throwFeatMissing("EndPositions", "edu.cmu.lti.uima.types.SNOMED");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getIntArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_EndPositions), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_EndPositions), i);
  return ll_cas.ll_getIntArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_EndPositions), i);
  }
   
  /** @generated */ 
  public void setEndPositions(int addr, int i, int v) {
        if (featOkTst && casFeat_EndPositions == null)
      jcas.throwFeatMissing("EndPositions", "edu.cmu.lti.uima.types.SNOMED");
    if (lowLevelTypeChecks)
      ll_cas.ll_setIntArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_EndPositions), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_EndPositions), i);
    ll_cas.ll_setIntArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_EndPositions), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public SNOMED_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_ConceptID = jcas.getRequiredFeatureDE(casType, "ConceptID", "uima.cas.String", featOkTst);
    casFeatCode_ConceptID  = (null == casFeat_ConceptID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ConceptID).getCode();

 
    casFeat_ConceptStatus = jcas.getRequiredFeatureDE(casType, "ConceptStatus", "uima.cas.Integer", featOkTst);
    casFeatCode_ConceptStatus  = (null == casFeat_ConceptStatus) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ConceptStatus).getCode();

 
    casFeat_IsPrimitive = jcas.getRequiredFeatureDE(casType, "IsPrimitive", "uima.cas.Boolean", featOkTst);
    casFeatCode_IsPrimitive  = (null == casFeat_IsPrimitive) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_IsPrimitive).getCode();

 
    casFeat_id = jcas.getRequiredFeatureDE(casType, "id", "uima.cas.String", featOkTst);
    casFeatCode_id  = (null == casFeat_id) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_id).getCode();

 
    casFeat_FullySpecifiedName = jcas.getRequiredFeatureDE(casType, "FullySpecifiedName", "uima.cas.String", featOkTst);
    casFeatCode_FullySpecifiedName  = (null == casFeat_FullySpecifiedName) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_FullySpecifiedName).getCode();

 
    casFeat_PreferedTermId = jcas.getRequiredFeatureDE(casType, "PreferedTermId", "uima.cas.Integer", featOkTst);
    casFeatCode_PreferedTermId  = (null == casFeat_PreferedTermId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_PreferedTermId).getCode();

 
    casFeat_PreferedTermDesc = jcas.getRequiredFeatureDE(casType, "PreferedTermDesc", "uima.cas.String", featOkTst);
    casFeatCode_PreferedTermDesc  = (null == casFeat_PreferedTermDesc) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_PreferedTermDesc).getCode();

 
    casFeat_Symptoms = jcas.getRequiredFeatureDE(casType, "Symptoms", "uima.cas.StringArray", featOkTst);
    casFeatCode_Symptoms  = (null == casFeat_Symptoms) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Symptoms).getCode();

 
    casFeat_Source = jcas.getRequiredFeatureDE(casType, "Source", "uima.cas.String", featOkTst);
    casFeatCode_Source  = (null == casFeat_Source) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Source).getCode();

 
    casFeat_Confidence = jcas.getRequiredFeatureDE(casType, "Confidence", "uima.cas.Double", featOkTst);
    casFeatCode_Confidence  = (null == casFeat_Confidence) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Confidence).getCode();

 
    casFeat_BeginPositions = jcas.getRequiredFeatureDE(casType, "BeginPositions", "uima.cas.IntegerArray", featOkTst);
    casFeatCode_BeginPositions  = (null == casFeat_BeginPositions) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_BeginPositions).getCode();

 
    casFeat_EndPositions = jcas.getRequiredFeatureDE(casType, "EndPositions", "uima.cas.IntegerArray", featOkTst);
    casFeatCode_EndPositions  = (null == casFeat_EndPositions) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_EndPositions).getCode();

  }
}



    