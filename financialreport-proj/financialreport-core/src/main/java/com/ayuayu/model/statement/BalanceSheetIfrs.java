/*
 * Created on 28 五月 2016 ( Time 12:11:43 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a composite Primary Key

package com.ayuayu.model.statement;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "BALANCE_SHEET_IFRS"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name = "BALANCE_SHEET_IFRS")
// Define named queries here
@NamedQueries({ @NamedQuery(name = "BalanceSheetIfrs.countAll", query = "SELECT COUNT(x) FROM BalanceSheetIfrs x") })
public class BalanceSheetIfrs implements Serializable {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )
	// ----------------------------------------------------------------------
	@EmbeddedId
	private BalanceSheetIfrsKey compositePrimaryKey;

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------
	@Column(name = "ASSETS")
	private Long assets;

	@Column(name = "CURRENT_ASSETS")
	private Long currentAssets;

	@Column(name = "CASH_AND_CASH_EQUIVALENTS")
	private Long cashAndCashEquivalents;

	@Column(name = "INVENTORIES")
	private Long inventories;

	@Column(name = "PREPAYMENTS")
	private Long prepayments;

	@Column(name = "NOTES_RECEIVABLE_NET")
	private Long notesReceivableNet;

	@Column(name = "ACCOUNTS_RECEIVABLE_NET")
	private Long accountsReceivableNet;

	@Column(name = "ACCOUNTS_RECEIVABLE_DUEFROM_RELATED_PARTIES_NET")
	private Long accountsReceivableDuefromRelatedPartiesNet;

	@Column(name = "OTHER_RECEIVABLES_DUE_FROM_RELATED_PARTIES")
	private Long otherReceivablesDueFromRelatedParties;

	@Column(name = "OTHER_CURRENT_ASSETS")
	private Long otherCurrentAssets;

	@Column(name = "PROPERTY_PLANT_AND_EQUIPMENT")
	private Long propertyPlantAndEquipment;

	@Column(name = "INVESTMENT_PROPERTY")
	private Long investmentProperty;

	@Column(name = "INVESTMENT_ACCOUNTED_FOR_USING_EQUITY_METHOD")
	private Long investmentAccountedForUsingEquityMethod;

	@Column(name = "NONCURRENT_ASSETS")
	private Long noncurrentAssets;

	@Column(name = "NONCURRENT_AVAILABLE_FOR_SALE_FINANCIAL_ASSETS")
	private Long noncurrentAvailableForSaleFinancialAssets;

	@Column(name = "NONCURRENT_FINANCIAL_ASSETS_AT_COST")
	private Long noncurrentFinancialAssetsAtCost;

	@Column(name = "OTHER_NONCURRENT_ASSETS")
	private Long otherNoncurrentAssets;

	@Column(name = "LIABILITIES")
	private Long liabilities;

	@Column(name = "CURRENT_LIABILITIES")
	private Long currentLiabilities;

	@Column(name = "NONCURRENT_LIABILITIES")
	private Long noncurrentLiabilities;

	@Column(name = "OTHER_NONCURRENT_LIABILITIES")
	private Long otherNoncurrentLiabilities;

	@Column(name = "EQUITY")
	private Long equity;

	// ----------------------------------------------------------------------
	// ENTITY LINKS ( RELATIONSHIP )
	// ----------------------------------------------------------------------

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public BalanceSheetIfrs() {
		super();
		this.compositePrimaryKey = new BalanceSheetIfrsKey();
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
	// --- DATABASE MAPPING : ASSETS ( BIGINT )
	public void setAssets(Long assets) {
		this.assets = assets;
	}

	public Long getAssets() {
		return this.assets;
	}

	// --- DATABASE MAPPING : CURRENT_ASSETS ( BIGINT )
	public void setCurrentAssets(Long currentAssets) {
		this.currentAssets = currentAssets;
	}

	public Long getCurrentAssets() {
		return this.currentAssets;
	}

	// --- DATABASE MAPPING : CASH_AND_CASH_EQUIVALENTS ( BIGINT )
	public void setCashAndCashEquivalents(Long cashAndCashEquivalents) {
		this.cashAndCashEquivalents = cashAndCashEquivalents;
	}

	public Long getCashAndCashEquivalents() {
		return this.cashAndCashEquivalents;
	}

	// --- DATABASE MAPPING : INVENTORIES ( BIGINT )
	public void setInventories(Long inventories) {
		this.inventories = inventories;
	}

	public Long getInventories() {
		return this.inventories;
	}

	// --- DATABASE MAPPING : PREPAYMENTS ( BIGINT )
	public void setPrepayments(Long prepayments) {
		this.prepayments = prepayments;
	}

	public Long getPrepayments() {
		return this.prepayments;
	}

	// --- DATABASE MAPPING : NOTES_RECEIVABLE_NET ( BIGINT )
	public void setNotesReceivableNet(Long notesReceivableNet) {
		this.notesReceivableNet = notesReceivableNet;
	}

	public Long getNotesReceivableNet() {
		return this.notesReceivableNet;
	}

	// --- DATABASE MAPPING : ACCOUNTS_RECEIVABLE_NET ( BIGINT )
	public void setAccountsReceivableNet(Long accountsReceivableNet) {
		this.accountsReceivableNet = accountsReceivableNet;
	}

	public Long getAccountsReceivableNet() {
		return this.accountsReceivableNet;
	}

	// --- DATABASE MAPPING : ACCOUNTS_RECEIVABLE_DUEFROM_RELATED_PARTIES_NET (
	// BIGINT )
	public void setAccountsReceivableDuefromRelatedPartiesNet(
			Long accountsReceivableDuefromRelatedPartiesNet) {
		this.accountsReceivableDuefromRelatedPartiesNet = accountsReceivableDuefromRelatedPartiesNet;
	}

	public Long getAccountsReceivableDuefromRelatedPartiesNet() {
		return this.accountsReceivableDuefromRelatedPartiesNet;
	}

	// --- DATABASE MAPPING : OTHER_RECEIVABLES_DUE_FROM_RELATED_PARTIES ( BIGINT
	// )
	public void setOtherReceivablesDueFromRelatedParties(
			Long otherReceivablesDueFromRelatedParties) {
		this.otherReceivablesDueFromRelatedParties = otherReceivablesDueFromRelatedParties;
	}

	public Long getOtherReceivablesDueFromRelatedParties() {
		return this.otherReceivablesDueFromRelatedParties;
	}

	// --- DATABASE MAPPING : OTHER_CURRENT_ASSETS ( BIGINT )
	public void setOtherCurrentAssets(Long otherCurrentAssets) {
		this.otherCurrentAssets = otherCurrentAssets;
	}

	public Long getOtherCurrentAssets() {
		return this.otherCurrentAssets;
	}

	// --- DATABASE MAPPING : PROPERTY_PLANT_AND_EQUIPMENT ( BIGINT )
	public void setPropertyPlantAndEquipment(Long propertyPlantAndEquipment) {
		this.propertyPlantAndEquipment = propertyPlantAndEquipment;
	}

	public Long getPropertyPlantAndEquipment() {
		return this.propertyPlantAndEquipment;
	}

	// --- DATABASE MAPPING : INVESTMENT_PROPERTY ( BIGINT )
	public void setInvestmentProperty(Long investmentProperty) {
		this.investmentProperty = investmentProperty;
	}

	public Long getInvestmentProperty() {
		return this.investmentProperty;
	}

	// --- DATABASE MAPPING : INVESTMENT_ACCOUNTED_FOR_USING_EQUITY_METHOD (
	// BIGINT )
	public void setInvestmentAccountedForUsingEquityMethod(
			Long investmentAccountedForUsingEquityMethod) {
		this.investmentAccountedForUsingEquityMethod = investmentAccountedForUsingEquityMethod;
	}

	public Long getInvestmentAccountedForUsingEquityMethod() {
		return this.investmentAccountedForUsingEquityMethod;
	}

	// --- DATABASE MAPPING : NONCURRENT_ASSETS ( BIGINT )
	public void setNoncurrentAssets(Long noncurrentAssets) {
		this.noncurrentAssets = noncurrentAssets;
	}

	public Long getNoncurrentAssets() {
		return this.noncurrentAssets;
	}

	// --- DATABASE MAPPING : NONCURRENT_AVAILABLE_FOR_SALE_FINANCIAL_ASSETS (
	// BIGINT )
	public void setNoncurrentAvailableForSaleFinancialAssets(
			Long noncurrentAvailableForSaleFinancialAssets) {
		this.noncurrentAvailableForSaleFinancialAssets = noncurrentAvailableForSaleFinancialAssets;
	}

	public Long getNoncurrentAvailableForSaleFinancialAssets() {
		return this.noncurrentAvailableForSaleFinancialAssets;
	}

	// --- DATABASE MAPPING : NONCURRENT_FINANCIAL_ASSETS_AT_COST ( BIGINT )
	public void setNoncurrentFinancialAssetsAtCost(
			Long noncurrentFinancialAssetsAtCost) {
		this.noncurrentFinancialAssetsAtCost = noncurrentFinancialAssetsAtCost;
	}

	public Long getNoncurrentFinancialAssetsAtCost() {
		return this.noncurrentFinancialAssetsAtCost;
	}

	// --- DATABASE MAPPING : OTHER_NONCURRENT_ASSETS ( BIGINT )
	public void setOtherNoncurrentAssets(Long otherNoncurrentAssets) {
		this.otherNoncurrentAssets = otherNoncurrentAssets;
	}

	public Long getOtherNoncurrentAssets() {
		return this.otherNoncurrentAssets;
	}

	// --- DATABASE MAPPING : LIABILITIES ( BIGINT )
	public void setLiabilities(Long liabilities) {
		this.liabilities = liabilities;
	}

	public Long getLiabilities() {
		return this.liabilities;
	}

	// --- DATABASE MAPPING : CURRENT_LIABILITIES ( BIGINT )
	public void setCurrentLiabilities(Long currentLiabilities) {
		this.currentLiabilities = currentLiabilities;
	}

	public Long getCurrentLiabilities() {
		return this.currentLiabilities;
	}

	// --- DATABASE MAPPING : NONCURRENT_LIABILITIES ( BIGINT )
	public void setNoncurrentLiabilities(Long noncurrentLiabilities) {
		this.noncurrentLiabilities = noncurrentLiabilities;
	}

	public Long getNoncurrentLiabilities() {
		return this.noncurrentLiabilities;
	}

	// --- DATABASE MAPPING : OTHER_NONCURRENT_LIABILITIES ( BIGINT )
	public void setOtherNoncurrentLiabilities(Long otherNoncurrentLiabilities) {
		this.otherNoncurrentLiabilities = otherNoncurrentLiabilities;
	}

	public Long getOtherNoncurrentLiabilities() {
		return this.otherNoncurrentLiabilities;
	}

	// --- DATABASE MAPPING : EQUITY ( BIGINT )
	public void setEquity(Long equity) {
		this.equity = equity;
	}

	public Long getEquity() {
		return this.equity;
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
		sb.append(assets);
		sb.append("|");
		sb.append(currentAssets);
		sb.append("|");
		sb.append(cashAndCashEquivalents);
		sb.append("|");
		sb.append(inventories);
		sb.append("|");
		sb.append(prepayments);
		sb.append("|");
		sb.append(notesReceivableNet);
		sb.append("|");
		sb.append(accountsReceivableNet);
		sb.append("|");
		sb.append(accountsReceivableDuefromRelatedPartiesNet);
		sb.append("|");
		sb.append(otherReceivablesDueFromRelatedParties);
		sb.append("|");
		sb.append(otherCurrentAssets);
		sb.append("|");
		sb.append(propertyPlantAndEquipment);
		sb.append("|");
		sb.append(investmentProperty);
		sb.append("|");
		sb.append(investmentAccountedForUsingEquityMethod);
		sb.append("|");
		sb.append(noncurrentAssets);
		sb.append("|");
		sb.append(noncurrentAvailableForSaleFinancialAssets);
		sb.append("|");
		sb.append(noncurrentFinancialAssetsAtCost);
		sb.append("|");
		sb.append(otherNoncurrentAssets);
		sb.append("|");
		sb.append(liabilities);
		sb.append("|");
		sb.append(currentLiabilities);
		sb.append("|");
		sb.append(noncurrentLiabilities);
		sb.append("|");
		sb.append(otherNoncurrentLiabilities);
		sb.append("|");
		sb.append(equity);
		return sb.toString();
	}

}