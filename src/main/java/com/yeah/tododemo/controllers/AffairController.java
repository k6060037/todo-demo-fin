package com.yeah.tododemo.controllers;

import com.yeah.tododemo.entity.Affair;
import com.yeah.tododemo.entity.DelAffair;
import com.yeah.tododemo.repository.AffairRepository;
import com.yeah.tododemo.repository.DelAffairRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController("/")
@RequiredArgsConstructor
public class AffairController {
    private final AffairRepository affairRepository;
    private final DelAffairRepository delAffairRepository;

    @GetMapping(value = "affair")
    public Affair getAffair(@RequestParam(name = "id") UUID id) {
        return affairRepository.findById(id).orElseThrow();
    }

    @GetMapping(value = "add_affair")
    public Affair addAffair(@RequestParam(name = "description") String affairDescription,
                          @RequestParam(value = "priority", defaultValue = "1") int affairPriority){
        Affair affair = new Affair();
        affair.setAffairDescription(affairDescription);
        affair.setAffairPriority(affairPriority);
        affairRepository.save(affair);
        return affair;
    }

    @GetMapping(value = "affairs")
    public List<Affair> getAllAffairs(){
        return affairRepository.findAll();

    }

    @GetMapping(value = "delete_affair")
    public Affair copyAffair(@RequestParam(name = "id") UUID id) {
        Affair affair = affairRepository.findById(id).orElseThrow();
        affairRepository.delete(affair);
        DelAffair delAffair = new DelAffair();
        delAffair.setAffairDescription(affair.getAffairDescription());
        delAffair.setAffairPriority(affair.getAffairPriority());
        delAffair.setId(affair.getId());
        delAffairRepository.save(delAffair);
        return affair;
    }

    @GetMapping(value = "deleted_affairs")
    public List<DelAffair> getAllDelAffairs(){
        return delAffairRepository.findAll();

    }

}
