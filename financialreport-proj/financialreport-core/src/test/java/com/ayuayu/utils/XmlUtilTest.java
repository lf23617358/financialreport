package com.ayuayu.utils;

import org.dom4j.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class XmlUtilTest {
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testParse() {
		Document document = XmlUtil.parse(TesterUtils
				.getInputStream("tifrs-fr0-m1-ci-cr-2330-2013Q4.xml"));
		System.out.println(document);
	}

	@Test
	public void testPrint() {
		Document document = XmlUtil.parse(TesterUtils
				.getInputStream("tifrs-fr0-m1-ci-cr-2330-2013Q4.xml"));
		XmlUtil.print(document);
	}

}
