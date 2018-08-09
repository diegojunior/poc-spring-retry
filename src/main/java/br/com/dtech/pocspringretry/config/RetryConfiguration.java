package br.com.dtech.pocspringretry.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import br.com.dtech.pocspringretry.cache.ConfiguracaoCache;

@Configuration
@ComponentScan("br.com.dtech.pocspringretry")
public class RetryConfiguration {

	@Autowired
	private ConfiguracaoCache configuracaoCache;
	
	@Bean
	public RetryTemplate retryTemplate() {
		RetryTemplate retryTemplate = new RetryTemplate();
		
		SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy(configuracaoCache.get());
		FixedBackOffPolicy backOff = new FixedBackOffPolicy();
		
		backOff.setBackOffPeriod(2000l);
		
		retryTemplate.setRetryPolicy(retryPolicy);
		retryTemplate.setBackOffPolicy(backOff);
		
		return retryTemplate;
	}
	
}
