package com.example.thi_cuoi_module.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maDanhMuc;
    private String tenDanhMuc;

    @OneToMany(mappedBy = "danhMuc")
    private Set<TinTuc> tinTucSet;

    public DanhMuc() {
    }

    public Integer getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(Integer maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public Set<TinTuc> getTinTucSet() {
        return tinTucSet;
    }

    public void setTinTucSet(Set<TinTuc> tinTucSet) {
        this.tinTucSet = tinTucSet;
    }
}
