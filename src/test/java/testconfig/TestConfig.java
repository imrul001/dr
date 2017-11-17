package testconfig;

import dr.hasan.clientRegistration.repository.ClientRepository;
import dr.hasan.clientRegistration.service.ClientRegistrationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean
    public ClientRegistrationService getClientRegistrationService(){
        return new ClientRegistrationService();
    }

    @Bean
    public ClientRepository getClientRepository(){
        return new ClientRepository();
    }


}
