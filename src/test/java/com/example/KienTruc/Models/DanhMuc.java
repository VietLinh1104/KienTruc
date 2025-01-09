package com.example.KienTruc.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_DanhMuc;
    private String tenDanhMuc;
    private String moTa;
    private Date ngayTao;
    private Date ngayCapNhat;

    public DanhMuc() {
    }

    public DanhMuc(int id_DanhMuc, String tenDanhMuc, String moTa, Date ngayTao, Date ngayCapNhat) {
        this.id_DanhMuc = id_DanhMuc;
        this.tenDanhMuc = tenDanhMuc;
        this.moTa = moTa;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }

    public int getId_DanhMuc() {
        return id_DanhMuc;
    }

    public void setId_DanhMuc(int id_DanhMuc) {
        this.id_DanhMuc = id_DanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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
        return "DanhMuc{" + "id_DanhMuc=" + id_DanhMuc + ", tenDanhMuc=" + tenDanhMuc + ", moTa=" + moTa + ", ngayTao=" + ngayTao + ", ngayCapNhat=" + ngayCapNhat + '}';
    }


}