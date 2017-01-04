/// Created by BB on 2017-01-04.
package com.greenfoxacademy.bbalint.reddit.controllers;

import com.greenfoxacademy.bbalint.reddit.domain.Post;
import com.greenfoxacademy.bbalint.reddit.domain.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RedditAppController {

    @Autowired
    private PostRepository repository;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("posts", repository.findAll());
        return "index";
    }

    @RequestMapping(value="/upvote/{id}", method = RequestMethod.GET)
    public ModelAndView upvote(@PathVariable long id) {
        Post post = repository.findOne(id);
        post.setScore(post.getScore()+1);
        repository.save(post);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value="/downvote/{id}", method = RequestMethod.GET)
    public ModelAndView downvote(@PathVariable long id) {
        Post post = repository.findOne(id);
        post.setScore(post.getScore()-1);
        repository.save(post);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value="/del/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {
        Post post = repository.findOne(id);
        repository.delete(id);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value="/newpost", method = RequestMethod.GET)
        public String newPost() {
            return "newpost";
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
        public ModelAndView create(@RequestParam("message") String content) {
            repository.save(new Post(0, content));
            return new ModelAndView("redirect:/");
    }

    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable long id, Model model) {
        Post post = repository.findOne(id);
        model.addAttribute("post", post);
        return "edit";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam ("post_id") long id, @RequestParam("content") String content) {
        Post post = repository.findOne(id);
        post.setContent(content);
        repository.save(post);
        return new ModelAndView("redirect:/");
    }
}
