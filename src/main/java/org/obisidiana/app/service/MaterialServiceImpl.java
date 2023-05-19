package org.obisidiana.app.service;

import lombok.RequiredArgsConstructor;
import org.obisidiana.app.entity.Material;
import org.obisidiana.app.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialRepository materialRepository;

    @Override
    public Material getMaterial(Long id) {
        return materialRepository.findById(id).orElse(null);
    }
}
