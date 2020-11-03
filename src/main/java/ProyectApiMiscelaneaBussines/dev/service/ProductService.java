/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectApiMiscelaneaBussines.dev.service;

import ProyectApiMiscelaneaBussines.dev.contract.ProductContract;
import ProyectApiMiscelaneaBussines.dev.dto.ProductDto;
import ProyectApiMiscelaneaBussines.dev.entities.Product;
import ProyectApiMiscelaneaBussines.dev.mapper.ProductMapper;
import ProyectApiMiscelaneaBussines.dev.persistence.crud.ProductCrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import ProyectApiMiscelaneaBussines.dev.util.Constant;
import ProyectApiMiscelaneaBussines.dev.util.GetDates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 * @author alexjandrohum
 */
@Service
public class ProductService implements ProductContract {

    @Autowired
    private ProductCrudRepository productCrud;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productCrud.getProductsActive();
        return productMapper.toProductDtos(products);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.toProduct(productDto);
        product.setCreatedDate(GetDates.getdate());
        product.setModifiedDate(GetDates.getdate());
        product.setStatus(Constant.isActive);
        productDto = productMapper.toProductDto(productCrud.save(product));
        return productDto;
    }

    @Override
    public boolean deleteProduct(int idProduct) {
        try {
            productCrud.deleteProduct(idProduct);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    @Override
    public int updateProduct(ProductDto productDto) {
        Product product = productMapper.toProduct(productDto);
        product.setModifiedDate(GetDates.getdate());
        return productCrud.updateProduct(product);
    }

    @Override
    public ProductDto getByIdProduct(int idProduct) {
        Product product = productCrud.getProductById(idProduct);
        return productMapper.toProductDto(product);
    }
}
