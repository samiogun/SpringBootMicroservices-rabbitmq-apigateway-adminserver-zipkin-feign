package org.ersun.accountservice.service;

import org.ersun.feign.model.account.AccountDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccountService {

    AccountDto get(String id);

    AccountDto save(AccountDto account);

    AccountDto update(String id, AccountDto account);

    void delete(String string);

    List<AccountDto> pagination(Pageable pageable);

    List<AccountDto> findAll();

}
