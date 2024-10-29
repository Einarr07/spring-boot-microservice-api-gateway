package com.einarr07.spring_boot_microservice_3_api_gateway.controller;

import com.einarr07.spring_boot_microservice_3_api_gateway.request.InmuebleServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gateway/inmueble")
public class InmuebleController {

    @Autowired
    private InmuebleServiceRequest inmuebleServiceRequest;

    @GetMapping
    public ResponseEntity<?> getAllInmuebles(){
        return ResponseEntity.ok(inmuebleServiceRequest.getAllInmuebles());
    }

    @PostMapping
    public ResponseEntity<?> saveInmueble(@RequestBody Object inmueble){
        return new ResponseEntity<>(inmuebleServiceRequest.saveInmueble(inmueble), HttpStatus.CREATED);
    }

    @DeleteMapping("/{inmuebleId}")
    public ResponseEntity<?> deleteInmueble(@PathVariable("inmuebleId") Long inmuebleId){
        inmuebleServiceRequest.deleteInmueble(inmuebleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
