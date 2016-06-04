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
import com.ayuayu.service.statement.BalanceSheetIfrsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, JPATestConfig.class })
@Sql(scripts = { "classpath:sql/h2/schema.sql", "classpath:sql/h2/data.sql" })
public class CapitalStructureAnalysisUtilsTest {
	@Autowired
	private BalanceSheetIfrsService balanceSheetIfrsService;

	private BalanceSheetIfrs balanceSheetIfrs;

	@Before
	public void setUp() {
		BalanceSheetIfrsKey key = new BalanceSheetIfrsKey("2412", (short) 2014,
				(byte) 4);
		balanceSheetIfrs = balanceSheetIfrsService.findById(key);
	}

	@Test
	public void testComputeDebtRatio() {
		double result = CapitalStructureAnalysisUtils
				.computeDebtRatio(balanceSheetIfrs.getLiabilities(),
						balanceSheetIfrs.getAssets());
		System.out.println(result);
		Assert.assertEquals(17.27, result, 0.02);
	}

	@Test
	public void testComputeDebtEquityRatio() {
		double result = CapitalStructureAnalysisUtils
				.computeDebtEquityRatio(balanceSheetIfrs.getLiabilities(),
						balanceSheetIfrs.getEquity());
		System.out.println(result);
		Assert.assertEquals(20.88, result, 0.02);
	}

	@Test
	public void testComputeLongTermFundsToFixedAssets() {
		double result = CapitalStructureAnalysisUtils
				.computeLongTermFundsToFixedAssets(
						balanceSheetIfrs.getEquity(),
						balanceSheetIfrs.getNoncurrentLiabilities(),
						balanceSheetIfrs.getPropertyPlantAndEquipment());
		System.out.println(result);
		Assert.assertEquals(128.14, result, 0.02);
	}
}
