package com.nttdata.bank.config;

/*import com.nttdata.bank.model.bean.Passive;
import com.nttdata.bank.model.bean.Staff;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.*;*/

import java.time.Duration;

//@Configuration
//@ConditionalOnProperty(name= "cache.enabled", havingValue = "true")
public class RedisConfig {

  /*@Bean
  public ReactiveHashOperations<Object, String, Passive> hashOperations(ReactiveRedisConnectionFactory reactiveRedisConnectionFactory){
    var template = new ReactiveRedisTemplate<>(
        reactiveRedisConnectionFactory,
        RedisSerializationContext.newSerializationContext(new StringRedisSerializer())
            .hashKey(new GenericToStringSerializer<>(String.class))
            .hashValue(new Jackson2JsonRedisSerializer<>(Staff.class))
            .build()
    );
    return template.opsForHash();
  }

  @Bean
  public LettuceConnectionFactory lettuceConnectionFactory(){
    return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost",6379));
  }

  @Bean
  public RedisCacheConfiguration cacheConfiguration(){
    return RedisCacheConfiguration.defaultCacheConfig()
            .entryTtl(Duration.ofMinutes(60)).disableCachingNullValues()
            .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
  }

  @Bean
  public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer(){
    return (builder ) -> builder.withCacheConfiguration("itemCache",
        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(10)))
        .withCacheConfiguration("passiveCache", RedisCacheConfiguration.defaultCacheConfig()
        .entryTtl(Duration.ofMinutes(5)));
  }*/

}
