package com.boot.ajax.springbootajax.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "jurusan",
        catalog = "spring_boot_buku")
public class Jurusan implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idjurusan;

    @Column(name = "nama", nullable = false)
    private String nama;


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
