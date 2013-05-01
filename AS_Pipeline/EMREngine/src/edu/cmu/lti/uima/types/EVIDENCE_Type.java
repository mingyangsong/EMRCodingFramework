
/* First created by JCasGen Thu Mar 21 00:56:41 EDT 2013 */
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
public class EVIDENCE_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (EVIDENCE_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = EVIDENCE_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new EVIDENCE(addr, EVIDENCE_Type.this);
  			   EVIDENCE_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new EVIDENCE(addr, EVIDENCE_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = EVIDENCE.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.uima.types.EVIDENCE");
 
  /** @generated */
  final Feature casFeat_Description;
  /** @generated */
  final int     casFeatCode_Description;
  /** @generated */ 
  public String getDescription(int addr) {
        if (featOkTst && casFeat_Description == null)
      jcas.throwFeatMissing("Description", "edu.cmu.lti.uima.types.EVIDENCE");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Description);
  }
  /** @generated */    
  public void setDescription(int addr, String v) {
        if (featOkTst && casFeat_Description == null)
      jcas.throwFeatMissing("Description", "edu.cmu.lti.uima.types.EVIDENCE");
    ll_cas.ll_setStringValue(addr, casFeatCode_Description, v);}
    
  
 
  /** @generated */
  final Feature casFeat_SupportSnomeds;
  /** @generated */
  final int     casFeatCode_SupportSnomeds;
  /** @generated */ 
  public int getSupportSnomeds(int addr) {
        if (featOkTst && casFeat_SupportSnomeds == null)
      jcas.throwFeatMissing("SupportSnomeds", "edu.cmu.lti.uima.types.EVIDENCE");
    return ll_cas.ll_getRefValue(addr, casFeatCode_SupportSnomeds);
  }
  /** @generated */    
  public void setSupportSnomeds(int addr, int v) {
        if (featOkTst && casFeat_SupportSnomeds == null)
      jcas.throwFeatMissing("SupportSnomeds", "edu.cmu.lti.uima.types.EVIDENCE");
    ll_cas.ll_setRefValue(addr, casFeatCode_SupportSnomeds, v);}
    
   /** @generated */
  public int getSupportSnomeds(int addr, int i) {
        if (featOkTst && casFeat_SupportSnomeds == null)
      jcas.throwFeatMissing("SupportSnomeds", "edu.cmu.lti.uima.types.EVIDENCE");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_SupportSnomeds), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_SupportSnomeds), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_SupportSnomeds), i);
  }
   
  /** @generated */ 
  public void setSupportSnomeds(int addr, int i, int v) {
        if (featOkTst && casFeat_SupportSnomeds == null)
      jcas.throwFeatMissing("SupportSnomeds", "edu.cmu.lti.uima.types.EVIDENCE");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_SupportSnomeds), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_SupportSnomeds), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_SupportSnomeds), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_MissingSnomeds;
  /** @generated */
  final int     casFeatCode_MissingSnomeds;
  /** @generated */ 
  public int getMissingSnomeds(int addr) {
        if (featOkTst && casFeat_MissingSnomeds == null)
      jcas.throwFeatMissing("MissingSnomeds", "edu.cmu.lti.uima.types.EVIDENCE");
    return ll_cas.ll_getRefValue(addr, casFeatCode_MissingSnomeds);
  }
  /** @generated */    
  public void setMissingSnomeds(int addr, int v) {
        if (featOkTst && casFeat_MissingSnomeds == null)
      jcas.throwFeatMissing("MissingSnomeds", "edu.cmu.lti.uima.types.EVIDENCE");
    ll_cas.ll_setRefValue(addr, casFeatCode_MissingSnomeds, v);}
    
   /** @generated */
  public int getMissingSnomeds(int addr, int i) {
        if (featOkTst && casFeat_MissingSnomeds == null)
      jcas.throwFeatMissing("MissingSnomeds", "edu.cmu.lti.uima.types.EVIDENCE");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_MissingSnomeds), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_MissingSnomeds), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_MissingSnomeds), i);
  }
   
  /** @generated */ 
  public void setMissingSnomeds(int addr, int i, int v) {
        if (featOkTst && casFeat_MissingSnomeds == null)
      jcas.throwFeatMissing("MissingSnomeds", "edu.cmu.lti.uima.types.EVIDENCE");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_MissingSnomeds), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_MissingSnomeds), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_MissingSnomeds), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public EVIDENCE_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_Description = jcas.getRequiredFeatureDE(casType, "Description", "uima.cas.String", featOkTst);
    casFeatCode_Description  = (null == casFeat_Description) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Description).getCode();

 
    casFeat_SupportSnomeds = jcas.getRequiredFeatureDE(casType, "SupportSnomeds", "uima.cas.FSArray", featOkTst);
    casFeatCode_SupportSnomeds  = (null == casFeat_SupportSnomeds) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_SupportSnomeds).getCode();

 
    casFeat_MissingSnomeds = jcas.getRequiredFeatureDE(casType, "MissingSnomeds", "uima.cas.FSArray", featOkTst);
    casFeatCode_MissingSnomeds  = (null == casFeat_MissingSnomeds) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_MissingSnomeds).getCode();

  }
}



    