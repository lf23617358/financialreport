package com.ayuayu.utils;

import org.dom4j.Document;
import org.junit.Test;

import com.ayuayu.bean.Report;
import com.ayuayu.constants.ReportType;
import com.ayuayu.model.statement.BalanceSheetIfrs;
import com.ayuayu.model.statement.CashFlowStatementIfrs;
import com.ayuayu.model.statement.IncomeStatementIfrs;

public class MappingUtilsTest {

	@Test
	public void testMappingAttr() {
		Document document = XmlUtil.parse(TesterUtils
				.getInputStream("tifrs-fr1-m1-ci-cr-2412-2014Q4.xml"));

		Report report = ReportUtil.parseReportData("2330", (short) 2014,
				(byte) 4, document, ReportType.BALANCE_SHEET);

		report.addAllData(ReportUtil.parseReportData("2330", (short) 2014,
				(byte) 1, document, ReportType.INCOME_STATEMENT));

		report.addAllData(ReportUtil.parseReportData("2330", (short) 2014,
				(byte) 1, document, ReportType.CASHFLOW_STATEMENT));

		MappingUtils.mappingAttr(report, BalanceSheetIfrs.class);
		MappingUtils.mappingAttr(report, IncomeStatementIfrs.class);
		MappingUtils.mappingAttr(report, CashFlowStatementIfrs.class);
	}
}
