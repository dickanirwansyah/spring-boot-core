package com.boot.ajax.springbootajax.service;

import com.boot.ajax.springbootajax.dao.MatakuliahDao;
import com.boot.ajax.springbootajax.dao.MatakuliahDosenDao;
import com.boot.ajax.springbootajax.entity.Matakuliah;
import com.boot.ajax.springbootajax.entity.MatakuliahDosen;
import com.boot.ajax.springbootajax.model.MatakuliahModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MatakuliahServiceImpl implements MatakuliahService{

    @Autowired
    private MatakuliahDao matakuliahDao;

    @Autowired
    private MatakuliahDosenDao matakuliahDosenDao;

    @Override
    public Matakuliah createMatakuliah(Matakuliah matakuliah) {
        return matakuliahDao.createdMatakuliah(matakuliah);
    }

    @Override
    public List<Matakuliah> listMatakuliah() {
        return matakuliahDao.listMatakuliah();
    }

    @Override
    public MatakuliahModel findIdmatakuliah(String idmatakuliah) {
        return matakuliahDao.findIdmatakuliah(idmatakuliah);
    }


    @Override
    public List<MatakuliahDosen> listMatakuliahDosen() {
        return matakuliahDosenDao.getListMatkuldosen();
    }
}
