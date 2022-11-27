package com.lab.archive.service;

import com.lab.archive.entity.Dossier;
import java.util.List;

public interface DossierService {

    List<Dossier> findAll();

    void add(Dossier dossier);

    void update(Dossier dossier);
}
