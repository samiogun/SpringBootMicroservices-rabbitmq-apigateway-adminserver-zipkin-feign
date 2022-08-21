package org.ersun.feign.clients;

import org.ersun.feign.model.account.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "account-service")
public interface AccountServiceClient {

    @RequestMapping(
            value = "v1/accounts/{id}",
            method = RequestMethod.GET
    )
    public ResponseEntity<AccountDto> get(@PathVariable("id") String id);

}