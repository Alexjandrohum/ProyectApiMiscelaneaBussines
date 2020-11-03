/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectApiMiscelaneaBussines.dev.contract;

import ProyectApiMiscelaneaBussines.dev.dto.ProductDto;
import ProyectApiMiscelaneaBussines.dev.entities.Product;

import java.util.List;

/**
 * @author alexjandrohum
 */
public interface ProductContract {

    List<ProductDto> getAllProducts();

    ProductDto createProduct(ProductDto productDto);

    boolean deleteProduct(int idProduct);

    int updateProduct(ProductDto productDto);

    ProductDto getByIdProduct(int idProduct);

}
