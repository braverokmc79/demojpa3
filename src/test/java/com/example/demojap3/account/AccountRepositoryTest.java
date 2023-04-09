package com.example.demojap3.account;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@SpringBootTest
@Transactional
@Rollback(value = false)
class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void crud(){
        QAccount account=QAccount.account;

        BooleanExpression predicate = account.firstName.containsIgnoreCase("keesun").and(account.lastName.startsWith("baik"));

        Optional<Account> one= accountRepository.findOne(predicate);
        Assertions.assertThat(one).isEmpty();
    }










}