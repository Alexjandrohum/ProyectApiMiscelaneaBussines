/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.service;

import Api.dev.contract.BottleContract;
import Api.dev.entities.Bottle;
import Api.dev.persistence.crud.BottleCrudRepository;
import Api.dev.util.Constant;
import Api.dev.util.GetDates;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexjandrohum
 */
@Service
public class BottleService implements BottleContract {

    @Autowired
    private BottleCrudRepository crudBottle;

    @Override
    public List<Bottle> getListBottle() {
        return crudBottle.getListBottleCrud();
    }

    @Override
    public Bottle getBottle(int id) {
        return crudBottle.getBottleCrud(id);
    }

    @Override
    public int updateBottle(Bottle bottle) {
        bottle.setModifiedDate(GetDates.getdate());
        return crudBottle.updateBottleCrud(bottle);
    }

    @Override
    public int deleteBottle(int id) {
        return crudBottle.deleteBottleCrud(id);
    }

    @Override
    public Bottle createBottle(Bottle bottle) {
        bottle.setCreatedDate(GetDates.getdate());
        bottle.setModifiedDate(GetDates.getdate());
        bottle.setStatus(Constant.isActive);
        return crudBottle.save(bottle);
    }

}
