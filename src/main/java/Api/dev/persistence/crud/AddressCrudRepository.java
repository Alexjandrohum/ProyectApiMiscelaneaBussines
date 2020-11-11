/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.persistence.crud;

import Api.dev.entities.Address;
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
public interface AddressCrudRepository extends JpaRepository<Address, Integer> {

    @Query(value = "SELECT "
            + "a.id_address, "
            + "a.street, "
            + "a.number_inside, "
            + "a.number_outside, "
            + "a.number_phone, "
            + "a.id_polity, "
            + "a.created_date, "
            + "a.modified_date, "
            + "a.status "
            + "FROM address_table a "
            + "WHERE a.status='activo'", nativeQuery = true)
    List<Address> getAllAddressCrud();

    @Transactional
    @Modifying
    @Query(value = "UPDATE address_table a SET a.status='inactivo' WHERE a.id_address=?1", nativeQuery = true)
    int deleteAddressCrud(int idAddress);

    @Transactional
    @Modifying
    @Query(value = "UPDATE address_table a SET "
            + "a.street=:#{#ad.street}, "
            + "a.number_inside=:#{#ad.numberInside}, "
            + "a.number_outside=:#{#ad.numberOutside}, "
            + "a.number_phone=:#{#ad.numberPhone}, "
            + "a.id_polity=:#{#ad.idPolity}, "
            + "a.modified_date=:#{#ad.modifiedDate} "
            + "WHERE a.id_address=:#{#ad.idAddress}", nativeQuery = true)
    int updateAddressCrud(@Param("ad") Address ad);

    @Query(value = "SELECT "
            + "a.id_address, "
            + "a.street, "
            + "a.number_inside, "
            + "a.number_outside, "
            + "a.number_phone, "
            + "a.id_polity, "
            + "a.created_date, "
            + "a.modified_date, "
            + "a.status "
            + "FROM address_table a "
            + "WHERE a.id_address = ?1", nativeQuery = true)
    Address getAddressByIdCrud(int idAddress);

}
