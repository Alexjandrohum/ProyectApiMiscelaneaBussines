/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectApiMiscelaneaBussines.dev.persistence.crud;

import ProyectApiMiscelaneaBussines.dev.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author alexjandrohum
 */
public interface ProductCrudRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT p.id_product, p.name, p.price_product, p.created_date, p.modified_date, p.status FROM product_table p WHERE p.status = 'activo'", nativeQuery = true)
    List<Product> getProductsActive();

    @Transactional
    @Modifying
    @Query(value = "UPDATE product_table p SET p.status = 'disable' WHERE p.id_product = ?1", nativeQuery = true)
    void deleteProduct(int id_product);

    @Transactional
    @Modifying
    @Query(value = "UPDATE product_table p SET p.name=:#{#pt.name}, p.price_product=:#{#pt.priceProduct}, p.modified_date=:#{#pt.modifiedDate} WHERE p.id_product=:#{#pt.idProduct}", nativeQuery = true)
    int updateProduct(@Param("pt") Product pt);

    @Query(value = "SELECT p.id_product, p.name, p.price_product, p.created_date FROM product_table p WHERE p.id_product=?1", nativeQuery = true)
    Product getProductById(int idProduct);

}
