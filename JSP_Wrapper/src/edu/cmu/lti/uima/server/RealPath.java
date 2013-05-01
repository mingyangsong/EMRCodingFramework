package edu.cmu.lti.uima.server;

public class RealPath {
	private static final RealPath _theInstance = new RealPath();

	private String realPath = "";

	private RealPath() {
	}

	public static RealPath getInstance() {
		return _theInstance;
	}

	public void set(String s) {
		realPath = s;
	}

	public String get() {
		return realPath;
	}
}
