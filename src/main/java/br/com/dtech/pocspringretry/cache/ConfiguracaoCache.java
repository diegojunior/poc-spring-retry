package br.com.dtech.pocspringretry.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ConfiguracaoCache {

	public static final String RETRY_CONVIVENCIA = "retry.convivencia";
	
	private Map<String, String> cache = new HashMap<>();
	
	public ConfiguracaoCache() {
		this.cache.put(RETRY_CONVIVENCIA, "2");
	}
	
	public Integer get() {
		return Integer.valueOf(cache.get(RETRY_CONVIVENCIA));
	}
	
}
