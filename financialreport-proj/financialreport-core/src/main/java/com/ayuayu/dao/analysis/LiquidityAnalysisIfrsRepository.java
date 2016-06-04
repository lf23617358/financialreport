package com.ayuayu.dao.analysis;

import org.springframework.data.repository.CrudRepository;

import com.ayuayu.model.analysis.LiquidityAnalysisIfrs;
import com.ayuayu.model.analysis.LiquidityAnalysisIfrsKey;

public interface LiquidityAnalysisIfrsRepository extends
		CrudRepository<LiquidityAnalysisIfrs, LiquidityAnalysisIfrsKey> {
}
