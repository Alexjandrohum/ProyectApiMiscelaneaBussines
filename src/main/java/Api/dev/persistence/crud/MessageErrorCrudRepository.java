/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.persistence.crud;

import Api.dev.entities.MessageError;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alexjandrohum
 */
public interface MessageErrorCrudRepository extends JpaRepository<MessageError, Integer>{
    
}
