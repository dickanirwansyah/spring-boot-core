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
@Table(name = "dosen",
        catalog = "spring_boot_buku")
public class Dosen implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String iddosen;

    @Column(name = "nama", nullable = false)
    private String nama;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idjurusan", nullable = false)
    private Jurusan jurusan;
}
