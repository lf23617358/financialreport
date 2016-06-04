package com.ayuayu.dao;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ayuayu.config.JPATestConfig;
import com.ayuayu.dao.statement.BalanceSheetIfrsRepository;
import com.ayuayu.model.statement.BalanceSheetIfrs;
import com.ayuayu.model.statement.BalanceSheetIfrsKey;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JPATestConfig.class })
@Sql(scripts = { "classpath:sql/h2/schema.sql" })
public class BalanceSheetIfrsRepositoryTest {

	@Autowired
	private BalanceSheetIfrsRepository balanceSheetIfrsRepository;

	@Test
	public void testSave() {
		BalanceSheetIfrs balanceSheetIfrs = new BalanceSheetIfrs();
		balanceSheetIfrs.setStockId("2412");
		balanceSheetIfrs.setYear((short) 2012);
		balanceSheetIfrs.setSeason((byte) 1);

		balanceSheetIfrsRepository.save(balanceSheetIfrs);

		BalanceSheetIfrsKey balanceSheetIfrsKey = new BalanceSheetIfrsKey(
				"2412", (short) 2012, (byte) 1);
		BalanceSheetIfrs balanceSheetIfrs2 = balanceSheetIfrsRepository
				.findOne(balanceSheetIfrsKey);
		Assert.assertEquals(balanceSheetIfrs.getStockId(),
				balanceSheetIfrs2.getStockId());
		Assert.assertEquals(balanceSheetIfrs.getYear(),
				balanceSheetIfrs2.getYear());
		Assert.assertEquals(balanceSheetIfrs.getSeason(),
				balanceSheetIfrs2.getSeason());
	}

	@Test
	@SuppressWarnings({ "unused", "unchecked" })
	public void testSaveIterable() {
		BalanceSheetIfrs balanceSheetIfrs = new BalanceSheetIfrs();
		balanceSheetIfrs.setStockId("2412");
		balanceSheetIfrs.setYear((short) 2012);
		balanceSheetIfrs.setSeason((byte) 1);

		BalanceSheetIfrs balanceSheetIfrs2 = new BalanceSheetIfrs();
		balanceSheetIfrs2.setStockId("2412");
		balanceSheetIfrs2.setYear((short) 2012);
		balanceSheetIfrs2.setSeason((byte) 2);

		List<BalanceSheetIfrs> list = new ArrayList<BalanceSheetIfrs>();
		list.add(balanceSheetIfrs);
		list.add(balanceSheetIfrs2);
		balanceSheetIfrsRepository.save(list);

		BalanceSheetIfrsKey balanceSheetIfrsKey = new BalanceSheetIfrsKey(
				"2412", (short) 2012, (byte) 1);
		List<BalanceSheetIfrs> list2 = IteratorUtils
				.toList(balanceSheetIfrsRepository.findAll().iterator());
		Assert.assertEquals(list.get(0).getStockId(), list2.get(0).getStockId());
		Assert.assertEquals(list.get(0).getYear(), list2.get(0).getYear());
		Assert.assertEquals(list.get(0).getSeason(), list2.get(0).getSeason());

		Assert.assertEquals(list.get(1).getStockId(), list2.get(1).getStockId());
		Assert.assertEquals(list.get(1).getYear(), list2.get(1).getYear());
		Assert.assertEquals(list.get(1).getSeason(), list2.get(1).getSeason());

	}

	@Test
	public void testFindOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testExists() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllIterableOfID() {
		fail("Not yet implemented");
	}

	@Test
	public void testCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteID() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteT() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteIterableOfQextendsT() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteAll() {
		fail("Not yet implemented");
	}

}
