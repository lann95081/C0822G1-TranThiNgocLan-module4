package com.example.thi_cuoi_module.service.impl;

import com.example.thi_cuoi_module.model.DanhMuc;
import com.example.thi_cuoi_module.repository.IDanhMucRepository;
import com.example.thi_cuoi_module.service.IDanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhMucService implements IDanhMucService {
    @Autowired
    private IDanhMucRepository iDanhMucRepository;

    @Override
    public List<DanhMuc> findAll() {
        return iDanhMucRepository.findAll();
    }
}
