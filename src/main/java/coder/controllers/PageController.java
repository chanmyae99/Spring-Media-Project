package coder.controllers;
import coder.models.Category;
import coder.services.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class PageController {
    @Autowired
    private CatService catService;

    @RequestMapping("/")
    public String home(Model model){
        List<Category> cats = catService.getAllCat();
        model.addAttribute("cats", cats);
        return "home";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }

    @RequestMapping("/admin/home")
    public String admin(){
        return "admin.home";
    }

    @RequestMapping("/author/home")
    public String author(){
        return "author.home";
    }
}
