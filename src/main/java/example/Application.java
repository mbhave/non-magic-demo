package example;

import config.EnableMagicProperties;
import config.MagicApplication;
import config.ServerProperties;

import org.springframework.boot.SpringApplication;

@MagicApplication
@EnableMagicProperties(ServerProperties.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

}
