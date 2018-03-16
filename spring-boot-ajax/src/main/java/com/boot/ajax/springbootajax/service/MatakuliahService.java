package com.boot.ajax.springbootajax.service;

import com.boot.ajax.springbootajax.entity.Matakuliah;
import com.boot.ajax.springbootajax.entity.MatakuliahDosen;
import com.boot.ajax.springbootajax.model.MatakuliahModel;

import java.util.List;

public interface MatakuliahService {

    Matakuliah createMatakuliah(Matakuliah matakuliah);

    List<Matakuliah> listMatakuliah();

    MatakuliahModel findIdmatakuliah(String idmatakuliah);


    List<MatakuliahDosen> listMatakuliahDosen();
}
