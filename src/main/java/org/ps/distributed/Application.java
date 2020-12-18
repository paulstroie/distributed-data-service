package org.ps.distributed;

import com.hazelcast.core.HazelcastInstance;
import org.ps.distributed.data.HazelcastConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PreDestroy;

@SpringBootApplication(scanBasePackages = "org.ps.distributed")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}