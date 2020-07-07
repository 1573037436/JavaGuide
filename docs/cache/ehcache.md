## spring集成ehcache
1. 导包
ehcache的包及其依赖包sl4j
~~~
<dependency>
            <groupId>net.sf.ehcache</groupId>
            <artifactId>ehcache-core</artifactId>
            <version>2.4.3</version>
</dependency>
~~~
2. classpath下放置ehcache.xml文件
~~~
<?xml version="1.0" encoding="UTF-8"?>
<ehcache updateCheck="false">
	<diskStore path="java.io.tmpdir" />

	<!-- 字典&国际化&在线用户列表[永久缓存] -->
	<cache name="foreverCache" maxElementsInMemory="500"  maxElementsOnDisk="500" diskSpoolBufferSizeMB="5" 
			overflowToDisk="true" eternal="true" timeToIdleSeconds="300" timeToLiveSeconds="3600" memoryStoreEvictionPolicy="LFU"/>
	<!-- 类注解&系统缓存[临时缓存] -->
	<cache name="systemBaseCache" maxElementsInMemory="500"  maxElementsOnDisk="500" diskSpoolBufferSizeMB="5" 
			overflowToDisk="true" eternal="false" timeToIdleSeconds="300" timeToLiveSeconds="3600" memoryStoreEvictionPolicy="LFU"/>
	<!-- 登录用户访问权限缓存[临时缓存] -->
	<cache name="sysAuthCache" maxElementsInMemory="500"  maxElementsOnDisk="500" diskSpoolBufferSizeMB="5" 
			overflowToDisk="true" eternal="false" timeToIdleSeconds="300" timeToLiveSeconds="3600" memoryStoreEvictionPolicy="LFU"/>
	<!-- UI标签页面缓存[临时缓存] -->
	<cache name="tagCache" maxElementsInMemory="500" maxElementsOnDisk="500" diskSpoolBufferSizeMB="10" 
			overflowToDisk="true" eternal="false" timeToIdleSeconds="300" timeToLiveSeconds="3600" memoryStoreEvictionPolicy="LFU"/>
	
	<defaultCache maxElementsInMemory="1000" overflowToDisk="true"
		eternal="false" memoryStoreEvictionPolicy="LRU" maxElementsOnDisk="10000"
		diskExpiryThreadIntervalSeconds="600" timeToIdleSeconds="120" 
		timeToLiveSeconds="120" diskPersistent="false" />
</ehcache>

~~~
3. 注入bean
~~~
<bean class="com.zzj.system.service.impl.EhcacheService"/>
~~~

4. 创建缓存工具的接口类(实现类可以是Ehcache或redis)
~~~

/**
 * 平台缓存工具类
 * @author qinfeng
 *
 */
public interface CacheServiceI {
	/**
	 * 类注解&系统缓存[临时缓存]
	 */
	public static String SYSTEM_BASE_CACHE = "systemBaseCache";
	/**
	 * UI标签[临时缓存]
	 */
	public static String TAG_CACHE = "tagCache";
	/**
	 * 字典\国际化\在线用户列表 [永久缓存]
	 */
	public static String FOREVER_CACHE = "foreverCache";
	/**
	 * 登录用户访问权限缓存[临时缓存]
	 */
	public static String SYS_AUTH_CACHE = "sysAuthCache";
	
	
	/**
	 * 获取缓存
	 * @param cacheName
	 * @param key
	 * @return
	 */
	public Object get(String cacheName, Object key);
	/**
	 * 设置缓存
	 * @param cacheName
	 * @param key
	 * @param value
	 */
	public void put(String cacheName, Object key, Object value);
	/**
	 * 移除缓存
	 * @param cacheName
	 * @param key
	 * @return
	 */
	public boolean remove(String cacheName, Object key);
	/**
	 * 清空所有缓存
	 */
	public void clean();
	
	/**
	 * 清空缓存
	 */
	public void clean(String cacheName);
}

~~~
5. 创建实现类
~~~
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import xxx.system.service.CacheServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EhcacheService implements CacheServiceI {
	private static final Logger log = LoggerFactory.getLogger(EhcacheService.class);
	public static CacheManager manager = CacheManager.create();
	
	@Override
	public Object get(String cacheName, Object key) {
		log.debug("  EhcacheService  get cacheName: [{}] , key: [{}]",cacheName,key);
		Cache cache = manager.getCache(cacheName);
		if (cache != null) {
			Element element = cache.get(key);
			if (element != null) {
				return element.getObjectValue();
			}
		}
		return null;
	}

	@Override
	public void put(String cacheName, Object key, Object value) {
		log.debug("  EhcacheService  put cacheName: [{}] , key: [{}]",cacheName,key);
		Cache cache = manager.getCache(cacheName);
		if (cache != null) {
			cache.put(new Element(key, value));
		}
	}

	@Override
	public boolean remove(String cacheName, Object key) {
		log.debug("  EhcacheService  remove cacheName: [{}] , key: [{}]",cacheName,key);
		Cache cache = manager.getCache(cacheName);
		if (cache != null) {
			return cache.remove(key);
		}
		return false;
	}

	@Override
	public void clean() {
		log.debug("  EhcacheService  clean all ");
		Cache eternalCache = manager.getCache(SYSTEM_BASE_CACHE);
		Cache tagCache = manager.getCache(TAG_CACHE);
		if (eternalCache != null) {
			eternalCache.removeAll();
		}
		if (tagCache != null) {
			tagCache.removeAll();
		}
	}

	@Override
	public void clean(String cacheName) {
		log.info("  EhcacheService  clean cacheName：[{}] ",cacheName);
		Cache eCache = manager.getCache(cacheName);
		if (eCache != null) {
			eCache.removeAll();
		}
	}

}

~~~
6. 具体使用
~~~

~~~