

/* First created by JCasGen Mon Feb 11 16:10:18 EST 2013 */
package edu.cmu.lti.uima.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Fri Apr 26 22:51:47 EDT 2013
 * XML source: /Users/Yitei/Projects/EMRCode/trunk/combined_src/EMREngine/descriptors/TypeSystem.xml
 * @generated */
public class ICD10DC extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(ICD10DC.class);
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
  protected ICD10DC() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public ICD10DC(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public ICD10DC(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public ICD10DC(JCas jcas, int begin, int end) {
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
    if (ICD10DC_Type.featOkTst && ((ICD10DC_Type)jcasType).casFeat_Source == null)
      jcasType.jcas.throwFeatMissing("Source", "edu.cmu.lti.uima.types.ICD10DC");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ICD10DC_Type)jcasType).casFeatCode_Source);}
    
  /** setter for Source - sets  
   * @generated */
  public void setSource(String v) {
    if (ICD10DC_Type.featOkTst && ((ICD10DC_Type)jcasType).casFeat_Source == null)
      jcasType.jcas.throwFeatMissing("Source", "edu.cmu.lti.uima.types.ICD10DC");
    jcasType.ll_cas.ll_setStringValue(addr, ((ICD10DC_Type)jcasType).casFeatCode_Source, v);}    
   
    
  //*--------------*
  //* Feature: Code

  /** getter for Code - gets 
   * @generated */
  public String getCode() {
    if (ICD10DC_Type.featOkTst && ((ICD10DC_Type)jcasType).casFeat_Code == null)
      jcasType.jcas.throwFeatMissing("Code", "edu.cmu.lti.uima.types.ICD10DC");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ICD10DC_Type)jcasType).casFeatCode_Code);}
    
  /** setter for Code - sets  
   * @generated */
  public void setCode(String v) {
    if (ICD10DC_Type.featOkTst && ((ICD10DC_Type)jcasType).casFeat_Code == null)
      jcasType.jcas.throwFeatMissing("Code", "edu.cmu.lti.uima.types.ICD10DC");
    jcasType.ll_cas.ll_setStringValue(addr, ((ICD10DC_Type)jcasType).casFeatCode_Code, v);}    
   
    
  //*--------------*
  //* Feature: Evidence

  /** getter for Evidence - gets 
   * @generated */
  public EVIDENCE getEvidence() {
    if (ICD10DC_Type.featOkTst && ((ICD10DC_Type)jcasType).casFeat_Evidence == null)
      jcasType.jcas.throwFeatMissing("Evidence", "edu.cmu.lti.uima.types.ICD10DC");
    return (EVIDENCE)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((ICD10DC_Type)jcasType).casFeatCode_Evidence)));}
    
  /** setter for Evidence - sets  
   * @generated */
  public void setEvidence(EVIDENCE v) {
    if (ICD10DC_Type.featOkTst && ((ICD10DC_Type)jcasType).casFeat_Evidence == null)
      jcasType.jcas.throwFeatMissing("Evidence", "edu.cmu.lti.uima.types.ICD10DC");
    jcasType.ll_cas.ll_setRefValue(addr, ((ICD10DC_Type)jcasType).casFeatCode_Evidence, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: Confidence

  /** getter for Confidence - gets 
   * @generated */
  public double getConfidence() {
    if (ICD10DC_Type.featOkTst && ((ICD10DC_Type)jcasType).casFeat_Confidence == null)
      jcasType.jcas.throwFeatMissing("Confidence", "edu.cmu.lti.uima.types.ICD10DC");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((ICD10DC_Type)jcasType).casFeatCode_Confidence);}
    
  /** setter for Confidence - sets  
   * @generated */
  public void setConfidence(double v) {
    if (ICD10DC_Type.featOkTst && ((ICD10DC_Type)jcasType).casFeat_Confidence == null)
      jcasType.jcas.throwFeatMissing("Confidence", "edu.cmu.lti.uima.types.ICD10DC");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((ICD10DC_Type)jcasType).casFeatCode_Confidence, v);}    
   
    
  //*--------------*
  //* Feature: sourceGroup

  /** getter for sourceGroup - gets 
   * @generated */
  public ICD10DCGROUP getSourceGroup() {
    if (ICD10DC_Type.featOkTst && ((ICD10DC_Type)jcasType).casFeat_sourceGroup == null)
      jcasType.jcas.throwFeatMissing("sourceGroup", "edu.cmu.lti.uima.types.ICD10DC");
    return (ICD10DCGROUP)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((ICD10DC_Type)jcasType).casFeatCode_sourceGroup)));}
    
  /** setter for sourceGroup - sets  
   * @generated */
  public void setSourceGroup(ICD10DCGROUP v) {
    if (ICD10DC_Type.featOkTst && ((ICD10DC_Type)jcasType).casFeat_sourceGroup == null)
      jcasType.jcas.throwFeatMissing("sourceGroup", "edu.cmu.lti.uima.types.ICD10DC");
    jcasType.ll_cas.ll_setRefValue(addr, ((ICD10DC_Type)jcasType).casFeatCode_sourceGroup, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    