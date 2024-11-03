package br.com.pacote.javacachemanagerconsumer.config;

import br.com.ronaldomatias.cachemanager.redis.config.client.RedisConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisClientConfig {

	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		RedisConnectionFactory.configure("localhost", 6379);
		return RedisConnectionFactory.getInstance();
	}

}
