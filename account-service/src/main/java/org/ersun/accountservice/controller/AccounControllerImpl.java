package org.ersun.accountservice.controller;

import lombok.RequiredArgsConstructor;
import org.ersun.accountservice.service.AccountService;
import org.ersun.feign.model.account.AccountDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/accounts")
@RequiredArgsConstructor
public class AccounControllerImpl implements AccountController {

    private final AccountService accountService;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> get(@PathVariable("id") String id) {
        return ResponseEntity.ok(accountService.get(id));
    }

    @Override
    @PostMapping
    public ResponseEntity<AccountDto> save(@RequestBody AccountDto account) {
        return ResponseEntity.ok(accountService.save(account));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> update(
            @PathVariable("id") String id,
            @RequestBody AccountDto accountDto
    ) {
        return ResponseEntity.ok(accountService.update(id, accountDto));
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        accountService.delete(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAll() {
        return ResponseEntity.ok(accountService.findAll());
    }

//    @Override
//    public ResponseEntity<List<Account>> pagination(Pageable pageable) {
//        accounService.pagination(pageable);
//        return null;
//    }

}
