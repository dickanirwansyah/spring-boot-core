package com.boot.ajax.springbootajax.service;

import com.boot.ajax.springbootajax.entity.Dosen;
import com.boot.ajax.springbootajax.model.DosenModel;

import java.util.List;

public interface DosenService {

    Dosen createDosen(Dosen dosen);

    List<Dosen> listDosen();

    DosenModel findId(String iddosen);

}
