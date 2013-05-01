package edu.cmu.lti.uima.rules.snomed;

public class ActiveNode {
	private FstNode node;
	private String matchedString;
	private int failCount;

	public ActiveNode(FstNode node, String str) {
		this.node = node;
		matchedString = new String(str);
		failCount = 0;
	}
	
	public ActiveNode(FstNode node, String str, int failCount) {
		this.node = node;
		matchedString = new String(str);
		this.failCount = failCount;
	}
	
	public ActiveNode(ActiveNode activeNode){
		this.node = activeNode.node;
		this.matchedString = activeNode.matchedString;
		this.failCount = activeNode.failCount;
	}

	public void incrementFailCount() {
		failCount++;
	}

	public FstNode getNode() {
		return node;
	}

	public void setNode(FstNode node) {
		this.node = node;
	}

	public String getMatchedString() {
		return matchedString;
	}

	public void setMatchedString(String matchedString) {
		this.matchedString = matchedString;
	}

	public int getFailCount() {
		return failCount;
	}

	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}
}
