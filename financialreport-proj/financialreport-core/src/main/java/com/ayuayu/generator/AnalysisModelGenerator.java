package com.ayuayu.generator;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.reflect.MethodUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayuayu.model.analysis.CapitalStructureAnalysisIfrs;
import com.ayuayu.model.analysis.CashFlowAnalysisIfrs;
import com.ayuayu.model.analysis.LiquidityAnalysisIfrs;
import com.ayuayu.model.analysis.OperatingPerformanceAnalysisIfrs;
import com.ayuayu.model.analysis.RetrunOnInvestmentAnalysisIfrs;
import com.ayuayu.model.statement.BalanceSheetIfrs;
import com.ayuayu.model.statement.BalanceSheetIfrsKey;
import com.ayuayu.model.statement.CashFlowStatementIfrs;
import com.ayuayu.model.statement.CashFlowStatementIfrsKey;
import com.ayuayu.model.statement.IncomeStatementIfrs;
import com.ayuayu.model.statement.IncomeStatementIfrsKey;
import com.ayuayu.service.statement.BalanceSheetIfrsService;
import com.ayuayu.service.statement.CashFlowStatementIfrsService;
import com.ayuayu.service.statement.IncomeStatementIfrsService;
import com.ayuayu.utils.CapitalStructureAnalysisUtils;
import com.ayuayu.utils.CashFlowAnalysisUtils;
import com.ayuayu.utils.LiquidityAnalysisUtils;
import com.ayuayu.utils.OperatingPerformanceAnalysisUtils;
import com.ayuayu.utils.RetrunOnInvestmentAnalysisUtils;

@Service
public class AnalysisModelGenerator {
	@Autowired
	private BalanceSheetIfrsService balanceSheetIfrsService;
	@Autowired
	private CashFlowStatementIfrsService cashflowStatementIfrsService;
	@Autowired
	private IncomeStatementIfrsService incomeStatementIfrsService;

	@SuppressWarnings("unchecked")
	public <T> T generate(String stockId, short year, byte season,
			Class<T> objClass) {
		T obj = initStockInfo(stockId, year, season, objClass);
		if (obj instanceof CapitalStructureAnalysisIfrs) {
			return (T) getCapitalStructureAnalysisIfrs((CapitalStructureAnalysisIfrs) obj);
		} else if (obj instanceof OperatingPerformanceAnalysisIfrs) {
			return (T) getOperatingPerformanceAnalysisIfrs((OperatingPerformanceAnalysisIfrs) obj);
		} else if (obj instanceof RetrunOnInvestmentAnalysisIfrs) {
			return (T) getRetrunOnInvestmentAnalysisIfrs((RetrunOnInvestmentAnalysisIfrs) obj);
		} else if (obj instanceof LiquidityAnalysisIfrs) {
			return (T) getLiquidityAnalysisIfrs((LiquidityAnalysisIfrs) obj);
		} else if (obj instanceof CashFlowAnalysisIfrs) {
			return (T) getCashFlowAnalysisIfrs((CashFlowAnalysisIfrs) obj);
		}
		return null;

	}

	private CapitalStructureAnalysisIfrs getCapitalStructureAnalysisIfrs(
			CapitalStructureAnalysisIfrs obj) {
		BalanceSheetIfrs balanceSheetIfrs = getBalanceSheetIfrs(
				obj.getStockId(), obj.getYear(), obj.getSeason());
		obj.setDebtRatio(CapitalStructureAnalysisUtils.computeDebtRatio(
				balanceSheetIfrs.getLiabilities(), balanceSheetIfrs.getAssets()));
		obj.setDebtEquityRatio(CapitalStructureAnalysisUtils
				.computeDebtEquityRatio(balanceSheetIfrs.getLiabilities(),
						balanceSheetIfrs.getEquity()));
		obj.setLongTermFundsToPropertyPlantAndEquipment(CapitalStructureAnalysisUtils
				.computeLongTermFundsToFixedAssets(
						balanceSheetIfrs.getEquity(),
						balanceSheetIfrs.getNoncurrentLiabilities(),
						balanceSheetIfrs.getPropertyPlantAndEquipment()));
		return obj;
	}

	private CashFlowAnalysisIfrs getCashFlowAnalysisIfrs(
			CashFlowAnalysisIfrs obj) {
		BalanceSheetIfrs balanceSheetIfrs = getBalanceSheetIfrs(
				obj.getStockId(), obj.getYear(), obj.getSeason());
		CashFlowStatementIfrs cashflowStatementIfrs = getCashFlowStatementIfrs(
				obj.getStockId(), obj.getYear(), obj.getSeason());
		obj.setCashFlowRatio(CashFlowAnalysisUtils.computeCashFlowRatio(
				cashflowStatementIfrs
						.getCashFlowsFromUsedInOperatingActivities(),
				balanceSheetIfrs.getCurrentLiabilities()));
		obj.setCashReinvestmentRatio(CashFlowAnalysisUtils
				.computeCashReinvestmentRatio(cashflowStatementIfrs
						.getCashFlowsFromUsedInOperatingActivities(),
						cashflowStatementIfrs.getCashDividendsPaid(),
						balanceSheetIfrs.getNoncurrentAssets(),
						balanceSheetIfrs.getCurrentAssets(), balanceSheetIfrs
								.getCurrentLiabilities()));
		return obj;
	}

	LiquidityAnalysisIfrs getLiquidityAnalysisIfrs(LiquidityAnalysisIfrs obj) {
		BalanceSheetIfrs balanceSheetIfrs = getBalanceSheetIfrs(
				obj.getStockId(), obj.getYear(), obj.getSeason());
		CashFlowStatementIfrs cashflowStatementIfrs = getCashFlowStatementIfrs(
				obj.getStockId(), obj.getYear(), obj.getSeason());
		IncomeStatementIfrs incomeStatementIfrs = getIncomeStatementIfrs(
				obj.getStockId(), obj.getYear(), obj.getSeason());
		obj.setCurrentRatio(LiquidityAnalysisUtils.computeCurrentRatio(
				balanceSheetIfrs.getCurrentAssets(),
				balanceSheetIfrs.getCurrentLiabilities()));
		obj.setQuickRatio(LiquidityAnalysisUtils.computeQuickRatio(
				balanceSheetIfrs.getCurrentAssets(),
				balanceSheetIfrs.getInventories(),
				balanceSheetIfrs.getPrepayments(),
				balanceSheetIfrs.getCurrentLiabilities()));
		obj.setInterestGuarantee(LiquidityAnalysisUtils
				.computeInterestGuarantee(
						incomeStatementIfrs.getProfitLossBeforeTax(),
						cashflowStatementIfrs.getInterestExpense()));
		return obj;
	}

	OperatingPerformanceAnalysisIfrs getOperatingPerformanceAnalysisIfrs(
			OperatingPerformanceAnalysisIfrs obj) {
		BalanceSheetIfrs balanceSheetIfrs = getBalanceSheetIfrs(
				obj.getStockId(), obj.getYear(), obj.getSeason());
		BalanceSheetIfrs beginBalanceSheetIfrs = getBalanceSheetIfrs(
				obj.getStockId(), (short) (obj.getYear() - 1), (byte) 4);
		IncomeStatementIfrs incomeStatementIfrs = getIncomeStatementIfrs(
				obj.getStockId(), obj.getYear(), obj.getSeason());
		obj.setAccountsReceivableTurnoverRatio(OperatingPerformanceAnalysisUtils.computeAccountsReceivableTurnoverRatio(
				incomeStatementIfrs.getOperatingRevenue(),
				beginBalanceSheetIfrs.getAccountsReceivableNet(),
				beginBalanceSheetIfrs
						.getAccountsReceivableDuefromRelatedPartiesNet(),
				beginBalanceSheetIfrs
						.getOtherReceivablesDueFromRelatedParties(),
				balanceSheetIfrs.getAccountsReceivableNet(), balanceSheetIfrs
						.getAccountsReceivableDuefromRelatedPartiesNet(),
				balanceSheetIfrs.getOtherReceivablesDueFromRelatedParties()));
		obj.setAccountsReceivableTurnoverDays(obj
				.getAccountsReceivableTurnoverRatio());
		obj.setInventoryTurnoverRatio(OperatingPerformanceAnalysisUtils
				.computeInventoryTurnoverRatio(
						incomeStatementIfrs.getOperatingCosts(),
						beginBalanceSheetIfrs.getInventories(),
						balanceSheetIfrs.getInventories()));
		obj.setInventoryTurnoverDays(obj.getInventoryTurnoverRatio());
		obj.setFixedAssetTurnoverRatio(OperatingPerformanceAnalysisUtils
				.computeFixedAssetTurnoverRatio(
						incomeStatementIfrs.getOperatingRevenue(),
						beginBalanceSheetIfrs.getPropertyPlantAndEquipment(),
						balanceSheetIfrs.getPropertyPlantAndEquipment()));
		obj.setTotalAssetTurnoverRatio(OperatingPerformanceAnalysisUtils
				.computeTotalAssetTurnoverRatio(
						incomeStatementIfrs.getOperatingRevenue(),
						beginBalanceSheetIfrs.getAssets(),
						balanceSheetIfrs.getAssets()));
		return obj;
	}

	RetrunOnInvestmentAnalysisIfrs getRetrunOnInvestmentAnalysisIfrs(
			RetrunOnInvestmentAnalysisIfrs obj) {
		BalanceSheetIfrs balanceSheetIfrs = getBalanceSheetIfrs(
				obj.getStockId(), obj.getYear(), obj.getSeason());
		BalanceSheetIfrs beginBalanceSheetIfrs = getBalanceSheetIfrs(
				obj.getStockId(), (short) (obj.getYear() - 1), (byte) 4);
		IncomeStatementIfrs incomeStatementIfrs = getIncomeStatementIfrs(
				obj.getStockId(), obj.getYear(), obj.getSeason());
		CashFlowStatementIfrs cashflowStatementIfrs = getCashFlowStatementIfrs(
				obj.getStockId(), obj.getYear(), obj.getSeason());
		obj.setRoa(RetrunOnInvestmentAnalysisUtils.computeROA(
				incomeStatementIfrs.getProfitLossFromContinuingOperations(),
				cashflowStatementIfrs.getInterestExpense(),
				incomeStatementIfrs.getIncomeTaxExpenseContinuingOperations(),
				incomeStatementIfrs.getProfitLossBeforeTax(),
				beginBalanceSheetIfrs.getAssets(), balanceSheetIfrs.getAssets()));
		obj.setRoe(RetrunOnInvestmentAnalysisUtils.computeROE(
				incomeStatementIfrs.getProfitLossFromContinuingOperations(),
				beginBalanceSheetIfrs.getEquity(), balanceSheetIfrs.getEquity()));
		obj.setGrossProfitMargin(RetrunOnInvestmentAnalysisUtils
				.computeGrossProfitMargin(
						incomeStatementIfrs.getGrossProfitLossFromOperations(),
						incomeStatementIfrs.getOperatingRevenue()));
		obj.setOperatingProfitMargin(RetrunOnInvestmentAnalysisUtils
				.computeOperatingProfitMargin(
						incomeStatementIfrs.getNetOperatingIncomeLoss(),
						incomeStatementIfrs.getOperatingRevenue()));
		obj.setPreTaxNetProfitMargin(RetrunOnInvestmentAnalysisUtils
				.computePreTaxNetProfitMargin(
						incomeStatementIfrs.getProfitLossBeforeTax(),
						incomeStatementIfrs.getOperatingRevenue()));
		obj.setNetProfitMargin(RetrunOnInvestmentAnalysisUtils
				.computeNetProfitMargin(incomeStatementIfrs
						.getProfitLossFromContinuingOperations(),
						incomeStatementIfrs.getOperatingRevenue()));
		return obj;
	}

	private BalanceSheetIfrs getBalanceSheetIfrs(String stockId, short year,
			byte season) {
		BalanceSheetIfrsKey key = initStockInfo(stockId, year, season,
				BalanceSheetIfrsKey.class);
		return balanceSheetIfrsService.findById(key);
	}

	private CashFlowStatementIfrs getCashFlowStatementIfrs(String stockId,
			short year, byte season) {
		CashFlowStatementIfrsKey key = initStockInfo(stockId, year, season,
				CashFlowStatementIfrsKey.class);
		return cashflowStatementIfrsService.findById(key);
	}

	private IncomeStatementIfrs getIncomeStatementIfrs(String stockId,
			short year, byte season) {
		IncomeStatementIfrsKey key = initStockInfo(stockId, year, season,
				IncomeStatementIfrsKey.class);
		return incomeStatementIfrsService.findById(key);
	}

	private <OBJ> OBJ initStockInfo(String stockId, short year, byte season,
			Class<OBJ> objClass) {
		OBJ obj = null;
		try {
			obj = objClass.newInstance();
			MethodUtils.invokeMethod(obj, "setStockId", stockId);
			MethodUtils.invokeMethod(obj, "setYear", year);
			MethodUtils.invokeMethod(obj, "setSeason", season);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
