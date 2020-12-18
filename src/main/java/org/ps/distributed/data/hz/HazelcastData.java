package org.ps.distributed.data.hz;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HazelcastData<K,V> {

    @Autowired
    private HazelcastComponent hz;

    public V getData(HzAllowedMaps map, K key){
        Map<K, V> mapGrid = hz.hazelcastInstance.getMap(map.toString());
        return mapGrid.get(key);
    }

    public void distributeData(HzAllowedMaps map, Map.Entry<K, V> data){
        hz.hazelcastInstance.getMap(map.toString()).put(data.getKey(), data.getValue());
    }

    public void distributeData(HzAllowedMaps map, Map<K, V> data){
        hz.hazelcastInstance.getMap(map.toString()).putAll(data);
    }
}
