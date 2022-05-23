package com.investree.demo.repository;

import com.investree.demo.model.Payment_history;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Payment_historyRepository extends PagingAndSortingRepository<Payment_history, Long> {
}
