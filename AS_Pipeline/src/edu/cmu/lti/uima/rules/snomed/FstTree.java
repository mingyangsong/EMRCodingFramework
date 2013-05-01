package edu.cmu.lti.uima.rules.snomed;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class FstTree {
  /**
   * The root of the FST Tree
   */
  private FstNode root = null;

  /**
   * The default constructure of the FST Tree. It creates a new root.
   * 
   */
  public FstTree() {
    root = new FstNode();
  }

  /**
   * The constructure of the FST Tree. It reads the exist FST Node as the new root.
   * 
   * @param root
   *          The exist FST Node that is assigned to be the root of the FST Tree.
   */
  public FstTree(FstNode root) {
    this.root = root;
  }

  /**
   * Return the root.
   * 
   * @return Return the root.
   */
  public FstNode getRoot() {
    return root;
  }

  /**
   * Set the root.
   * 
   * @param root
   *          The root of the FST Tree.
   */
  public void setRoot(FstNode root) {
    this.root = root;
  }

  /**
   * Load the protein names from a file, and create a FST Tree by the proteins.
   * 
   * @param fileName
   *          The file which contains the proteins.
   * @param list
   *          Specify which protein list the protein belongs to.
   * @param onlyOneTermination
   *          Specify if the FST needs only one termination class or not
   * @throws IOException
   */
  public void loadSnomedDescriptions(String fileName) throws IOException {
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
      String proteinName = reader.readLine();
      while (proteinName != null) {
        addSnomed(proteinName);
        proteinName = reader.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    } finally {
      reader.close();
    }
  }

  /**
   * Load the first specific number of protein names from a file, and create a FST Tree by the
   * proteins.
   * 
   * @param fileName
   *          The file which contains the proteins.
   * @param number
   *          The number of proteins that users want to load into the FST.
   * @throws IOException
   */
  public void loadSnomedDescriptions(String fileName, int number) throws IOException {
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
      for (int i = 0; i < number; i++) {
        String proteinName = reader.readLine();
        if (proteinName == null)
          break;
        addSnomed(proteinName);
        proteinName = reader.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    } finally {
      reader.close();
    }
  }

  /**
   * Add a new protein to the FST by the protein name.
   * 
   * @param proteinName
   *          The new protein's name.
   */
  private FstNode addSnomed(String snomedDescription) {
    FstNode currentNode = root;
    FstNode nextNode = null;
    String[] splitsnomedDescription = snomedDescription.trim().toLowerCase().split("\\s+");
    String word;
    for (int i = 1; i < splitsnomedDescription.length - 1; i++) {
      word = splitsnomedDescription[i];
      if (currentNode.hasRoute(word)) {
        currentNode = currentNode.getChild(word);
        // System.out.println(currentNode.getWord());
      } else {
        nextNode = new FstNode(word, false, currentNode.getDepth() + 1);
        currentNode.addNewChild(nextNode);
        currentNode = nextNode;
        // System.out.println(i+currentNode.getWord());
      }
    }
    // System.out.println(currentNode.getWord());
    currentNode.setFINALSTATEFLAG(true);
    String snomedCode = splitsnomedDescription[0];
    currentNode.setSnomedCode(snomedCode);
    return currentNode;
  }

  /**
   * Return a format String which contains the information of the FST, so that users can see how
   * does the FST looks like on console.
   * 
   * @return Return a format String which contains the information of the FST.
   */
  public String toConsole() {
    return root.toConsole();
  }

  /**
   * Dump the FST Tree object into a file.
   * 
   * @param fileName
   *          The file name of the FST Tree.
   * @throws IOException
   */
  public void DumpToFile(String fileName) throws IOException {
    ObjectOutputStream out = null;
    try {
      out = new ObjectOutputStream(new FileOutputStream(fileName));
      out.writeObject(root);
      out.flush();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      throw e;
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    } finally {
      out.close();
    }
  }

  public void levelOrderTraverse(String fileName) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
    LinkedList<FstNode> L = new LinkedList<FstNode>();
    FstNode dummy = null;
    L.add(root);
    L.add(dummy);
    while (!L.isEmpty()) {
      FstNode n = L.removeFirst();
      if (n == null) {
        writer.write("\n");
        if (!L.isEmpty())
          L.add(n);
      } else {
        if (n != null && n.getSnomedCode()!=null)
          writer.write(n + " ");
        List<FstNode> children = n.getChildrenList();
        if (children != null)
          for (FstNode c : children) {
            L.add(c);
          }
      }
    }
    writer.close();
  }

  /**
   * Restore the FST Tree object from the exist file.
   * 
   * @param fileName
   *          The file name of the FST Tree.
   * @throws IOException
   * @throws ClassNotFoundException
   */
  public void restoreFromFile(String fileName) throws IOException, ClassNotFoundException {
    ObjectInputStream in = null;
    try {
      in = new ObjectInputStream(new FileInputStream(fileName));
      root = (FstNode) in.readObject();
      in.close();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      throw e;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      throw e;
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    } finally {
      in.close();
    }
  }
}