package com.ayuayu.dao.analysis;

import org.springframework.data.repository.CrudRepository;

import com.ayuayu.model.analysis.OperatingPerformanceAnalysisIfrs;
import com.ayuayu.model.analysis.OperatingPerformanceAnalysisIfrsKey;

public interface OperatingPerformanceAnalysisIfrsRepository
		extends
		CrudRepository<OperatingPerformanceAnalysisIfrs, OperatingPerformanceAnalysisIfrsKey> {
}
