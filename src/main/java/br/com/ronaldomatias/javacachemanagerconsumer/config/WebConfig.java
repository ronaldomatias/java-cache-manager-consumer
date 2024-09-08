package br.com.ronaldomatias.javacachemanagerconsumer.config;

import br.com.ronaldomatias.cachemanager.aspect.CacheAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.instrument.classloading.ReflectiveLoadTimeWeaver;
import org.springframework.instrument.classloading.ShadowingClassLoader;

@Configuration
public class WebConfig {

	@Bean
	public LoadTimeWeaver loadTimeWeaver() {
		return new ReflectiveLoadTimeWeaver(customClassLoader());
	}

	@Bean
	public ClassLoader customClassLoader() {
		return new ShadowingClassLoader(getClass().getClassLoader());
	}

	@Bean
	public CacheAspect getCacheAspect() {
		return new CacheAspect();
	}

}
