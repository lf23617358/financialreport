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
import com.ayuayu.model.statement.IncomeStatementIfrs;
import com.ayuayu.model.statement.IncomeStatementIfrsKey;
import com.ayuayu.service.statement.BalanceSheetIfrsService;
import com.ayuayu.service.statement.CashFlowStatementIfrsService;
import com.ayuayu.service.statement.IncomeStatementIfrsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, JPATestConfig.class })
@Sql(scripts = { "classpath:sql/h2/schema.sql", "classpath:sql/h2/data.sql" })
public class OperatingPerformanceAnalysisUtilsTest {
	@Autowired
	private BalanceSheetIfrsService balanceSheetIfrsService;
	@Autowired
	private CashFlowStatementIfrsService cashflowStatementIfrsService;
	@Autowired
	private IncomeStatementIfrsService incomeStatementIfrsService;

	private BalanceSheetIfrs beginBalanceSheetIfrs;
	private BalanceSheetIfrs balanceSheetIfrs;
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
		incomeStatementIfrs = incomeStatementIfrsService
				.findById(new IncomeStatementIfrsKey(stockId, year, season));
	}

	@Test
	public void testComputeAccountsReceivableTurnoverRatio() {
		double result = OperatingPerformanceAnalysisUtils
				.computeAccountsReceivableTurnoverRatio(
						incomeStatementIfrs.getOperatingRevenue(),
						beginBalanceSheetIfrs.getAccountsReceivableNet(),
						beginBalanceSheetIfrs
								.getAccountsReceivableDuefromRelatedPartiesNet(),
						beginBalanceSheetIfrs
								.getOtherReceivablesDueFromRelatedParties(),
						balanceSheetIfrs.getAccountsReceivableNet(),
						balanceSheetIfrs
								.getAccountsReceivableDuefromRelatedPartiesNet(),
						balanceSheetIfrs
								.getOtherReceivablesDueFromRelatedParties());
		System.out.println(result);
		Assert.assertEquals(9.20, result, 0.02);
	}

	@Test
	public void testComputeAccountsReceivableTurnoverDays() {
		double accountsReceivableTurnoverRatio = OperatingPerformanceAnalysisUtils
				.computeAccountsReceivableTurnoverRatio(
						incomeStatementIfrs.getOperatingRevenue(),
						beginBalanceSheetIfrs.getAccountsReceivableNet(),
						beginBalanceSheetIfrs
								.getAccountsReceivableDuefromRelatedPartiesNet(),
						beginBalanceSheetIfrs
								.getOtherReceivablesDueFromRelatedParties(),
						balanceSheetIfrs.getAccountsReceivableNet(),
						balanceSheetIfrs
								.getAccountsReceivableDuefromRelatedPartiesNet(),
						balanceSheetIfrs
								.getOtherReceivablesDueFromRelatedParties());
		double result = OperatingPerformanceAnalysisUtils
				.computeAccountsReceivableTurnoverDays(accountsReceivableTurnoverRatio);
		System.out.println(result);
		Assert.assertEquals(39.69, result, 0.02);
	}

	@Test
	public void testComputeInventoryTurnoverRatio() {
		double result = OperatingPerformanceAnalysisUtils
				.computeInventoryTurnoverRatio(
						incomeStatementIfrs.getOperatingCosts(),
						beginBalanceSheetIfrs.getInventories(),
						balanceSheetIfrs.getInventories());
		System.out.println(result);
		Assert.assertEquals(19.86, result, 0.02);
	}

	@Test
	public void testComputeInventoryTurnoverDays() {
		double inventoryTurnoverRatio = OperatingPerformanceAnalysisUtils
				.computeInventoryTurnoverRatio(
						incomeStatementIfrs.getOperatingCosts(),
						beginBalanceSheetIfrs.getInventories(),
						balanceSheetIfrs.getInventories());
		double result = OperatingPerformanceAnalysisUtils
				.computeInventoryTurnoverDays(inventoryTurnoverRatio);
		System.out.println(result);
		Assert.assertEquals(18.38, result, 0.02);
	}

	@Test
	public void testComputeFixedAssetTurnoverRatio() {
		double result = OperatingPerformanceAnalysisUtils
				.computeFixedAssetTurnoverRatio(
						incomeStatementIfrs.getOperatingRevenue(),
						beginBalanceSheetIfrs.getPropertyPlantAndEquipment(),
						balanceSheetIfrs.getPropertyPlantAndEquipment());
		System.out.println(result);
		Assert.assertEquals(0.75, result, 0.02);
	}

	@Test
	public void testComputeTotalAssetTurnoverRatio() {
		double result = OperatingPerformanceAnalysisUtils
				.computeTotalAssetTurnoverRatio(
						incomeStatementIfrs.getOperatingRevenue(),
						beginBalanceSheetIfrs.getAssets(),
						balanceSheetIfrs.getAssets());
		System.out.println(result);
		Assert.assertEquals(0.51, result, 0.02);
	}
}
