package com.example.demo.controles;

import com.example.demo.Entity.Categories;
import com.example.demo.Entity.Post;
import com.example.demo.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class SortCont {
    final PostService postService;

    public SortCont(PostService postService) {
        this.postService = postService;
    }

//    @GetMapping("/sortByCategory/{category}")
//    public String SortByCategory(@PathVariable String  category,
//                                 Model model){
//        Categories newCategory;
//        if (category.equals("evil")) {
//            newCategory = Categories.EVIL;
//        } else {
//            newCategory = Categories.GOODNESS;
//        }
//        List<Post> postList =
//                postService.findAllByCategory(newCategory);
//        model.addAttribute("list",postList);
//
//        return "index";
//    }
}
