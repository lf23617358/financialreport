package com.ayuayu.utils;

public class CapitalStructureAnalysisUtils {
	/**
	 * 計算負債比(%)=負債/資產
	 *
	 * @param liabilities
	 *            負債
	 * @param assets
	 *            資產
	 * @return 負債比
	 */
	public static double computeDebtRatio(long liabilities, long assets) {
		return ((double) liabilities / assets) * 100;
	}

	/**
	 * 計算負債淨值比(負債股東權益比)(%)=負債/權益
	 *
	 * @param liabilities
	 *            負債
	 * @param equity
	 *            權益
	 * @return 負債淨值比
	 */
	public static double computeDebtEquityRatio(long liabilities, long equity) {
		return ((double) liabilities / equity) * 100;
	}

	/**
	 * 計算長期資金佔固定資產比(%)=(權益+非流動負債)/固定資產;
	 *
	 * @param equity
	 *            權益
	 * @param noncurrentLiabilities
	 *            非流動負債
	 * @param fixedAssets
	 *            固定資產
	 * @return 長期資金佔固定資產比
	 */
	public static double computeLongTermFundsToFixedAssets(long equity,
			long noncurrentLiabilities, long fixedAssets) {
		return ((double) (equity + noncurrentLiabilities) / fixedAssets) * 100;
	}
}
