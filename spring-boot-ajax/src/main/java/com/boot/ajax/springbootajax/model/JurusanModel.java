package com.boot.ajax.springbootajax.model;

import com.boot.ajax.springbootajax.entity.Jurusan;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class JurusanModel {

    private String idjurusan;
    private String nama;

    public JurusanModel(Jurusan jurusan){
        this.idjurusan = jurusan.getIdjurusan();
        this.nama = jurusan.getNama();
    }

    public JurusanModel(String idjurusan, String nama){
        this.idjurusan = idjurusan;
        this.nama = nama;
    }

    public String getIdjurusan(){
        return idjurusan;
    }

    public void setIdjurusan(String idjurusan){
        this.idjurusan = idjurusan;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }
}
