package coder.controllers;

import coder.models.Category;
import coder.models.Posts;
import coder.services.CatService;
import coder.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    private CatService catService;
    @Autowired
    private PostService postService;

    @RequestMapping("/post/all")
    public String allPost(Model model) {
        List<Posts> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "author.post.all";
    }

    @RequestMapping("/post/edit/{id}")
    public String showPostEditPage(@PathVariable("id") String id, Model model) {
        Posts post = postService.getPostById(Integer.parseInt(id));
        List<Category> cats = catService.getAllCat();
        model.addAttribute("cats", cats);
        model.addAttribute("post", post);
        return "author.post.edit";
    }

    @RequestMapping(value = "/post/edit", method = RequestMethod.POST)
    public String postEdit(@ModelAttribute("post") Posts post, Model model, HttpServletRequest request) {
        MultipartFile file = post.getFile();
        if (file != null && !file.isEmpty()) {
            String imgName = saveImage(file, request);
            post.setImage(imgName);
        } else {
            System.out.println("file not exist");
        }
        postService.updatePost(post);
        return "redirect:/post/all";
    }

    @RequestMapping("/post/delete/{id}")
    public String deletePost(@PathVariable("id") String id, Model model) {
        postService.deletePost(Integer.parseInt(id));
        return "redirect:/post/all";
    }

    @RequestMapping("/post/create")
    public String showPostCreate(Model model) {
        List<Category> cats = catService.getAllCat();
        model.addAttribute("cats", cats);
        model.addAttribute("post", new Posts());
        return "author.post.create";
    }

    @RequestMapping(value = "/post/create", method = RequestMethod.POST)
    public String postCreate(@ModelAttribute("post") Posts post, Model model, HttpServletRequest request) {
        MultipartFile file = post.getFile();

        String imgName = saveImage(file, request);
        post.setImage(imgName);
        post.setUser_id(1);
        postService.addPost(post);
        System.out.println("Created date is " + post.getCreated_at());
        return "redirect:/post/all";
    }

    public String saveImage(MultipartFile file, HttpServletRequest request) {
        String imgName = System.currentTimeMillis() + ".png";
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        Path path = Paths.get(rootDirectory + "/WEB-INF/assets/imgs/" + imgName);
        if (file != null && !file.isEmpty()) {
            try {
                file.transferTo(new File(path.toString()));
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Image can't be uploaded!");
            }
        }
        return imgName;
    }
}
