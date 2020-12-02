/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.contract;

import Api.dev.entities.AccountProduct;
import java.util.List;

/**
 *
 * @author alexjandrohum
 */
public interface AccountProductContract {

    List<AccountProduct> getListAccountProduct();

    AccountProduct getAccountProductById(int id);

    AccountProduct createAccountProduct(AccountProduct accountProduct);

    int updateAccountProduct(AccountProduct accountProduct);

    int deleteAccountProduct(int id);
}
