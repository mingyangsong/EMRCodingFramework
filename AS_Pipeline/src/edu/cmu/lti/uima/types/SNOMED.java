

/* First created by JCasGen Mon Feb 11 16:10:18 EST 2013 */
package edu.cmu.lti.uima.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.IntegerArray;
import org.apache.uima.jcas.tcas.Annotation;


import org.apache.uima.jcas.cas.StringArray;


/** 
 * Updated by JCasGen Fri Apr 26 22:51:47 EDT 2013
 * XML source: /Users/Yitei/Projects/EMRCode/trunk/combined_src/EMREngine/descriptors/TypeSystem.xml
 * @generated */
public class SNOMED extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(SNOMED.class);
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
  protected SNOMED() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public SNOMED(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public SNOMED(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public SNOMED(JCas jcas, int begin, int end) {
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
  //* Feature: ConceptID

  /** getter for ConceptID - gets 
   * @generated */
  public String getConceptID() {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_ConceptID == null)
      jcasType.jcas.throwFeatMissing("ConceptID", "edu.cmu.lti.uima.types.SNOMED");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SNOMED_Type)jcasType).casFeatCode_ConceptID);}
    
  /** setter for ConceptID - sets  
   * @generated */
  public void setConceptID(String v) {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_ConceptID == null)
      jcasType.jcas.throwFeatMissing("ConceptID", "edu.cmu.lti.uima.types.SNOMED");
    jcasType.ll_cas.ll_setStringValue(addr, ((SNOMED_Type)jcasType).casFeatCode_ConceptID, v);}    
   
    
  //*--------------*
  //* Feature: ConceptStatus

  /** getter for ConceptStatus - gets 
   * @generated */
  public int getConceptStatus() {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_ConceptStatus == null)
      jcasType.jcas.throwFeatMissing("ConceptStatus", "edu.cmu.lti.uima.types.SNOMED");
    return jcasType.ll_cas.ll_getIntValue(addr, ((SNOMED_Type)jcasType).casFeatCode_ConceptStatus);}
    
  /** setter for ConceptStatus - sets  
   * @generated */
  public void setConceptStatus(int v) {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_ConceptStatus == null)
      jcasType.jcas.throwFeatMissing("ConceptStatus", "edu.cmu.lti.uima.types.SNOMED");
    jcasType.ll_cas.ll_setIntValue(addr, ((SNOMED_Type)jcasType).casFeatCode_ConceptStatus, v);}    
   
    
  //*--------------*
  //* Feature: IsPrimitive

  /** getter for IsPrimitive - gets 
   * @generated */
  public boolean getIsPrimitive() {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_IsPrimitive == null)
      jcasType.jcas.throwFeatMissing("IsPrimitive", "edu.cmu.lti.uima.types.SNOMED");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((SNOMED_Type)jcasType).casFeatCode_IsPrimitive);}
    
  /** setter for IsPrimitive - sets  
   * @generated */
  public void setIsPrimitive(boolean v) {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_IsPrimitive == null)
      jcasType.jcas.throwFeatMissing("IsPrimitive", "edu.cmu.lti.uima.types.SNOMED");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((SNOMED_Type)jcasType).casFeatCode_IsPrimitive, v);}    
   
    
  //*--------------*
  //* Feature: id

  /** getter for id - gets 
   * @generated */
  public String getId() {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.lti.uima.types.SNOMED");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SNOMED_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated */
  public void setId(String v) {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.lti.uima.types.SNOMED");
    jcasType.ll_cas.ll_setStringValue(addr, ((SNOMED_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: FullySpecifiedName

  /** getter for FullySpecifiedName - gets 
   * @generated */
  public String getFullySpecifiedName() {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_FullySpecifiedName == null)
      jcasType.jcas.throwFeatMissing("FullySpecifiedName", "edu.cmu.lti.uima.types.SNOMED");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SNOMED_Type)jcasType).casFeatCode_FullySpecifiedName);}
    
  /** setter for FullySpecifiedName - sets  
   * @generated */
  public void setFullySpecifiedName(String v) {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_FullySpecifiedName == null)
      jcasType.jcas.throwFeatMissing("FullySpecifiedName", "edu.cmu.lti.uima.types.SNOMED");
    jcasType.ll_cas.ll_setStringValue(addr, ((SNOMED_Type)jcasType).casFeatCode_FullySpecifiedName, v);}    
   
    
  //*--------------*
  //* Feature: PreferedTermId

  /** getter for PreferedTermId - gets 
   * @generated */
  public int getPreferedTermId() {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_PreferedTermId == null)
      jcasType.jcas.throwFeatMissing("PreferedTermId", "edu.cmu.lti.uima.types.SNOMED");
    return jcasType.ll_cas.ll_getIntValue(addr, ((SNOMED_Type)jcasType).casFeatCode_PreferedTermId);}
    
  /** setter for PreferedTermId - sets  
   * @generated */
  public void setPreferedTermId(int v) {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_PreferedTermId == null)
      jcasType.jcas.throwFeatMissing("PreferedTermId", "edu.cmu.lti.uima.types.SNOMED");
    jcasType.ll_cas.ll_setIntValue(addr, ((SNOMED_Type)jcasType).casFeatCode_PreferedTermId, v);}    
   
    
  //*--------------*
  //* Feature: PreferedTermDesc

  /** getter for PreferedTermDesc - gets 
   * @generated */
  public String getPreferedTermDesc() {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_PreferedTermDesc == null)
      jcasType.jcas.throwFeatMissing("PreferedTermDesc", "edu.cmu.lti.uima.types.SNOMED");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SNOMED_Type)jcasType).casFeatCode_PreferedTermDesc);}
    
  /** setter for PreferedTermDesc - sets  
   * @generated */
  public void setPreferedTermDesc(String v) {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_PreferedTermDesc == null)
      jcasType.jcas.throwFeatMissing("PreferedTermDesc", "edu.cmu.lti.uima.types.SNOMED");
    jcasType.ll_cas.ll_setStringValue(addr, ((SNOMED_Type)jcasType).casFeatCode_PreferedTermDesc, v);}    
   
    
  //*--------------*
  //* Feature: Symptoms

  /** getter for Symptoms - gets 
   * @generated */
  public StringArray getSymptoms() {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_Symptoms == null)
      jcasType.jcas.throwFeatMissing("Symptoms", "edu.cmu.lti.uima.types.SNOMED");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((SNOMED_Type)jcasType).casFeatCode_Symptoms)));}
    
  /** setter for Symptoms - sets  
   * @generated */
  public void setSymptoms(StringArray v) {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_Symptoms == null)
      jcasType.jcas.throwFeatMissing("Symptoms", "edu.cmu.lti.uima.types.SNOMED");
    jcasType.ll_cas.ll_setRefValue(addr, ((SNOMED_Type)jcasType).casFeatCode_Symptoms, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for Symptoms - gets an indexed value - 
   * @generated */
  public String getSymptoms(int i) {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_Symptoms == null)
      jcasType.jcas.throwFeatMissing("Symptoms", "edu.cmu.lti.uima.types.SNOMED");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((SNOMED_Type)jcasType).casFeatCode_Symptoms), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((SNOMED_Type)jcasType).casFeatCode_Symptoms), i);}

  /** indexed setter for Symptoms - sets an indexed value - 
   * @generated */
  public void setSymptoms(int i, String v) { 
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_Symptoms == null)
      jcasType.jcas.throwFeatMissing("Symptoms", "edu.cmu.lti.uima.types.SNOMED");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((SNOMED_Type)jcasType).casFeatCode_Symptoms), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((SNOMED_Type)jcasType).casFeatCode_Symptoms), i, v);}
   
    
  //*--------------*
  //* Feature: Source

  /** getter for Source - gets 
   * @generated */
  public String getSource() {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_Source == null)
      jcasType.jcas.throwFeatMissing("Source", "edu.cmu.lti.uima.types.SNOMED");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SNOMED_Type)jcasType).casFeatCode_Source);}
    
  /** setter for Source - sets  
   * @generated */
  public void setSource(String v) {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_Source == null)
      jcasType.jcas.throwFeatMissing("Source", "edu.cmu.lti.uima.types.SNOMED");
    jcasType.ll_cas.ll_setStringValue(addr, ((SNOMED_Type)jcasType).casFeatCode_Source, v);}    
   
    
  //*--------------*
  //* Feature: Confidence

  /** getter for Confidence - gets 
   * @generated */
  public double getConfidence() {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_Confidence == null)
      jcasType.jcas.throwFeatMissing("Confidence", "edu.cmu.lti.uima.types.SNOMED");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((SNOMED_Type)jcasType).casFeatCode_Confidence);}
    
  /** setter for Confidence - sets  
   * @generated */
  public void setConfidence(double v) {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_Confidence == null)
      jcasType.jcas.throwFeatMissing("Confidence", "edu.cmu.lti.uima.types.SNOMED");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((SNOMED_Type)jcasType).casFeatCode_Confidence, v);}    
   
    
  //*--------------*
  //* Feature: BeginPositions

  /** getter for BeginPositions - gets 
   * @generated */
  public IntegerArray getBeginPositions() {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_BeginPositions == null)
      jcasType.jcas.throwFeatMissing("BeginPositions", "edu.cmu.lti.uima.types.SNOMED");
    return (IntegerArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((SNOMED_Type)jcasType).casFeatCode_BeginPositions)));}
    
  /** setter for BeginPositions - sets  
   * @generated */
  public void setBeginPositions(IntegerArray v) {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_BeginPositions == null)
      jcasType.jcas.throwFeatMissing("BeginPositions", "edu.cmu.lti.uima.types.SNOMED");
    jcasType.ll_cas.ll_setRefValue(addr, ((SNOMED_Type)jcasType).casFeatCode_BeginPositions, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for BeginPositions - gets an indexed value - 
   * @generated */
  public int getBeginPositions(int i) {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_BeginPositions == null)
      jcasType.jcas.throwFeatMissing("BeginPositions", "edu.cmu.lti.uima.types.SNOMED");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((SNOMED_Type)jcasType).casFeatCode_BeginPositions), i);
    return jcasType.ll_cas.ll_getIntArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((SNOMED_Type)jcasType).casFeatCode_BeginPositions), i);}

  /** indexed setter for BeginPositions - sets an indexed value - 
   * @generated */
  public void setBeginPositions(int i, int v) { 
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_BeginPositions == null)
      jcasType.jcas.throwFeatMissing("BeginPositions", "edu.cmu.lti.uima.types.SNOMED");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((SNOMED_Type)jcasType).casFeatCode_BeginPositions), i);
    jcasType.ll_cas.ll_setIntArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((SNOMED_Type)jcasType).casFeatCode_BeginPositions), i, v);}
   
    
  //*--------------*
  //* Feature: EndPositions

  /** getter for EndPositions - gets 
   * @generated */
  public IntegerArray getEndPositions() {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_EndPositions == null)
      jcasType.jcas.throwFeatMissing("EndPositions", "edu.cmu.lti.uima.types.SNOMED");
    return (IntegerArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((SNOMED_Type)jcasType).casFeatCode_EndPositions)));}
    
  /** setter for EndPositions - sets  
   * @generated */
  public void setEndPositions(IntegerArray v) {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_EndPositions == null)
      jcasType.jcas.throwFeatMissing("EndPositions", "edu.cmu.lti.uima.types.SNOMED");
    jcasType.ll_cas.ll_setRefValue(addr, ((SNOMED_Type)jcasType).casFeatCode_EndPositions, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for EndPositions - gets an indexed value - 
   * @generated */
  public int getEndPositions(int i) {
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_EndPositions == null)
      jcasType.jcas.throwFeatMissing("EndPositions", "edu.cmu.lti.uima.types.SNOMED");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((SNOMED_Type)jcasType).casFeatCode_EndPositions), i);
    return jcasType.ll_cas.ll_getIntArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((SNOMED_Type)jcasType).casFeatCode_EndPositions), i);}

  /** indexed setter for EndPositions - sets an indexed value - 
   * @generated */
  public void setEndPositions(int i, int v) { 
    if (SNOMED_Type.featOkTst && ((SNOMED_Type)jcasType).casFeat_EndPositions == null)
      jcasType.jcas.throwFeatMissing("EndPositions", "edu.cmu.lti.uima.types.SNOMED");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((SNOMED_Type)jcasType).casFeatCode_EndPositions), i);
    jcasType.ll_cas.ll_setIntArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((SNOMED_Type)jcasType).casFeatCode_EndPositions), i, v);}
  }

    