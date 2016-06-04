import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.dom4j.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ayuayu.bean.Report;
import com.ayuayu.config.AppConfig;
import com.ayuayu.config.JPAConfig;
import com.ayuayu.constants.ReportType;
import com.ayuayu.generator.AnalysisModelGenerator;
import com.ayuayu.model.analysis.CapitalStructureAnalysisIfrs;
import com.ayuayu.model.analysis.CashFlowAnalysisIfrs;
import com.ayuayu.model.analysis.LiquidityAnalysisIfrs;
import com.ayuayu.model.analysis.OperatingPerformanceAnalysisIfrs;
import com.ayuayu.model.analysis.RetrunOnInvestmentAnalysisIfrs;
import com.ayuayu.model.statement.BalanceSheetIfrs;
import com.ayuayu.model.statement.CashFlowStatementIfrs;
import com.ayuayu.model.statement.IncomeStatementIfrs;
import com.ayuayu.service.analysis.CapitalStructureAnalysisIfrsService;
import com.ayuayu.service.analysis.CashFlowAnalysisIfrsService;
import com.ayuayu.service.analysis.LiquidityAnalysisIfrsService;
import com.ayuayu.service.analysis.OperatingPerformanceAnalysisIfrsService;
import com.ayuayu.service.analysis.RetrunOnInvestmentAnalysisIfrsService;
import com.ayuayu.service.statement.BalanceSheetIfrsService;
import com.ayuayu.service.statement.CashFlowStatementIfrsService;
import com.ayuayu.service.statement.IncomeStatementIfrsService;
import com.ayuayu.utils.MappingUtils;
import com.ayuayu.utils.ReadWebUtil;
import com.ayuayu.utils.ReportUtil;
import com.ayuayu.utils.XmlUtil;

public class App {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class, JPAConfig.class);
		BalanceSheetIfrsService balanceSheetIfrsService = context
				.getBean(BalanceSheetIfrsService.class);
		IncomeStatementIfrsService incomeStatementIfrsService = context
				.getBean(IncomeStatementIfrsService.class);
		CashFlowStatementIfrsService cashflowStatementIfrsService = context
				.getBean(CashFlowStatementIfrsService.class);
		CapitalStructureAnalysisIfrsService capitalStructureAnalysisIfrsService = context
				.getBean(CapitalStructureAnalysisIfrsService.class);
		CashFlowAnalysisIfrsService cashFlowAnalysisIfrsService = context
				.getBean(CashFlowAnalysisIfrsService.class);
		LiquidityAnalysisIfrsService liquidityAnalysisIfrsService = context
				.getBean(LiquidityAnalysisIfrsService.class);
		OperatingPerformanceAnalysisIfrsService operatingPerformanceAnalysisIfrsService = context
				.getBean(OperatingPerformanceAnalysisIfrsService.class);
		RetrunOnInvestmentAnalysisIfrsService retrunOnInvestmentAnalysisIfrsService = context
				.getBean(RetrunOnInvestmentAnalysisIfrsService.class);
		AnalysisModelGenerator generator = context
				.getBean(AnalysisModelGenerator.class);
		String stockId = "2330";
		short year = 2014;
		short year1 = 2013;
		byte season = 4;
		byte season1 = 4;
		Report report = getReport(stockId, year, season);
		Report report1 = getReport(stockId, year1, season1);
		System.out.println(report);
		BalanceSheetIfrs balanceSheetIfrs = MappingUtils.mappingAttr(report,
				BalanceSheetIfrs.class);
		BalanceSheetIfrs balanceSheetIfrs1 = MappingUtils.mappingAttr(report1,
				BalanceSheetIfrs.class);
		List<BalanceSheetIfrs> list = new ArrayList<BalanceSheetIfrs>();
		list.add(balanceSheetIfrs);
		list.add(balanceSheetIfrs1);
		balanceSheetIfrsService.save(list);
		incomeStatementIfrsService.save(MappingUtils.mappingAttr(report,
				IncomeStatementIfrs.class));
		cashflowStatementIfrsService.save(MappingUtils.mappingAttr(report,
				CashFlowStatementIfrs.class));
		capitalStructureAnalysisIfrsService.save(generator.generate(stockId,
				year, season, CapitalStructureAnalysisIfrs.class));
		cashFlowAnalysisIfrsService.save(generator.generate(stockId, year,
				season, CashFlowAnalysisIfrs.class));
		liquidityAnalysisIfrsService.save(generator.generate(stockId, year,
				season, LiquidityAnalysisIfrs.class));
		operatingPerformanceAnalysisIfrsService.save(generator.generate(
				stockId, year, season, OperatingPerformanceAnalysisIfrs.class));
		retrunOnInvestmentAnalysisIfrsService.save(generator.generate(stockId,
				year, season, RetrunOnInvestmentAnalysisIfrs.class));

	}

	private static Report getReport(String stockId, short year, byte season)
			throws FileNotFoundException {
		Map<String, String> form = new HashMap<String, String>();
		form.put("step", "9");
		form.put("functionName", "t164sb01");
		form.put("report_id", "C");
		form.put("co_id", stockId);
		form.put("year", "" + year);
		form.put("season", "" + season);
		String filePath = FileUtils.getUserDirectoryPath() + File.separator
				+ "stockid";
		String fileName = ReadWebUtil.fileDownload(
				"http://mops.twse.com.tw/server-java/FileDownLoad", filePath,
				form, "UTF-8");
		Document document = XmlUtil.parse(new FileInputStream(filePath
				+ File.separator + fileName));

		Report report = ReportUtil.parseReportData(stockId, year, season,
				document, ReportType.BALANCE_SHEET);
		report.addAllData(ReportUtil.parseReportData(stockId, year, season,
				document, ReportType.INCOME_STATEMENT));

		report.addAllData(ReportUtil.parseReportData(stockId, year, season,
				document, ReportType.CASHFLOW_STATEMENT));
		return report;
	}
}
