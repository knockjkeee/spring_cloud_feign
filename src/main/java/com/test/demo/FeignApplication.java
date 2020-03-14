package com.test.demo;

import com.test.demo.domain.UserClient;
import com.test.demo.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@EnableFeignClients
public class FeignApplication {

    @Autowired
    private UserClient client;

    @GetMapping("/findUsers")
    public List<UserResponse> getUser() {
        return client.getUsers();
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }

}
