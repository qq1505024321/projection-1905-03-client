package com.jk.redis;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
@Configuration
@EnableCaching
public class CachingConfig extends CachingConfigurerSupport {
  /*  private RedisSerializer<String> keySerializer() {
        return new StringRedisSerializer();
    }
    //使用Jackson序列化器
    private RedisSerializer<Object> valueSerializer() {
        return new GenericJackson2JsonRedisSerializer();
    }
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        //缓存配置对象
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        redisCacheConfiguration = redisCacheConfiguration.entryTtl(Duration.ofMinutes(30L)) //设置缓存的默认超时时间：30分钟
                .disableCachingNullValues()             //如果是空值，不缓存
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(keySerializer()))         //设置key序列化器
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer((valueSerializer())));  //设置value序列化器
        return RedisCacheManager
                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(redisCacheConfiguration).build();
    }
    @Override
    @Bean
    public KeyGenerator keyGenerator() {
        // TODO Auto-generated method stub
        return new KeyGenerator() {
            @Override
            public Object generate(Object object, Method method, Object... objects) {
                // TODO Auto-generated method stub
                StringBuilder sb = new StringBuilder();
                sb.append(object.getClass().getName());
                sb.append(method.getName());
                for (Object obj : objects) {
                    if (obj != null) {
                        sb.append(obj.toString());
                    }
                }
                return sb.toString();
            }
        };
    }*/
}