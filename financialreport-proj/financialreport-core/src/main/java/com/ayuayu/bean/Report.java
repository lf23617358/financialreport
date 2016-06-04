package com.ayuayu.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Report {
//	protected ReportType reportType;
	protected String stockId;
	protected byte season;
	protected int month;
	protected short year;
	protected Map<String, Number> datas = new HashMap<String, Number>();

	/**
	 * @return the reportType
	 */
//	public ReportType getReportType() {
//		return reportType;
//	}
//
//	/**
//	 * @param reportType
//	 *            the reportType to set
//	 */
//	public void setReportType(ReportType reportType) {
//		this.reportType = reportType;
//	}

	/**
	 * @return the stockId
	 */
	public String getStockId() {
		return stockId;
	}

	/**
	 * @param stockId
	 *            the stockId to set
	 */
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	/**
	 * @return the season
	 */
	public byte getSeason() {
		return season;
	}

	/**
	 * @param season
	 *            the season to set
	 */
	public void setSeason(byte season) {
		this.season = season;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * @return the year
	 */
	public short getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(short year) {
		this.year = year;
	}

	/**
	 * @return the datas
	 */
	public Map<String, Number> getAllDatas() {
		return datas;
	}

	/**
	 * @param key
	 * @return
	 */
	public Number getData(String key) {
		return datas.get(key);
	}

	/**
	 * @param datas
	 *            the datas to set
	 */
	public void addAllData(Report report) {
		datas.putAll(report.getAllDatas());
	}

	public void addData(String key, Number value) {
		this.datas.put(key, value);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(stockId);
		buffer.append(" ");
		buffer.append(year);
		buffer.append("年 第");
		buffer.append(season);
		buffer.append("季 ");
//		buffer.append(reportType.getName());
		buffer.append("\n");
		for (Entry<String, Number> entry : datas.entrySet()) {
			buffer.append("\t");
			buffer.append(entry.getKey());
			buffer.append(":");
			buffer.append(entry.getValue());
			buffer.append("\n");
		}
		return buffer.toString();
	}
}
