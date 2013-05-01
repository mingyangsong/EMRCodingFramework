
/* First created by JCasGen Tue Mar 26 00:08:15 EDT 2013 */
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
public class ICD9DC_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (ICD9DC_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = ICD9DC_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new ICD9DC(addr, ICD9DC_Type.this);
  			   ICD9DC_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new ICD9DC(addr, ICD9DC_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = ICD9DC.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.uima.types.ICD9DC");
 
  /** @generated */
  final Feature casFeat_Source;
  /** @generated */
  final int     casFeatCode_Source;
  /** @generated */ 
  public String getSource(int addr) {
        if (featOkTst && casFeat_Source == null)
      jcas.throwFeatMissing("Source", "edu.cmu.lti.uima.types.ICD9DC");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Source);
  }
  /** @generated */    
  public void setSource(int addr, String v) {
        if (featOkTst && casFeat_Source == null)
      jcas.throwFeatMissing("Source", "edu.cmu.lti.uima.types.ICD9DC");
    ll_cas.ll_setStringValue(addr, casFeatCode_Source, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Code;
  /** @generated */
  final int     casFeatCode_Code;
  /** @generated */ 
  public String getCode(int addr) {
        if (featOkTst && casFeat_Code == null)
      jcas.throwFeatMissing("Code", "edu.cmu.lti.uima.types.ICD9DC");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Code);
  }
  /** @generated */    
  public void setCode(int addr, String v) {
        if (featOkTst && casFeat_Code == null)
      jcas.throwFeatMissing("Code", "edu.cmu.lti.uima.types.ICD9DC");
    ll_cas.ll_setStringValue(addr, casFeatCode_Code, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public ICD9DC_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_Source = jcas.getRequiredFeatureDE(casType, "Source", "uima.cas.String", featOkTst);
    casFeatCode_Source  = (null == casFeat_Source) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Source).getCode();

 
    casFeat_Code = jcas.getRequiredFeatureDE(casType, "Code", "uima.cas.String", featOkTst);
    casFeatCode_Code  = (null == casFeat_Code) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Code).getCode();

  }
}



    