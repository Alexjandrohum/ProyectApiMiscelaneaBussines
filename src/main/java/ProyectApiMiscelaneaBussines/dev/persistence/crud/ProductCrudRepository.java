/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectApiMiscelaneaBussines.dev.persistence.crud;

import ProyectApiMiscelaneaBussines.dev.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 * @author alexjandrohum
 */
public interface ProductCrudRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT p.id_product, p.name, p.price_product, p.created_date, p.modified_date, p.status FROM product_table p WHERE p.status = 'activo'", nativeQuery = true)
    List<Product> getProductsActive();
    
}
