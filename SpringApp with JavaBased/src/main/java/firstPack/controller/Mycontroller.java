package firstPack.controller;

import firstPack.JavaContactService;
import firstPack.rootClasses.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by Stas on 02.08.2015.
 */

@Controller
@RequestMapping("/*")

public class Mycontroller {

    @Autowired
    JavaContactService service;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        Set<Contact> contacts = this.service.getAllContacs();
        model.addAttribute("message", "You can see all contacts below");
        model.addAttribute("ContactList",contacts);
        return "Contacts";
    }

    @RequestMapping(value = "addContact", method = RequestMethod.POST)
    public String addContact(HttpServletRequest request,ModelMap model) {
        System.out.println(request.getParameter("firstName"));
        System.out.println(request.getParameter("lastName"));
        System.out.println(request.getParameter("birthday"));
        this.service.createContact(request.getParameter("firstName"), request.getParameter("lastName"), LocalDate.parse(request.getParameter("birthday")));

        Set<Contact> contacts = this.service.getAllContacs();
        model.addAttribute("message", "You can see all contacts below");
        model.addAttribute("ContactList", contacts);

        return "Contacts";
    }

    @RequestMapping(value = "deleteContact", method = RequestMethod.POST)
    public String deleteContact(HttpServletRequest request,ModelMap model) {
        System.out.println(request.getParameter("firstName"));
        System.out.println(request.getParameter("lastName"));
        System.out.println(request.getParameter("birthday"));
        this.service.createContact(request.getParameter("firstName"), request.getParameter("lastName"), LocalDate.parse(request.getParameter("birthday")));

        Set<Contact> contacts = this.service.getAllContacs();
        model.addAttribute("message", "You can see all contacts below");
        model.addAttribute("ContactList", contacts);

        return "Contacts";
    }
}