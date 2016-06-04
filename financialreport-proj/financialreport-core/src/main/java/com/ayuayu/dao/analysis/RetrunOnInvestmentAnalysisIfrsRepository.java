package com.ayuayu.dao.analysis;

import org.springframework.data.repository.CrudRepository;

import com.ayuayu.model.analysis.RetrunOnInvestmentAnalysisIfrs;
import com.ayuayu.model.analysis.RetrunOnInvestmentAnalysisIfrsKey;

public interface RetrunOnInvestmentAnalysisIfrsRepository
		extends
		CrudRepository<RetrunOnInvestmentAnalysisIfrs, RetrunOnInvestmentAnalysisIfrsKey> {
}
