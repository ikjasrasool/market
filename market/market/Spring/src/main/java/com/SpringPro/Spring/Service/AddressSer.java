package com.SpringPro.Spring.Service;

import com.SpringPro.Spring.Entity.Address;
import com.SpringPro.Spring.Entity.Product;
import com.SpringPro.Spring.Repository.AddressRepo;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressSer {
    @Autowired
    AddressRepo repo;
    public void save(Address add) {
        repo.save(add);
    }
    public List<Address> getAll(){
        return repo.findAll();
    }
    public void delete(long id)
    {
        repo.deleteById(id);
    }
}
