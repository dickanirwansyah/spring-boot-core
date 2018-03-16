package com.boot.ajax.springbootajax.dao;

import com.boot.ajax.springbootajax.entity.Jurusan;
import com.boot.ajax.springbootajax.model.JurusanModel;
import com.boot.ajax.springbootajax.utils.JurusanUtils;

import java.util.List;

public interface JurusanDao {

    Jurusan findId(String idjurusan);

    JurusanModel findById(String idjurusan);

    Jurusan createdJurusanByModel(JurusanUtils jurusanUtils);

    Jurusan updateJurusanByModel(JurusanUtils jurusanUtils);

    List<Jurusan> listJurusan();

    Jurusan findByNama(String nama);

    Jurusan createJurusan(Jurusan jurusan);
}
