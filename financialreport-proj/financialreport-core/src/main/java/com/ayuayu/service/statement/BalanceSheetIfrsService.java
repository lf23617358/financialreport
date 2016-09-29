package com.ayuayu.service.statement;

import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Service;

import com.ayuayu.model.statement.BalanceSheetIfrs;
import com.ayuayu.model.statement.BalanceSheetIfrsKey;
import com.ayuayu.predicates.statement.BalanceSheetIfrsPredicates;
import com.ayuayu.service.BaseServiceImpl;
import com.querydsl.core.types.Predicate;

@Service
public class BalanceSheetIfrsService extends
		BaseServiceImpl<BalanceSheetIfrs, BalanceSheetIfrsKey> {
	@SuppressWarnings("unchecked")
	public List<BalanceSheetIfrs> findAllByCond() {
		Predicate predicate = BalanceSheetIfrsPredicates
				.lessEquelAccountsReceivableDuefromRelatedPartiesNet(0);
		Iterable<BalanceSheetIfrs> result = ((QueryDslPredicateExecutor<BalanceSheetIfrs>) repository)
				.findAll(predicate);
		return IteratorUtils.toList(result.iterator());
	}
}
