/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectApiMiscelaneaBussines.dev.persistence.crud;

import ProyectApiMiscelaneaBussines.dev.entities.Product;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author alexjandrohum
 */
public interface ProductCrudRepository extends CrudRepository<Product, Integer>{
    
}
