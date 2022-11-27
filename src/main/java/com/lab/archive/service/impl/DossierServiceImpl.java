package com.lab.archive.service.impl;

import com.lab.archive.entity.Dossier;
import com.lab.archive.repository.DossierRepository;
import com.lab.archive.service.DossierService;
import java.util.List;

public class DossierServiceImpl implements DossierService {
    private final DossierRepository dossierRepository;

    public DossierServiceImpl(DossierRepository dossierRepository) {
        this.dossierRepository = dossierRepository;
    }

    @Override
    public List<Dossier> findAll() {
        return dossierRepository.findAll();
    }

    @Override
    public void add(Dossier dossier) {
        dossierRepository.save(dossier);
    }

    @Override
    public void update(Dossier dossier) {
        dossierRepository.update(dossier);
    }
}
