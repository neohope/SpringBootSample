package com.neohope.test.kotlin.hello

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@EnableAutoConfiguration
@RestController
class MyController() {
    private val log = LoggerFactory.getLogger(MyApplication::class.java)
    private val nameArray = arrayOf("张三", "李四", "王五", "赵六", "小明", "张伟", "王伟", "王芳", "李伟", "李娜", "张敏", "李静", "王静", "刘伟" );
    private val sexArray = arrayOf("男", "女", "其他", "未知")

    @GetMapping("/")
    fun hi() : String{
        return "Hi~~";
    }

    @GetMapping("/AppName")
    fun appName() : String {
        return "SpringBootKotlin";
    }

    @GetMapping("/GetUser/{userId}")
    fun GetUser(@PathVariable userId:String) : User {
        val u = User()
        u.UserId = userId
        u.UserName = nameArray[(Math.random()*nameArray.size).toInt()];
        u.UserSex = sexArray[(Math.random()*sexArray.size).toInt()];
        u.BirthDate = String.format("{%04d-%02d-%02d}", 1987 + (Math.random()*30).toInt(), 1 + (Math.random()*12).toInt(), 1 +(Math.random()*12).toInt());
        return u;
    }
}