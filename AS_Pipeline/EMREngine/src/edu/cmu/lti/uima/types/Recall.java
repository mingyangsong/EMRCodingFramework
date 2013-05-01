

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
public class Recall extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Recall.class);
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
  protected Recall() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Recall(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Recall(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Recall(JCas jcas, int begin, int end) {
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
  //* Feature: TestType

  /** getter for TestType - gets 
   * @generated */
  public String getTestType() {
    if (Recall_Type.featOkTst && ((Recall_Type)jcasType).casFeat_TestType == null)
      jcasType.jcas.throwFeatMissing("TestType", "edu.cmu.lti.uima.types.Recall");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Recall_Type)jcasType).casFeatCode_TestType);}
    
  /** setter for TestType - sets  
   * @generated */
  public void setTestType(String v) {
    if (Recall_Type.featOkTst && ((Recall_Type)jcasType).casFeat_TestType == null)
      jcasType.jcas.throwFeatMissing("TestType", "edu.cmu.lti.uima.types.Recall");
    jcasType.ll_cas.ll_setStringValue(addr, ((Recall_Type)jcasType).casFeatCode_TestType, v);}    
   
    
  //*--------------*
  //* Feature: GoldSource

  /** getter for GoldSource - gets 
   * @generated */
  public String getGoldSource() {
    if (Recall_Type.featOkTst && ((Recall_Type)jcasType).casFeat_GoldSource == null)
      jcasType.jcas.throwFeatMissing("GoldSource", "edu.cmu.lti.uima.types.Recall");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Recall_Type)jcasType).casFeatCode_GoldSource);}
    
  /** setter for GoldSource - sets  
   * @generated */
  public void setGoldSource(String v) {
    if (Recall_Type.featOkTst && ((Recall_Type)jcasType).casFeat_GoldSource == null)
      jcasType.jcas.throwFeatMissing("GoldSource", "edu.cmu.lti.uima.types.Recall");
    jcasType.ll_cas.ll_setStringValue(addr, ((Recall_Type)jcasType).casFeatCode_GoldSource, v);}    
   
    
  //*--------------*
  //* Feature: TestSource

  /** getter for TestSource - gets 
   * @generated */
  public String getTestSource() {
    if (Recall_Type.featOkTst && ((Recall_Type)jcasType).casFeat_TestSource == null)
      jcasType.jcas.throwFeatMissing("TestSource", "edu.cmu.lti.uima.types.Recall");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Recall_Type)jcasType).casFeatCode_TestSource);}
    
  /** setter for TestSource - sets  
   * @generated */
  public void setTestSource(String v) {
    if (Recall_Type.featOkTst && ((Recall_Type)jcasType).casFeat_TestSource == null)
      jcasType.jcas.throwFeatMissing("TestSource", "edu.cmu.lti.uima.types.Recall");
    jcasType.ll_cas.ll_setStringValue(addr, ((Recall_Type)jcasType).casFeatCode_TestSource, v);}    
   
    
  //*--------------*
  //* Feature: Value

  /** getter for Value - gets 
   * @generated */
  public double getValue() {
    if (Recall_Type.featOkTst && ((Recall_Type)jcasType).casFeat_Value == null)
      jcasType.jcas.throwFeatMissing("Value", "edu.cmu.lti.uima.types.Recall");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Recall_Type)jcasType).casFeatCode_Value);}
    
  /** setter for Value - sets  
   * @generated */
  public void setValue(double v) {
    if (Recall_Type.featOkTst && ((Recall_Type)jcasType).casFeat_Value == null)
      jcasType.jcas.throwFeatMissing("Value", "edu.cmu.lti.uima.types.Recall");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Recall_Type)jcasType).casFeatCode_Value, v);}    
   
    
  //*--------------*
  //* Feature: total_recall_icd10

  /** getter for total_recall_icd10 - gets 
   * @generated */
  public double getTotal_recall_icd10() {
    if (Recall_Type.featOkTst && ((Recall_Type)jcasType).casFeat_total_recall_icd10 == null)
      jcasType.jcas.throwFeatMissing("total_recall_icd10", "edu.cmu.lti.uima.types.Recall");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Recall_Type)jcasType).casFeatCode_total_recall_icd10);}
    
  /** setter for total_recall_icd10 - sets  
   * @generated */
  public void setTotal_recall_icd10(double v) {
    if (Recall_Type.featOkTst && ((Recall_Type)jcasType).casFeat_total_recall_icd10 == null)
      jcasType.jcas.throwFeatMissing("total_recall_icd10", "edu.cmu.lti.uima.types.Recall");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Recall_Type)jcasType).casFeatCode_total_recall_icd10, v);}    
   
    
  //*--------------*
  //* Feature: total_gold_size_icd10

  /** getter for total_gold_size_icd10 - gets 
   * @generated */
  public double getTotal_gold_size_icd10() {
    if (Recall_Type.featOkTst && ((Recall_Type)jcasType).casFeat_total_gold_size_icd10 == null)
      jcasType.jcas.throwFeatMissing("total_gold_size_icd10", "edu.cmu.lti.uima.types.Recall");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Recall_Type)jcasType).casFeatCode_total_gold_size_icd10);}
    
  /** setter for total_gold_size_icd10 - sets  
   * @generated */
  public void setTotal_gold_size_icd10(double v) {
    if (Recall_Type.featOkTst && ((Recall_Type)jcasType).casFeat_total_gold_size_icd10 == null)
      jcasType.jcas.throwFeatMissing("total_gold_size_icd10", "edu.cmu.lti.uima.types.Recall");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Recall_Type)jcasType).casFeatCode_total_gold_size_icd10, v);}    
   
    
  //*--------------*
  //* Feature: total_recall_snomed

  /** getter for total_recall_snomed - gets 
   * @generated */
  public double getTotal_recall_snomed() {
    if (Recall_Type.featOkTst && ((Recall_Type)jcasType).casFeat_total_recall_snomed == null)
      jcasType.jcas.throwFeatMissing("total_recall_snomed", "edu.cmu.lti.uima.types.Recall");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Recall_Type)jcasType).casFeatCode_total_recall_snomed);}
    
  /** setter for total_recall_snomed - sets  
   * @generated */
  public void setTotal_recall_snomed(double v) {
    if (Recall_Type.featOkTst && ((Recall_Type)jcasType).casFeat_total_recall_snomed == null)
      jcasType.jcas.throwFeatMissing("total_recall_snomed", "edu.cmu.lti.uima.types.Recall");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Recall_Type)jcasType).casFeatCode_total_recall_snomed, v);}    
   
    
  //*--------------*
  //* Feature: total_gold_size_snomed

  /** getter for total_gold_size_snomed - gets 
   * @generated */
  public double getTotal_gold_size_snomed() {
    if (Recall_Type.featOkTst && ((Recall_Type)jcasType).casFeat_total_gold_size_snomed == null)
      jcasType.jcas.throwFeatMissing("total_gold_size_snomed", "edu.cmu.lti.uima.types.Recall");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Recall_Type)jcasType).casFeatCode_total_gold_size_snomed);}
    
  /** setter for total_gold_size_snomed - sets  
   * @generated */
  public void setTotal_gold_size_snomed(double v) {
    if (Recall_Type.featOkTst && ((Recall_Type)jcasType).casFeat_total_gold_size_snomed == null)
      jcasType.jcas.throwFeatMissing("total_gold_size_snomed", "edu.cmu.lti.uima.types.Recall");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Recall_Type)jcasType).casFeatCode_total_gold_size_snomed, v);}    
  }

    