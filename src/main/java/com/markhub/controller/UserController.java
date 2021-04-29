package com.markhub.controller;


import com.markhub.common.lang.Result;
import com.markhub.entity.User;
import com.markhub.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cwb
 * @since 2021-04-26
 */
@RestController//如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。
//如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，
// 配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequiresAuthentication
    @GetMapping("/index")
    public Result index(){
        User user = userService.getById(1L);

        return Result.succ(200,"操作成功",user);

    }


    @PostMapping("/save")
    public Result save(@Validated @RequestBody User user){


        return Result.succ(200,"操作成功",user);

    }

}
