package com.boot.ajax.springbootajax.model;

import com.boot.ajax.springbootajax.entity.Jurusan;
import com.boot.ajax.springbootajax.entity.Matakuliah;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MatakuliahModel {

    private String idmatakuliah;
    private String nama;
    private int sks;
    private Jurusan jurusan;

    public MatakuliahModel(Matakuliah matakuliah){
        this.idmatakuliah = matakuliah.getIdmatakuliah();
        this.nama = matakuliah.getNama();
        this.sks = matakuliah.getSks();
        this.jurusan = matakuliah.getJurusan();
    }

    public MatakuliahModel(String idmatakuliah, String nama, int sks, Jurusan jurusan){
        this.idmatakuliah = idmatakuliah;
        this.nama = nama;
        this.sks = sks;
        this.jurusan = jurusan;
    }
}
