package com.ayuayu.predicates.statement;

import com.ayuayu.model.statement.QBalanceSheetIfrs;
import com.querydsl.core.types.Predicate;

public class BalanceSheetIfrsPredicates {
	public static Predicate lessEquelAccountsReceivableDuefromRelatedPartiesNet(
			final long number) {
		QBalanceSheetIfrs balanceSheetIfrs = QBalanceSheetIfrs.balanceSheetIfrs;
		return balanceSheetIfrs.assets.goe(number);
	}
}