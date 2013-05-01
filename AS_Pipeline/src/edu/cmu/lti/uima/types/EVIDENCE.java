

/* First created by JCasGen Thu Mar 21 00:56:41 EDT 2013 */
package edu.cmu.lti.uima.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Fri Apr 26 22:51:46 EDT 2013
 * XML source: /Users/Yitei/Projects/EMRCode/trunk/combined_src/EMREngine/descriptors/TypeSystem.xml
 * @generated */
public class EVIDENCE extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(EVIDENCE.class);
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
  protected EVIDENCE() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public EVIDENCE(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public EVIDENCE(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public EVIDENCE(JCas jcas, int begin, int end) {
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
  //* Feature: Description

  /** getter for Description - gets 
   * @generated */
  public String getDescription() {
    if (EVIDENCE_Type.featOkTst && ((EVIDENCE_Type)jcasType).casFeat_Description == null)
      jcasType.jcas.throwFeatMissing("Description", "edu.cmu.lti.uima.types.EVIDENCE");
    return jcasType.ll_cas.ll_getStringValue(addr, ((EVIDENCE_Type)jcasType).casFeatCode_Description);}
    
  /** setter for Description - sets  
   * @generated */
  public void setDescription(String v) {
    if (EVIDENCE_Type.featOkTst && ((EVIDENCE_Type)jcasType).casFeat_Description == null)
      jcasType.jcas.throwFeatMissing("Description", "edu.cmu.lti.uima.types.EVIDENCE");
    jcasType.ll_cas.ll_setStringValue(addr, ((EVIDENCE_Type)jcasType).casFeatCode_Description, v);}    
   
    
  //*--------------*
  //* Feature: SupportSnomeds

  /** getter for SupportSnomeds - gets 
   * @generated */
  public FSArray getSupportSnomeds() {
    if (EVIDENCE_Type.featOkTst && ((EVIDENCE_Type)jcasType).casFeat_SupportSnomeds == null)
      jcasType.jcas.throwFeatMissing("SupportSnomeds", "edu.cmu.lti.uima.types.EVIDENCE");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((EVIDENCE_Type)jcasType).casFeatCode_SupportSnomeds)));}
    
  /** setter for SupportSnomeds - sets  
   * @generated */
  public void setSupportSnomeds(FSArray v) {
    if (EVIDENCE_Type.featOkTst && ((EVIDENCE_Type)jcasType).casFeat_SupportSnomeds == null)
      jcasType.jcas.throwFeatMissing("SupportSnomeds", "edu.cmu.lti.uima.types.EVIDENCE");
    jcasType.ll_cas.ll_setRefValue(addr, ((EVIDENCE_Type)jcasType).casFeatCode_SupportSnomeds, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for SupportSnomeds - gets an indexed value - 
   * @generated */
  public SNOMED getSupportSnomeds(int i) {
    if (EVIDENCE_Type.featOkTst && ((EVIDENCE_Type)jcasType).casFeat_SupportSnomeds == null)
      jcasType.jcas.throwFeatMissing("SupportSnomeds", "edu.cmu.lti.uima.types.EVIDENCE");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((EVIDENCE_Type)jcasType).casFeatCode_SupportSnomeds), i);
    return (SNOMED)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((EVIDENCE_Type)jcasType).casFeatCode_SupportSnomeds), i)));}

  /** indexed setter for SupportSnomeds - sets an indexed value - 
   * @generated */
  public void setSupportSnomeds(int i, SNOMED v) { 
    if (EVIDENCE_Type.featOkTst && ((EVIDENCE_Type)jcasType).casFeat_SupportSnomeds == null)
      jcasType.jcas.throwFeatMissing("SupportSnomeds", "edu.cmu.lti.uima.types.EVIDENCE");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((EVIDENCE_Type)jcasType).casFeatCode_SupportSnomeds), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((EVIDENCE_Type)jcasType).casFeatCode_SupportSnomeds), i, jcasType.ll_cas.ll_getFSRef(v));}
   
    
  //*--------------*
  //* Feature: MissingSnomeds

  /** getter for MissingSnomeds - gets 
   * @generated */
  public FSArray getMissingSnomeds() {
    if (EVIDENCE_Type.featOkTst && ((EVIDENCE_Type)jcasType).casFeat_MissingSnomeds == null)
      jcasType.jcas.throwFeatMissing("MissingSnomeds", "edu.cmu.lti.uima.types.EVIDENCE");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((EVIDENCE_Type)jcasType).casFeatCode_MissingSnomeds)));}
    
  /** setter for MissingSnomeds - sets  
   * @generated */
  public void setMissingSnomeds(FSArray v) {
    if (EVIDENCE_Type.featOkTst && ((EVIDENCE_Type)jcasType).casFeat_MissingSnomeds == null)
      jcasType.jcas.throwFeatMissing("MissingSnomeds", "edu.cmu.lti.uima.types.EVIDENCE");
    jcasType.ll_cas.ll_setRefValue(addr, ((EVIDENCE_Type)jcasType).casFeatCode_MissingSnomeds, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for MissingSnomeds - gets an indexed value - 
   * @generated */
  public EVIDENCE getMissingSnomeds(int i) {
    if (EVIDENCE_Type.featOkTst && ((EVIDENCE_Type)jcasType).casFeat_MissingSnomeds == null)
      jcasType.jcas.throwFeatMissing("MissingSnomeds", "edu.cmu.lti.uima.types.EVIDENCE");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((EVIDENCE_Type)jcasType).casFeatCode_MissingSnomeds), i);
    return (EVIDENCE)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((EVIDENCE_Type)jcasType).casFeatCode_MissingSnomeds), i)));}

  /** indexed setter for MissingSnomeds - sets an indexed value - 
   * @generated */
  public void setMissingSnomeds(int i, EVIDENCE v) { 
    if (EVIDENCE_Type.featOkTst && ((EVIDENCE_Type)jcasType).casFeat_MissingSnomeds == null)
      jcasType.jcas.throwFeatMissing("MissingSnomeds", "edu.cmu.lti.uima.types.EVIDENCE");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((EVIDENCE_Type)jcasType).casFeatCode_MissingSnomeds), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((EVIDENCE_Type)jcasType).casFeatCode_MissingSnomeds), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    