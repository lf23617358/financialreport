package com.ayuayu.constants;

public enum ReportType {
    BALANCE_SHEET("資產負債表"), INCOME_STATEMENT("損益表"), CASHFLOW_STATEMENT("現金流量表"), STATEMENTS_OF_CHANGES_IN_EQUITY(
            "權益變動表"), LIQUIDITY_ANALYSIS("償還能力"), CAPITAL_STRUCTURE_ANALYSIS(
            "財務結構"), OPERATING_PERFORMANCE_ANALYSIS("經營能力"), RETRUN_ON_INVESTMENT_ANALYSIS(
            "獲利能力"), CASH_FLOW("現金流量"), LEVERAGE("槓桿度");
    private String name;

    private ReportType(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

}
