package com.ayuayu.dao.analysis;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayuayu.model.analysis.OperatingPerformanceAnalysisIfrs;
import com.ayuayu.model.analysis.OperatingPerformanceAnalysisIfrsKey;

public interface OperatingPerformanceAnalysisIfrsRepository
		extends
		JpaRepository<OperatingPerformanceAnalysisIfrs, OperatingPerformanceAnalysisIfrsKey> {
}
