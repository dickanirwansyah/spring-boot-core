package com.boot.ajax.springbootajax.dao;

import com.boot.ajax.springbootajax.entity.Matakuliah;
import com.boot.ajax.springbootajax.model.MatakuliahModel;
import com.boot.ajax.springbootajax.repo.MatakuliahRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class MatakuliahDaoImpl implements MatakuliahDao {

    @Autowired
    private MatakuliahRepo matakuliahRepo;

    @Override
    public Matakuliah createdMatakuliah(Matakuliah matakuliah) {
        if(matakuliah.getIdmatakuliah()!=null){
            matakuliahRepo.save(matakuliah);
        }else{
            matakuliahRepo.save(matakuliah);
        }
        return matakuliah;
    }

    @Override
    public List<Matakuliah> listMatakuliah() {
        return matakuliahRepo.findAll();
    }

    @Override
    public Matakuliah findId(String idmatakuliah) {
        return matakuliahRepo.getOne(idmatakuliah);
    }

    @Override
    public MatakuliahModel findIdmatakuliah(String idmatakuliah) {
        Matakuliah matakuliah = this.findId(idmatakuliah);
        if(matakuliah == null){
            return null;
        }else{
            return new MatakuliahModel(matakuliah.getIdmatakuliah(),
                    matakuliah.getNama(), matakuliah.getSks(), matakuliah.getJurusan());
        }
    }
}
