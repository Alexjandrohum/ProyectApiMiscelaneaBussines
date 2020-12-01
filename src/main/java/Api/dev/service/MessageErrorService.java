/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.service;

import Api.dev.contract.MessageErrorContract;
import Api.dev.entities.MessageError;
import Api.dev.persistence.crud.MessageErrorCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexjandrohum
 */
@Service
public class MessageErrorService implements MessageErrorContract {

    @Autowired
    private MessageErrorCrudRepository errorRepository;

    @Override
    public MessageError createMessage(MessageError error) {
        return errorRepository.save(error);
    }

}
