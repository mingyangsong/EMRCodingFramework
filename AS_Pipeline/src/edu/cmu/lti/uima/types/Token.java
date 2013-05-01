

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
public class Token extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Token.class);
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
  protected Token() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Token(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Token(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Token(JCas jcas, int begin, int end) {
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
  //* Feature: DocID

  /** getter for DocID - gets 
   * @generated */
  public String getDocID() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_DocID == null)
      jcasType.jcas.throwFeatMissing("DocID", "edu.cmu.lti.uima.types.Token");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Token_Type)jcasType).casFeatCode_DocID);}
    
  /** setter for DocID - sets  
   * @generated */
  public void setDocID(String v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_DocID == null)
      jcasType.jcas.throwFeatMissing("DocID", "edu.cmu.lti.uima.types.Token");
    jcasType.ll_cas.ll_setStringValue(addr, ((Token_Type)jcasType).casFeatCode_DocID, v);}    
   
    
  //*--------------*
  //* Feature: Tag

  /** getter for Tag - gets 
   * @generated */
  public String getTag() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_Tag == null)
      jcasType.jcas.throwFeatMissing("Tag", "edu.cmu.lti.uima.types.Token");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Token_Type)jcasType).casFeatCode_Tag);}
    
  /** setter for Tag - sets  
   * @generated */
  public void setTag(String v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_Tag == null)
      jcasType.jcas.throwFeatMissing("Tag", "edu.cmu.lti.uima.types.Token");
    jcasType.ll_cas.ll_setStringValue(addr, ((Token_Type)jcasType).casFeatCode_Tag, v);}    
   
    
  //*--------------*
  //* Feature: Text

  /** getter for Text - gets 
   * @generated */
  public String getText() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_Text == null)
      jcasType.jcas.throwFeatMissing("Text", "edu.cmu.lti.uima.types.Token");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Token_Type)jcasType).casFeatCode_Text);}
    
  /** setter for Text - sets  
   * @generated */
  public void setText(String v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_Text == null)
      jcasType.jcas.throwFeatMissing("Text", "edu.cmu.lti.uima.types.Token");
    jcasType.ll_cas.ll_setStringValue(addr, ((Token_Type)jcasType).casFeatCode_Text, v);}    
   
    
  //*--------------*
  //* Feature: Expanded

  /** getter for Expanded - gets 
   * @generated */
  public String getExpanded() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_Expanded == null)
      jcasType.jcas.throwFeatMissing("Expanded", "edu.cmu.lti.uima.types.Token");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Token_Type)jcasType).casFeatCode_Expanded);}
    
  /** setter for Expanded - sets  
   * @generated */
  public void setExpanded(String v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_Expanded == null)
      jcasType.jcas.throwFeatMissing("Expanded", "edu.cmu.lti.uima.types.Token");
    jcasType.ll_cas.ll_setStringValue(addr, ((Token_Type)jcasType).casFeatCode_Expanded, v);}    
  }

    