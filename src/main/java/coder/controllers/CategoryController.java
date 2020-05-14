package coder.controllers;

import coder.models.Category;
import coder.services.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CatService catService;

    @RequestMapping("/cat/all")
    public String allCat(Model model){
        List<Category> cats = catService.getAllCat();
        model.addAttribute("cats", cats);
        return "admin.cat.all";
    }

    @RequestMapping("/cat/edit/{id}")
    public String showEditCat(@PathVariable("id") String id, Model model){
        Category category = catService.getCatById(Integer.parseInt(id));
        model.addAttribute("category", category);
        return "admin.cat.edit";
    }

    @RequestMapping(value="/cat/edit", method = RequestMethod.POST)
    public String editCat(@ModelAttribute("category") Category category, Model model){
        catService.catUpdate(category);
        return "redirect:/cat/all";
    }

    @RequestMapping("/cat/delete/{id}")
    public String deleteCat(@PathVariable("id") String id, Model model){
        catService.catDelete(Integer.parseInt(id));
        return "redirect:/cat/all";
    }

    @RequestMapping("/cat/create")
    public String createCat(Model model){
        model.addAttribute("category", new Category());
        return "admin.cat.create";
    }

    @RequestMapping(value = "/cat/create", method = RequestMethod.POST)
    public String createCat(@ModelAttribute("category") Category category, Model model){
        model.addAttribute("category", new Category());
        catService.addCat(category);
        return "redirect:/cat/all";
    }

}
