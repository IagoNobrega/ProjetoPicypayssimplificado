package com.ProjetoPicypaysimplificado.services;

import com.ProjetoPicypaysimplificado.domain.transaction.Transaction;
import com.ProjetoPicypaysimplificado.domain.user.User;
import com.ProjetoPicypaysimplificado.dtos.TransactionDTO;
import com.ProjetoPicypaysimplificado.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransactionService {
    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public void createTransaction(TransactionDTO transaction) {
        User sender = this.userService.findUserById(transaction.getSenderId());
        User receiver = this.userService.findUserById(transaction.getReceiverId());

        userService.validateTransaction(sender, transaction.getValue());

        boolean isAuthorized = this.authorizeTransaction(sender, transaction.getValue());
        //TODO: enviar a transação para o banco de transações
        if (!isAuthorized) {
            throw new Exception("Transação não autorizada");
        }

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.getValue());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transaction.getValue()));
        receiver.setBalance(receiver.getBalance().add(transaction.getValue()));

        this.repository.save(newTransaction);
        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);
    }

    public boolean authorizeTransaction(User sender, BigDecimal value) {
        ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity("https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc", Map.class);

        if (authorizationResponse.getStatusCode() == HttpStatus.OK) {
            String message = (String) authorizationResponse.getBody().get("message");
            return "Autorizado".equalsIgnoreCase(message);
        } else {
            return false;
        }
    }
}