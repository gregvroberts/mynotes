package com.greg.mynotes.controllers;

/**
 *
 * Created by Gregory Roberts on 5/27/21
 *
 */

import com.greg.mynotes.models.Notes;
import com.greg.mynotes.models.User;
import com.greg.mynotes.repositories.NotesRepository;
import com.greg.mynotes.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class NotesController {
    @Autowired
    private CustomUserDetailsService userService;

    @Autowired
    private NotesRepository noteRepository;

    /**
     * Create the model and view
     * @return the model and view
     */
    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public ModelAndView notes() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("notes", noteRepository.findAll());
        modelAndView.addObject("currentUser", user);
        modelAndView.addObject("fullName", "Welcome, " + user.getFullName());
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role.");
        modelAndView.setViewName("notes");
        return modelAndView;
    }

    /**
     * create the model and view for create note
     * @return the model and view
     */
    @RequestMapping("/notes/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("currentUser", user);
        modelAndView.addObject("fulllName", "Welcome, " + user.getFullName());
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.setViewName("create");
        return modelAndView;
    }

    /**
     * Save a note
     * @param title note title
     * @param content note content
     * @return redirect to view the note saved
     */
    @RequestMapping("/notes/save")
    public String save(@RequestParam String title, @RequestParam String content) {
        Notes note = new Notes();
        note.setTitle(title);
        note.setContent(content);
        note.setUpdated(new Date());
        noteRepository.save(note);

        return "redirect:/notes/show/" + note.getId();
    }

    /**
     * Show a note
     * @param id note id
     * @return the model and view
     */
    @RequestMapping("/notes/show/{id}")
    public ModelAndView show(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("currentUser", user);
        modelAndView.addObject("fulllName", "Welcome, " + user.getFullName());
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.addObject("note", noteRepository.findById(id).orElse(null));
        modelAndView.setViewName("show");
        return modelAndView;
    }

    /**
     * delete a note by id
     * @param id note id
     * @return a redirect
     */
    @RequestMapping("/notes/delete")
    public String delete(@RequestParam Long id) {
        Notes note = noteRepository.findById(id).orElse(null);
        noteRepository.delete(note);

        return "redirect:/notes";
    }

    /**
     * Edit a note
     * @param id note id
     * @return model and view
     */
    @RequestMapping("/notes/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("currentUser", user);
        modelAndView.addObject("fullName", "Welcome " + user.getFullName());
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.addObject("note", noteRepository.findById(id).orElse(null));
        modelAndView.setViewName("edit");
        return modelAndView;
    }

    /**
     * Update a note
     * @param id note id
     * @param title note title
     * @param content note content
     * @return a redirect to the note
     */
    @RequestMapping("/notes/update")
    public String update(@RequestParam Long id, @RequestParam String title, @RequestParam String content) {
        Notes note = noteRepository.findById(id).orElse(null);
        note.setTitle(title);
        note.setContent(content);
        note.setUpdated(new Date());
        noteRepository.save(note);

        return "redirect:/notes/show/" + note.getId();
    }

}
