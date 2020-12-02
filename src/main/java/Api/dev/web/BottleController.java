/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.web;

import Api.dev.entities.Bottle;
import Api.dev.service.BottleService;
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
@RequestMapping("/bottle")
public class BottleController {

    @Autowired
    private BottleService serviceBottle;

    @GetMapping("/getListBottle")
    public ResponseEntity<List<Bottle>> getListBottle() {
        try {
            return new ResponseEntity<>(serviceBottle.getListBottle(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getBottlebyId/{id}")
    public ResponseEntity<Bottle> getBottleById(@PathVariable("id") int id) {
        try {
            Bottle bottle = serviceBottle.getBottle(id);
            if (bottle == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(bottle, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createBottle")
    public ResponseEntity<Bottle> createBottle(@RequestBody Bottle bottle) {
        try {
            return new ResponseEntity<>(serviceBottle.createBottle(bottle), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateBottle")
    public ResponseEntity<HttpStatus> updateBottle(@RequestBody Bottle botlle) {
        try {
            if (serviceBottle.updateBottle(botlle) == Constant.isEnabled) {
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteBottle/{id}")
    public ResponseEntity<HttpStatus> deleteBottle(@PathVariable("id") int id) {
        try {
            if (serviceBottle.deleteBottle(id) == Constant.isEnabled) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
