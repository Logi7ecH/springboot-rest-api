package com.investree.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.investree.demo.model.Transaksi;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface TransaksiRepository extends PagingAndSortingRepository<Transaksi, Long> {
    @Query("SELECT tf from Transaksi tf WHERE tf.id = :id")
    public Transaksi getByID(@Param("id") Long id);

    @Query("SELECT tf from Transaksi tf")
    Page<Transaksi> getList(Pageable pageable);

    @Query("SELECT tf from Transaksi tf WHERE tf.status = :status")
    Page <Transaksi> getByStatus(@Param("status") String status, Pageable pageable);
}
