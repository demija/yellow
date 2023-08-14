package ba.gabela.yellow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class YellowApplication {

	public static void main(String[] args) {
		SpringApplication.run(YellowApplication.class, args);
	}
}
