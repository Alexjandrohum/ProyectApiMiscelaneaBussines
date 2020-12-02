/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.persistence.crud;

import Api.dev.entities.AccountProduct;
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
public interface AccountProductCrudRepository extends JpaRepository<AccountProduct, Integer> {

    @Query(value = "SELECT "
            + "a.id_account_product, "
            + "a.id_account, "
            + "a.id_product, "
            + "a.created_date, "
            + "a.modified_date, "
            + "a.status "
            + "FROM account_product_table a "
            + "WHERE a.status = 'activo'", nativeQuery = true)
    List<AccountProduct> getListAccountProductCrud();

    @Query(value = "SELECT "
            + "a.id_account_product, "
            + "a.id_account, "
            + "a.id_product, "
            + "a.created_date, "
            + "a.modified_date, "
            + "a.status "
            + "FROM account_product_table a "
            + "WHERE a.id_account_product = ?1", nativeQuery = true)
    AccountProduct getAccountProductCrud(int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE account_product_table a SET "
            + "a.id_account = :#{#ap.idAccount}, "
            + "a.id_product = :#{#ap.idProduct}, "
            + "a.modified_date = :#{#ap.modifiedDate} "
            + "WHERE a.id_account_product = :#{#ap.idAccountProduct}", nativeQuery = true)
    int updateAccountProduct(@Param("ap") AccountProduct accountProduct);

    @Transactional
    @Modifying
    @Query(value = "UPDATE account_product_table a SET "
            + "a.status = 'inactive' "
            + "WHERE a.id_account_product = ?1", nativeQuery = true)
    int deleteAccountProduct(int id);

}
