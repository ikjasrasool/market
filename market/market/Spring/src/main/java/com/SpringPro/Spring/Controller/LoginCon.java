package com.SpringPro.Spring.Controller;

import org.springframework.ui.Model;
import com.SpringPro.Spring.Entity.Login;
import com.SpringPro.Spring.Service.LoginSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Controller
public class LoginCon {
    @Autowired
    LoginSer ser;
    //Regiter page
    @GetMapping("/registration")
    public String getRegPage(@ModelAttribute("user")Login login) {
        return "register";
    }


    //Save Register details
    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") Login login,Model model) {
        if (login.getPassword().equals(login.getRePassword())) {
            if(!ser.checkEmail(login.getEmail()))
            {
                ser.saveUser(login);
                model.addAttribute("message", "Please Login...");
                return "login";
            }
            else
            {
                model.addAttribute("message", "Email is already exits");
                return "login";
            }
        } else {
            model.addAttribute("message", "Incorrect Password");
            return "register";
        }
    }


    //login page
    @GetMapping("/login")
    public String getSignPage(@ModelAttribute("user")Login login)
    {
        return "login";
    }


    //check user or manager and go there page
    @PostMapping("/login")
    public String checkUser(@ModelAttribute("user") Login login,Model model)
    {
        Login check=ser.checkUser(login.getEmail());
        if(Objects.nonNull(check))
        {
            if(check.getRole().equals("Manager"))
            {
                if(check.getRole().equals(login.getRole()))
                {
                    if(check.getPassword().equals(login.getPassword()))
                    {
                        return "redirect:/allProduct";
                    }
                    else
                    {
                        model.addAttribute("message", "Incorrect Password");
                        return "login";
                    }
                }
                else {
                    model.addAttribute("message", "Login Role Failed");
                    return "login";
                }
            }
            else
            {
                if(check.getRole().equals(login.getRole()))
                {
                    if(check.getPassword().equals(login.getPassword()))
                    {
                        return "redirect:/home";
                    }
                    else
                    {
                        model.addAttribute("message", "Incorrect Password");
                        return "login";
                    }
                }
                else {
                    model.addAttribute("message", "Login Role Failed");
                    return "login";
                }
            }
        }
        else
        {
            model.addAttribute("message", "Eamil Address not found");
            return "register";
        }

    }

}
