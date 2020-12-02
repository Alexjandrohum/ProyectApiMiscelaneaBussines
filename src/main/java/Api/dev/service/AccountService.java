/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.service;

import Api.dev.contract.AccountContract;
import Api.dev.entities.Account;
import Api.dev.persistence.crud.AccountCrudRepository;
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
public class AccountService implements AccountContract {

    @Autowired
    private AccountCrudRepository crudAccount;

    @Override
    public List<Account> getListAccount() {
        return crudAccount.getListAccountCrud();
    }

    @Override
    public Account getAccountById(int id) {
        return crudAccount.getAccountCrud(id);
    }

    @Override
    public Account createAccount(Account account) {
        account.setCreatedDate(GetDates.getdate());
        account.setModifiedDate(GetDates.getdate());
        account.setStatus(Constant.isActive);
        return crudAccount.save(account);
    }

    @Override
    public int updateAccount(Account account) {
        account.setModifiedDate(GetDates.getdate());
        return crudAccount.updateAccountCrud(account);
    }

    @Override
    public int deleteAccount(int id) {
        return crudAccount.deleteAccountCrud(id);
    }

}
