package com.waylau.spring.boot.blog.contorll;


import com.waylau.spring.boot.blog.domian.User;
import com.waylau.spring.boot.blog.repositroy.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserContorll {

    @Autowired  //注入数据
    private UserRepositoryImpl userRepository;
    @GetMapping()
    public ModelAndView list(Model model){
        model.addAttribute("userList",userRepository.listUser());
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/list","userModel",model);
    }


    /***
     * 根据Id查询用户
     * */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model){
        User user = userRepository.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户");
        return new ModelAndView("users/view","userModel",model);
    }

    /***
     * 获取创建表单页面
     * */
    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form","userModel",model);
    }


    /***
     * 保存用户
     * */
    @PostMapping()
    public ModelAndView saveOrUpdateUser(User user){
        userRepository.saveOrUpdateUser(user);
        Model model = new ExtendedModelMap();
        List<User> userList = userRepository.listUser();
        model.addAttribute("userList",userList);
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/list","userModel",model);
    }


}
