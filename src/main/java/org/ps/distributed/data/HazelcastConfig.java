package org.ps.distributed.data;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import javax.annotation.PreDestroy;
import java.util.Map;

@Configuration
public class HazelcastConfig {

    @Autowired
    private HazelcastInstance hazelcastInstance;


    @Bean
    public HazelcastInstance hazelcastInstance(){
       return Hazelcast.newHazelcastInstance();
    }

    @PreDestroy
    public void shutDownHook(){
        hazelcastInstance.shutdown();
    }

}
