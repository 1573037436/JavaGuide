## spring集成rieds
1. 导包
~~~
    <!-- redis cache start -->
        <dependency>
            <groupId>org.springframework.data</groupId>
            <artifactId>spring-data-redis</artifactId>
            <version>1.6.2.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>redis.clients</groupId>
            <artifactId>jedis</artifactId>
            <version>2.9.0</version>
        </dependency>
    <!-- redis cache end -->
~~~
2. 编写redis.properties
~~~
#IP
redis.host=localhost
#端口
redis.port=6379
#密码
redis.password=
#超时，单位毫秒
redis.timeout=10000 
#最大空闲数
redis.maxIdle=300
#最大连接数
redis.maxTotal=600
#最大空闲数
redis.minIdle=1
#最大建立连接等待时间
redis.maxWait=1000
#指明是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个
redis.testOnBorrow=false
#使用redis块分区,0-15
redis.database=0
~~~
3. redis.xml,引用redis.proerties,并注入redisTemplate
~~~
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:context="http://www.springframework.org/schema/context" 
    xmlns:p="http://www.springframework.org/schema/p"
    xmlns:cache="http://www.springframework.org/schema/cache" 
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:redis="http://www.springframework.org/schema/redis"
    xsi:schemaLocation="
     http://www.springframework.org/schema/beans 
     http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
     http://www.springframework.org/schema/context 
     http://www.springframework.org/schema/context/spring-context-3.1.xsd
     http://www.springframework.org/schema/cache 
     http://www.springframework.org/schema/cache/spring-cache-3.1.xsd
     http://www.springframework.org/schema/redis
     http://www.springframework.org/schema/redis/spring-redis-1.0.xsd">
    <context:property-placeholder location="classpath:redis.properties" ignore-unresolvable="true"/>
    
    <!-- jedis 配置 -->
    <bean id="poolConfig" class="redis.clients.jedis.JedisPoolConfig">
        <!-- 最大空闲连接数 -->
        <property name="maxIdle" value="${redis.maxIdle}" />
        <!-- 最小空闲连接数 -->
        <property name="minIdle" value="${redis.minIdle}" />
        <property name="maxWaitMillis" value="${redis.maxWait}" />
        <!-- 在获取连接的时候检查有效性 -->
        <property name="testOnBorrow" value="${redis.testOnBorrow}" />
    </bean>
    
    <!-- redis服务器中心 -->
    <bean id="redisConnectionFactory" class="org.springframework.data.redis.connection.jedis.JedisConnectionFactory">
        <property name="poolConfig" ref="poolConfig" />
        <property name="port" value="${redis.port}" />
        <property name="hostName" value="${redis.host}" />
        <property name="password" value="${redis.password}" />
        <property name="timeout" value="${redis.timeout}" />
        <property name="database" value="${redis.database}" />
    </bean>
    
	<!-- redis操作模板，面向对象的模板 -->
	<bean id="redisTemplate" class="org.springframework.data.redis.core.StringRedisTemplate"> 
    	<property name="connectionFactory" ref="redisConnectionFactory" /> 
    	<!-- 将key和value序列化后存入redis，读取时再进行反序列化 -->
        <!-- 对key的默认序列化器 -->
        <property name="keySerializer">
            <bean class="org.springframework.data.redis.serializer.StringRedisSerializer" />
        </property>
        <!-- 对value的默认序列化器 -->
        <property name="valueSerializer">
            <bean class="org.springframework.data.redis.serializer.JdkSerializationRedisSerializer"/>
        </property>
        <!-- 对hash结构数据的hashkey的默认序列化器 -->
        <property name="hashKeySerializer">
            <bean class="org.springframework.data.redis.serializer.JdkSerializationRedisSerializer" />
        </property>
        <!-- 对hash结构数据的hashvalue的默认序列化器 -->
        <property name="hashValueSerializer">
            <bean class="org.springframework.data.redis.serializer.JdkSerializationRedisSerializer" />
        </property>
  	</bean>
  	
</beans>
~~~
4. spring配置文件中引用redis.xml
~~~
<!-- 配置 redis -->
    <import resource="classpath:redis.xml" />
~~~
5. 使用redisTemplate
~~~
public class RedisCacheService implements CacheServiceI {

	@Resource
	private RedisTemplate redisTemplate;

    @Override
	public Object get(String cacheName, Object key) {
		Object obj = redisTemplate.boundValueOps(cacheName+"_"+key).get();
		log.debug("  RedisCacheService  get cacheName: [{}] , key: [{}]",cacheName,key);
		if(obj!=null && obj instanceof byte []){
			obj = unserizlize((byte [])obj);
			return obj;
		}
		return obj;
	}

	@Override
	public void put(String cacheName, Object key, Object value) {
		log.debug("  RedisCacheService  put cacheName: [{}] , key: [{}]",cacheName,key);
		if(value instanceof Template){
			redisTemplate.boundValueOps(cacheName+"_"+key).set(serialize(value));
		}else
		redisTemplate.boundValueOps(cacheName+"_"+key).set(value);
	}
}
~~~