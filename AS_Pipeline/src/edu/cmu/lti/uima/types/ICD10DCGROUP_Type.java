
/* First created by JCasGen Mon Feb 25 22:34:10 EST 2013 */
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
public class ICD10DCGROUP_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (ICD10DCGROUP_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = ICD10DCGROUP_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new ICD10DCGROUP(addr, ICD10DCGROUP_Type.this);
  			   ICD10DCGROUP_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new ICD10DCGROUP(addr, ICD10DCGROUP_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = ICD10DCGROUP.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.uima.types.ICD10DCGROUP");
 
  /** @generated */
  final Feature casFeat_ICD10DC_List;
  /** @generated */
  final int     casFeatCode_ICD10DC_List;
  /** @generated */ 
  public int getICD10DC_List(int addr) {
        if (featOkTst && casFeat_ICD10DC_List == null)
      jcas.throwFeatMissing("ICD10DC_List", "edu.cmu.lti.uima.types.ICD10DCGROUP");
    return ll_cas.ll_getRefValue(addr, casFeatCode_ICD10DC_List);
  }
  /** @generated */    
  public void setICD10DC_List(int addr, int v) {
        if (featOkTst && casFeat_ICD10DC_List == null)
      jcas.throwFeatMissing("ICD10DC_List", "edu.cmu.lti.uima.types.ICD10DCGROUP");
    ll_cas.ll_setRefValue(addr, casFeatCode_ICD10DC_List, v);}
    
  
 
  /** @generated */
  final Feature casFeat_PriorityList;
  /** @generated */
  final int     casFeatCode_PriorityList;
  /** @generated */ 
  public int getPriorityList(int addr) {
        if (featOkTst && casFeat_PriorityList == null)
      jcas.throwFeatMissing("PriorityList", "edu.cmu.lti.uima.types.ICD10DCGROUP");
    return ll_cas.ll_getRefValue(addr, casFeatCode_PriorityList);
  }
  /** @generated */    
  public void setPriorityList(int addr, int v) {
        if (featOkTst && casFeat_PriorityList == null)
      jcas.throwFeatMissing("PriorityList", "edu.cmu.lti.uima.types.ICD10DCGROUP");
    ll_cas.ll_setRefValue(addr, casFeatCode_PriorityList, v);}
    
   /** @generated */
  public int getPriorityList(int addr, int i) {
        if (featOkTst && casFeat_PriorityList == null)
      jcas.throwFeatMissing("PriorityList", "edu.cmu.lti.uima.types.ICD10DCGROUP");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getIntArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_PriorityList), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_PriorityList), i);
  return ll_cas.ll_getIntArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_PriorityList), i);
  }
   
  /** @generated */ 
  public void setPriorityList(int addr, int i, int v) {
        if (featOkTst && casFeat_PriorityList == null)
      jcas.throwFeatMissing("PriorityList", "edu.cmu.lti.uima.types.ICD10DCGROUP");
    if (lowLevelTypeChecks)
      ll_cas.ll_setIntArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_PriorityList), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_PriorityList), i);
    ll_cas.ll_setIntArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_PriorityList), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_SourceSnowmed;
  /** @generated */
  final int     casFeatCode_SourceSnowmed;
  /** @generated */ 
  public int getSourceSnowmed(int addr) {
        if (featOkTst && casFeat_SourceSnowmed == null)
      jcas.throwFeatMissing("SourceSnowmed", "edu.cmu.lti.uima.types.ICD10DCGROUP");
    return ll_cas.ll_getRefValue(addr, casFeatCode_SourceSnowmed);
  }
  /** @generated */    
  public void setSourceSnowmed(int addr, int v) {
        if (featOkTst && casFeat_SourceSnowmed == null)
      jcas.throwFeatMissing("SourceSnowmed", "edu.cmu.lti.uima.types.ICD10DCGROUP");
    ll_cas.ll_setRefValue(addr, casFeatCode_SourceSnowmed, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public ICD10DCGROUP_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_ICD10DC_List = jcas.getRequiredFeatureDE(casType, "ICD10DC_List", "uima.cas.NonEmptyFSList", featOkTst);
    casFeatCode_ICD10DC_List  = (null == casFeat_ICD10DC_List) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ICD10DC_List).getCode();

 
    casFeat_PriorityList = jcas.getRequiredFeatureDE(casType, "PriorityList", "uima.cas.IntegerArray", featOkTst);
    casFeatCode_PriorityList  = (null == casFeat_PriorityList) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_PriorityList).getCode();

 
    casFeat_SourceSnowmed = jcas.getRequiredFeatureDE(casType, "SourceSnowmed", "edu.cmu.lti.uima.types.SNOMED", featOkTst);
    casFeatCode_SourceSnowmed  = (null == casFeat_SourceSnowmed) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_SourceSnowmed).getCode();

  }
}



    