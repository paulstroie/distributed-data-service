package org.ps.distributed.data;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import org.springframework.stereotype.Component;

@Component
public class HazelcastConfig {

    private final HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();



}
