package com.boot.ajax.springbootajax.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Getter
@Setter
@Entity
@Table(name = "matakuliah",
        catalog = "spring_boot_buku")
public class Matakuliah implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idmatakuliah;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column(name = "sks", nullable = false)
    private int sks;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idjurusan", nullable = false)
    private Jurusan jurusan;
}
