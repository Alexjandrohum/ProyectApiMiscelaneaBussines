/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectApiMiscelaneaBussines.dev.web;

import ProyectApiMiscelaneaBussines.dev.contract.ProductContract;
import ProyectApiMiscelaneaBussines.dev.dto.ProductDto;
import ProyectApiMiscelaneaBussines.dev.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author alexjandrohum
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductContract productContract;

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> all() {
        List<ProductDto> productDtos = productContract.getAllProducts();
        if (productDtos == null || productDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(productDtos, HttpStatus.OK);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto productDto) {
        productDto = productContract.createProduct(productDto);
        if (productDto != null) {
            return new ResponseEntity<>(productDto, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProductDto> get(@PathVariable("id") int id) {
        ProductDto productDto = productContract.getByIdProduct(id);
        if (productDto != null) {
            return new ResponseEntity<>(productDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        if (productContract.deleteProduct(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> update(@RequestBody ProductDto productDto) {
        if (productContract.updateProduct(productDto) == Constant.isEnabled) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
