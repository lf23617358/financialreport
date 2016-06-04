package com.ayuayu.dao;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeMethod;

import com.ayuayu.config.HibernateTestConfiguration;

@ContextConfiguration(classes = { HibernateTestConfiguration.class })
public abstract class EntityDaoImplTest {

	@Autowired
	DataSource dataSource;

	@BeforeMethod
	public void setUp() throws Exception {
		IDatabaseConnection dbConn = new DatabaseDataSourceConnection(
				dataSource);
		DatabaseOperation.CLEAN_INSERT.execute(dbConn, getDataSet());
	}

	protected abstract IDataSet getDataSet() throws Exception;

}