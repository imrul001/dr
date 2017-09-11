package dr.hasan.clientRegistration.service;

import dr.hasan.clientRegistration.entity.Client;
import dr.hasan.clientRegistration.repository.ClientRepository;
import dr.hasan.clientRegistration.viewmodel.ClientDTO;
import dr.hasan.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ejb.TransactionAttribute;

/**
 * Created by Imrul on 9/11/2017.
 */

@Service
public class ClientRegistrationService {

    @Autowired
    private ClientRepository clientRepository;

    public Response registerClient(ClientDTO clientDTO){
        Response response = new Response();
        Client client1 = clientRepository.registerClient(convertClientDTOtoEntity(clientDTO));
        if(client1!=null){
            response.setErrors(null);
            response.setResponseCode(100);
            response.setResponseMessage("Client Profile Created Successfully");
        }
        return  response;
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
