package com.example.demo.controles;

import com.example.demo.service.impl.PostServiceImpl;
import org.springframework.stereotype.Controller;

@Controller
public class SortCont {
    final PostServiceImpl postService;

    public SortCont(PostServiceImpl postService) {
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
