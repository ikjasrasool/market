package com.SpringPro.Spring.Repository;

import com.SpringPro.Spring.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address,Long>{
}
