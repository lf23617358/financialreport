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
public class RetrunOnInvestmentAnalysisUtilsTest {
	@Autowired
	private BalanceSheetIfrsService balanceSheetIfrsService;
	@Autowired
	private CashFlowStatementIfrsService cashflowStatementIfrsService;
	@Autowired
	private IncomeStatementIfrsService incomeStatementIfrsService;

	private BalanceSheetIfrs beginBalanceSheetIfrs;
	private BalanceSheetIfrs balanceSheetIfrs;
	private CashFlowStatementIfrs cashflowStatementIfrs;
	private IncomeStatementIfrs incomeStatementIfrs;

	@Before
	public void setUp() throws Exception {
		String stockId = "2412";
		short year = 2014;
		short year2 = 2013;
		byte season = 4;
		byte season2 = 4;
		beginBalanceSheetIfrs = balanceSheetIfrsService
				.findById(new BalanceSheetIfrsKey(stockId, year, season));
		balanceSheetIfrs = balanceSheetIfrsService
				.findById(new BalanceSheetIfrsKey(stockId, year2, season2));
		cashflowStatementIfrs = cashflowStatementIfrsService
				.findById(new CashFlowStatementIfrsKey(stockId, year, season));
		incomeStatementIfrs = incomeStatementIfrsService
				.findById(new IncomeStatementIfrsKey(stockId, year, season));
	}

	@Test
	public void testComputeROA() {
		double result = RetrunOnInvestmentAnalysisUtils.computeROA(
				incomeStatementIfrs.getProfitLossFromContinuingOperations(),
				cashflowStatementIfrs.getInterestExpense(),
				incomeStatementIfrs.getIncomeTaxExpenseContinuingOperations(),
				incomeStatementIfrs.getProfitLossBeforeTax(),
				beginBalanceSheetIfrs.getAssets(), balanceSheetIfrs.getAssets());
		System.out.println(result);
		Assert.assertEquals(8.83, result, 0.02);
	}

	@Test
	public void testComputeROE() {
		double result = RetrunOnInvestmentAnalysisUtils.computeROE(
				incomeStatementIfrs.getProfitLossFromContinuingOperations(),
				beginBalanceSheetIfrs.getEquity(), balanceSheetIfrs.getEquity());
		System.out.println(result);
		Assert.assertEquals(10.66, result, 0.02);
	}

	@Test
	public void testComputeGrossProfitMargin() {
		double result = RetrunOnInvestmentAnalysisUtils
				.computeGrossProfitMargin(
						incomeStatementIfrs.getGrossProfitLossFromOperations(),
						incomeStatementIfrs.getOperatingRevenue());
		System.out.println(result);
		Assert.assertEquals(34.52, result, 0.02);
	}

	@Test
	public void testComputeOperatingProfitMargin() {
		double result = RetrunOnInvestmentAnalysisUtils
				.computeOperatingProfitMargin(
						incomeStatementIfrs.getNetOperatingIncomeLoss(),
						incomeStatementIfrs.getOperatingRevenue());
		System.out.println(result);
		Assert.assertEquals(19.77, result, 0.02);
	}

	@Test
	public void testComputePreTaxNetProfitMargin() {
		double result = RetrunOnInvestmentAnalysisUtils
				.computePreTaxNetProfitMargin(
						incomeStatementIfrs.getProfitLossBeforeTax(),
						incomeStatementIfrs.getOperatingRevenue());
		System.out.println(result);
		Assert.assertEquals(20.54, result, 0.02);
	}

	@Test
	public void testComputeNetProfitMargin() {
		double result = RetrunOnInvestmentAnalysisUtils.computeNetProfitMargin(
				incomeStatementIfrs.getProfitLossFromContinuingOperations(),
				incomeStatementIfrs.getOperatingRevenue());
		System.out.println(result);
		Assert.assertEquals(17.28, result, 0.02);
	}

}
