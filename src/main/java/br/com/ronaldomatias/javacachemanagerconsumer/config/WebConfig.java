package br.com.ronaldomatias.javacachemanagerconsumer.config;

import br.com.ronaldomatias.cachemanager.aspect.CacheAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

	@Bean
	public CacheAspect getCacheAspect() {
		return new CacheAspect();
	}

}
