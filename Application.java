/**
 * 
 */
package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author TCS
 *
 */
@ImportResource("classpath:app-context.xml")
@SpringBootApplication
public class Application {
	public static void main(String args[]) {
		SpringApplication.run(Application.class, args);
	}

}
