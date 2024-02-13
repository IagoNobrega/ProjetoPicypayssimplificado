package com.ProjetoPicypaysimplificado.repositaries;

import com.ProjetoPicypaysimplificado.domin.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRespository extends JpaRepository<Transaction, Long>{
}
