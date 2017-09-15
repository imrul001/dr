package dr.hasan.clientRegistration.service;

import dr.hasan.clientRegistration.entity.Client;
import dr.hasan.clientRegistration.repository.ClientRepository;
import dr.hasan.clientRegistration.viewmodel.ClientDTO;
import dr.hasan.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Imrul on 9/11/2017.
 */

@Service
@Transactional()
public class ClientRegistrationService {

    @Autowired
    private ClientRepository clientRepository;

    public Map<String, Object> registerClient(ClientDTO clientDTO){
        Response response = new Response();
        Map<String, Object> resp = new HashMap<String, Object>();
        Client client1 = clientRepository.registerClient(convertClientDTOtoEntity(clientDTO));
        if(client1!=null){
            resp.put("error", null);
            resp.put("responseCode", 100);
            resp.put("message", "Client Profile Created Successfully");
        }else{
            List<String> errors = new ArrayList<String>();
            resp.put("error", "error");
            resp.put("responseCode", 103);
            resp.put("message", "Internal Server error");
        }
        return resp;
    }

    private Client convertClientDTOtoEntity(ClientDTO clientDTO){
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());
        client.setDateOfBirth(clientDTO.getDateOfBirth());
        client.setGender(clientDTO.getGender());
        client.setActive(clientDTO.getActive());
        client.setPassword(clientDTO.getPassword());
        return client;
    }

}
