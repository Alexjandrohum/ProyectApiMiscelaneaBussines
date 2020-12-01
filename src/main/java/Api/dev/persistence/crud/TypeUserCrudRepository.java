/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.persistence.crud;

import Api.dev.entities.TypeUser;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author alexjandrohum
 */
public interface TypeUserCrudRepository extends JpaRepository<TypeUser, Integer> {

    @Query(value = "SELECT "
            + "t.id_type_user, "
            + "t.name, "
            + "t.created_date, "
            + "t.modified_date, "
            + "t.status "
            + "FROM type_user_table t WHERE t.status='activo'", nativeQuery = true)
    List<TypeUser> getListTypeUserCrud();

    @Query(value = "SELECT "
            + "t.id_type_user, "
            + "t.name, "
            + "t.created_date, "
            + "t.modified_date, "
            + "t.status "
            + "FROM type_user_table t WHERE t.id_type_user = ?1", nativeQuery = true)
    TypeUser getTypeUserByIdCrud(int id);
}
