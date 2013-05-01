package edu.cmu.lti.uima.server;

public class StandardOutput {
	private static final StandardOutput _theInstance = new StandardOutput();

	private String out = "";

	private StandardOutput() {
	}

	public static StandardOutput getInstance() {
		return _theInstance;
	}

	public void setNull() {
		this.out = "";
	}

	public void setString(String s) {
		out = out + s + "\n";
	}

	public String getString() {
		return out;
	}
}
