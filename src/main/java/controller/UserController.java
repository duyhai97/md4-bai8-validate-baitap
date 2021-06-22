package controller;

import exception.NotfoundException;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IUserService;


import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping("")
    public ModelAndView showListBlog(){
        List<User> userList = this.userService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("userList", userList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {

            return new ModelAndView("/create");
        }
        else {
            this.userService.save(user);
            return new ModelAndView("redirect:/user");
        }

    }

    @GetMapping("/{id}/view")
    public ModelAndView viewDetail(@PathVariable Long id) throws NotfoundException {
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("user",userService.findById(id));
        return modelAndView;

    }


    @ExceptionHandler(NotfoundException.class)
    public ModelAndView notfound(){
        return new ModelAndView("/notfound");
    }



}
