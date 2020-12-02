/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.web;

import Api.dev.entities.Store;
import Api.dev.service.StoreService;
import Api.dev.util.Constant;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/getListStore")
    public ResponseEntity<List<Store>> getListStore() {
        try {
            return new ResponseEntity<>(storeService.getListStore(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getStoreById/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable("id") int id) {
        try {
            Store store = storeService.getStoreById(id);
            if (store == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(store, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/createStore")
    public ResponseEntity<Store> createStore(@RequestBody Store store) {
        try {
            return new ResponseEntity<>(storeService.createStore(store), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateStore")
    public ResponseEntity<HttpStatus> updateStore(@RequestBody Store store) {
        try {
            if (storeService.updateStore(store) == Constant.isEnabled) {
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
        } catch (Exception e) {
            //log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteStore/{id}")
    public ResponseEntity<HttpStatus> deleteStore(@PathVariable("id") int id) {
        try {
            if (storeService.deleteStore(id) == Constant.isEnabled) {
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
