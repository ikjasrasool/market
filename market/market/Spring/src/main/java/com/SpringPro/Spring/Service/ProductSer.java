package com.SpringPro.Spring.Service;

import com.SpringPro.Spring.Entity.Product;
import com.SpringPro.Spring.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductSer {
    @Autowired
    ProductRepo repo;
    public void saveProduct(Product pro) {
        repo.save(pro);
    }
    public List<Product> getAllProduct(){
        return repo.findAll();
    }
    public void deleteProduct(long id)
    {
        repo.deleteById(id);
    }
    public Product updateProduct(long id)
    {
       Optional<Product> temp=repo.findById(id);
       Product pro=temp.get();
       return pro;
    }

}
