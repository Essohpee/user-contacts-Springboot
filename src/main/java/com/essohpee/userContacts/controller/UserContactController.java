package com.essohpee.userContacts.controller;

import com.essohpee.userContacts.model.UserContact;
import com.essohpee.userContacts.service.UserContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserContactController {

    private final UserContactService userContactService;
    public UserContactController(UserContactService userContactService) {
        this.userContactService = userContactService;
    }


    @GetMapping({"/users"})
    public String listUserContacts(Model model) {
        model.addAttribute("users", userContactService.getUserContacts());
        return "users";
    }

    @GetMapping("/users/new")
    public String createUserContact(Model model) {
        UserContact userContact = new UserContact();
        model.addAttribute("userContact", userContact);
        return "add_user";
    }

    @PostMapping("/users")
    public String guardUserContact(@Validated UserContact userContact,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirect, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("userContact", userContact);
            return "add_user";
        } else {
            userContactService.saveUserContact(userContact);
            redirect.addFlashAttribute("msgExit", "User has been added successfully!");
            return "redirect:/users";
        }
    }

    @GetMapping("/users/edit/{id}")
    public String editUserContact(@PathVariable Integer id, Model model) {
        model.addAttribute("userContact",
                userContactService.getUserContactById(id));
        return "edit_user_contact";
    }

    @PostMapping("/users/{id}")
    public String updateUserContact(@Validated @PathVariable Integer id,
                                    @ModelAttribute("userContact") UserContact userContact,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirect) {
        UserContact existingUserContact = userContactService.getUserContactById(id);
        if (bindingResult.hasErrors()) {
            return "edit_user_contact";
        }
        existingUserContact.setId(userContact.getId());
        existingUserContact.setName(userContact.getName());
        existingUserContact.setBirthDate(userContact.getBirthDate());
        existingUserContact.setRegistrationDate(userContact.getRegistrationDate());
        existingUserContact.setPhoneNumber(userContact.getPhoneNumber());
        existingUserContact.setEmail(userContact.getEmail());

        userContactService.updateUserContact(existingUserContact);
        redirect.addFlashAttribute("msgExit", "User has been successfully updated!");
        return "redirect:/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUserContact(@PathVariable Integer id,RedirectAttributes redirect) {
        userContactService.deleteUserContactById(id);
        redirect.addFlashAttribute("msgExit", "User has been successfully deleted!");
        return "redirect:/users";
    }
}
