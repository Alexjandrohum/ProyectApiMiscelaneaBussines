/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.service;

import Api.dev.contract.UserContract;
import Api.dev.entities.TypeUser;
import Api.dev.entities.User;
import Api.dev.persistence.crud.TypeUserCrudRepository;
import Api.dev.persistence.crud.UserCrudRepository;
import Api.dev.util.Constant;
import Api.dev.util.GetDates;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexjandrohum
 */
@Service
public class UserService implements UserContract {

    @Autowired
    private UserCrudRepository repositoryUser;
    @Autowired
    private TypeUserCrudRepository repositoryTypeUser;

    @Override
    public List<User> getListUser() {
        return repositoryUser.getListUserCrud();
    }

    @Override
    public User getUserById(int idUser) {
        return repositoryUser.getUserByIdCrud(idUser);
    }

    @Override
    public int updateUser(User user) {
        user.setModifiedDate(GetDates.getdate());
        return repositoryUser.updateUserCrud(user);
    }

    @Override
    public int deleteUser(int idUser) {
        return repositoryUser.deleteUserCrud(idUser);
    }

    @Override
    public List<TypeUser> getListTypeUser() {
        return repositoryTypeUser.getListTypeUserCrud();
    }

    @Override
    public TypeUser getTypeUser(int id) {
        return repositoryTypeUser.getTypeUserByIdCrud(id);
    }

    @Override
    public User createUser(User user) {
        user.setCreatedDate(GetDates.getdate());
        user.setModifiedDate(GetDates.getdate());
        user.setStatus(Constant.isActive);
        return repositoryUser.save(user);
    }

}
