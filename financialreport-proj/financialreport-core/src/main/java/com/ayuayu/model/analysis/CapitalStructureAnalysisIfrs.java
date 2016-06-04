/*
 * Created on 29 五月 2016 ( Time 00:10:32 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a composite Primary Key

package com.ayuayu.model.analysis;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "CAPITAL_STRUCTURE_ANALYSIS_IFRS"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name = "CAPITAL_STRUCTURE_ANALYSIS_IFRS", schema = "PUBLIC", catalog = "STOCKDB")
// Define named queries here
@NamedQueries({ @NamedQuery(name = "CapitalStructureAnalysisIfrs.countAll", query = "SELECT COUNT(x) FROM CapitalStructureAnalysisIfrs x") })
public class CapitalStructureAnalysisIfrs implements Serializable {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )
	// ----------------------------------------------------------------------
	@EmbeddedId
	private CapitalStructureAnalysisIfrsKey compositePrimaryKey;

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------
	@Column(name = "DEBT_RATIO")
	private Double debtRatio;

	@Column(name = "DEBT_EQUITY_RATIO")
	private Double debtEquityRatio;

	@Column(name = "LONG_TERM_FUNDS_TO_PROPERTY_PLANT_AND_EQUIPMENT")
	private Double longTermFundsToPropertyPlantAndEquipment;

	// ----------------------------------------------------------------------
	// ENTITY LINKS ( RELATIONSHIP )
	// ----------------------------------------------------------------------

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public CapitalStructureAnalysisIfrs() {
		super();
		this.compositePrimaryKey = new CapitalStructureAnalysisIfrsKey();
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
	// --- DATABASE MAPPING : DEBT_RATIO ( DOUBLE )
	public void setDebtRatio(Double debtRatio) {
		this.debtRatio = debtRatio;
	}

	public Double getDebtRatio() {
		return this.debtRatio;
	}

	// --- DATABASE MAPPING : DEBT_EQUITY_RATIO ( DOUBLE )
	public void setDebtEquityRatio(Double debtEquityRatio) {
		this.debtEquityRatio = debtEquityRatio;
	}

	public Double getDebtEquityRatio() {
		return this.debtEquityRatio;
	}

	// --- DATABASE MAPPING : LONG_TERM_FUNDS_TO_PROPERTY_PLANT_AND_EQUIPMENT (
	// DOUBLE )
	public void setLongTermFundsToPropertyPlantAndEquipment(
			Double longTermFundsToPropertyPlantAndEquipment) {
		this.longTermFundsToPropertyPlantAndEquipment = longTermFundsToPropertyPlantAndEquipment;
	}

	public Double getLongTermFundsToPropertyPlantAndEquipment() {
		return this.longTermFundsToPropertyPlantAndEquipment;
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
		sb.append(debtRatio);
		sb.append("|");
		sb.append(debtEquityRatio);
		sb.append("|");
		sb.append(longTermFundsToPropertyPlantAndEquipment);
		return sb.toString();
	}

}