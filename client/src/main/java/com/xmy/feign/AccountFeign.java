package com.xmy.feign;

import com.xmy.entity.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "account")
public interface AccountFeign {

    @PostMapping("/account/login")
    public Account login(@RequestBody Account account);

}
