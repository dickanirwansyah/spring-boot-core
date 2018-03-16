package com.boot.ajax.springbootajax.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
@Table(name = "matakuliah_dosen",
        catalog = "spring_boot_buku")
public class MatakuliahDosen implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmatdos;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "tanggal", nullable = false)
    private Date tanggal;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinTable(name = "matdos", joinColumns =
    @JoinColumn(name = "idmatdos"), inverseJoinColumns =
    @JoinColumn(name = "idmatakuliah"))
    private Set<Matakuliah> matakuliahs = new HashSet<Matakuliah>();

    @OneToOne
    private Dosen dosen;
}
