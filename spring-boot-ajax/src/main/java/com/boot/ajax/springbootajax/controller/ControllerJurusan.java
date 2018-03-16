package com.boot.ajax.springbootajax.controller;

import com.boot.ajax.springbootajax.entity.Jurusan;
import com.boot.ajax.springbootajax.model.JurusanModel;
import com.boot.ajax.springbootajax.service.JurusanService;
import com.boot.ajax.springbootajax.utils.JurusanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerJurusan {

    @Autowired
    private JurusanService jurusanService;

    @GetMapping(value = "/api/jurusan")
    public ResponseEntity<List<Jurusan>> getList(){
        return Optional.ofNullable(jurusanService.listJurusan())
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Jurusan>>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/api/jurusan/{idjurusan}")
    public ResponseEntity<JurusanModel> getId(@PathVariable String idjurusan){
        return Optional.ofNullable(jurusanService.findId(idjurusan))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<JurusanModel>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/api/jurusan/create")
    public ResponseEntity<Jurusan> getCreate(@RequestBody Jurusan jurusan){
        return Optional.ofNullable(jurusanService.createJurusan(jurusan))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Jurusan>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "/api/jurusan/by")
    public ResponseEntity<Jurusan> getByNama(@RequestParam(value = "nama")String nama){
        return Optional.ofNullable(jurusanService.findByNama(nama))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<Jurusan>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/api/jurusan/created")
    public ResponseEntity<Jurusan> created(@RequestBody JurusanUtils jurusanUtils){
        return Optional.ofNullable(jurusanService.createJurusanByModel(jurusanUtils))
                .map(jurusan -> new ResponseEntity<>(jurusan, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Jurusan>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/api/jurusan/updated")
    public ResponseEntity<Jurusan> updated(@RequestBody JurusanUtils jurusanUtils){
        return Optional.ofNullable(jurusanService.updateJurusanByModel(jurusanUtils))
                .map(jurusan -> new ResponseEntity<>(jurusan, HttpStatus.OK))
                .orElse(new ResponseEntity<Jurusan>(HttpStatus.BAD_REQUEST));
    }
}
