package com.qf.controller;

import com.qf.entity.Student;
import com.qf.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
/*
ssssssssss
 */
@Controller
@RequestMapping("stu")
public class StuController {
    @Value("${server.port}")
    private Integer myport;
    @Autowired
    private IStuService stuService;
    @RequestMapping("list")
    public String getList(Model model){
        List<Student> list1=stuService.list();
        model.addAttribute("list",list1);
        return "list";
    }
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id){
        stuService.removeById(id);
        return "redirect:/stu/list";
    }
    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        System.out.println("调用了controller");
        return "hello+当前我的端口:"+ myport;
    }

}
