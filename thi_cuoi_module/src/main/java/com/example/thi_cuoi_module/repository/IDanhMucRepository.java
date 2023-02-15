package com.example.thi_cuoi_module.repository;

import com.example.thi_cuoi_module.model.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDanhMucRepository extends JpaRepository<DanhMuc, Integer> {
}
