package com.secbro.config;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author sec
 * @version 1.0
 * @date 2020/3/24 10:37 上午
 **/
@Configuration
@ConfigurationProperties(prefix = "memcached")
public class MemcachedClientAutoConfiguration {

	private String servers;

	private int poolSize;

	private long opTimeout;

	@Bean
	@ConditionalOnMissingBean(MemcachedClient.class)
	public MemcachedClient createMemcachedClient() throws IOException {
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(servers);
		builder.setConnectionPoolSize(poolSize);
		builder.setOpTimeout(opTimeout);
		return builder.build();
	}

	public void setServers(String servers) {
		this.servers = servers;
	}

	public void setPoolSize(int poolSize) {
		this.poolSize = poolSize;
	}

	public void setOpTimeout(long opTimeout) {
		this.opTimeout = opTimeout;
	}
}
