package com.ayuayu.utils;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.ayuayu.constants.Institution;
import com.ayuayu.constants.ReportType;

public class ReportResourceUtil {
	private static final ResourceBundle bs_ifrs_resource = ResourceBundle
			.getBundle("balance_sheet_ifrs");
	private static final ResourceBundle is_ifrs_resource = ResourceBundle
			.getBundle("income_statement_ifrs");
	private static final ResourceBundle cs_ifrs_resource = ResourceBundle
			.getBundle("cashflow_statement_ifrs");
	private static final ResourceBundle bs_gaap_resource = ResourceBundle
			.getBundle("balance_sheet_gaap");
	private static final ResourceBundle is_gaap_resource = ResourceBundle
			.getBundle("income_statement_gaap");
	private static final ResourceBundle cs_gaap_resource = ResourceBundle
			.getBundle("cashflow_statement_gaap");

	public static ResourceBundle getResource(ReportType reportType) {
		return getResource(Institution.IFRS, reportType);
	}

	public static ResourceBundle getResource(String institution,
			ReportType reportType) {
		if (Institution.GAAP.equals(institution)) {
			switch (reportType) {
			case BALANCE_SHEET:
				return bs_gaap_resource;
			case INCOME_STATEMENT:
				return is_gaap_resource;
			case CASHFLOW_STATEMENT:
				return cs_gaap_resource;
			case STATEMENTS_OF_CHANGES_IN_EQUITY:
				return null;
			default:
				return null;
			}
		} else {
			switch (reportType) {
			case BALANCE_SHEET:
				return bs_ifrs_resource;
			case INCOME_STATEMENT:
				return is_ifrs_resource;
			case CASHFLOW_STATEMENT:
				return cs_ifrs_resource;
			case STATEMENTS_OF_CHANGES_IN_EQUITY:
				return null;
			default:
				return null;
			}
		}
	}

	public static Properties getResource(String institution) {
		Properties properties = new Properties();
		if (Institution.GAAP.equals(institution)) {
			load(properties, "balance_sheet_gaap.properties");
			load(properties, "income_statement_gaap.properties");
			load(properties, "cashflow_statement_gaap.properties");
		} else {
			load(properties, "balance_sheet_ifrs.properties");
			load(properties, "income_statement_ifrs.properties");
			load(properties, "cashflow_statement_ifrs.properties");
		}
		return properties;
	}

	private static void load(Properties properties, String name) {
		try {
			properties.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(name));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
