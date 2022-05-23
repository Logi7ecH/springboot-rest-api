package com.investree.demo.repository;
import com.investree.demo.model.Users_detail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Users_detailRepository extends PagingAndSortingRepository<Users_detail, Long> {
}
