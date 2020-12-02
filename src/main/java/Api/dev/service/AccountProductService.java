/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.service;

import Api.dev.contract.AccountProductContract;
import Api.dev.entities.AccountProduct;
import Api.dev.persistence.crud.AccountProductCrudRepository;
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
public class AccountProductService implements AccountProductContract {
    
    @Autowired
    private AccountProductCrudRepository crudAccountProduct;
    
    @Override
    public List<AccountProduct> getListAccountProduct() {
        return crudAccountProduct.getListAccountProductCrud();
    }
    
    @Override
    public AccountProduct getAccountProductById(int id) {
        return crudAccountProduct.getAccountProductCrud(id);
    }
    
    @Override
    public AccountProduct createAccountProduct(AccountProduct accountProduct) {
        accountProduct.setCreatedDate(GetDates.getdate());
        accountProduct.setModifiedDate(GetDates.getdate());
        accountProduct.setStatus(Constant.isActive);
        return crudAccountProduct.save(accountProduct);
    }
    
    @Override
    public int updateAccountProduct(AccountProduct accountProduct) {
        accountProduct.setModifiedDate(GetDates.getdate());
        return crudAccountProduct.updateAccountProduct(accountProduct);
    }
    
    @Override
    public int deleteAccountProduct(int id) {
        return crudAccountProduct.deleteAccountProduct(id);
    }
    
}
