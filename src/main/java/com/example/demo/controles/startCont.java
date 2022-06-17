//package com.example.demo.controles;
//
//import com.example.demo.Dto.Post.PostDetail;
//import com.example.demo.Entity.*;
//import com.example.demo.Entity.enums.Categories;
//import com.example.demo.repos.*;
//import com.example.demo.service.MailService;
//import com.example.demo.service.PostService;
//import com.example.demo.service.UserService;
//import org.springframework.data.domain.*;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//
//@Controller
//public class startCont {
//    final
//    UserService userService;
//    final
//    userRepos userRepos;
//    final
//    MailService mailService;
//
//    final
//    PostRepo postRepo;
//
//    final CommentsRepo commentsRepo;
//    final PostService postService;
//
//
//
//    public startCont(UserService userService, userRepos userRepos, MailService mailService, PostRepo postRepo, CommentsRepo commentsRepo, PostService postService) {
//        this.userService = userService;
//
//        this.userRepos = userRepos;
//
//        this.mailService = mailService;
//
//        this.postRepo = postRepo;
//        this.commentsRepo = commentsRepo;
//        this.postService = postService;
//    }
//
//
//    @GetMapping("/")
//    public String index(Model model) {
//      return listByPage(0,"nf",model);
//    }
//
//
//    @GetMapping("/page/{pageNumber}/{categoryFilter}")
//    public String listByPage(@PathVariable("pageNumber") int currentPage,
//                              @PathVariable ("categoryFilter") String categoryFilter,
//                              Model model){
//
//        int pageSize = 4;
//        boolean filterOn;
//        filterOn = !categoryFilter.equals("nf");
//
//        double postCount;
//        Categories newCategory = null;
//
//
//        if (!filterOn){
//            postCount = postRepo.count();
//        }else{
//
//            newCategory = Categories.valueOf(categoryFilter);
//            postCount = postRepo.countByCategories(newCategory);
//        }
//
//        long totalPages  = (long)Math.ceil(postCount/pageSize);
//
//
//        if (currentPage >= totalPages && postCount > 0) {
//            currentPage = (int) totalPages-1;
//        }
//
//        Pageable pageable = PageRequest.of(currentPage,pageSize);
//        List<PostDetail> list;
//
//        if (filterOn){
//            list = postRepo.findAllPostsByCategoryAndCommentsCount(newCategory,pageable).getContent();
//        }else
//            list = postRepo.findAllPostsByCategoryAndCommentsCount(pageable).getContent();
//
//        if (filterOn){
//            model.addAttribute("categoryFilter", newCategory);
//        }else{
//            model.addAttribute("categoryFilter","nf");
//
//        }
//        model.addAttribute("list", list);
//        System.out.println(totalPages);
//        model.addAttribute("currentPage",currentPage);
//        model.addAttribute("totalPages",totalPages);
//        return "index";
//    }
//
//    @GetMapping("/signup")
//    public String signup(Model model) {
//
//        model.addAttribute("user" ,new User());
//        return "/signup";
//    }
//
//    @PostMapping("/validationForm")
//    public String UserRegistration(@Valid User user,
//                                   BindingResult result,
//                                   Model model) throws Exception {
//
//
//        if (!result.hasErrors()) {
//
//
//
//            model.addAttribute("noError",result);
//            userService.saveUser(user,model.asMap());
//
//            return "/signup";
//        }
//
//        model.addAttribute("user", user);
//        return "/signup";
//    }
//    @GetMapping("/userPage/{id}")
//    public String getUserPage(@PathVariable("id") Long id,
//                           Model model){
//        User userById = userService.findUserById(id);
//        model.addAttribute("user1",userById);
//        return "userPage";
//    }
//
//    @GetMapping("/login")
//    public  String loginPage(@RequestParam (name = "error",required = false)
//                             Boolean error,
//                             Model model){
//        if (Boolean.TRUE.equals(error)){
//            model.addAttribute("error",true);
//        }
//        return "/login";
//    }
//
//    @GetMapping("/form")
//    public String getForm(){
//        return "/form";
//    }
//
//
//
//
//
//
//    @GetMapping("/postComments/{postId}/{commentsCount}")
//    public String getTestArea(Model model,@PathVariable ("postId") Long postId,
//                              @PathVariable ("commentsCount") int commentsCount){
//
//
//        Post post = postService.findByPostById(postId);
//        if (commentsCount!= 0){
//            List<Comment> commentByPost = post.getComments();
//            model.addAttribute("comments",commentByPost);
//        }
//        model.addAttribute("Post",post);
//
//        return "parts/comments";
//    }
//
//
//
//
//}
//
