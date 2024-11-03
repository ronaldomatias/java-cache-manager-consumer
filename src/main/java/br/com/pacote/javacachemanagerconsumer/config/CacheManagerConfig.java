package br.com.pacote.javacachemanagerconsumer.config;

import br.com.ronaldomatias.cachemanager.aspect.CacheAspect;
import br.com.ronaldomatias.cachemanager.redis.config.client.RedisConnectionFactory;
import br.com.ronaldomatias.cachemanager.redis.config.key.RedisKeyComposer;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheManagerConfig {

	@Bean
	public CacheAspect getCacheAspect() {
		return new CacheAspect();
	}

	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		RedisConnectionFactory.configure("localhost", 6379);
		return RedisConnectionFactory.getInstance();
	}

	@PostConstruct
	public void setCacheManagerPrefix() {
		RedisKeyComposer.setKeyPrefix("distributorId");
	}

}
