package org.hillel.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String hello() {

    return "hello/hello";
  }
  @GetMapping("/hello2")
  public String hello2() {

    return "hello/hello";
  }

  @GetMapping("/hello3")
  public String hello3(@RequestParam("name") String name, Model model) {

    model.addAttribute("message", "hi " + name);

    return "hello/helloD";
  }

  @GetMapping("/hello4/{name}")
  public String hello4(@PathVariable("name") String name, Model model) {

    model.addAttribute("message", "hi " + name);

    return "hello/helloD";
  }
}
