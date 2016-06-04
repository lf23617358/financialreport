package com.ayuayu.utils;

public class LiquidityAnalysisUtils {
	/**
	 * 計算流動比率(%)=流動資產/流動負債
	 *
	 * @param currentAssets
	 *            流動資產
	 * @param currentLiabilities
	 *            流動負債
	 * @return 流動比率
	 */
	public static double computeCurrentRatio(long currentAssets,
			long currentLiabilities) {
		return ((double) currentAssets / currentLiabilities) * 100;
	}

	/**
	 * 計算速動比率(%)=(流動資產-存貨-預付款項)/流動負債
	 *
	 * @param currentAssets
	 *            流動資產
	 * @param inventories
	 *            存貨
	 * @param prepayments
	 *            預付款項
	 * @param currentLiabilities
	 *            流動負債
	 * @return 速動比率
	 */
	/**
	 * @return
	 */
	public static double computeQuickRatio(double currentAssets,
			long inventories, long prepayments, double currentLiabilities) {
		return ((double) (currentAssets - inventories - prepayments) / currentLiabilities) * 100;
	}

	/**
	 * 計算利息保障倍數(%)=稅前淨利/利息費用+1
	 *
	 * @param profitLossBeforeTax
	 *            稅前淨利
	 * @param interestExpense
	 *            利息費用
	 * @return 利息保障倍數
	 */
	public static double computeInterestGuarantee(long profitLossBeforeTax,
			long interestExpense) {
		return (((double) profitLossBeforeTax / interestExpense) + 1) * 100;
	}
}
