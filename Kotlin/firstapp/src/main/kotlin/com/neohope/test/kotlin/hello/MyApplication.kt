package com.neohope.test.kotlin.hello

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class MyApplication {
}

fun main(args: Array<String>) {
    SpringApplication.run(MyApplication::class.java, *args)
}