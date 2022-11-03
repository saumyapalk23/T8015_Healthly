package com.nighthawk.spring_portfolio.mvc.Blog.Login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class AccountService {
   @Autowired
   private AccountRepository accountRepository;
   
   public Account save(Account account){
    return accountRepository.save(account);
   }

   @ResponseStatus(value=HttpStatus.OK)
   public Optional<Account> findByEmail(String email){
      return accountRepository.findOneByEmail(email);
      
   }
}
