package com.boot.ajax.springbootajax.controller;

import com.boot.ajax.springbootajax.entity.Dosen;
import com.boot.ajax.springbootajax.service.DosenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerDosen {

    @Autowired
    private DosenService dosenService;

    @GetMapping(value = "/api/dosen")
    public ResponseEntity<List<Dosen>> listDosen(){
        return Optional.ofNullable(dosenService.listDosen())
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Dosen>>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/api/dosen/create")
    public ResponseEntity<Dosen> created(@RequestBody Dosen dosen){
        return Optional.ofNullable(dosenService.createDosen(dosen))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Dosen>(HttpStatus.BAD_REQUEST));
    }


}
