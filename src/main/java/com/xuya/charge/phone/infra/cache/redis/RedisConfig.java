package com.xuya.charge.phone.infra.cache.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
	
	@Autowired
	private Environment env;
	
	@Bean(name="authInfoStringRedisTemplate")
	public StringRedisTemplate authInfoStringRedisTemplate(
			@Value("${spring.redis.host}") String hostName,
			@Value("${spring.redis.port}") int port,
			@Value("${spring.redis.password}") String password) {
		return new StringRedisTemplate(redisConnectionFactory(hostName,port,password, 1));
	}
	
	@Bean(name="configStringRedisTemplate")
	public StringRedisTemplate configStringRedisTemplate(
			@Value("${spring.redis.host}") String hostName,
			@Value("${spring.redis.port}") int port,
			@Value("${spring.redis.password}") String password) {
		return new StringRedisTemplate(redisConnectionFactory(hostName,port,password, 2));
	}
	
	@Bean(name="queueRedisTemplate")
	public StringRedisTemplate queueRedisTemplate(
			@Value("${spring.redis.host}") String hostName,
			@Value("${spring.redis.port}") int port,
			@Value("${spring.redis.password}") String password) {
		return new StringRedisTemplate(redisConnectionFactory(hostName,port,password, 5));
	}
	
	public RedisConnectionFactory redisConnectionFactory(String hostName,int port,String password, int index) {
        RedisStandaloneConfiguration redisStandaloneConfiguration = redisStandaloneConfiguration(hostName, port, password);
        redisStandaloneConfiguration.setDatabase(index);
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jpcb =
                (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder)JedisClientConfiguration.builder();
        jpcb.poolConfig(jedisPoolConfig());
        JedisClientConfiguration jedisClientConfiguration = jpcb.build();
        return new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
	}

	public JedisPoolConfig jedisPoolConfig() {
    	int maxTotal = Integer.valueOf(env.getProperty("spring.redis.jedis.pool.max-active"));
    	int maxIdle = Integer.valueOf(env.getProperty("spring.redis.jedis.pool.max-idle"));
    	int maxWait = Integer.valueOf(env.getProperty("spring.redis.jedis.pool.max-wait"));
    	int minIdle = Integer.valueOf(env.getProperty("spring.redis.jedis.pool.min-idle"));
    	JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWait);
        jedisPoolConfig.setTestOnBorrow(false);
        return jedisPoolConfig;
    }
    
    private RedisStandaloneConfiguration redisStandaloneConfiguration(String hostName, int port, String password) {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(hostName);
        redisStandaloneConfiguration.setPort(port);
        redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
        return redisStandaloneConfiguration;
    }
	
}
