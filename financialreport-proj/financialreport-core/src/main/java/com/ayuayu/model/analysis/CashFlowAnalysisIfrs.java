/*
 * Created on 1 六月 2016 ( Time 21:33:45 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a composite Primary Key

package com.ayuayu.model.analysis;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "CASH_FLOW_ANALYSIS_IFRS"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name = "CASH_FLOW_ANALYSIS_IFRS")
// Define named queries here
@NamedQueries({ @NamedQuery(name = "CashFlowAnalysisIfrs.countAll", query = "SELECT COUNT(x) FROM CashFlowAnalysisIfrs x") })
public class CashFlowAnalysisIfrs implements Serializable {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )
	// ----------------------------------------------------------------------
	@EmbeddedId
	private CashFlowAnalysisIfrsKey compositePrimaryKey;

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------
	@Column(name = "CASH_FLOW_RATIO")
	private Double cashFlowRatio;

	@Column(name = "CASH_REINVESTMENT_RATIO")
	private Double cashReinvestmentRatio;

	// ----------------------------------------------------------------------
	// ENTITY LINKS ( RELATIONSHIP )
	// ----------------------------------------------------------------------

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public CashFlowAnalysisIfrs() {
		super();
		this.compositePrimaryKey = new CashFlowAnalysisIfrsKey();
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
	// --- DATABASE MAPPING : CASH_FLOW_RATIO ( DOUBLE )
	public void setCashFlowRatio(Double cashFlowRatio) {
		this.cashFlowRatio = cashFlowRatio;
	}

	public Double getCashFlowRatio() {
		return this.cashFlowRatio;
	}

	// --- DATABASE MAPPING : CASH_REINVESTMENT_RATIO ( DOUBLE )
	public void setCashReinvestmentRatio(Double cashReinvestmentRatio) {
		this.cashReinvestmentRatio = cashReinvestmentRatio;
	}

	public Double getCashReinvestmentRatio() {
		return this.cashReinvestmentRatio;
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
		sb.append(cashFlowRatio);
		sb.append("|");
		sb.append(cashReinvestmentRatio);
		return sb.toString();
	}

}
