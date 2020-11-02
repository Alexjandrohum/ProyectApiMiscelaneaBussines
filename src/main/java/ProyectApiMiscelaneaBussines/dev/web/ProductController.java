/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectApiMiscelaneaBussines.dev.web;

import ProyectApiMiscelaneaBussines.dev.contract.ProductContract;
import ProyectApiMiscelaneaBussines.dev.entities.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alexjandrohum
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductContract productContract;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> all() {
        return new ResponseEntity(productContract.getAllProducts(), HttpStatus.OK);
    }

}
