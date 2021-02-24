package demo;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import repository.ProductRepository;


@SpringBootApplication

@EntityScan( basePackages = {"models"} ) 
@ComponentScan(basePackages={"service","repository","controllers","br.com.crud.demo.service","models"})
@EnableAutoConfiguration(exclude = JpaRepositoriesAutoConfiguration.class)
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
