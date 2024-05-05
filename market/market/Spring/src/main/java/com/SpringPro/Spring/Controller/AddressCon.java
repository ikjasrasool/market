package com.SpringPro.Spring.Controller;

import com.SpringPro.Spring.Entity.Address;
import com.SpringPro.Spring.Entity.Product;
import com.SpringPro.Spring.Service.AddressSer;
import com.SpringPro.Spring.Service.ProductSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AddressCon {
    @Autowired
    AddressSer ser;
    @GetMapping("/address")
    public String getAddress(@ModelAttribute("address")Address add)
    {
        return "address";
    }

    //save address
    @PostMapping("/address")
    public String saveAddress(@ModelAttribute("address") Address add, Model model) {
        ser.save(add);
        return "redirect:/payment";
    }

    //payment to message(your order is placed)
    @GetMapping("/payment")
    public String getMessage(@ModelAttribute("address")Address add)
    {
        return "message";
    }

    //Display all address details in manager
    @GetMapping("/order")
    public String getAll(Model model) {
        List<Address> list = ser.getAll();
        model.addAttribute("address", list);
        return "orders";
    }

    //remove the placed order
    @GetMapping("/place/{id}")
    public String deletePro(@PathVariable("id")long id)
    {
        ser.delete(id);
        return "redirect:/order";
    }
}
