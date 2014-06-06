import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * Created by bob zhou on 14-5-30.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
