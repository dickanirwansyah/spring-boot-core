package com.boot.ajax.springbootajax.service;

import com.boot.ajax.springbootajax.dao.JurusanDao;
import com.boot.ajax.springbootajax.entity.Jurusan;
import com.boot.ajax.springbootajax.model.JurusanModel;
import com.boot.ajax.springbootajax.utils.JurusanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JurusanServiceImpl implements JurusanService{

    @Autowired
    private JurusanDao jurusanDao;

    @Override
    public Jurusan createJurusan(Jurusan jurusan) {
        return jurusanDao.createJurusan(jurusan);
    }

    @Override
    public List<Jurusan> listJurusan() {
        return jurusanDao.listJurusan();
    }

    @Override
    public JurusanModel findId(String idjurusan) {
        return jurusanDao.findById(idjurusan);
    }

    @Override
    public Jurusan createJurusanByModel(JurusanUtils jurusanUtils) {
        return jurusanDao.createdJurusanByModel(jurusanUtils);
    }

    @Override
    public Jurusan updateJurusanByModel(JurusanUtils jurusanUtils) {
        return jurusanDao.updateJurusanByModel(jurusanUtils);
    }


    @Override
    public Jurusan findByNama(String nama) {
        return jurusanDao.findByNama(nama);
    }
}
