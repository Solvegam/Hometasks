package firstPack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Stas on 02.08.2015.
 */

@Controller
@RequestMapping("/start")

public class Mycontroller {

    @RequestMapping(method = RequestMethod.GET)
//    @RequestMapping(value = "/start")
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "If you want to AppConfig – just wait");
        return "start";
    }
}