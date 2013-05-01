package edu.cmu.lti.uima.rules.hierarchical;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.io.ObjectOutputStream;

//test should include:
/* not concurrent:
 * 1.one to one snowMed iwth not onset
 * 2.one to one and many to one with priority(1 can be found) without onset
 * 3 one to one and many to one with priority(1 can be found)
 * 4 one to one snowMed with onset
 * 5 many to one and one to one with onset (incomplete proority)
 * 6 many to one and one to one with onset (complete proority)
 * concurrent:
 * 7 multiple groups(share one snowMed)
 * 8 multiple groups(not share one snowMed)
 */
public class test {

  /**
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    HierarchicalRule tmp = new HierarchicalRule();

    long start = System.currentTimeMillis();
    tmp.readRulesThroughFile("infile.txt");
    long end = System.currentTimeMillis();
    System.out.println("runtime: " + (end - start) + "ms");
    Object o = tmp.getChecker();
    SnowMed snow1 = new SnowMed();
    SnowMed snow2 = new SnowMed();
    snow1.setConceptId("140004");
    snow2.setConceptId("74960003");
    test2 t = new test2(tmp);
    t.addSnowMed(snow1);
    t.addSnowMed(snow2);
    t.run();
    /*Thread th = new Thread(t);
    th.run();*/
    
  }
}
