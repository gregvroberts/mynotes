package com.greg.mynotes.controllers;
/**
 *
 * Created by Gregory Roberts on 5/27/21
 *
 */

// TODO Fix valid attribute import
//import javax.validation.Valid;
import com.greg.mynotes.models.User;
import com.greg.mynotes.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    /**
     * Autowired CustomDetailsService field
     */
    @Autowired
    private CustomUserDetailsService userService;

    /**
     * model and view method for login page
     * @return returns ModelAndView obj
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
            return modelAndView;
    }

    /**
     * model and view method for signup/register page
     * @return model and view
     */
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("signup");
        return modelAndView;
    }


    // TODO Fix valid attribute below
    // TODO Fix valid attribute below
    // TODO Fix valid attribute below

    /**
     * Model and view method for saving the new user when form submitted
     * from signup page
     * @param user
     * @param bindingResult result of validation and binding
     * @return returns the model and view
     */
//    @RequestMapping(value = "/signup", method = RequestMethod.POST)
//    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
//        ModelAndView modelAndView = new ModelAndView();
//        User userExists = userService.findUserByEmail(user.getEmail());
//        if (userExists != null) {
//            bindingResult
//                    .rejectValue("email", "error.user",
//                            "There is already a user registered with the username provided");
//        }
//        if (bindingResult.hasErrors()) {
//            modelAndView.setViewName("signup");
//        } else {
//            userService.saveUser(user);
//            modelAndView.addObject("successMessage", "User has been registered successfully");
//            modelAndView.addObject("user", new User());
//            modelAndView.setViewName("login");
//
//        }
//        return modelAndView;
//    }


}