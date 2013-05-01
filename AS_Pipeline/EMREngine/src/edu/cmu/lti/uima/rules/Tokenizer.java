package edu.cmu.lti.uima.rules;

import java.util.ArrayList;

public class Tokenizer {
  
  public static ArrayList<String> tokenizeDoc(String cur_doc) {
    cur_doc = myTokenizer(cur_doc);
    ArrayList<String> returnTokens = new ArrayList<String>();
    String[] strArr = cur_doc.split("\\W+");
    for (int j = 0; j < strArr.length; j++) {
      if (strArr[j].equals(" ") || strArr[j].equals(""))
        continue;
      String token = strArr[j];
      returnTokens.add(token);
    }
    return returnTokens;
  }

  private static String myTokenizer(String text) {
    text = text.toLowerCase();
    text = text.replaceFirst("\\(finding\\)", "");
    text = text.replaceFirst("\\(disorder\\)", "");
    for (int i = 0; i < text.length(); i++) {
      // System.out.println(text.charAt(i)+"ANIKA");
      if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {

      } else {// System.out.println("hello");
        text = text.replace(text.charAt(i), ' ');
      }
    }
    return text;
  }
}
