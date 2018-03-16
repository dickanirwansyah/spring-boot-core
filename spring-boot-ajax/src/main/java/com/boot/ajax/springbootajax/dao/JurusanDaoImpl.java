package com.boot.ajax.springbootajax.dao;

import com.boot.ajax.springbootajax.entity.Jurusan;
import com.boot.ajax.springbootajax.model.JurusanModel;
import com.boot.ajax.springbootajax.repo.JurusanRepo;
import com.boot.ajax.springbootajax.utils.JurusanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class JurusanDaoImpl implements JurusanDao{

    private final Logger log  = LoggerFactory.getLogger(JurusanDao.class);

    @Autowired
    private JurusanRepo jurusanRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Jurusan findId(String idjurusan) {
        return jurusanRepo.getOne(idjurusan);
    }

    @Override
    public JurusanModel findById(String idjurusan) {
        Jurusan jurusan = this.findId(idjurusan);
        if(jurusan == null){
            log.debug("JURUSAN BY ID NOT FOUND");
            return null;
        }else{
            return new JurusanModel(jurusan.getIdjurusan(), jurusan.getNama());
        }
    }

    @Override
    public Jurusan createdJurusanByModel(JurusanUtils jurusanUtils) {

        String idjurusan = jurusanUtils.getIdjurusan();
        Jurusan jurusan = null;
        boolean isNew = false;

        //handling save
        if(idjurusan==null){
            isNew = true;
        }

        jurusan = new Jurusan();
        jurusan.setNama(jurusanUtils.getNama());

        if(isNew){
            jurusanRepo.save(jurusan);
        }

        return jurusan;
    }

    @Override
    public Jurusan updateJurusanByModel(JurusanUtils jurusanUtils) {

        String idjurusan = jurusanUtils.getIdjurusan();
        Jurusan jurusan = null;

        if(idjurusan != null){
            jurusan = this.findId(idjurusan);
        }

        jurusan.setIdjurusan(jurusanUtils.getIdjurusan());
        jurusan.setNama(jurusanUtils.getNama());

        return jurusanRepo.save(jurusan);
    }


    @Override
    public List<Jurusan> listJurusan() {
        log.debug("ACCESS LIST JURUSAN");
        return jurusanRepo.findAll();
    }

    @Override
    public Jurusan findByNama(String nama) {
        log.info("ACCESS GET NAMA");
        String jpql="SELECT j FROM Jurusan AS j WHERE j.nama=:nama";
        return (Jurusan) entityManager.createQuery(jpql)
                .setParameter("nama", nama).getSingleResult();
    }

    @Override
    public Jurusan createJurusan(Jurusan jurusan) {
        if(jurusan.getIdjurusan() != null){
            jurusanRepo.save(jurusan);
        }else{
            jurusanRepo.save(jurusan);
        }
        return jurusan;
    }
}
