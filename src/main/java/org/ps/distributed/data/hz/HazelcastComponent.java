package org.ps.distributed.data.hz;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PreDestroy;

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
