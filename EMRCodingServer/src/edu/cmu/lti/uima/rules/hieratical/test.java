package edu.cmu.lti.uima.rules.hieratical;

import java.io.IOException;

import edu.cmu.lti.uima.server.RealPath;
import edu.cmu.lti.uima.server.StandardOutput;

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
	private static StandardOutput stdOut = StandardOutput.getInstance();

	/**
	 * @param args
	 * @throws IOException
	 */
	public test(String snowMed) throws IOException {
		// TODO Auto-generated method stub
		hieraticalRule tmp = new hieraticalRule();

		long start = System.currentTimeMillis();
		tmp.readRulesThroughFile("C:/Users/s/Desktop/EMRCoding/EMRCoding_Server/EMRCodingServer/WebContent/data/input/infile.txt");
		long end = System.currentTimeMillis();
		stdOut.setString("runtime: " + (end - start) + "ms");
		tmp.getChecker();
		test2 t = new test2(tmp);
		String[] snowMedSet = snowMed.split(" ");
		for (String s : snowMedSet) {
			System.out.println(s);
			snowMed snow = new snowMed();
			snow.setConceptId(s);
			t.addSnowMed(snow);
		}
		t.run();
		/*
		 * Thread th = new Thread(t); th.run();
		 */

	}
}
