/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.service;

import Api.dev.contract.StoreContract;
import Api.dev.entities.Store;
import Api.dev.persistence.crud.StoreCrudRepository;
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
public class StoreService implements StoreContract {

    @Autowired
    private StoreCrudRepository crudStore;

    @Override
    public List<Store> getListStore() {
        return crudStore.getListStoreCrud();
    }

    @Override
    public Store getStoreById(int id) {
        return crudStore.getStoreByIdCrud(id);
    }

    @Override
    public Store createStore(Store store) {
        store.setCreatedDate(GetDates.getdate());
        store.setModifiedDate(GetDates.getdate());
        store.setStatus(Constant.isActive);
        return crudStore.save(store);
    }

    @Override
    public int deleteStore(int id) {
        return crudStore.deleteStoreCrud(id);
    }

    @Override
    public int updateStore(Store store) {
        store.setModifiedDate(GetDates.getdate());
        return crudStore.updateStoreCrud(store);
    }

}
