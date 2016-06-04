package com.ayuayu.utils;

import java.util.Map.Entry;

import org.dom4j.Document;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ayuayu.bean.Data;
import com.ayuayu.bean.DayOfReport;
import com.ayuayu.bean.Report;

public class ReportUtilTest {
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAnalaystReportData() {
		String stockId = "2330";
		short year = 2013;
		byte season = 1;
		Document document = XmlUtil.parse(TesterUtils
				.getInputStream("tifrs-fr1-m1-ci-cr-2330-2014Q1.xml"));
		Report report = ReportUtil.parseReportData(stockId, year, season,
				document);
		System.out.println(report);
		Assert.assertEquals(
				(long) report.getData("Assets"),
				report.getData("Liabilities").longValue()
						+ report.getData("Equity").longValue());
		Assert.assertEquals((long) report.getData("Assets"),
				report.getData("CurrentAssets").longValue()
						+ report.getData("NoncurrentAssets").longValue());
		Assert.assertEquals((long) report.getData("Liabilities"),
				report.getData("CurrentLiabilities").longValue()
						+ report.getData("NoncurrentLiabilities").longValue());
		// report = ReportUtil.parseReportData(stockId, year, season, document);
		System.out.println(report);
		// report = ReportUtil.parseReportData(stockId, year, season, document);
		System.out.println(report);
	}

	@Test
	public void testParseIndicators() {
		DayOfReport report = ReportUtil.parseIndicators("2330", 2013, 8,
				TesterUtils.getInputStream("test1.txt"));
		for (Entry<String, Data> entry : report.getAllDatas().entrySet()) {
			System.out.println(entry.getKey() + ":");
			for (Entry<Integer, Number> subEntry : entry.getValue().getDatas()
					.entrySet()) {
				System.out.println("\t" + report.getYear() + "/"
						+ report.getMonth() + "/" + subEntry.getKey() + "\t"
						+ subEntry.getValue());
			}
		}
	}
}
