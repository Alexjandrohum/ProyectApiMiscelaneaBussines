/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.service;

import Api.dev.contract.AddressContract;
import Api.dev.dto.AddressDto;
import Api.dev.entities.Address;
import Api.dev.mapper.AddressMapper;
import Api.dev.persistence.crud.AddressCrudRepository;
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
public class AddressService implements AddressContract {

    @Autowired
    private AddressCrudRepository addressCrud;
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<AddressDto> getListAddress() {
        List<Address> addresses = addressCrud.getAllAddressCrud();
        return addressMapper.toAddressesDto(addresses);
    }

    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        System.out.println(addressDto);
        addressDto.setDateCreated(GetDates.getdate());
        addressDto.setDateModified(GetDates.getdate());
        addressDto.setStatus(Constant.isActive);
        Address address = addressMapper.toAddress(addressDto);
        return addressMapper.toAddressDto(addressCrud.save(address));
    }

    @Override
    public int deleteAddress(int idAddress) {
        return addressCrud.deleteAddressCrud(idAddress);
    }

    @Override
    public int updateAddress(AddressDto addressDto) {
        addressDto.setDateModified(GetDates.getdate());
        Address address = addressMapper.toAddress(addressDto);
        return addressCrud.updateAddressCrud(address);
    }

    @Override
    public AddressDto getAddressById(int idAddress) {
        return addressMapper.toAddressDto(addressCrud.getAddressByIdCrud(idAddress));
    }

}
