package user.rendszerhaz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync
@SpringBootApplication
public class ProducingWebServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProducingWebServiceApplication.class, args);
	}
}
