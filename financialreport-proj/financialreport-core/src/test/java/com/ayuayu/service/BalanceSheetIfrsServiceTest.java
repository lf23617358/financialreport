package com.ayuayu.service;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
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
public class BalanceSheetIfrsServiceTest {
	@Autowired
	private BalanceSheetIfrsService balanceSheetIfrsService;

	@Test
	public void testFindById() {
		BalanceSheetIfrs balanceSheetIfrs = new BalanceSheetIfrs();
		balanceSheetIfrs.setStockId("2412");
		balanceSheetIfrs.setYear((short) 2012);
		balanceSheetIfrs.setSeason((byte) 1);

		balanceSheetIfrsService.save(balanceSheetIfrs);

		BalanceSheetIfrsKey balanceSheetIfrsKey = new BalanceSheetIfrsKey(
				"2412", (short) 2012, (byte) 1);
		BalanceSheetIfrs balanceSheetIfrs2 = balanceSheetIfrsService
				.findById(balanceSheetIfrsKey);
		Assert.assertEquals(balanceSheetIfrs.getStockId(),
				balanceSheetIfrs2.getStockId());
		Assert.assertEquals(balanceSheetIfrs.getYear(),
				balanceSheetIfrs2.getYear());
		Assert.assertEquals(balanceSheetIfrs.getSeason(),
				balanceSheetIfrs2.getSeason());
	}

	@Test
	public void testFindByIds() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteID() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteListOfDOMAIN() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveDOMAIN() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveListOfDOMAIN() {
		fail("Not yet implemented");
	}

	@Test
	public void findAllByCond() {
		List<BalanceSheetIfrs> list = balanceSheetIfrsService.findAllByCond();
		System.out.println(list);
		System.out.println(list.size());
	}

}
