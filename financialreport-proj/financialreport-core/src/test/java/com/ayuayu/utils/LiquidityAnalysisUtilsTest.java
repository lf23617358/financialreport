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
import com.ayuayu.model.statement.IncomeStatementIfrs;
import com.ayuayu.model.statement.IncomeStatementIfrsKey;
import com.ayuayu.service.statement.BalanceSheetIfrsService;
import com.ayuayu.service.statement.CashFlowStatementIfrsService;
import com.ayuayu.service.statement.IncomeStatementIfrsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, JPATestConfig.class })
@Sql(scripts = { "classpath:sql/h2/schema.sql", "classpath:sql/h2/data.sql" })
public class LiquidityAnalysisUtilsTest {
	@Autowired
	private BalanceSheetIfrsService balanceSheetIfrsService;
	@Autowired
	private CashFlowStatementIfrsService cashflowStatementIfrsService;
	@Autowired
	private IncomeStatementIfrsService incomeStatementIfrsService;

	private BalanceSheetIfrs balanceSheetIfrs;
	private CashFlowStatementIfrs cashflowStatementIfrs;
	private IncomeStatementIfrs incomeStatementIfrs;

	@Before
	public void setUp() throws Exception {
		String stockId = "2412";
		short year = 2014;
		byte season = 4;
		balanceSheetIfrs = balanceSheetIfrsService
				.findById(new BalanceSheetIfrsKey(stockId, year, season));
		cashflowStatementIfrs = cashflowStatementIfrsService
				.findById(new CashFlowStatementIfrsKey(stockId, year, season));
		incomeStatementIfrs = incomeStatementIfrsService
				.findById(new IncomeStatementIfrsKey(stockId, year, season));
	}

	@Test
	public void testComputeCurrentRatio() {
		double result = LiquidityAnalysisUtils.computeCurrentRatio(
				balanceSheetIfrs.getCurrentAssets(),
				balanceSheetIfrs.getCurrentLiabilities());
		System.out.println(result);
		Assert.assertEquals(117.85, result, 0.02);
	}

	@Test
	public void testComputeQuickRatio() {
		double result = LiquidityAnalysisUtils.computeQuickRatio(
				balanceSheetIfrs.getCurrentAssets(),
				balanceSheetIfrs.getInventories(),
				balanceSheetIfrs.getPrepayments(),
				balanceSheetIfrs.getCurrentLiabilities());
		System.out.println(result);
		Assert.assertEquals(101.65, result, 0.02);
	}

	@Test
	public void testComputeInterestGuarantee() {
		double result = LiquidityAnalysisUtils.computeInterestGuarantee(
				incomeStatementIfrs.getProfitLossBeforeTax(),
				cashflowStatementIfrs.getInterestExpense());
		System.out.println(result);
		Assert.assertEquals(100990.91, result, 0.02);
	}
}
