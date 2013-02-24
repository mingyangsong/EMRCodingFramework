
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
 * Updated by JCasGen Wed Feb 13 16:54:59 EST 2013
 * @generated */
public class Recall_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Recall_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Recall_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Recall(addr, Recall_Type.this);
  			   Recall_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Recall(addr, Recall_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Recall.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.uima.types.Recall");
 
  /** @generated */
  final Feature casFeat_TestType;
  /** @generated */
  final int     casFeatCode_TestType;
  /** @generated */ 
  public String getTestType(int addr) {
        if (featOkTst && casFeat_TestType == null)
      jcas.throwFeatMissing("TestType", "edu.cmu.lti.uima.types.Recall");
    return ll_cas.ll_getStringValue(addr, casFeatCode_TestType);
  }
  /** @generated */    
  public void setTestType(int addr, String v) {
        if (featOkTst && casFeat_TestType == null)
      jcas.throwFeatMissing("TestType", "edu.cmu.lti.uima.types.Recall");
    ll_cas.ll_setStringValue(addr, casFeatCode_TestType, v);}
    
  
 
  /** @generated */
  final Feature casFeat_GoldSource;
  /** @generated */
  final int     casFeatCode_GoldSource;
  /** @generated */ 
  public String getGoldSource(int addr) {
        if (featOkTst && casFeat_GoldSource == null)
      jcas.throwFeatMissing("GoldSource", "edu.cmu.lti.uima.types.Recall");
    return ll_cas.ll_getStringValue(addr, casFeatCode_GoldSource);
  }
  /** @generated */    
  public void setGoldSource(int addr, String v) {
        if (featOkTst && casFeat_GoldSource == null)
      jcas.throwFeatMissing("GoldSource", "edu.cmu.lti.uima.types.Recall");
    ll_cas.ll_setStringValue(addr, casFeatCode_GoldSource, v);}
    
  
 
  /** @generated */
  final Feature casFeat_TestSource;
  /** @generated */
  final int     casFeatCode_TestSource;
  /** @generated */ 
  public String getTestSource(int addr) {
        if (featOkTst && casFeat_TestSource == null)
      jcas.throwFeatMissing("TestSource", "edu.cmu.lti.uima.types.Recall");
    return ll_cas.ll_getStringValue(addr, casFeatCode_TestSource);
  }
  /** @generated */    
  public void setTestSource(int addr, String v) {
        if (featOkTst && casFeat_TestSource == null)
      jcas.throwFeatMissing("TestSource", "edu.cmu.lti.uima.types.Recall");
    ll_cas.ll_setStringValue(addr, casFeatCode_TestSource, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Value;
  /** @generated */
  final int     casFeatCode_Value;
  /** @generated */ 
  public double getValue(int addr) {
        if (featOkTst && casFeat_Value == null)
      jcas.throwFeatMissing("Value", "edu.cmu.lti.uima.types.Recall");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_Value);
  }
  /** @generated */    
  public void setValue(int addr, double v) {
        if (featOkTst && casFeat_Value == null)
      jcas.throwFeatMissing("Value", "edu.cmu.lti.uima.types.Recall");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_Value, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Recall_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_TestType = jcas.getRequiredFeatureDE(casType, "TestType", "uima.cas.String", featOkTst);
    casFeatCode_TestType  = (null == casFeat_TestType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_TestType).getCode();

 
    casFeat_GoldSource = jcas.getRequiredFeatureDE(casType, "GoldSource", "uima.cas.String", featOkTst);
    casFeatCode_GoldSource  = (null == casFeat_GoldSource) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_GoldSource).getCode();

 
    casFeat_TestSource = jcas.getRequiredFeatureDE(casType, "TestSource", "uima.cas.String", featOkTst);
    casFeatCode_TestSource  = (null == casFeat_TestSource) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_TestSource).getCode();

 
    casFeat_Value = jcas.getRequiredFeatureDE(casType, "Value", "uima.cas.Double", featOkTst);
    casFeatCode_Value  = (null == casFeat_Value) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Value).getCode();

  }
}



    