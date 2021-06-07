package kodlama.hrms.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kodlama.hrms.core.utilities.validations.EmailVerificationManager;
import kodlama.hrms.core.utilities.validations.EmailVerificationService;
import kodlama.hrms.core.utilities.validations.MernisVerificationManager;
import kodlama.hrms.core.utilities.validations.MernisVerificationService;

@Configuration
public class AppConfiguration<T> {
	@Bean
	
    public EmailVerificationService<T> EmailVerificationService(){
        return new EmailVerificationManager<T>();
    }

    @Bean
    public MernisVerificationService<T> mernisVerificationService(){
        return new MernisVerificationManager<T>();
    }
    

}

