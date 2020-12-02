/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.persistence.crud;

import Api.dev.entities.Bottle;
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
public interface BottleCrudRepository extends JpaRepository<Bottle, Integer> {

    @Query(value = "SELECT "
            + "b.id_bottle, "
            + "b.name, "
            + "b.quantity, "
            + "b.id_user, "
            + "b.created_date, "
            + "b.modified_date, "
            + "b.status "
            + "FROM bottle_table b "
            + "WHERE b.status = 'activo'", nativeQuery = true)
    List<Bottle> getListBottleCrud();

    @Query(value = "SELECT "
            + "b.id_bottle, "
            + "b.name, "
            + "b.quantity, "
            + "b.id_user, "
            + "b.created_date, "
            + "b.modified_date, "
            + "b.status "
            + "FROM bottle_table b "
            + "WHERE b.id_bottle = ?1", nativeQuery = true)
    Bottle getBottleCrud(int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE bottle_table b SET "
            + "b.status = 'inactive' "
            + "WHERE b.id_bottle = ?1", nativeQuery = true)
    int deleteBottleCrud(int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE bottle_table b SET "
            + "b.name =:#{#bt.name}, "
            + "b.quantity =:#{#bt.quantity}, "
            + "b.id_user = :#{#bt.idUser}, "
            + "b.modified_date =:#{#bt.modifiedDate} "
            + "WHERE b.id_bottle =:#{#bt.idBottle}", nativeQuery = true)
    int updateBottleCrud(@Param("bt") Bottle bottle);
}
