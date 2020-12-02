/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.web;

import Api.dev.entities.AccountProduct;
import Api.dev.service.AccountProductService;
import Api.dev.util.Constant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alexjandrohum
 */
@RestController
@RequestMapping("/accountProduct")
public class AccountProductController {

    @Autowired
    private AccountProductService service;

    @GetMapping("/getListAccountProduct")
    public ResponseEntity<List<AccountProduct>> getListAccountProduct() {
        try {
            return new ResponseEntity<>(service.getListAccountProduct(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAccountProductById/{id}")
    public ResponseEntity<AccountProduct> getAccountProductById(@PathVariable("id") int id) {
        try {
            AccountProduct ap = service.getAccountProductById(id);
            if (ap == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(ap, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createAccountProduct")
    public ResponseEntity<AccountProduct> createAccountProduct(@RequestBody AccountProduct accountProduct) {
        try {
            AccountProduct ap = service.createAccountProduct(accountProduct);
            if (ap == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>(ap, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateAccountProduct")
    public ResponseEntity<HttpStatus> updateAccountProduct(@RequestBody AccountProduct ap) {
        try {
            if (service.updateAccountProduct(ap) == Constant.isEnabled) {
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAccountProduct/{id}")
    public ResponseEntity<HttpStatus> deleteAccountProduct(@PathVariable("id") int id) {
        try {
            if (service.deleteAccountProduct(id) == Constant.isEnabled) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
