package com.nttdata.products.products.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nttdata.products.products.model.Moviments;

@FeignClient(name = "movements", url = "http://localhost:8003", path = "/movements")
public interface MovimentFeignClient {

    @PostMapping("")
    public boolean saveMoviment(@RequestBody Moviments movimients);

}
