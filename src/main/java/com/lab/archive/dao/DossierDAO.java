package com.lab.archive.dao;

import com.lab.archive.dao.exception.DAOException;
import com.lab.archive.criteria.Criteria;
import com.lab.archive.entity.Dossier;
import java.util.List;

public interface DossierDAO {
    List<Dossier> find(Criteria criteria) throws DAOException;

    void save(Dossier dossier) throws DAOException;

    void update(Dossier dossier) throws DAOException;
}
