package com.ayuayu.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ayuayu.config.AppConfig;
import com.ayuayu.config.JPATestConfig;
import com.ayuayu.model.statement.BalanceSheetIfrs;
import com.ayuayu.model.statement.BalanceSheetIfrsKey;
import com.ayuayu.model.statement.CashFlowStatementIfrs;
import com.ayuayu.model.statement.CashFlowStatementIfrsKey;
import com.ayuayu.service.statement.BalanceSheetIfrsService;
import com.ayuayu.service.statement.CashFlowStatementIfrsService;
import com.ayuayu.service.statement.IncomeStatementIfrsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, JPATestConfig.class })
@Sql(scripts = { "classpath:sql/h2/schema.sql", "classpath:sql/h2/data.sql" })
public class CashFlowAnalysisUtilsTest {
	@Autowired
	private BalanceSheetIfrsService balanceSheetIfrsService;
	@Autowired
	private CashFlowStatementIfrsService cashflowStatementIfrsService;
	@Autowired
	private IncomeStatementIfrsService incomeStatementIfrsService;

	private BalanceSheetIfrs balanceSheetIfrs;
	private CashFlowStatementIfrs cashflowStatementIfrs;

	@Before
	public void setUp() throws Exception {
		String stockId = "2412";
		short year = 2014;
		byte season = 4;
		balanceSheetIfrs = balanceSheetIfrsService
				.findById(new BalanceSheetIfrsKey(stockId, year, season));
		cashflowStatementIfrs = cashflowStatementIfrsService
				.findById(new CashFlowStatementIfrsKey(stockId, year, season));
	}

	@Test
	public void testComputeCashFlowRatio() {
		double result = CashFlowAnalysisUtils.computeCashFlowRatio(
				cashflowStatementIfrs
						.getCashFlowsFromUsedInOperatingActivities(),
				balanceSheetIfrs.getCurrentLiabilities());
		System.out.println(result);
		Assert.assertEquals(121.19, result, 0.02);
	}

	@Test
	public void testComputeCashReinvestmentRatio() {
		double result = CashFlowAnalysisUtils.computeCashReinvestmentRatio(
				cashflowStatementIfrs
						.getCashFlowsFromUsedInOperatingActivities(),
				cashflowStatementIfrs.getCashDividendsPaid(), balanceSheetIfrs
						.getNoncurrentAssets(), balanceSheetIfrs
						.getCurrentAssets(), balanceSheetIfrs
						.getCurrentLiabilities());
		System.out.println(result);
		Assert.assertEquals(9.35, result, 0.02);
	}
}
