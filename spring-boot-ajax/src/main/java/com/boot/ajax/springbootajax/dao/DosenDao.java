package com.boot.ajax.springbootajax.dao;

import com.boot.ajax.springbootajax.entity.Dosen;
import com.boot.ajax.springbootajax.model.DosenModel;

import java.util.List;

public interface DosenDao {

    Dosen createDosen(Dosen dosen);

    List<Dosen> listDosen();

    Dosen getId(String iddosen);

    DosenModel findId(String iddosen);
}
