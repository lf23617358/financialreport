package com.ayuayu.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.dom4j.Document;
import org.dom4j.Element;

import com.ayuayu.bean.DayOfReport;
import com.ayuayu.bean.Report;
import com.ayuayu.constants.Institution;
import com.ayuayu.constants.ReportType;
import com.iisigroup.aamgr.constants.Base64Mode;
import com.iisigroup.aamgr.handler.impl.Base64Handler;

@SuppressWarnings("unchecked")
public class ReportUtil {
	public static Report parseReportData(String stockId, short year,
			byte season, Document document, ReportType reportType) {
		ResourceBundle rb = ReportResourceUtil.getResource(
				year > 2012 ? Institution.IFRS : Institution.GAAP, reportType);
		Report report = new Report();
		report.setStockId(stockId);
		report.setYear(year);
		report.setSeason(season);
		// report.setReportType(reportType);
		for (String key : rb.keySet()) {
			List<Element> elements = document
					.selectNodes("//*[ends-with(name(),':" + key
							+ "') and not(starts-with(name(),'tifrs-notes'))]");
			if (elements.isEmpty()) {
				report.addData(key, 0);
			} else {
				report.addData(key,
						NumberUtils.createNumber(elements.get(0).getTextTrim()));
			}
		}
		return report;
	}

	public static Report parseReportData(String stockId, short year,
			byte season, Document document) {
		Properties properties = ReportResourceUtil
				.getResource(year > 2012 ? Institution.IFRS : Institution.GAAP);
		Report report = new Report();
		report.setStockId(stockId);
		report.setYear(year);
		report.setSeason(season);
		// report.setReportType(reportType);
		for (Entry<Object, Object> entry : properties.entrySet()) {
			List<Element> elements = document
					.selectNodes("//*[ends-with(name(),':" + entry.getKey()
							+ "') and not(starts-with(name(),'tifrs-notes'))]");
			if (elements.isEmpty()) {
				report.addData((String) entry.getKey(), 0);
			} else {
				report.addData((String) entry.getKey(),
						NumberUtils.createNumber(elements.get(0).getTextTrim()));
			}
		}
		return report;
	}

	/**
	 * 剖析本益比淨值比殖利率
	 *
	 * @param stockId
	 * @param year
	 * @param month
	 * @param document
	 * @return
	 */
	public static DayOfReport parseIndicators(String stockId, int year,
			int month, InputStream is) {
		DayOfReport report = new DayOfReport();
		report.setYear(year);
		report.setMonth(month);
		report.setStockId(stockId);
		// File file = new File(filePath);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(is));
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (!line
						.startsWith("<input type=hidden id='html' name='html' value="))
					continue;
				line = StringUtils.substringBetween(line,
						"<input type=hidden id='html' name='html' value=\"",
						"\">");
				Base64Handler handler = new Base64Handler(Base64Mode.DECODE);
				byte[] result = handler.handle(line.getBytes());
				line = new String(result);
				String[] trs = StringUtils.substringsBetween(line,
						"<tr bgcolor=#FFFFFF>", "</tr>");
				for (String tr : trs) {
					String date = StringUtils
							.substringBetween(tr,
									"<td height=20 class=basic2 align=center>",
									"</td>");
					String[] tds = StringUtils.substringsBetween(tr,
							"<td height=20 class=basic2 align=right>", "</td>");
					int day = Integer.parseInt(date.split("/")[2]);
					report.addData("本益比", day,
							Double.parseDouble(tds[0].trim()));
					report.addData("殖利率", day,
							Double.parseDouble(tds[1].trim()));
					report.addData("股價淨值比", day,
							Double.parseDouble(tds[2].trim()));
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(reader);
		}

		return report;
	}

//	public static DayOfReport compute(String stockId, int year, int season,
//			ReportType reportType, DayOfReport... reports) {
//		DayOfReport report = new DayOfReport();
//		report.setYear(year);
//		report.setSeason(season);
//		report.setStockId(stockId);
//		report.setReportType(reportType);
//		switch (reportType) {
//		case LIQUIDITY_ANALYSIS:
//			LiquidityAnalysisService liquidityAnalysisService = new LiquidityAnalysisServiceImpl();
//			liquidityAnalysisService.init(year, season, reports);
//			report.addData("流動比",
//					liquidityAnalysisService.computeCurrentRatio());
//			report.addData("速動比", liquidityAnalysisService.computeQuickRatio());
//			report.addData("利息保障倍數",
//					liquidityAnalysisService.computeInterestGuarantee());
//			break;
//		case RETRUN_ON_INVESTMENT_ANALYSIS:
//			RetrunOnInvestmentAnalysisService retrunOnInvestmentAnalysisService = new RetrunOnInvestmentAnalysisServiceImpl();
//			retrunOnInvestmentAnalysisService.init(year, season, reports);
//			report.addData("毛利率", retrunOnInvestmentAnalysisService
//					.computeGrossProfitMargin());
//			report.addData("營業利益率", retrunOnInvestmentAnalysisService
//					.computeOperatingProfitMargin());
//			report.addData("稅前淨利率", retrunOnInvestmentAnalysisService
//					.computePreTaxNetProfitMargin());
//			report.addData("稅後淨利率",
//					retrunOnInvestmentAnalysisService.computeNetProfitMargin());
//			report.addData("股東權益報酬率",
//					retrunOnInvestmentAnalysisService.computeROE());
//			report.addData("資產報酬率",
//					retrunOnInvestmentAnalysisService.computeROA());
//			break;
//		case CAPITAL_STRUCTURE_ANALYSIS:
//			// CapitalStructureAnalysisService capitalStructureAnalysisService =
//			// new CapitalStructureAnalysisServiceImpl();
//			// capitalStructureAnalysisService.init(year, season, reports);
//			// report.addData("負債比",
//			// capitalStructureAnalysisService.computeDebtRatio());
//			// report.addData("負債淨值比",
//			// capitalStructureAnalysisService.computeDebtEquityRatio());
//			// report.addData("長期資金佔固定資產比", capitalStructureAnalysisService
//			// .computeLongTermFundsToFixedAssets());
//			break;
//		case OPERATING_PERFORMANCE_ANALYSIS:
//			OperatingPerformanceAnalysisService operatingPerformanceAnalysisService = new OperatingPerformanceAnalysisServiceImpl();
//			operatingPerformanceAnalysisService.init(year, season, reports);
//			report.addData("應收帳款周轉率", operatingPerformanceAnalysisService
//					.computeAccountsReceivableTurnoverRatio());
//			report.addData("平均收現日數", operatingPerformanceAnalysisService
//					.computeAccountsReceivableTurnoverDays());
//			report.addData("存貨周轉率", operatingPerformanceAnalysisService
//					.computeInventoryTurnoverRatio());
//			report.addData("平均銷貨日數", operatingPerformanceAnalysisService
//					.computeInventoryTurnoverDays());
//			report.addData("固定資產周轉率", operatingPerformanceAnalysisService
//					.computeFixedAssetTurnoverRatio());
//			report.addData("總資產周轉率", operatingPerformanceAnalysisService
//					.computeTotalAssetTurnoverRatio());
//			break;
//		case CASH_FLOW:
//			CashFlowService cashFlowService = new CashFlowServiceImpl();
//			cashFlowService.init(year, season, reports);
//			report.addData("現金流量比率", cashFlowService.computeCashFlowRatio());
//			report.addData("現金再投資比率",
//					cashFlowService.computeCashReinvestmentRatio());
//			// report.addData("現金流量允當比率",
//			// cashFlowService.computeCashFlowAdequacyRatio());
//			break;
//		// case LEVERAGE:
//		// LeverageService leverageService = new LeverageServiceImpl();
//		// leverageService.init(year, season, reports);
//		// report.addData("財務槓桿度", leverageService.computeFiancialLeverage());
//		// report.addData("營運槓桿度", leverageService.computeOperatingLeverage());
//		// break;
//		default:
//			throw new RuntimeException("unsupport report type:" + reportType);
//		}
//		return report;
//	}
}
