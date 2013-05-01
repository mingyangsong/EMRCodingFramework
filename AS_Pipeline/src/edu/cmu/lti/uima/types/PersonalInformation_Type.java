
/* First created by JCasGen Fri Apr 26 22:51:47 EDT 2013 */
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
public class PersonalInformation_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (PersonalInformation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = PersonalInformation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new PersonalInformation(addr, PersonalInformation_Type.this);
  			   PersonalInformation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new PersonalInformation(addr, PersonalInformation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = PersonalInformation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.uima.types.PersonalInformation");
 
  /** @generated */
  final Feature casFeat_Age;
  /** @generated */
  final int     casFeatCode_Age;
  /** @generated */ 
  public int getAge(int addr) {
        if (featOkTst && casFeat_Age == null)
      jcas.throwFeatMissing("Age", "edu.cmu.lti.uima.types.PersonalInformation");
    return ll_cas.ll_getIntValue(addr, casFeatCode_Age);
  }
  /** @generated */    
  public void setAge(int addr, int v) {
        if (featOkTst && casFeat_Age == null)
      jcas.throwFeatMissing("Age", "edu.cmu.lti.uima.types.PersonalInformation");
    ll_cas.ll_setIntValue(addr, casFeatCode_Age, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Gender;
  /** @generated */
  final int     casFeatCode_Gender;
  /** @generated */ 
  public String getGender(int addr) {
        if (featOkTst && casFeat_Gender == null)
      jcas.throwFeatMissing("Gender", "edu.cmu.lti.uima.types.PersonalInformation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Gender);
  }
  /** @generated */    
  public void setGender(int addr, String v) {
        if (featOkTst && casFeat_Gender == null)
      jcas.throwFeatMissing("Gender", "edu.cmu.lti.uima.types.PersonalInformation");
    ll_cas.ll_setStringValue(addr, casFeatCode_Gender, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public PersonalInformation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_Age = jcas.getRequiredFeatureDE(casType, "Age", "uima.cas.Integer", featOkTst);
    casFeatCode_Age  = (null == casFeat_Age) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Age).getCode();

 
    casFeat_Gender = jcas.getRequiredFeatureDE(casType, "Gender", "uima.cas.String", featOkTst);
    casFeatCode_Gender  = (null == casFeat_Gender) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Gender).getCode();

  }
}



    