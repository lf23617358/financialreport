package com.ayuayu.dao.analysis;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayuayu.model.analysis.CashFlowAnalysisIfrs;
import com.ayuayu.model.analysis.CashFlowAnalysisIfrsKey;

public interface CashFlowAnalysisIfrsRepository extends
		JpaRepository<CashFlowAnalysisIfrs, CashFlowAnalysisIfrsKey> {
}
