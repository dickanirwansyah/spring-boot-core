package com.boot.ajax.springbootajax.service;

import com.boot.ajax.springbootajax.entity.Jurusan;
import com.boot.ajax.springbootajax.model.JurusanModel;
import com.boot.ajax.springbootajax.utils.JurusanUtils;

import java.util.List;

public interface JurusanService {

    Jurusan createJurusan(Jurusan jurusan);

    List<Jurusan> listJurusan();

    JurusanModel findId(String idjurusan);

    Jurusan createJurusanByModel(JurusanUtils jurusanUtils);

    Jurusan updateJurusanByModel(JurusanUtils jurusanUtils);

    Jurusan findByNama(String nama);
}
