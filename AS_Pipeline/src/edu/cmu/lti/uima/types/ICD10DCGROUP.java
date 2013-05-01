

/* First created by JCasGen Mon Feb 25 22:34:09 EST 2013 */
package edu.cmu.lti.uima.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.NonEmptyFSList;
import org.apache.uima.jcas.cas.IntegerArray;
import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Fri Apr 26 22:51:47 EDT 2013
 * XML source: /Users/Yitei/Projects/EMRCode/trunk/combined_src/EMREngine/descriptors/TypeSystem.xml
 * @generated */
public class ICD10DCGROUP extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(ICD10DCGROUP.class);
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
  protected ICD10DCGROUP() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public ICD10DCGROUP(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public ICD10DCGROUP(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public ICD10DCGROUP(JCas jcas, int begin, int end) {
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
  //* Feature: ICD10DC_List

  /** getter for ICD10DC_List - gets 
   * @generated */
  public NonEmptyFSList getICD10DC_List() {
    if (ICD10DCGROUP_Type.featOkTst && ((ICD10DCGROUP_Type)jcasType).casFeat_ICD10DC_List == null)
      jcasType.jcas.throwFeatMissing("ICD10DC_List", "edu.cmu.lti.uima.types.ICD10DCGROUP");
    return (NonEmptyFSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((ICD10DCGROUP_Type)jcasType).casFeatCode_ICD10DC_List)));}
    
  /** setter for ICD10DC_List - sets  
   * @generated */
  public void setICD10DC_List(NonEmptyFSList v) {
    if (ICD10DCGROUP_Type.featOkTst && ((ICD10DCGROUP_Type)jcasType).casFeat_ICD10DC_List == null)
      jcasType.jcas.throwFeatMissing("ICD10DC_List", "edu.cmu.lti.uima.types.ICD10DCGROUP");
    jcasType.ll_cas.ll_setRefValue(addr, ((ICD10DCGROUP_Type)jcasType).casFeatCode_ICD10DC_List, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: PriorityList

  /** getter for PriorityList - gets 
   * @generated */
  public IntegerArray getPriorityList() {
    if (ICD10DCGROUP_Type.featOkTst && ((ICD10DCGROUP_Type)jcasType).casFeat_PriorityList == null)
      jcasType.jcas.throwFeatMissing("PriorityList", "edu.cmu.lti.uima.types.ICD10DCGROUP");
    return (IntegerArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((ICD10DCGROUP_Type)jcasType).casFeatCode_PriorityList)));}
    
  /** setter for PriorityList - sets  
   * @generated */
  public void setPriorityList(IntegerArray v) {
    if (ICD10DCGROUP_Type.featOkTst && ((ICD10DCGROUP_Type)jcasType).casFeat_PriorityList == null)
      jcasType.jcas.throwFeatMissing("PriorityList", "edu.cmu.lti.uima.types.ICD10DCGROUP");
    jcasType.ll_cas.ll_setRefValue(addr, ((ICD10DCGROUP_Type)jcasType).casFeatCode_PriorityList, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for PriorityList - gets an indexed value - 
   * @generated */
  public int getPriorityList(int i) {
    if (ICD10DCGROUP_Type.featOkTst && ((ICD10DCGROUP_Type)jcasType).casFeat_PriorityList == null)
      jcasType.jcas.throwFeatMissing("PriorityList", "edu.cmu.lti.uima.types.ICD10DCGROUP");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((ICD10DCGROUP_Type)jcasType).casFeatCode_PriorityList), i);
    return jcasType.ll_cas.ll_getIntArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((ICD10DCGROUP_Type)jcasType).casFeatCode_PriorityList), i);}

  /** indexed setter for PriorityList - sets an indexed value - 
   * @generated */
  public void setPriorityList(int i, int v) { 
    if (ICD10DCGROUP_Type.featOkTst && ((ICD10DCGROUP_Type)jcasType).casFeat_PriorityList == null)
      jcasType.jcas.throwFeatMissing("PriorityList", "edu.cmu.lti.uima.types.ICD10DCGROUP");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((ICD10DCGROUP_Type)jcasType).casFeatCode_PriorityList), i);
    jcasType.ll_cas.ll_setIntArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((ICD10DCGROUP_Type)jcasType).casFeatCode_PriorityList), i, v);}
   
    
  //*--------------*
  //* Feature: SourceSnowmed

  /** getter for SourceSnowmed - gets 
   * @generated */
  public SNOMED getSourceSnowmed() {
    if (ICD10DCGROUP_Type.featOkTst && ((ICD10DCGROUP_Type)jcasType).casFeat_SourceSnowmed == null)
      jcasType.jcas.throwFeatMissing("SourceSnowmed", "edu.cmu.lti.uima.types.ICD10DCGROUP");
    return (SNOMED)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((ICD10DCGROUP_Type)jcasType).casFeatCode_SourceSnowmed)));}
    
  /** setter for SourceSnowmed - sets  
   * @generated */
  public void setSourceSnowmed(SNOMED v) {
    if (ICD10DCGROUP_Type.featOkTst && ((ICD10DCGROUP_Type)jcasType).casFeat_SourceSnowmed == null)
      jcasType.jcas.throwFeatMissing("SourceSnowmed", "edu.cmu.lti.uima.types.ICD10DCGROUP");
    jcasType.ll_cas.ll_setRefValue(addr, ((ICD10DCGROUP_Type)jcasType).casFeatCode_SourceSnowmed, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    