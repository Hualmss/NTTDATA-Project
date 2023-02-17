package com.nttdata.products.products.feignClients;

import org.springframework.cloud.openfeign.FeignClient;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "clients", url = "http://localhost:8002", path = "/clients")
public interface ClientFeignClient {

    @GetMapping("isEnterpriceClient/{idClient}")
    public boolean isEnterpriceClient(@PathVariable long idClient);

    @GetMapping("isPersonalClient/{idClient}")
    public boolean isPersonalClient(@PathVariable long idClient);
    
}
