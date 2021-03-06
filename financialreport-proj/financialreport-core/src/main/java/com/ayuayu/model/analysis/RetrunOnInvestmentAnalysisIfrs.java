/*
 * Created on 1 六月 2016 ( Time 21:34:07 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a composite Primary Key

package com.ayuayu.model.analysis;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table
 * "RETRUN_ON_INVESTMENT_ANALYSIS_IFRS"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name = "RETRUN_ON_INVESTMENT_ANALYSIS_IFRS")
// Define named queries here
@NamedQueries({ @NamedQuery(name = "RetrunOnInvestmentAnalysisIfrs.countAll", query = "SELECT COUNT(x) FROM RetrunOnInvestmentAnalysisIfrs x") })
public class RetrunOnInvestmentAnalysisIfrs implements Serializable {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )
	// ----------------------------------------------------------------------
	@EmbeddedId
	private RetrunOnInvestmentAnalysisIfrsKey compositePrimaryKey;

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------
	@Column(name = "ROA")
	private Double roa;

	@Column(name = "ROE")
	private Double roe;

	@Column(name = "GROSS_PROFIT_MARGIN")
	private Double grossProfitMargin;

	@Column(name = "OPERATING_PROFIT_MARGIN")
	private Double operatingProfitMargin;

	@Column(name = "PRE_TAX_NET_PROFIT_MARGIN")
	private Double preTaxNetProfitMargin;

	@Column(name = "NET_PROFIT_MARGIN")
	private Double netProfitMargin;

	// ----------------------------------------------------------------------
	// ENTITY LINKS ( RELATIONSHIP )
	// ----------------------------------------------------------------------

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public RetrunOnInvestmentAnalysisIfrs() {
		super();
		this.compositePrimaryKey = new RetrunOnInvestmentAnalysisIfrsKey();
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
	// --- DATABASE MAPPING : ROA ( DOUBLE )
	public void setRoa(Double roa) {
		this.roa = roa;
	}

	public Double getRoa() {
		return this.roa;
	}

	// --- DATABASE MAPPING : ROE ( DOUBLE )
	public void setRoe(Double roe) {
		this.roe = roe;
	}

	public Double getRoe() {
		return this.roe;
	}

	// --- DATABASE MAPPING : GROSS_PROFIT_MARGIN ( DOUBLE )
	public void setGrossProfitMargin(Double grossProfitMargin) {
		this.grossProfitMargin = grossProfitMargin;
	}

	public Double getGrossProfitMargin() {
		return this.grossProfitMargin;
	}

	// --- DATABASE MAPPING : OPERATING_PROFIT_MARGIN ( DOUBLE )
	public void setOperatingProfitMargin(Double operatingProfitMargin) {
		this.operatingProfitMargin = operatingProfitMargin;
	}

	public Double getOperatingProfitMargin() {
		return this.operatingProfitMargin;
	}

	// --- DATABASE MAPPING : PRE_TAX_NET_PROFIT_MARGIN ( DOUBLE )
	public void setPreTaxNetProfitMargin(Double preTaxNetProfitMargin) {
		this.preTaxNetProfitMargin = preTaxNetProfitMargin;
	}

	public Double getPreTaxNetProfitMargin() {
		return this.preTaxNetProfitMargin;
	}

	// --- DATABASE MAPPING : NET_PROFIT_MARGIN ( DOUBLE )
	public void setNetProfitMargin(Double netProfitMargin) {
		this.netProfitMargin = netProfitMargin;
	}

	public Double getNetProfitMargin() {
		return this.netProfitMargin;
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
		sb.append(roa);
		sb.append("|");
		sb.append(roe);
		sb.append("|");
		sb.append(grossProfitMargin);
		sb.append("|");
		sb.append(operatingProfitMargin);
		sb.append("|");
		sb.append(preTaxNetProfitMargin);
		sb.append("|");
		sb.append(netProfitMargin);
		return sb.toString();
	}

}
