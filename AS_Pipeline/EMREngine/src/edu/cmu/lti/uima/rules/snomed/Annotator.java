package edu.cmu.lti.uima.rules.snomed;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.nio.cs.ext.MacThai;

import edu.cmu.lti.uima.rules.snomed.FstNode;
import edu.cmu.lti.uima.rules.snomed.FstTree;

public class Annotator {
  /**
   * The Fst Tree of the proteins.
   */
  private FstTree fst = null;

  /**
   * The HashMap to record the labels of an article.
   */
  private static HashMap<Integer, Integer> labelMap = new HashMap<Integer, Integer>();

  /**
   * Construct a object of the class Annotator with the input parameter protein FST.
   * 
   * @param fst
   *          FST of proteins.
   */
  public Annotator(FstTree fst) {
    // Initialize the FST
    this.fst = fst;
  }

  public void annotateFile(String fileName) throws IOException {
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
      String description = reader.readLine();

      while (description != null) {
        // annotateArticleWild(description, 0);
        annotateArticleWild(description, 1);
        description = reader.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    } finally {
      reader.close();
    }
  }

  /**
   * Annotate the input source with the FST. The method put the outcome of labels in a HashMap.
   * Users can get the HashMap by calling the method "getLabelMap()."
   * 
   * @param input
   *          The input source of the artilce.
   * @param isFILE
   *          The flag which specifies the input is a single sentence (false) or a file name (true).
   */

  public HashMap<String, ArrayList<Match>> annotateArticleWild(String input, int MAX_FAILS) {
    //System.out.println("Inside annotate");
    HashMap<String, ArrayList<Match>> snomedMatches = new HashMap<String, ArrayList<Match>>();
    String[] words = input.split(" ");
    //System.out.println("number of words:"+words.length);
    FstNode root = fst.getRoot();
    ArrayList<ActiveNode> activeNodes = new ArrayList<ActiveNode>();
    activeNodes.add(new ActiveNode(root, ""));
    for (String word : words) {
      ArrayList<ActiveNode> newActiveNodes = new ArrayList<ActiveNode>();
      newActiveNodes.add(new ActiveNode(root, ""));
      for (ActiveNode aNode : activeNodes) {
        if (aNode.getNode().hasRoute(word)) {
          FstNode child = aNode.getNode().getChild(word);
          ActiveNode newActiveNode = new ActiveNode(child, aNode.getMatchedString().toString()
                  + " " + word);
          newActiveNodes.add(newActiveNode);
          if (child.isFINALSTATEFLAG())
            addMatch(snomedMatches, newActiveNode.getNode().getSnomedCode(),
                    newActiveNode.getMatchedString(), input);
        }
        if (aNode.getFailCount() < MAX_FAILS) {
          ActiveNode newActiveNode = new ActiveNode(aNode);
          newActiveNode.setMatchedString(aNode.getMatchedString() + " " + word);
          newActiveNode.incrementFailCount();
          newActiveNodes.add(newActiveNode);
        }
        if (aNode.getFailCount() < MAX_FAILS && aNode.getNode().getChildrenList() != null) {
          for (FstNode cNode : aNode.getNode().getChildrenList()) {
            ActiveNode newActiveNode = new ActiveNode(cNode, aNode.getMatchedString() + " " + word,
                    aNode.getFailCount());
            newActiveNode.incrementFailCount();
            newActiveNodes.add(newActiveNode);
          }
        }
      }
      activeNodes.clear();
      activeNodes.addAll(newActiveNodes);
    }
    // System.out.println(input);
    // printMatches(snomedMatches);
    // System.out.println("---------------------");

    return snomedMatches;
  }

  public void printMatches(HashMap<String, ArrayList<String>> snomedMatches) {
    Iterator it = snomedMatches.keySet().iterator();

    while (it.hasNext()) {
      String snomet = (String) it.next();
      ArrayList<String> texts = snomedMatches.get(snomet);
      System.out.println(snomet + "->" + texts.toString());
    }

    /*
     * try { // Create file BufferedWriter out = new BufferedWriter( new FileWriter(
     * "/Users/zhenxiang/Documents/EMRCode/suyounBranch/data/fst/wild.txt"));
     * 
     * if (it.hasNext()) { String snomet = (String) it.next(); ArrayList<String> texts =
     * snomedMatches.get(snomet); System.out.println(snomet + "->" + texts.toString());
     * out.write("abc"); // out.flush(); } for (int i = 0; i < 10; i++) out.write("Hello Java"); //
     * Close the output stream out.flush(); out.close(); } catch (Exception e) {// Catch exception
     * if any System.err.println("Error: " + e.getMessage()); }
     */
  }

  private void addMatch(HashMap<String, ArrayList<Match>> matches, String snomedCode,
          String matchedString, String text) {
    //System.out.println("Inside addMatch");
    Pattern p = Pattern.compile(matchedString);
    Matcher m = p.matcher(text);
    
    //System.out.println("Macthed string:"+matchedString);
    //System.out.println("text:"+text);

    if (m.find()) {
      //System.out.println("Inside matches");

      int start = m.start();
      int end = m.end();

      if (matches.containsKey(snomedCode))
        matches.get(snomedCode).add(new Match(matchedString, start, end));
      else {
        ArrayList<Match> newList = new ArrayList<Match>();
        newList.add(new Match(matchedString, start, end));
        matches.put(snomedCode, newList);
      }
    }
  }

  /**
   * Returns the labelMap.
   * 
   * @return Returns the labelMap.
   */
  public static HashMap<Integer, Integer> getLabelMap() {
    return labelMap;
  }

  public class Match {
    String match;

    int start, end;

    public Match(String str, int s, int e) {
      match = str;
      start = s;
      end = e;
    }
    
    public int getStart() {
      return start;
    }
    
    public int getEnd() {
      return end;
    }
    
    public String getMatchedString() {
      return match;
    }
    
  }

}