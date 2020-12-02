/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.persistence.crud;

import Api.dev.entities.Account;
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
public interface AccountCrudRepository extends JpaRepository<Account, Integer> {

    @Query(value = "SELECT "
            + "a.id_account, "
            + "a.limit_quantity, "
            + "a.total_quantity, "
            + "a.id_user, "
            + "a.created_date, "
            + "a.modified_date, "
            + "a.status "
            + "FROM account_table a "
            + "WHERE a.status = 'activo'", nativeQuery = true)
    List<Account> getListAccountCrud();

    @Query(value = "SELECT "
            + "a.id_account, "
            + "a.limit_quantity, "
            + "a.total_quantity, "
            + "a.id_user, "
            + "a.created_date, "
            + "a.modified_date,"
            + "a.status "
            + "FROM account_table a "
            + "WHERE a.id_account = ?1", nativeQuery = true)
    Account getAccountCrud(int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE account_table a SET "
            + "a.limit_quantity=:#{#ac.limitQuantity}, "
            + "a.total_quantity=:#{#ac.totalQuantity}, "
            + "a.id_user=:#{#ac.idUser}, "
            + "a.modified_date=:#{#ac.modifiedDate} "
            + "WHERE a.id_account =:#{#ac.idAccount}", nativeQuery = true)
    int updateAccountCrud(@Param("ac") Account account);

    @Transactional
    @Modifying
    @Query(value = "UPDATE account_table a SET "
            + "a.status = 'inactive' "
            + "WHERE a.id_account = ?1", nativeQuery = true)
    int deleteAccountCrud(int id);

}
