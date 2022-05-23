package com.investree.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "transaksi")
public class Transaksi implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    @JoinColumn(name = "id_peminjam", referencedColumnName = "id")
    private Users users_peminjam;


    @OneToOne
    @JoinColumn(name = "id_meminjam", referencedColumnName = "id")
    private Users users_meminjam;

    @Column(name = "tenor")
    private Integer tenor;

    @Column(name = "total_pinjaman")
    private Double total_pinjaman;

    @Column(name = "bunga_persen")
    private Double bunga_persen;

    @Column(name = "status")
    private String status;

    public Transaksi(){

    }

    public Transaksi(Users users_peminjam, Users users_meminjam, Integer tenor, Double total_pinjaman, Double bunga_persen, String status) {
        this.users_peminjam = users_peminjam;
        this.users_meminjam = users_meminjam;
        this.tenor = tenor;
        this.total_pinjaman = total_pinjaman;
        this.bunga_persen = bunga_persen;
        this.status = status;
    }

    public Users getUsers_peminjam() {
        return users_peminjam;
    }

    public void setUsers_peminjam(Users users_peminjam) {
        this.users_peminjam = users_peminjam;
    }

    public Users getUsers_meminjam() {
        return users_meminjam;
    }

    public void setUsers_meminjam(Users users_meminjam) {
        this.users_meminjam = users_meminjam;
    }

    public Integer getTenor() {
        return tenor;
    }

    public void setTenor(Integer tenor) {
        this.tenor = tenor;
    }

    public Double getTotal_pinjaman() {
        return total_pinjaman;
    }

    public void setTotal_pinjaman(Double total_pinjaman) {
        this.total_pinjaman = total_pinjaman;
    }

    public Double getBunga_persen() {
        return bunga_persen;
    }

    public void setBunga_persen(Double bunga_persen) {
        this.bunga_persen = bunga_persen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
