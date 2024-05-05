package com.SpringPro.Spring.Controller;

import com.SpringPro.Spring.Entity.Product;
import com.SpringPro.Spring.Service.ProductSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class    ProductCon {
    @Autowired
    ProductSer ser;
    //Manager
    @GetMapping("/product")
    public String getproductPage(@ModelAttribute("product") Product pro)
    {
        return "newProduct";
    }


    //Save product  or new Product
    @PostMapping("/product")
    public String saveProduct(@ModelAttribute("product") Product pro, Model model) {
        ser.saveProduct(pro);
        return "redirect:/allProduct";
    }


    //Display all Product
    @GetMapping("/allProduct")
    public String getAllPro(Model model) {
        List<Product> list = ser.getAllProduct();
        model.addAttribute("product", list);
        return "listProduct";
    }


    //update product
    @GetMapping("/edit/{id}")
    public String update(@ModelAttribute("product") Product p,@PathVariable("id") long id,Model model)
    {
        Product pro=ser.updateProduct(id);
        model.addAttribute("pro",pro);
        return "editProduct";
    }


    //Delete product
    @GetMapping("/delete/{id}")
    public String deletePro(@PathVariable("id")long id)
    {
        ser.deleteProduct(id);
        return "redirect:/allProduct";
    }



    //User
    //Home
    @GetMapping("/home")
    public String goHome()
    {
        return "home";
    }

    //About
    @GetMapping("/about")
    public String goAbout()
    {
        return "about";
    }

    //Contact
    @GetMapping("/contact")
    public String goCon()
    {
        return "contact";
    }

    //User Product display
    @GetMapping("/shop")
    public String showProducts( Model model)
    {
        List<Product> list=ser.getAllProduct();
        model.addAttribute("allUser",list);
        return "user";
    }
}
