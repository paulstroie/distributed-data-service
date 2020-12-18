package org.ps.distributed.data.hz;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class HazelcastComponent {

    HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();

    @PreDestroy
    public void shutDownHook(){
        hazelcastInstance.shutdown();
    }

}
