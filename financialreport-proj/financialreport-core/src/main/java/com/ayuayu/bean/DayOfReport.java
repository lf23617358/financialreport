package com.ayuayu.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.ayuayu.constants.Period;
import com.ayuayu.constants.ReportType;

public class DayOfReport {
    protected ReportType reportType;
    protected String stockId;
    protected int season;
    protected int month;
    protected int year;
    protected Map<String, Data> datas = new HashMap<String, Data>();

    /**
     * @return the reportType
     */
    public ReportType getReportType() {
        return reportType;
    }

    /**
     * @param reportType
     *            the reportType to set
     */
    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }

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
    public int getSeason() {
        return season;
    }

    /**
     * @param season
     *            the season to set
     */
    public void setSeason(int season) {
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
    public int getYear() {
        return year;
    }

    /**
     * @param year
     *            the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the datas
     */
    public Map<String, Data> getAllDatas() {
        return datas;
    }

    /**
     * @param key
     * @return
     */
    public Number getData(String key) {
        return getData(key, Period.CURRENT);
    }

    /**
     * @param key
     * @param period
     * @return
     */
    public Number getData(String key, int period) {
        return datas.get(key).getData(period);
    }

    /**
     * @param datas
     *            the datas to set
     */
    public void addAllData(DayOfReport report) {
        datas.putAll(report.getAllDatas());
    }

    /**
     * @param datas
     *            the datas to set
     */
    public void addData(String key, Number value) {
        addData(key, Period.CURRENT, value);
    }

    public void addData(String key, int period, Number value) {
        if (!datas.containsKey(key)) {
            Data data = new Data();
            this.datas.put(key, data);
        }
        this.datas.get(key).addData(period, value);
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
        buffer.append(reportType.getName());
        buffer.append("\n");
        for (Entry<String, Data> entry : datas.entrySet()) {
            buffer.append("\t");
            buffer.append(entry.getKey());
            buffer.append(":");
            buffer.append(entry.getValue().getData(Period.CURRENT));
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
