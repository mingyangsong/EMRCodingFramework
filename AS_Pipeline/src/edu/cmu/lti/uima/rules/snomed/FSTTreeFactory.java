package edu.cmu.lti.uima.rules.snomed;

import edu.cmu.lti.uima.rules.snomed.FstTree;

public class FSTTreeFactory {

	private static FstTree fstTree = new FstTree();
	
	public static FstTree createFSTTree(){
		
		if (fstTree == null){
			fstTree = new FstTree();
		}
		
		return fstTree;
	}
	
}
