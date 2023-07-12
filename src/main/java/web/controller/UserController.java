package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
/*@RequestMapping("/user")*/
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/new")
    public String save(User user) {
        return "new";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute("user") User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "new";
        }else {
            return "redirect:/";
        }
    }


    @GetMapping("/by/{id}")
    public String show(@PathVariable("id") ModelMap model, Long id){
        model.addAttribute("user", userService.getUserById(id));
        return "byId";

    }

    @GetMapping("update/{id}")
    public String updateUser(@PathVariable("id") long id, Model model) {
        model.addAttribute(userService.getUserById(id));
        return "update";
    }

    @PatchMapping("/update")
    public String update(User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        } else {
            userService.updateUser(user);
            return "redirect:/";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.removeUserById(id);
        return "redirect:/";
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "getAll";
    }






}


