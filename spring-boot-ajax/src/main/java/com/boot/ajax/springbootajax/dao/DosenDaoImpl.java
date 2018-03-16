package com.boot.ajax.springbootajax.dao;

import com.boot.ajax.springbootajax.entity.Dosen;
import com.boot.ajax.springbootajax.model.DosenModel;
import com.boot.ajax.springbootajax.repo.DosenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class DosenDaoImpl implements DosenDao{

    @Autowired
    private DosenRepo dosenRepo;

    @Override
    public Dosen createDosen(Dosen dosen) {
        if(dosen.getIddosen()!=null){
            dosenRepo.save(dosen);
        }else{
            dosenRepo.save(dosen);
        }
        return dosen;
    }

    @Override
    public List<Dosen> listDosen() {
        return dosenRepo.findAll();
    }

    @Override
    public Dosen getId(String iddosen) {
        return dosenRepo.getOne(iddosen);
    }

    @Override
    public DosenModel findId(String iddosen) {
        Dosen dosen = this.getId(iddosen);
        if(dosen!=null){
            return null;
        }else{
            return new DosenModel(dosen.getIddosen(),
                    dosen.getNama(), dosen.getJurusan());
        }
    }
}
