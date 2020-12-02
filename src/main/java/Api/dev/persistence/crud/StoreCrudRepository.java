/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.persistence.crud;

import Api.dev.entities.Store;
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
public interface StoreCrudRepository extends JpaRepository<Store, Integer> {

    @Query(value = "SELECT "
            + "s.id_store, "
            + "s.name, "
            + "s.id_address, "
            + "s.id_user, "
            + "s.photo, "
            + "s.created_date, "
            + "s.modified_date, "
            + "s.status "
            + "FROM store_table s "
            + "WHERE s.status='activo'", nativeQuery = true)
    List<Store> getListStoreCrud();

    @Query(value = "SELECT "
            + "s.id_store, "
            + "s.name, "
            + "s.id_address, "
            + "s.id_user, "
            + "s.photo, "
            + "s.created_date, "
            + "s.modified_date, "
            + "s.status "
            + "FROM store_table s "
            + "WHERE s.id_store=?1", nativeQuery = true)
    Store getStoreByIdCrud(int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE store_table s SET "
            + "s.status='inactive' "
            + "WHERE s.id_store=?1", nativeQuery = true)
    int deleteStoreCrud(int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE store_table s SET "
            + "s.name = :#{#st.name}, "
            + "s.id_address = :#{#st.idAddress}, "
            + "s.id_user = :#{#st.idUser}, "
            + "s.photo = :#{#st.photo}, "
            + "s.modified_date = :#{#st.modifiedDate} "
            + "WHERE s.id_store = :#{#st.idStore}", nativeQuery = true)
    int updateStoreCrud(@Param("st") Store s);

}
