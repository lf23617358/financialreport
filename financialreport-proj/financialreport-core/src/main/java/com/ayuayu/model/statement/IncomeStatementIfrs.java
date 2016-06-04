/*
 * Created on 28 五月 2016 ( Time 15:18:25 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a composite Primary Key

package com.ayuayu.model.statement;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "INCOME_STATEMENT_IFRS"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name = "INCOME_STATEMENT_IFRS")
// Define named queries here
@NamedQueries({ @NamedQuery(name = "IncomeStatementIfrs.countAll", query = "SELECT COUNT(x) FROM IncomeStatementIfrs x") })
public class IncomeStatementIfrs implements Serializable {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )
	// ----------------------------------------------------------------------
	@EmbeddedId
	private IncomeStatementIfrsKey compositePrimaryKey;

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------
	@Column(name = "OPERATING_REVENUE")
	private Long operatingRevenue;

	@Column(name = "OPERATING_COSTS")
	private Long operatingCosts;

	@Column(name = "GROSS_PROFIT_LOSS_FROM_OPERATIONS")
	private Long grossProfitLossFromOperations;

	@Column(name = "REALIZED_PROFIT_LOSS_ON_FROM_SALES")
	private Long realizedProfitLossOnFromSales;

	@Column(name = "OPERATING_EXPENSES")
	private Long operatingExpenses;

	@Column(name = "NET_OPERATING_INCOME_LOSS")
	private Long netOperatingIncomeLoss;

	@Column(name = "NONOPERATING_INCOME_AND_EXPENSES")
	private Long nonoperatingIncomeAndExpenses;

	@Column(name = "PROFIT_LOSS_BEFORE_TAX")
	private Long profitLossBeforeTax;

	@Column(name = "INCOME_TAX_EXPENSE_CONTINUING_OPERATIONS")
	private Long incomeTaxExpenseContinuingOperations;

	@Column(name = "PROFIT_LOSS_FROM_CONTINUING_OPERATIONS")
	private Long profitLossFromContinuingOperations;

	@Column(name = "BASIC_EARNINGS_LOSS_PER_SHARE")
	private Double basicEarningsLossPerShare;

	// ----------------------------------------------------------------------
	// ENTITY LINKS ( RELATIONSHIP )
	// ----------------------------------------------------------------------

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public IncomeStatementIfrs() {
		super();
		this.compositePrimaryKey = new IncomeStatementIfrsKey();
	}

	// ----------------------------------------------------------------------
	// GETTER & SETTER FOR THE COMPOSITE KEY
	// ----------------------------------------------------------------------
	public void setStockId(String stockId) {
		this.compositePrimaryKey.setStockId(stockId);
	}

	public String getStockId() {
		return this.compositePrimaryKey.getStockId();
	}

	public void setYear(Short year) {
		this.compositePrimaryKey.setYear(year);
	}

	public Short getYear() {
		return this.compositePrimaryKey.getYear();
	}

	public void setSeason(Byte season) {
		this.compositePrimaryKey.setSeason(season);
	}

	public Byte getSeason() {
		return this.compositePrimaryKey.getSeason();
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR FIELDS
	// ----------------------------------------------------------------------
	// --- DATABASE MAPPING : OPERATING_REVENUE ( BIGINT )
	public void setOperatingRevenue(Long operatingRevenue) {
		this.operatingRevenue = operatingRevenue;
	}

	public Long getOperatingRevenue() {
		return this.operatingRevenue;
	}

	// --- DATABASE MAPPING : OPERATING_COSTS ( BIGINT )
	public void setOperatingCosts(Long operatingCosts) {
		this.operatingCosts = operatingCosts;
	}

	public Long getOperatingCosts() {
		return this.operatingCosts;
	}

	// --- DATABASE MAPPING : GROSS_PROFIT_LOSS_FROM_OPERATIONS ( BIGINT )
	public void setGrossProfitLossFromOperations(
			Long grossProfitLossFromOperations) {
		this.grossProfitLossFromOperations = grossProfitLossFromOperations;
	}

	public Long getGrossProfitLossFromOperations() {
		return this.grossProfitLossFromOperations;
	}

	// --- DATABASE MAPPING : REALIZED_PROFIT_LOSS_ON_FROM_SALES ( BIGINT )
	public void setRealizedProfitLossOnFromSales(
			Long realizedProfitLossOnFromSales) {
		this.realizedProfitLossOnFromSales = realizedProfitLossOnFromSales;
	}

	public Long getRealizedProfitLossOnFromSales() {
		return this.realizedProfitLossOnFromSales;
	}

	// --- DATABASE MAPPING : OPERATING_EXPENSES ( BIGINT )
	public void setOperatingExpenses(Long operatingExpenses) {
		this.operatingExpenses = operatingExpenses;
	}

	public Long getOperatingExpenses() {
		return this.operatingExpenses;
	}

	// --- DATABASE MAPPING : NET_OPERATING_INCOME_LOSS ( BIGINT )
	public void setNetOperatingIncomeLoss(Long netOperatingIncomeLoss) {
		this.netOperatingIncomeLoss = netOperatingIncomeLoss;
	}

	public Long getNetOperatingIncomeLoss() {
		return this.netOperatingIncomeLoss;
	}

	// --- DATABASE MAPPING : NONOPERATING_INCOME_AND_EXPENSES ( BIGINT )
	public void setNonoperatingIncomeAndExpenses(
			Long nonoperatingIncomeAndExpenses) {
		this.nonoperatingIncomeAndExpenses = nonoperatingIncomeAndExpenses;
	}

	public Long getNonoperatingIncomeAndExpenses() {
		return this.nonoperatingIncomeAndExpenses;
	}

	// --- DATABASE MAPPING : PROFIT_LOSS_BEFORE_TAX ( BIGINT )
	public void setProfitLossBeforeTax(Long profitLossBeforeTax) {
		this.profitLossBeforeTax = profitLossBeforeTax;
	}

	public Long getProfitLossBeforeTax() {
		return this.profitLossBeforeTax;
	}

	// --- DATABASE MAPPING : INCOME_TAX_EXPENSE_CONTINUING_OPERATIONS ( BIGINT
	// )
	public void setIncomeTaxExpenseContinuingOperations(
			Long incomeTaxExpenseContinuingOperations) {
		this.incomeTaxExpenseContinuingOperations = incomeTaxExpenseContinuingOperations;
	}

	public Long getIncomeTaxExpenseContinuingOperations() {
		return this.incomeTaxExpenseContinuingOperations;
	}

	// --- DATABASE MAPPING : PROFIT_LOSS_FROM_CONTINUING_OPERATIONS ( BIGINT )
	public void setProfitLossFromContinuingOperations(
			Long profitLossFromContinuingOperations) {
		this.profitLossFromContinuingOperations = profitLossFromContinuingOperations;
	}

	public Long getProfitLossFromContinuingOperations() {
		return this.profitLossFromContinuingOperations;
	}

	// --- DATABASE MAPPING : BASIC_EARNINGS_LOSS_PER_SHARE ( BIGINT )
	public void setBasicEarningsLossPerShare(Double basicEarningsLossPerShare) {
		this.basicEarningsLossPerShare = basicEarningsLossPerShare;
	}

	public Double getBasicEarningsLossPerShare() {
		return this.basicEarningsLossPerShare;
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR LINKS
	// ----------------------------------------------------------------------

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		if (compositePrimaryKey != null) {
			sb.append(compositePrimaryKey.toString());
		} else {
			sb.append("(null-key)");
		}
		sb.append("]:");
		sb.append(operatingRevenue);
		sb.append("|");
		sb.append(operatingCosts);
		sb.append("|");
		sb.append(grossProfitLossFromOperations);
		sb.append("|");
		sb.append(realizedProfitLossOnFromSales);
		sb.append("|");
		sb.append(operatingExpenses);
		sb.append("|");
		sb.append(netOperatingIncomeLoss);
		sb.append("|");
		sb.append(nonoperatingIncomeAndExpenses);
		sb.append("|");
		sb.append(profitLossBeforeTax);
		sb.append("|");
		sb.append(incomeTaxExpenseContinuingOperations);
		sb.append("|");
		sb.append(profitLossFromContinuingOperations);
		sb.append("|");
		sb.append(basicEarningsLossPerShare);
		return sb.toString();
	}

}