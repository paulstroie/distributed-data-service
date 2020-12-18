package org.ps.distributed.data;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HazelcastData<K,V> {

    @Autowired
    private HazelcastInstance hazelcastInstance;

    public Map<K, V> getMap(String map){
        return hazelcastInstance.getMap(map);
    }

    public Object getData(String map, K key){
        Map<K, V> mapGrid = hazelcastInstance.getMap(map);
        return mapGrid.get(key);
    }

    public void distributeData(String map, Map.Entry<K, V> data){
        hazelcastInstance.getMap(map).put(data.getKey(), data.getValue());
    }
}
