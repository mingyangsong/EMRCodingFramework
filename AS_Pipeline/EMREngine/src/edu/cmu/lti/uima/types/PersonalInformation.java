

/* First created by JCasGen Fri Apr 26 22:51:47 EDT 2013 */
package edu.cmu.lti.uima.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Fri Apr 26 22:51:47 EDT 2013
 * XML source: /Users/Yitei/Projects/EMRCode/trunk/combined_src/EMREngine/descriptors/TypeSystem.xml
 * @generated */
public class PersonalInformation extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(PersonalInformation.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected PersonalInformation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public PersonalInformation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public PersonalInformation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public PersonalInformation(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: Age

  /** getter for Age - gets 
   * @generated */
  public int getAge() {
    if (PersonalInformation_Type.featOkTst && ((PersonalInformation_Type)jcasType).casFeat_Age == null)
      jcasType.jcas.throwFeatMissing("Age", "edu.cmu.lti.uima.types.PersonalInformation");
    return jcasType.ll_cas.ll_getIntValue(addr, ((PersonalInformation_Type)jcasType).casFeatCode_Age);}
    
  /** setter for Age - sets  
   * @generated */
  public void setAge(int v) {
    if (PersonalInformation_Type.featOkTst && ((PersonalInformation_Type)jcasType).casFeat_Age == null)
      jcasType.jcas.throwFeatMissing("Age", "edu.cmu.lti.uima.types.PersonalInformation");
    jcasType.ll_cas.ll_setIntValue(addr, ((PersonalInformation_Type)jcasType).casFeatCode_Age, v);}    
   
    
  //*--------------*
  //* Feature: Gender

  /** getter for Gender - gets 
   * @generated */
  public String getGender() {
    if (PersonalInformation_Type.featOkTst && ((PersonalInformation_Type)jcasType).casFeat_Gender == null)
      jcasType.jcas.throwFeatMissing("Gender", "edu.cmu.lti.uima.types.PersonalInformation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((PersonalInformation_Type)jcasType).casFeatCode_Gender);}
    
  /** setter for Gender - sets  
   * @generated */
  public void setGender(String v) {
    if (PersonalInformation_Type.featOkTst && ((PersonalInformation_Type)jcasType).casFeat_Gender == null)
      jcasType.jcas.throwFeatMissing("Gender", "edu.cmu.lti.uima.types.PersonalInformation");
    jcasType.ll_cas.ll_setStringValue(addr, ((PersonalInformation_Type)jcasType).casFeatCode_Gender, v);}    
  }

    