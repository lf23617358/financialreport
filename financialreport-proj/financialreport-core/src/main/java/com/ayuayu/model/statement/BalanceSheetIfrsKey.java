/*
 * Created on 28 五月 2016 ( Time 12:11:43 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.ayuayu.model.statement;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Composite primary key for entity "BalanceSheetIfrsEntity" ( stored in table
 * "BALANCE_SHEET_IFRS" )
 *
 * @author Telosys Tools Generator
 *
 */
@Embeddable
public class BalanceSheetIfrsKey implements Serializable {
	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY KEY ATTRIBUTES
	// ----------------------------------------------------------------------
	@Column(name = "STOCK_ID", nullable = false, length = 5)
	private String stockId;

	@Column(name = "YEAR", nullable = false)
	private Short year;

	@Column(name = "SEASON", nullable = false)
	private Byte season;

	// ----------------------------------------------------------------------
	// CONSTRUCTORS
	// ----------------------------------------------------------------------
	public BalanceSheetIfrsKey() {
		super();
	}

	public BalanceSheetIfrsKey(String stockId, Short year, Byte season) {
		super();
		this.stockId = stockId;
		this.year = year;
		this.season = season;
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR KEY FIELDS
	// ----------------------------------------------------------------------
	public void setStockId(String value) {
		this.stockId = value;
	}

	public String getStockId() {
		return this.stockId;
	}

	public void setYear(Short value) {
		this.year = value;
	}

	public Short getYear() {
		return this.year;
	}

	public void setSeason(Byte value) {
		this.season = value;
	}

	public Byte getSeason() {
		return this.season;
	}

	// ----------------------------------------------------------------------
	// equals METHOD
	// ----------------------------------------------------------------------
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		BalanceSheetIfrsKey other = (BalanceSheetIfrsKey) obj;
		// --- Attribute stockId
		if (stockId == null) {
			if (other.stockId != null)
				return false;
		} else if (!stockId.equals(other.stockId))
			return false;
		// --- Attribute year
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		// --- Attribute season
		if (season == null) {
			if (other.season != null)
				return false;
		} else if (!season.equals(other.season))
			return false;
		return true;
	}

	// ----------------------------------------------------------------------
	// hashCode METHOD
	// ----------------------------------------------------------------------
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		// --- Attribute stockId
		result = prime * result + ((stockId == null) ? 0 : stockId.hashCode());
		// --- Attribute year
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		// --- Attribute season
		result = prime * result + ((season == null) ? 0 : season.hashCode());

		return result;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(stockId);
		sb.append("|");
		sb.append(year);
		sb.append("|");
		sb.append(season);
		return sb.toString();
	}
}