package testsources;

import dr.hasan.clientRegistration.service.ClientRegistrationService;
import dr.hasan.clientRegistration.viewmodel.ClientDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans/spring-context-config.xml")
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
public class ClientRegistrationServiceTest{


    @Autowired
    private ClientRegistrationService registrationService;

    @Test
    public void testGetNameService(){
        assertEquals("imrul", registrationService.getName());
    }

    @Test
    public void testIsExistService(){
        assertEquals(true,registrationService.isExist("bimpu@gmail.com", "123456"));
    }

    @Test
    @Transactional
    public void testRegisterClient(){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setActive(1);
        clientDTO.setDateOfBirth("11/9/1988");
        clientDTO.setEmail("imrul001@gmail.com");
        clientDTO.setName("Imrul Hasan");
        clientDTO.setGender(1);
        clientDTO.setPassword("123456");

        Map<String, Object> response = registrationService.registerClient(clientDTO);
        assertEquals(100, response.get("responseCode"));
    }
}
