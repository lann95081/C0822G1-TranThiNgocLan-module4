package com.example.thi_cuoi_module.model;

import javax.persistence.*;

@Entity
public class TinTuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maTinTuc;
    private String tieuDe;
    private String noiDung;
    private String ngayDangTin;
    private String phongVien;
    private boolean trangThai;

    @ManyToOne
    @JoinColumn(name = "ma_danh_muc", referencedColumnName = "maDanhMuc")
    private DanhMuc danhMuc;

    public TinTuc() {
    }

    public Integer getMaTinTuc() {
        return maTinTuc;
    }

    public void setMaTinTuc(Integer maTinTuc) {
        this.maTinTuc = maTinTuc;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public String getNgayDangTin() {
        return ngayDangTin;
    }

    public void setNgayDangTin(String ngayDangTin) {
        this.ngayDangTin = ngayDangTin;
    }

    public String getPhongVien() {
        return phongVien;
    }

    public void setPhongVien(String phongVien) {
        this.phongVien = phongVien;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }
}
