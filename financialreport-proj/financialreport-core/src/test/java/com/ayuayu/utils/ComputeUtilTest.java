package com.ayuayu.utils;

import java.io.InputStream;

import org.dom4j.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ayuayu.bean.Report;
import com.ayuayu.constants.ReportType;

public class ComputeUtilTest {
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCompute() {
//		String stockId = "2330";
//		short year = 2014;
//		byte season = 4;
//		Document document = XmlUtil.parse(getInputStream("tifrs-fr0-m1-ci-cr-"
//				+ stockId + "-" + year + "Q" + season + ".xml"));
		// Document document2013 = XmlUtil
		// .parse(getInputStream("tifrs-fr0-m1-ci-cr-"+stockId+"-2013Q4.xml"));
		// Document document2012 = XmlUtil
		// .parse(getInputStream("tw-gaap-ci-"+stockId+"-2012Q4-cr.xml"));
		// Document document2011 = XmlUtil
		// .parse(getInputStream("tw-gaap-ci-"+stockId+"-2011Q4-cr.xml"));
		// Document document2010 = XmlUtil
		// .parse(getInputStream("tw-gaap-ci-"+stockId+"-2010Q4-cr.xml"));
//		Report bsReport = ReportUtil.parseReportData(stockId, year, season,
//				document, ReportType.BALANCE_SHEET);
//		Report isReport = ReportUtil.parseReportData(stockId, year, season,
//				document, ReportType.INCOME_STATEMENT);
//		Report csReport = ReportUtil.parseReportData(stockId, year, season,
//				document, ReportType.CASHFLOW_STATEMENT);
		// Report csReport2013 = ReportUtil.parseReportData("2330", 2013, 4,
		// document2013, ReportType.CASHFLOW_STATEMENT);
		// Report csReport2012 = ReportUtil.parseReportData("2330", 2012, 4,
		// document2012, ReportType.CASHFLOW_STATEMENT);
		// Report csReport2011 = ReportUtil.parseReportData("2330", 2011, 4,
		// document2011, ReportType.CASHFLOW_STATEMENT);
		// Report csReport2010 = ReportUtil.parseReportData("2330", 2010, 4,
		// document2010, ReportType.CASHFLOW_STATEMENT);
//		Report laRatio = ReportUtil.compute(stockId, year, season,
//				ReportType.LIQUIDITY_ANALYSIS, bsReport, isReport, csReport);
//		System.out.println(laRatio);
//		Report roiaRatio = ReportUtil.compute(stockId, year, season,
//				ReportType.RETRUN_ON_INVESTMENT_ANALYSIS, bsReport, isReport,
//				csReport);
//		System.out.println(roiaRatio);
//		Report csaRatio = ReportUtil.compute(stockId, year, season,
//				ReportType.CAPITAL_STRUCTURE_ANALYSIS, bsReport, isReport,
//				csReport);
//		System.out.println(csaRatio);
//		Report opaRatio = ReportUtil.compute(stockId, year, season,
//				ReportType.OPERATING_PERFORMANCE_ANALYSIS, bsReport, isReport,
//				csReport);
//		System.out.println(opaRatio);
//		Report cfRatio = ReportUtil.compute(stockId, year, season,
//				ReportType.CASH_FLOW, bsReport, isReport, csReport);
		// Report cfRatio = ReportUtil.compute("2330", 2014, 4,
		// ReportType.CASH_FLOW, bsReport, isReport, csReport,
		// csReport2013, csReport2012, csReport2011, csReport2010);
//		System.out.println(cfRatio);
		// Report lRatio = ReportUtil.compute("2330", 2014, 4,
		// ReportType.LEVERAGE, bsReport, isReport, csReport);
		// System.out.println(lRatio);
	}

	private static InputStream getInputStream(String fileName) {
		return ClassLoader.getSystemResourceAsStream("stocks/" + fileName);
	}
}
