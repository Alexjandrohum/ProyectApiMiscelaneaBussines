/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.persistence.crud;

import Api.dev.entities.TypeUser;
import Api.dev.entities.User;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author alexjandrohum
 */
public interface UserCrudRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT "
            + "u.id_user, "
            + "u.name, "
            + "u.last_name, "
            + "u.username, "
            + "u.pass, "
            + "u.photo, "
            + "u.created_date, "
            + "u.mofified_date, "
            + "u.status, "
            + "u.id_address, "
            + "u.id_type_user "
            + "FROM user_table u WHERE u.status = 'activo'", nativeQuery = true)
    List<User> getListUserCrud();

    @Query(value = "SELECT "
            + "u.id_user, "
            + "u.name, "
            + "u.last_name, "
            + "u.id_address, "
            + "u.id_type_user, "
            + "u.username, "
            + "u.pass, "
            + "u.photo, "
            + "u.created_date, "
            + "u.mofified_date, "
            + "u.status "
            + "FROM user_table u WHERE u.id_user = ?1", nativeQuery = true)
    User getUserByIdCrud(int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user_table u SET u.status = 'inactivo' WHERE u.id_user=?1", nativeQuery = true)
    int deleteUserCrud(int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user_table u SET "
            + "u.name=:#{#usr.name}, "
            + "u.last_name=:#{#usr.lastName}, "
            + "u.id_address=:#{#usr.idAddress}, "
            + "u.id_type_user=:#{#usr.idTypeUser}, "
            + "u.username=:#{#usr.username}, "
            + "u.pass=:#{#usr.pass}, "
            + "u.photo=:#{#usr.photo}, "
            + "u.mofified_date=:#{#usr.modifiedDate} "
            + "WHERE u.id_user=:#{#usr.idUser}", nativeQuery = true)
    int updateUserCrud(@Param("usr") User usr);
    
    @Query(value = "SELECT "
            + "u.id_user, "
            + "u.name, "
            + "u.last_name, "
            + "u.id_address, "
            + "u.id_type_user, "
            + "u.username, "
            + "u.pass, "
            + "u.photo, "
            + "u.created_date, "
            + "u.mofified_date, "
            + "u.status "
            + "FROM user_table u WHERE u.username = ?1", nativeQuery = true)
    User getUserByUsername(String username);

}
