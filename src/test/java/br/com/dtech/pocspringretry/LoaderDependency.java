package br.com.dtech.pocspringretry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.dtech.pocspringretry.cache.ConfiguracaoCache;

@Configuration
public class LoaderDependency {

	@Bean
	public ConfiguracaoCache configuracaoCache() {
		return new ConfiguracaoCache();
	}
}
