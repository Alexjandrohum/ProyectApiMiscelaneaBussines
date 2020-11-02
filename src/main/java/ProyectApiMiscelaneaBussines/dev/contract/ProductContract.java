/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectApiMiscelaneaBussines.dev.contract;

import ProyectApiMiscelaneaBussines.dev.entities.Product;
import java.util.List;

/**
 *
 * @author alexjandrohum
 */
public interface ProductContract {
    
    List<Product> getAllProducts();
    
}
