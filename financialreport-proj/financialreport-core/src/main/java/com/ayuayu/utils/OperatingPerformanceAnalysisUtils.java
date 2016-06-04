package com.ayuayu.utils;


public class OperatingPerformanceAnalysisUtils {
	/**
	 * 計算應收帳款周轉率(次)=營業收入/各期平均應收款項餘額
	 *
	 * @param operatingRevenue
	 *            營業收入
	 * @param beginAccountsReceivableNet
	 *            期初應收帳款
	 * @param beginAccountsReceivableDuefromRelatedPartiesNet
	 *            期初應收帳款－關係人淨額
	 * @param beginOtherReceivablesDueFromRelatedParties
	 *            期初其他應收款－關係人
	 * @param accountsReceivableNet
	 *            應收帳款
	 * @param accountsReceivableDuefromRelatedPartiesNet
	 *            應收帳款－關係人淨額
	 * @param otherReceivablesDueFromRelatedParties
	 *            其他應收款－關係人
	 * @return 應收帳款周轉率
	 */
	public static double computeAccountsReceivableTurnoverRatio(
			long operatingRevenue, long beginAccountsReceivableNet,
			long beginAccountsReceivableDuefromRelatedPartiesNet,
			long beginOtherReceivablesDueFromRelatedParties,
			long accountsReceivableNet,
			long accountsReceivableDuefromRelatedPartiesNet,
			long otherReceivablesDueFromRelatedParties) {
		double avgReceivables = ((double) beginAccountsReceivableNet
				+ beginAccountsReceivableDuefromRelatedPartiesNet
				+ beginOtherReceivablesDueFromRelatedParties
				+ accountsReceivableNet
				+ accountsReceivableDuefromRelatedPartiesNet + otherReceivablesDueFromRelatedParties) / 2;
		return (double) operatingRevenue / avgReceivables;
	}

	/**
	 * 計算平均收現日數(天)=365/應收帳款周轉率
	 *
	 * @param accountsReceivableTurnoverRatio
	 *            應收帳款周轉率
	 *
	 * @return 平均收現日數
	 */
	public static double computeAccountsReceivableTurnoverDays(
			double accountsReceivableTurnoverRatio) {
		return 365.0 / accountsReceivableTurnoverRatio;
	}

	/**
	 * 計算存貨周轉率(次)=營業成本/平均存貨
	 *
	 * @param operatingCosts
	 *            營業成本
	 * @param beginInventories
	 *            期初存貨
	 * @param inventories
	 *            存貨
	 * @return 存貨周轉率
	 */
	public static double computeInventoryTurnoverRatio(long operatingCosts,
			long beginInventories, long inventories) {
		double avgInventories = ((double) beginInventories + inventories) / 2;
		return (double) operatingCosts / avgInventories;
	}

	/**
	 * 計算平均銷貨日數(天)=365/存貨周轉率
	 *
	 * @param inventoryTurnoverRatio
	 *            存貨周轉率
	 * @return 平均銷貨日數
	 */
	public static double computeInventoryTurnoverDays(
			double inventoryTurnoverRatio) {
		return 365.0 / inventoryTurnoverRatio;
	}

	/**
	 * 計算固定資產周轉率(次)=營業收入/平均固定資產
	 *
	 * @param operatingRevenue
	 *            營業收入
	 * @param beginFixedAssets
	 *            期初固定資產
	 * @param fixedAssets
	 *            固定資產
	 * @return 固定資產周轉率
	 */
	public static double computeFixedAssetTurnoverRatio(long operatingRevenue,
			long beginFixedAssets, long fixedAssets) {
		double avgFixedAssets = ((double) beginFixedAssets + fixedAssets) / 2;
		return (double) operatingRevenue / avgFixedAssets;
	}

	/**
	 * 計算總資產周轉率(次)=營業收入/平均資產
	 *
	 * @param operatingRevenue
	 *            營業收入
	 * @param beginAssets
	 *            期初資產
	 * @param assets
	 *            資產
	 * @return 總資產周轉率
	 */
	public static double computeTotalAssetTurnoverRatio(long operatingRevenue,
			long beginAssets, long assets) {
		double avgAssets = ((double) beginAssets + assets) / 2;
		return operatingRevenue / avgAssets;
	}

}
