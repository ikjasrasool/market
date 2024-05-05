package com.SpringPro.Spring.Controller;

import com.SpringPro.Spring.Entity.Product;
import com.SpringPro.Spring.Service.ProductSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CardCon {
    @Autowired
    ProductSer ser;
     //Add To Cart
    public List<Product> cart=new ArrayList<>();
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id")long id)
    {
        Product pro=ser.updateProduct(id);
        cart.add(pro);
        return "redirect:/shop";
    }

    //Display Cart
    @GetMapping("/cart")
    public String cart(Model model)
    {
        model.addAttribute("count",cart.size());
        model.addAttribute("total", cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart",cart);
        return "cart";
    }

    //Remove a Cart
    @GetMapping("/del/{id}")
    public String deletePro(@PathVariable("id")long id)
    {
        Product pro=ser.updateProduct(id);
        cart.remove(pro);
        return "redirect:/cart";
    }

    //cart to payment page
    @GetMapping("/proceed")
    public String goAddress()
    {
        return "redirect:/address";
    }
}