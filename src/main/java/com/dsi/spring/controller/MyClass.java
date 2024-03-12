package com.dsi.spring.controller;

import com.dsi.spring.model.Car;
import com.dsi.spring.model.Jurnal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jurnal")
public class MyClass {


    @Autowired
    private Car car;

    private Map<Long,Jurnal> jurnalMap = new HashMap<>();

    @GetMapping("abc")
    public List<Jurnal> sayHello(){
        return new ArrayList<>(jurnalMap.values());
    }

    @PostMapping("abc")
    public boolean createJurnal(@RequestBody Jurnal data){
        jurnalMap.put(data.getId(),data);
        return true;
    }

    @GetMapping("/id/{id}")
    public Jurnal getById(@PathVariable long id){
        return jurnalMap.get(id);
    }

    @GetMapping("car")
    public String car(){
        return car.fun();
    }
}
