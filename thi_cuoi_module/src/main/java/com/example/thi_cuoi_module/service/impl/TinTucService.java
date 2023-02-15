package com.example.thi_cuoi_module.service.impl;

import com.example.thi_cuoi_module.model.TinTuc;
import com.example.thi_cuoi_module.repository.ITinTucRepository;
import com.example.thi_cuoi_module.service.ITinTucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TinTucService implements ITinTucService {
    @Autowired
    private ITinTucRepository iTinTucRepository;

    @Override
    public List<TinTuc> findAll() {
        return iTinTucRepository.findAll();
    }

    @Override
    public void save(TinTuc tinTuc) {
        iTinTucRepository.save(tinTuc);
    }

    @Override
    public Optional<TinTuc> findById(Integer ma) {
        return iTinTucRepository.findById(ma);
    }

    @Override
    public void deleteLogical(Integer ma) {
        iTinTucRepository.deleteLogical(ma);
    }

    @Override
    public List<TinTuc> searchByTieuDe(String tieuDe) {
        return iTinTucRepository.findByTieuDeContaining(tieuDe);
    }
}
