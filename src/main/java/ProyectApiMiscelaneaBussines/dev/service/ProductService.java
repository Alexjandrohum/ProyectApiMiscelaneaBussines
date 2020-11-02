/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectApiMiscelaneaBussines.dev.service;

import ProyectApiMiscelaneaBussines.dev.contract.ProductContract;
import ProyectApiMiscelaneaBussines.dev.entities.Product;
import ProyectApiMiscelaneaBussines.dev.persistence.crud.ProductCrudRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexjandrohum
 */
@Service
public class ProductService implements ProductContract{
    
    @Autowired
    private ProductCrudRepository productCrud;

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productCrud.findAll();
    }
    
}
