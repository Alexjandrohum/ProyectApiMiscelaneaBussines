/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.contract;

import Api.dev.entities.MessageError;

/**
 *
 * @author alexjandrohum
 */
public interface MessageErrorContract {

    MessageError createMessage(MessageError error);

}
