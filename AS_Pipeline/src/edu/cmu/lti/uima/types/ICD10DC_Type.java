
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
public class ICD10DC_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (ICD10DC_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = ICD10DC_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new ICD10DC(addr, ICD10DC_Type.this);
  			   ICD10DC_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new ICD10DC(addr, ICD10DC_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = ICD10DC.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.uima.types.ICD10DC");
 
  /** @generated */
  final Feature casFeat_Source;
  /** @generated */
  final int     casFeatCode_Source;
  /** @generated */ 
  public String getSource(int addr) {
        if (featOkTst && casFeat_Source == null)
      jcas.throwFeatMissing("Source", "edu.cmu.lti.uima.types.ICD10DC");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Source);
  }
  /** @generated */    
  public void setSource(int addr, String v) {
        if (featOkTst && casFeat_Source == null)
      jcas.throwFeatMissing("Source", "edu.cmu.lti.uima.types.ICD10DC");
    ll_cas.ll_setStringValue(addr, casFeatCode_Source, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Code;
  /** @generated */
  final int     casFeatCode_Code;
  /** @generated */ 
  public String getCode(int addr) {
        if (featOkTst && casFeat_Code == null)
      jcas.throwFeatMissing("Code", "edu.cmu.lti.uima.types.ICD10DC");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Code);
  }
  /** @generated */    
  public void setCode(int addr, String v) {
        if (featOkTst && casFeat_Code == null)
      jcas.throwFeatMissing("Code", "edu.cmu.lti.uima.types.ICD10DC");
    ll_cas.ll_setStringValue(addr, casFeatCode_Code, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Evidence;
  /** @generated */
  final int     casFeatCode_Evidence;
  /** @generated */ 
  public int getEvidence(int addr) {
        if (featOkTst && casFeat_Evidence == null)
      jcas.throwFeatMissing("Evidence", "edu.cmu.lti.uima.types.ICD10DC");
    return ll_cas.ll_getRefValue(addr, casFeatCode_Evidence);
  }
  /** @generated */    
  public void setEvidence(int addr, int v) {
        if (featOkTst && casFeat_Evidence == null)
      jcas.throwFeatMissing("Evidence", "edu.cmu.lti.uima.types.ICD10DC");
    ll_cas.ll_setRefValue(addr, casFeatCode_Evidence, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Confidence;
  /** @generated */
  final int     casFeatCode_Confidence;
  /** @generated */ 
  public double getConfidence(int addr) {
        if (featOkTst && casFeat_Confidence == null)
      jcas.throwFeatMissing("Confidence", "edu.cmu.lti.uima.types.ICD10DC");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_Confidence);
  }
  /** @generated */    
  public void setConfidence(int addr, double v) {
        if (featOkTst && casFeat_Confidence == null)
      jcas.throwFeatMissing("Confidence", "edu.cmu.lti.uima.types.ICD10DC");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_Confidence, v);}
    
  
 
  /** @generated */
  final Feature casFeat_sourceGroup;
  /** @generated */
  final int     casFeatCode_sourceGroup;
  /** @generated */ 
  public int getSourceGroup(int addr) {
        if (featOkTst && casFeat_sourceGroup == null)
      jcas.throwFeatMissing("sourceGroup", "edu.cmu.lti.uima.types.ICD10DC");
    return ll_cas.ll_getRefValue(addr, casFeatCode_sourceGroup);
  }
  /** @generated */    
  public void setSourceGroup(int addr, int v) {
        if (featOkTst && casFeat_sourceGroup == null)
      jcas.throwFeatMissing("sourceGroup", "edu.cmu.lti.uima.types.ICD10DC");
    ll_cas.ll_setRefValue(addr, casFeatCode_sourceGroup, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public ICD10DC_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_Source = jcas.getRequiredFeatureDE(casType, "Source", "uima.cas.String", featOkTst);
    casFeatCode_Source  = (null == casFeat_Source) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Source).getCode();

 
    casFeat_Code = jcas.getRequiredFeatureDE(casType, "Code", "uima.cas.String", featOkTst);
    casFeatCode_Code  = (null == casFeat_Code) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Code).getCode();

 
    casFeat_Evidence = jcas.getRequiredFeatureDE(casType, "Evidence", "edu.cmu.lti.uima.types.EVIDENCE", featOkTst);
    casFeatCode_Evidence  = (null == casFeat_Evidence) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Evidence).getCode();

 
    casFeat_Confidence = jcas.getRequiredFeatureDE(casType, "Confidence", "uima.cas.Double", featOkTst);
    casFeatCode_Confidence  = (null == casFeat_Confidence) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Confidence).getCode();

 
    casFeat_sourceGroup = jcas.getRequiredFeatureDE(casType, "sourceGroup", "edu.cmu.lti.uima.types.ICD10DCGROUP", featOkTst);
    casFeatCode_sourceGroup  = (null == casFeat_sourceGroup) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sourceGroup).getCode();

  }
}



    