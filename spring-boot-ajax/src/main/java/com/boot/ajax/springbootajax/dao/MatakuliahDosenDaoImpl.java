package com.boot.ajax.springbootajax.dao;

import com.boot.ajax.springbootajax.entity.Dosen;
import com.boot.ajax.springbootajax.entity.Matakuliah;
import com.boot.ajax.springbootajax.entity.MatakuliahDosen;
import com.boot.ajax.springbootajax.repo.MatakuliahDosenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@Repository
public class MatakuliahDosenDaoImpl implements MatakuliahDosenDao {

    @Autowired
    private MatakuliahDosenRepo matakuliahDosenRepo;

    @Autowired
    private MatakuliahDao matakuliahDao;


    @Override
    public List<MatakuliahDosen> getListMatkuldosen() {
        return matakuliahDosenRepo.findAll();
    }
}
