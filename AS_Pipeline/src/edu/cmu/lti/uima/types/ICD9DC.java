

/* First created by JCasGen Tue Mar 26 00:08:15 EDT 2013 */
package edu.cmu.lti.uima.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Fri Apr 26 22:51:47 EDT 2013
 * XML source: /Users/Yitei/Projects/EMRCode/trunk/combined_src/EMREngine/descriptors/TypeSystem.xml
 * @generated */
public class ICD9DC extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(ICD9DC.class);
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
  protected ICD9DC() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public ICD9DC(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public ICD9DC(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public ICD9DC(JCas jcas, int begin, int end) {
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
  //* Feature: Source

  /** getter for Source - gets 
   * @generated */
  public String getSource() {
    if (ICD9DC_Type.featOkTst && ((ICD9DC_Type)jcasType).casFeat_Source == null)
      jcasType.jcas.throwFeatMissing("Source", "edu.cmu.lti.uima.types.ICD9DC");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ICD9DC_Type)jcasType).casFeatCode_Source);}
    
  /** setter for Source - sets  
   * @generated */
  public void setSource(String v) {
    if (ICD9DC_Type.featOkTst && ((ICD9DC_Type)jcasType).casFeat_Source == null)
      jcasType.jcas.throwFeatMissing("Source", "edu.cmu.lti.uima.types.ICD9DC");
    jcasType.ll_cas.ll_setStringValue(addr, ((ICD9DC_Type)jcasType).casFeatCode_Source, v);}    
   
    
  //*--------------*
  //* Feature: Code

  /** getter for Code - gets 
   * @generated */
  public String getCode() {
    if (ICD9DC_Type.featOkTst && ((ICD9DC_Type)jcasType).casFeat_Code == null)
      jcasType.jcas.throwFeatMissing("Code", "edu.cmu.lti.uima.types.ICD9DC");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ICD9DC_Type)jcasType).casFeatCode_Code);}
    
  /** setter for Code - sets  
   * @generated */
  public void setCode(String v) {
    if (ICD9DC_Type.featOkTst && ((ICD9DC_Type)jcasType).casFeat_Code == null)
      jcasType.jcas.throwFeatMissing("Code", "edu.cmu.lti.uima.types.ICD9DC");
    jcasType.ll_cas.ll_setStringValue(addr, ((ICD9DC_Type)jcasType).casFeatCode_Code, v);}    
  }

    