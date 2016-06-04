package com.ayuayu.utils;

public class RetrunOnInvestmentAnalysisUtils {
	/**
	 * 計算總資產報酬率(%)=(稅後淨利+利息費用*(1-(所得稅費用/稅前淨利)))/(平均資產/2)
	 *
	 * @param profitLossFromContinuingOperations
	 *            稅後淨利
	 * @param interestExpense
	 *            利息費用
	 * @param incomeTaxExpenseContinuingOperations
	 *            所得稅費用
	 * @param profitLossBeforeTax
	 *            稅前淨利
	 * @param beginAssets
	 *            期初資產
	 * @param assets
	 *            資產
	 * @return 總資產報酬率
	 */
	public static double computeROA(long profitLossFromContinuingOperations,
			long interestExpense, long incomeTaxExpenseContinuingOperations,
			long profitLossBeforeTax, long beginAssets, long assets) {
		double taxRatio = (double) incomeTaxExpenseContinuingOperations
				/ profitLossBeforeTax;
		double avgAssets = (double) (beginAssets + assets) / 2;
		return (((double) profitLossFromContinuingOperations + (double) interestExpense
				* (1.0 - taxRatio)) / avgAssets) * 100;
	}

	/**
	 * 計算股東權益報酬率(%)=稅後淨利/(平均權益/2)
	 *
	 * @param profitLossFromContinuingOperations
	 *            稅後淨利
	 * @param beginEquity
	 *            期初權益
	 * @param equity
	 *            權益
	 * @return 股東權益報酬率
	 */
	public static double computeROE(long profitLossFromContinuingOperations,
			long beginEquity, long equity) {
		double avgEquity = (double) (beginEquity + equity) / 2;
		return ((double) profitLossFromContinuingOperations / avgEquity) * 100;
	}

	/**
	 * 計算毛利率(%)=營業毛利/營業收入
	 *
	 * @param grossProfitLossFromOperations
	 *            營業毛利
	 * @param operatingRevenue
	 *            營業收入
	 * @return 毛利率
	 */
	public static double computeGrossProfitMargin(
			long grossProfitLossFromOperations, long operatingRevenue) {
		return ((double) grossProfitLossFromOperations / operatingRevenue) * 100;
	}

	/**
	 * 計算營業利益率(%)=營業利益/營業收入
	 *
	 * @param netOperatingIncomeLoss
	 *            營業利益
	 * @param operatingRevenue
	 *            營業收入
	 * @return 營業利益率
	 */
	public static double computeOperatingProfitMargin(
			long netOperatingIncomeLoss, long operatingRevenue) {
		return ((double) netOperatingIncomeLoss / operatingRevenue) * 100;
	}

	/**
	 * 計算稅前淨利率(%)=稅前淨利/營業收入
	 *
	 * @param profitLossBeforeTax
	 *            稅前淨利
	 * @param operatingRevenue
	 *            營業收入
	 * @return 稅前淨利率
	 */
	public static double computePreTaxNetProfitMargin(long profitLossBeforeTax,
			long operatingRevenue) {
		return ((double) profitLossBeforeTax / operatingRevenue) * 100;
	}

	/**
	 * 計算稅後淨利率(%)=稅後淨利/營業收入
	 *
	 * @param profitLossFromContinuingOperations
	 *            稅後淨利
	 * @param operatingRevenue
	 *            營業收入
	 * @return 稅後淨利率
	 */
	public static double computeNetProfitMargin(
			long profitLossFromContinuingOperations, long operatingRevenue) {
		return ((double) profitLossFromContinuingOperations / operatingRevenue) * 100;
	}

}
