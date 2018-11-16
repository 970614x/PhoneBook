package pl.chrislem.phonebook.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.chrislem.phonebook.models.UserSession;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class IndexController {
    final UserSession userSession;

    @Autowired
    public IndexController(UserSession userSession) {
        this.userSession = userSession;
    }


    @GetMapping("/")
    @ResponseBody
    public  String index(HttpServletResponse servletResponse){

        if(!userSession.isLogin()){
            try {
                servletResponse.sendRedirect("/user/login");
                return "";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "Witaj, " + userSession.getUserEntity().getPassword();
    }

}