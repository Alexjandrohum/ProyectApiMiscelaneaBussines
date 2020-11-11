/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.contract;

import Api.dev.dto.AddressDto;
import java.util.List;

/**
 *
 * @author alexjandrohum
 */
public interface AddressContract {

    List<AddressDto> getListAddress();

    AddressDto createAddress(AddressDto addressDto);

    int deleteAddress(int idAddress);

    int updateAddress(AddressDto addressDto);

    AddressDto getAddressById(int idAddress);

}
