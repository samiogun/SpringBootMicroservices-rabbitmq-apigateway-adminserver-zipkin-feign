package org.ersun.accountservice.controller;

import org.ersun.feign.model.account.AccountDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountController {

    ResponseEntity<AccountDto> get(String id);

    ResponseEntity<AccountDto> save(AccountDto accountDto);

    ResponseEntity<AccountDto> update(String id, AccountDto accountDto);

    void delete(String id);

//    ResponseEntity<List<Account>> pagination(Pageable pageable);

    ResponseEntity<List<AccountDto>> getAll();

}
