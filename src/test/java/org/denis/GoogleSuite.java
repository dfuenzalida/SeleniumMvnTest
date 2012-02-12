package org.denis;

import junit.framework.Test;
import junit.framework.TestSuite;

public class GoogleSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(LibrosTestCase.class);
		return suite;
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
