package com.example.thi_cuoi_module.repository;

import com.example.thi_cuoi_module.model.TinTuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ITinTucRepository extends JpaRepository<TinTuc, Integer> {
    @Query(value = "select * from tin_tuc where trang_thai = false", nativeQuery = true)
    List<TinTuc> findAll();

    @Modifying
    @Query(value = "update tin_tuc set trang_thai = true where ma_tin_tuc = :ma", nativeQuery = true)
    void deleteLogical(@Param("ma") Integer ma);

    List<TinTuc> findByTieuDeContaining(String tieuDe);
}
