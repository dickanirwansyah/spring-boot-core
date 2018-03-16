package com.boot.ajax.springbootajax.model;

import com.boot.ajax.springbootajax.entity.Dosen;
import com.boot.ajax.springbootajax.entity.Jurusan;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class DosenModel {

    private String iddosen;
    private String nama;
    private Jurusan jurusan;

    public DosenModel(Dosen dosen){
        this.iddosen = dosen.getIddosen();
        this.nama = dosen.getNama();
        this.jurusan = dosen.getJurusan();
    }

    public DosenModel(String iddosen, String nama, Jurusan jurusan){
        this.iddosen = iddosen;
        this.nama = nama;
        this.jurusan = jurusan;
    }
}
