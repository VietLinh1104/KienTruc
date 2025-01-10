package com.example.KienTruc.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "nhacungcap")
public class NhaCungCap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nha_cung_cap")
    private Long idNhaCungCap;

    @Column(name = "ten_nha_cung_cap", nullable = false)
    private String tenNhaCungCap;

    // Getters and Setters

    public NhaCungCap() {
    }

    public NhaCungCap(Long idNhaCungCap, String tenNhaCungCap) {
        this.idNhaCungCap = idNhaCungCap;
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public Long getIdNhaCungCap() {
        return idNhaCungCap;
    }

    public void setIdNhaCungCap(Long idNhaCungCap) {
        this.idNhaCungCap = idNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }
}
