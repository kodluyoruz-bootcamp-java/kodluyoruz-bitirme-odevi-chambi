package org.kodluyoruz.group1.library.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeResourceController {

    @GetMapping("/")
    public String home() {
        return "fragments/header";
    }

    @GetMapping("/user")
    public String user() {
        return ("Welcome User ");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("Welcome Admin ");
    }
}