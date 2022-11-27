package com.lab.archive.repository;

import com.lab.archive.entity.Dossier;
import java.util.List;

public interface DossierRepository {

    List<Dossier> findAll();

    Dossier findByCardNum(String cardNum);

    void save(Dossier dossier);

    void update(Dossier dossier);
}
