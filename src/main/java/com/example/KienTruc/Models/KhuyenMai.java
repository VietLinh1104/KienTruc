package com.example.KienTruc.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "khuyenmai")
public class KhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_khuyen_mai")
    private Long idKhuyenMai;

    @ManyToOne
    @JoinColumn(name = "id_san_pham", nullable = false)
    private SanPham sanPham;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    // Getters and Setters

    public KhuyenMai() {
    }

    public KhuyenMai(Long idKhuyenMai, SanPham sanPham, LocalDate startDate, LocalDate endDate) {
        this.idKhuyenMai = idKhuyenMai;
        this.sanPham = sanPham;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getIdKhuyenMai() {
        return idKhuyenMai;
    }

    public void setIdKhuyenMai(Long idKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
