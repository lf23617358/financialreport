package com.ayuayu.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReadWebUtilTest {
	private String filePath;

	@Before
	public void setUp() throws Exception {
		filePath = System.getProperty("user.home") + File.separator + "stocks";
	}

	@After
	public void tearDown() throws Exception {
	}

	// @Test
	public void testReadWebContentByPost() {
		// Map<String, String> form = new HashMap<String, String>();
		// form.put("step", "1");
		// form.put("DEBUG", "");
		// form.put("CO_ID", "2330");
		// form.put("SYEAR", "2014");
		// form.put("SSEASON", "3");
		// form.put("REPORT_ID", "C");
		// String result = ReadWebUtil.readWebContentByPost(
		// "http://mops.twse.com.tw/server-java/t164sb01", form,
		// "BIG5");
		// System.out.println(result);
		Map<String, String> form = new HashMap<String, String>();
		form.put("myear", "2015");
		form.put("mmon", "8");
		form.put("STK_NO", "2330");
		form.put("login_btn", "+%E6%9F%A5%E8%A9%A2+");
		// String result = ReadWebUtil
		// .readWebContentByPost(
		// "http://www.twse.com.tw/device/ch/trading/exchange/BWIBBU/BWIBBU.php",
		// form, "utf8");
		String result = ReadWebUtil.readWebContentByPost(
				"http://www.twse.com.tw/ch/trading/exchange/BWIBBU/BWIBBU.php",
				form, "big5");
		FileWriter w;
		try {
			w = new FileWriter(new File(filePath + "/test1.txt"));
			w.write(result);
			w.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
	}

	// @Test
	public void testReadWebContentByGet() {
		String result = ReadWebUtil.readWebContentByGet(
				"http://www.google.com.tw/search?q=httpclinet", "UTF-8");
		System.out.println(result);
	}

	@Test
	public void testFileDownload() {
		Map<String, String> form = new HashMap<String, String>();
		form.put("step", "9");
		form.put("functionName", "t164sb01");
		form.put("report_id", "C");
		form.put("co_id", "2412");
		form.put("year", "2013");
		form.put("season", "4");
		String fileName = ReadWebUtil.fileDownload(
				"http://mops.twse.com.tw/server-java/FileDownLoad", filePath,
				form, "UTF-8");
		System.out.println(fileName);
	}

	// @Test
	public void testGaapFileDownload() {
		Map<String, String> form = new HashMap<String, String>();
		form.put("step", "9");
		form.put("functionName", "t147sb02");
		form.put("report_id", "B");
		form.put("co_id", "2412");
		form.put("year", "2010");
		form.put("season", "4");
		ReadWebUtil.fileDownload(
				"http://mops.twse.com.tw/server-java/FileDownLoad", filePath,
				form, "UTF-8");
	}
}
