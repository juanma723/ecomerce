package ecomerce.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.TimeZone;

@SpringBootApplication
@EntityScan("ecomerce")
@EnableJpaRepositories("ecomerce.out")
public class EcomerceApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+02:00"));
        SpringApplication.run(EcomerceApplication.class, args);
    }


}
