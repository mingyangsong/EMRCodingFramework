package edu.cmu.lti.uima.server;

public class StandardOutput {
	private static final StandardOutput _theInstance = new StandardOutput();

	private String out = null;

	private StandardOutput() {

	}

	public static StandardOutput getInstance() {
		return _theInstance;
	}

	public void setString(String s) {
		out += s;
	}

	public String getString() {
		return out;
	}
}
