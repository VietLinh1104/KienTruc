package com.example.KienTruc.Models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_SanPham;
    private int id_DanhMuc;
    private int id_GiaSanPham;
    private String thuongHieu;
    private String moTa;
    private double tonKho;
    private Date ngayTao;
    private Date ngayCapNhat;

    public Product() {
    }

    public Product(int id_SanPham, int id_DanhMuc, int id_GiaSanPham, String thuongHieu, String moTa, double tonKho, Date ngayTao, Date ngayCapNhat) {
        this.id_SanPham = id_SanPham;
        this.id_DanhMuc = id_DanhMuc;
        this.id_GiaSanPham = id_GiaSanPham;
        this.thuongHieu = thuongHieu;
        this.moTa = moTa;
        this.tonKho = tonKho;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }

    public int getId_SanPham() {
        return id_SanPham;
    }

    public void setId_SanPham(int id_SanPham) {
        this.id_SanPham = id_SanPham;
    }

    public int getId_DanhMuc() {
        return id_DanhMuc;
    }

    public void setId_DanhMuc(int id_DanhMuc) {
        this.id_DanhMuc = id_DanhMuc;
    }

    public int getId_GiaSanPham() {
        return id_GiaSanPham;
    }

    public void setId_GiaSanPham(int id_GiaSanPham) {
        this.id_GiaSanPham = id_GiaSanPham;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getTonKho() {
        return tonKho;
    }

    public void setTonKho(double tonKho) {
        this.tonKho = tonKho;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    @Override
    public String toString() {
        return "Product{" + "id_SanPham=" + id_SanPham + ", id_DanhMuc=" + id_DanhMuc + ", id_GiaSanPham=" + id_GiaSanPham + ", thuongHieu=" + thuongHieu + ", moTa=" + moTa + ", tonKho=" + tonKho + ", ngayTao=" + ngayTao + ", ngayCapNhat=" + ngayCapNhat + '}';
    }



}
