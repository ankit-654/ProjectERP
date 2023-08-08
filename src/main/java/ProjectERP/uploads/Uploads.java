package ProjectERP.uploads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;



@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class Uploads 
{
    public static void main( String[] args )
    {
    	 SpringApplication.run(Uploads.class, args);    }
}
