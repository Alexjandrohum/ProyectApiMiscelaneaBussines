/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.contract;

import Api.dev.entities.TypeUser;
import Api.dev.entities.User;
import java.util.List;

/**
 *
 * @author alexjandrohum
 */
public interface UserContract {

    User createUser(User user);

    List<User> getListUser();

    User getUserById(int idUser);

    int updateUser(User user);

    int deleteUser(int idUser);

    List<TypeUser> getListTypeUser();

    TypeUser getTypeUser(int id);

}
