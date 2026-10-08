package designpatterns.mvc.webdev.controller;

import designpatterns.mvc.webdev.model.Application;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InternshipController {

    @GetMapping("/apply")
    public String showForm() {
        return "apply"; // renders apply.html
    }

    @PostMapping("/apply")
    public String submitForm(@RequestParam("name") String name,
                             @RequestParam("email") String email,
                             @RequestParam("role") String role,
                             Model viewData) {
        Application application = new Application(name, email, role);
        viewData.addAttribute("myapp", application);

        return "thankyou";
    }
}
