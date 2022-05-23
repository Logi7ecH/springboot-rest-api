package com.investree.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "payment_history")
public class Payment_history implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @OneToOne
    @JoinColumn(name = "id_transaksi", referencedColumnName = "id")
    private Transaksi transaksi;

    @Column(name = "pembayaran_ke")
    private Integer pembayaran_ke;

    @Column(name = "jumlah")
    private Double jumlah;

    @Column(name = "bukti_pembayaran")
    private String bukti_pembayaran;

    public Payment_history(){

    }

    public Payment_history(Transaksi transaksi, Integer pembayaran_ke, Double jumlah, String bukti_pembayaran) {
        this.transaksi = transaksi;
        this.pembayaran_ke = pembayaran_ke;
        this.jumlah = jumlah;
        this.bukti_pembayaran = bukti_pembayaran;
    }

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public Integer getPembayaran_ke() {
        return pembayaran_ke;
    }

    public void setPembayaran_ke(Integer pembayaran_ke) {
        this.pembayaran_ke = pembayaran_ke;
    }

    public Double getJumlah() {
        return jumlah;
    }

    public void setJumlah(Double jumlah) {
        this.jumlah = jumlah;
    }

    public String getBukti_pembayaran() {
        return bukti_pembayaran;
    }

    public void setBukti_pembayaran(String bukti_pembayaran) {
        this.bukti_pembayaran = bukti_pembayaran;
    }
}
