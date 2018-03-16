package com.boot.ajax.springbootajax.controller;

import com.boot.ajax.springbootajax.entity.Matakuliah;
import com.boot.ajax.springbootajax.entity.MatakuliahDosen;
import com.boot.ajax.springbootajax.model.MatakuliahModel;
import com.boot.ajax.springbootajax.service.MatakuliahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerMatakuliah {

    @Autowired
    private MatakuliahService matakuliahService;


    @PostMapping(value = "/api/matakuliah/create")
    public ResponseEntity<Matakuliah> created(@RequestBody Matakuliah matakuliah){
        return Optional.ofNullable(matakuliahService.createMatakuliah(matakuliah))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Matakuliah>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "/api/matakuliah/get")
    public ResponseEntity<MatakuliahModel> getId(@RequestParam(value = "idmatakuliah")String idmatakuliah){
        return Optional.ofNullable(matakuliahService.findIdmatakuliah(idmatakuliah))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<MatakuliahModel>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "/api/matakuliah")
    public ResponseEntity<List<Matakuliah>> listMatakuliah(){
        return Optional.ofNullable(matakuliahService.listMatakuliah())
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Matakuliah>>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/api/matakuliah/update")
    public ResponseEntity<Matakuliah> updated(@RequestBody Matakuliah matakuliah){
        return Optional.ofNullable(matakuliahService.createMatakuliah(matakuliah))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<Matakuliah>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "/api/matakuliah/dosen")
    public ResponseEntity<List<MatakuliahDosen>> listMatkulDosen(){
        return Optional.ofNullable(matakuliahService.listMatakuliahDosen())
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<List<MatakuliahDosen>>(HttpStatus.BAD_REQUEST));
    }


}
