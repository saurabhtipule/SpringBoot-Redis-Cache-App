package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.model.Employee;

@SpringBootApplication
public class SbRedisCacheApplication {

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jcf = new JedisConnectionFactory();

		// jcf.setHostName(hostName);
		// jcf.setPassword(password);
		// jcf.setPort(port);
		return jcf;
	}

	@Bean
	public RedisTemplate<String, Employee> redisTemplate() {

		RedisTemplate<String, Employee> redisTemplate = new RedisTemplate<String, Employee>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(SbRedisCacheApplication.class, args);
		System.out.println("Redis Cache Application Starts");
	}

}
