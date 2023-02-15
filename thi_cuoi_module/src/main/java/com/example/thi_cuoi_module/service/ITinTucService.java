package com.example.thi_cuoi_module.service;

import com.example.thi_cuoi_module.model.TinTuc;

import java.util.List;
import java.util.Optional;

public interface ITinTucService {
    List<TinTuc> findAll();

    void save(TinTuc tinTuc);

    Optional<TinTuc> findById(Integer ma);

    void deleteLogical(Integer ma);

    List<TinTuc> searchByTieuDe(String tieuDe);
}
