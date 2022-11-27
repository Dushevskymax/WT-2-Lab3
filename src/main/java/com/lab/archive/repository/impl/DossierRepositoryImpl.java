package com.lab.archive.repository.impl;

import com.lab.archive.criteria.Criteria;
import com.lab.archive.dao.DossierDAO;
import com.lab.archive.dao.exception.DAOException;
import com.lab.archive.entity.Dossier;
import com.lab.archive.repository.DossierRepository;
import java.util.List;

public class DossierRepositoryImpl implements DossierRepository {
    private final DossierDAO dossierDAO;

    public DossierRepositoryImpl(DossierDAO dossierDAO) {
        this.dossierDAO = dossierDAO;
    }

    @Override
    public List<Dossier> findAll() {
        try {
            return dossierDAO.find(new Criteria());
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Dossier findByCardNum(String cardNum) {
        var criteria = new Criteria();
        criteria.add("cardNum", cardNum);
        try {
            return dossierDAO.find(criteria).get(0);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Dossier dossier) {
        try {
            dossierDAO.save(dossier);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Dossier dossier) {
        try {
            dossierDAO.update(dossier);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }
}
