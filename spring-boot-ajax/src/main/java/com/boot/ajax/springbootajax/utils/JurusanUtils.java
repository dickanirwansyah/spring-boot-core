package com.boot.ajax.springbootajax.utils;

import com.boot.ajax.springbootajax.entity.Jurusan;

public class JurusanUtils {

    private String idjurusan;
    private String nama;
    private boolean valid = false;

    public JurusanUtils(){
        this.valid = true;
    }

    public JurusanUtils(Jurusan jurusan){
        this.idjurusan = jurusan.getIdjurusan();
        this.nama = jurusan.getNama();
    }

    public boolean isValid(){
        return valid;
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
