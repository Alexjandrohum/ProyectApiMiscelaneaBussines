/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.contract;

import Api.dev.entities.Store;
import java.util.List;

/**
 *
 * @author alexjandrohum
 */
public interface StoreContract {

    List<Store> getListStore();

    Store getStoreById(int id);

    Store createStore(Store store);

    int deleteStore(int id);

    int updateStore(Store store);

}
