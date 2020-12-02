/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.contract;

import Api.dev.entities.Account;
import java.util.List;

/**
 *
 * @author alexjandrohum
 */
public interface AccountContract {

    List<Account> getListAccount();

    Account getAccountById(int id);

    Account createAccount(Account account);

    int updateAccount(Account account);

    int deleteAccount(int id);

}
