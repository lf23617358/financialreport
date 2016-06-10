package com.ayuayu.dao.analysis;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayuayu.model.analysis.RetrunOnInvestmentAnalysisIfrs;
import com.ayuayu.model.analysis.RetrunOnInvestmentAnalysisIfrsKey;

public interface RetrunOnInvestmentAnalysisIfrsRepository
		extends
		JpaRepository<RetrunOnInvestmentAnalysisIfrs, RetrunOnInvestmentAnalysisIfrsKey> {
}
