package com.sm.multi.db;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ChainedTransactionManagerConfig {

	@Bean(name = "chainedTransactionManager")
	public ChainedTransactionManager createChainedTransactionManager(
			@Qualifier("barTransactionManager") PlatformTransactionManager barTransactionManager,
			@Qualifier("transactionManager") PlatformTransactionManager transactionManager) {
		return new ChainedTransactionManager(barTransactionManager, transactionManager);
	}
}
