package com.boot.ajax.springbootajax.dao;

import com.boot.ajax.springbootajax.entity.Matakuliah;
import com.boot.ajax.springbootajax.model.MatakuliahModel;

import java.util.List;

public interface MatakuliahDao {

    Matakuliah createdMatakuliah(Matakuliah matakuliah);

    List<Matakuliah> listMatakuliah();

    Matakuliah findId(String idmatakuliah);


    MatakuliahModel findIdmatakuliah(String idmatakuliah);
}
