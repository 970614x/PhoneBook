package pl.chrislem.phonebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.chrislem.phonebook.models.UserSession;

@Controller
public class IndexController {
    final UserSession userSession;

    @Autowired
    public IndexController(UserSession userSession) {
        this.userSession = userSession;
    }


    @GetMapping("/")
    @ResponseBody
    public  String index(){
        if(!userSession.isLogin()){
            return "redirect:/user/login";
        }
        return "Witaj w twoteetoroomtwotwo klubie ksiazki telefonicznej";
    }

}
