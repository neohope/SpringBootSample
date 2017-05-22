package com.neohope.test.kotlin.hello

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class MyApplicationTests {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun hi() {
        var content = "Hi~~"
        assertEquals(content, restTemplate.getForEntity("/", String::class.java).body)
    }

}