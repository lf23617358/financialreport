package com.ayuayu.dao.analysis;

import org.springframework.data.repository.CrudRepository;

import com.ayuayu.model.analysis.CashFlowAnalysisIfrs;
import com.ayuayu.model.analysis.CashFlowAnalysisIfrsKey;

public interface CashFlowAnalysisIfrsRepository extends
		CrudRepository<CashFlowAnalysisIfrs, CashFlowAnalysisIfrsKey> {
}
