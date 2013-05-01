package edu.cmu.lti.uima.rules.snomed;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class FstNode implements Serializable {
	private static final long serialVersionUID = 7079517340714429667L;

	/**
	 * The character of current FST Node.
	 */
	private String word = null;

	private String snomedCode;

	/**
	 * The flag which determines if the current FST Node represents the final
	 * state or not.
	 */
	private boolean FINALSTATEFLAG = false;

	/**
	 * The depth of the current FST Node in a tree.
	 */
	private int depth = 0;

	/**
	 * The linked list to store the child trees.
	 */
	private LinkedList<FstNode> childrenList = null;
	
	/**
	 * Default Constructure.
	 * 
	 */
	FstNode() {
	}

	/**
	 * Constructure of the FstNode.
	 * 
	 * @param character
	 *            The character of current FST Node.
	 * @param FINALSTATEFLAG
	 *            The flag which determines if the current FST Node represents
	 *            the final state or not.
	 * @param depth
	 *            The depth of the current FST Node in a tree.
	 */
	FstNode(String word, boolean FINALSTATEFLAG, int depth) {
		this.word = word;
		this.FINALSTATEFLAG = FINALSTATEFLAG;
		this.depth = depth;
	}

	/**
	 * Constructure of the FstNode.
	 * 
	 * @param character
	 *            The character of current FST Node.
	 * @param childrenList
	 *            The child tree which needs to be attached to the current FST
	 *            Node.
	 * @param FINALSTATEFLAG
	 *            The flag which determines if the current FST Node represents
	 *            the final state or not.
	 * @param depth
	 *            The depth of the current FST Node in a tree.
	 */
	FstNode(String word, LinkedList<FstNode> childrenList,
			boolean FINALSTATEFLAG, int depth) {
		this.childrenList = childrenList;
		this.word = word;
		this.FINALSTATEFLAG = FINALSTATEFLAG;
		this.depth = depth;
	}
	
	/**
	 * Returns the character.
	 * 
	 * @return Returns the character.
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Set the character.
	 * 
	 * @param character
	 *            The character to set.
	 */
	public void setWord(String word) {
		this.word = word;
	}

	public String getSnomedCode() {
		return snomedCode;
	}

	public void setSnomedCode(String snomedCode) {
		this.snomedCode = snomedCode;
	}

	public boolean isFINALSTATEFLAG() {
		return FINALSTATEFLAG;
	}

	/**
	 * Set the fINALSTATEFLAG.
	 * 
	 * @param finalstateflag
	 *            The fINALSTATEFLAG to set.
	 */
	public void setFINALSTATEFLAG(boolean finalstateflag) {
		FINALSTATEFLAG = finalstateflag;
	}



	/**
	 * Returns the depth.
	 * 
	 * @return Returns the depth.
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * Set the depth.
	 * 
	 * @param depth
	 *            The depth to set.
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * Returns the childrenList.
	 * 
	 * @return Returns the childrenList.
	 */
	public LinkedList<FstNode> getChildrenList() {
		return childrenList;
	}

	/**
	 * Set the childrenList.
	 * 
	 * @param childrenList
	 *            The childrenList to set.
	 */
	public void setChildrenList(LinkedList<FstNode> childrenList) {
		this.childrenList = childrenList;
	}

	/**
	 * Add a new Child into current FST Node by a character.
	 * 
	 * @param character
	 *            The character of the new child.
	 * @param FINALSTATEFLAG
	 *            True if the new child is in the final state. False if not.
	 */
	public void addNewChildByWord(String word, boolean FINALSTATEFLAG) {
		if (childrenList == null) {
			childrenList = new LinkedList<FstNode>();
		}
		childrenList.add(new FstNode(word, FINALSTATEFLAG, depth + 1));
	}

	public void addNewChildList(LinkedList<FstNode> childList) {
		if (childrenList == null) {
			childrenList = new LinkedList<FstNode>();
		}
		Iterator iterator = childList.iterator();
		FstNode child = null;
		while (iterator.hasNext()) {
			child = (FstNode) iterator.next();
			childrenList.add(child);
		}
	}
	
	/**
	 * Add a new Child into current FST Node by a FST Node.
	 * 
	 * @param child
	 *            The FST Node whcih is added into the current FST Node as a new
	 *            child.
	 */
	public void addNewChild(FstNode child) {
		if (childrenList == null) {
			childrenList = new LinkedList<FstNode>();
		}
		childrenList.add(child);
	}

	/**
	 * Return a format String which contains the information of the FST, so that
	 * users can see how does the FST looks like on console.
	 * 
	 * @return Return a format String which contains the information of the FST.
	 */
	public String toConsole() {
		String output = "";
		if (word == null) {
			output += "root";
		} else {
			output += "Char:" + word;
		}
		if (childrenList != null) {
			Iterator iterator = childrenList.iterator();
			int childNumber = 1;
			while (iterator.hasNext()) {
				output += "\n";
				for (int i = 0; i <= depth; i++) {
					output += "\t";
				}
				output += "child-" + childNumber++ + ": "
						+ ((FstNode) iterator.next()).toConsole();
			}
		}
		return output;
	}

	/**
	 * Check if the current FST Node has any further routes to go for the input
	 * character.
	 * 
	 * @param character
	 *            The next character that wants to find a route in the FST.
	 * @return Return true if the current FST Node has further routesto go for
	 *         the input character. Return false if not.
	 */
	public boolean hasRoute(String word) {
		if (childrenList != null) {
			Iterator iterator = childrenList.iterator();
			while (iterator.hasNext()) {
				if (word.equals( ((FstNode) iterator.next()).getWord()) ) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Return a child which conatins a specific character of the current FST
	 * Node.
	 * 
	 * @param character
	 *            The specific character of the child.
	 * @return Return a child which conatins a specific character of the current
	 *         FST Node.
	 */
	public FstNode getChild(String word) {
		Iterator iterator = childrenList.iterator();
		FstNode child = null;
		while (iterator.hasNext()) {
			child = (FstNode) iterator.next();
			if (word.equals(child.getWord())) {
				return child;
			}
		}
		return null;
	}
}
