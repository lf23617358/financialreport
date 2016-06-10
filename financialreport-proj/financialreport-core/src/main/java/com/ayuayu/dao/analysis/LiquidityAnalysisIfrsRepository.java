package com.ayuayu.dao.analysis;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayuayu.model.analysis.LiquidityAnalysisIfrs;
import com.ayuayu.model.analysis.LiquidityAnalysisIfrsKey;

public interface LiquidityAnalysisIfrsRepository extends
		JpaRepository<LiquidityAnalysisIfrs, LiquidityAnalysisIfrsKey> {
}
