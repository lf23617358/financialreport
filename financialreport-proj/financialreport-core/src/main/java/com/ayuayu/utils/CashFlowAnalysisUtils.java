package com.ayuayu.utils;

public class CashFlowAnalysisUtils {

	/**
	 * 計算現金流量比率(%)=營業活動之現金流量/流動負債
	 *
	 * @param cashFlowsFromUsedInOperatingActivities
	 *            營業活動之現金流量
	 * @param currentLiabilities
	 *            流動負債
	 * @return 現金流量比率
	 */
	public static double computeCashFlowRatio(
			long cashFlowsFromUsedInOperatingActivities, long currentLiabilities) {
		return ((double) cashFlowsFromUsedInOperatingActivities / currentLiabilities) * 100;
	}

	/**
	 * 計算現金再投資比率(%)=(營業活動之現金流量+發放現金股利)/(非流動資產+營運資金）
	 *
	 * @param cashFlowsFromUsedInOperatingActivities
	 *            營業活動之現金流量
	 * @param cashDividendsPaid
	 *            發放現金股利
	 * @param noncurrentAssets
	 *            非流動資產
	 * @param currentAssets
	 *            流動資產
	 * @param currentLiabilities
	 *            流動負債
	 * @return 現金再投資比率
	 */
	public static double computeCashReinvestmentRatio(
			long cashFlowsFromUsedInOperatingActivities,
			long cashDividendsPaid, long noncurrentAssets, long currentAssets,
			long currentLiabilities) {
		double molecule = cashFlowsFromUsedInOperatingActivities
				+ cashDividendsPaid;
		if (molecule < 0)
			return 0;
		double income = currentAssets - currentLiabilities;
		if (income < 0)
			return 0;
		double denominator = noncurrentAssets + income;
		if (denominator < 0)
			return 0;
		return (molecule / denominator) * 100;
	}
}
