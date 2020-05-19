package ui;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class APIClient {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(APIClient.class, args);
	}

}