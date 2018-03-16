package com.boot.ajax.springbootajax.service;

import com.boot.ajax.springbootajax.dao.DosenDao;
import com.boot.ajax.springbootajax.entity.Dosen;
import com.boot.ajax.springbootajax.model.DosenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DosenServiceImpl implements DosenService {

    @Autowired
    private DosenDao dosenDao;

    @Override
    public Dosen createDosen(Dosen dosen) {
        return dosenDao.createDosen(dosen);
    }

    @Override
    public List<Dosen> listDosen() {
        return dosenDao.listDosen();
    }

    @Override
    public DosenModel findId(String iddosen) {
        return dosenDao.findId(iddosen);
    }
}
