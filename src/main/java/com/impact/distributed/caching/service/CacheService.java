package com.impact.distributed.caching.service;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CacheService {

    private final HazelcastInstance hazelcastInstance;

    public CacheService(@Qualifier("hazelcastInstance") HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    public void putDataInMap(Map<String, String> data) {
        IMap<String, String> map = hazelcastInstance.getMap("my-distributed-map");
        map.put("key1", data.get("key1"));
        map.put("key2", data.get("key2"));
        map.put("key3", data.get("key3"));
    }

    public Map<String, String> getDataFromMap() {
        IMap<String, String> map = hazelcastInstance.getMap("my-distributed-map");
        return map.getAll(map.keySet());
    }
}
