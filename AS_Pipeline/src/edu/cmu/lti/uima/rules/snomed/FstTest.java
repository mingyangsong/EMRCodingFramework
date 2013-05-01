package edu.cmu.lti.uima.rules.snomed;

import java.io.IOException;
import java.util.Date;

import edu.cmu.lti.uima.rules.snomed.FstTree;
import edu.cmu.lti.uima.rules.snomed.Annotator;

public class FstTest {

	// private static boolean OUTPUT_SERIALIZED_OBJECT = false;

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {

		FstTree tree = new FstTree();
		double start_time = 0;
		double end_time = 0;

		start_time = new Date().getTime();
		System.out.println("Begin to load the SNOMET and build the tree....");
		tree = new FstTree();
		tree.loadSnomedDescriptions("data/fst/result.txt");
		end_time = new Date().getTime();
		System.out.println("The snomet tree is built completely. "
				+ (end_time - start_time) / 1000 + " secondselasped.");
		System.out.println();

		Annotator tester3 = new Annotator(tree);
		tester3.annotateFile("data/fst/long_description_working_file.txt");

	}

}
