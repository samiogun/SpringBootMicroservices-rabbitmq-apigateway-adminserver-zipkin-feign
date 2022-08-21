package org.ersun.accountservice.service;

import lombok.RequiredArgsConstructor;
import org.ersun.accountservice.model.Account;
import org.ersun.accountservice.repository.AccountRepository;
import org.ersun.feign.model.account.AccountDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final ModelMapper modelMapper;

    @Override
    public AccountDto get(String id) {
        Account account = accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(
                account,
                AccountDto.class
        );
    }

    @Override
    @Transactional
    public AccountDto save(AccountDto accountDto) {
        accountDto.setId(
                accountRepository.save(
                        modelMapper.map(
                                accountDto,
                                Account.class
                        )
                ).getId()
        );
        return accountDto;
    }

    @Override
    @Transactional
    public AccountDto update(String id, AccountDto accountDto) {
        Assert.isNull(id, "Id cannot be null");
        Account account = accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
//        Optional<Account> account1 = accountRepository.findById(id);
//        account1.map(() -> )

        return modelMapper.map(accountRepository.save(account), AccountDto.class);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Account account = accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        accountRepository.delete(account);
    }

    @Override
    public List<AccountDto> pagination(Pageable pageable) {
        Slice<Account> slice = accountRepository.findAll(pageable);
        return slice.getContent().stream().map(
                account -> modelMapper.map(account,AccountDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public List<AccountDto> findAll() {
        return accountRepository.findAll().stream().map(
                account -> modelMapper.map(account,AccountDto.class)
        ).collect(Collectors.toList());
    }

}
