package com.yeah.tododemo.controllers;

import com.yeah.tododemo.entity.Affair;
import com.yeah.tododemo.entity.DeletedAffair;
import com.yeah.tododemo.repository.AffairRepository;
import com.yeah.tododemo.repository.DeletedAffairRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController("/")
@RequiredArgsConstructor
public class AffairController {
    private final AffairRepository affairRepository;
    private final DeletedAffairRepository deletedAffairRepository;

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
        return affairRepository.findAll(Sort.by(Sort.Direction.DESC, "affairPriority"));
        //Collections.reverse(affairs);
        //return affairs;
    }

    @GetMapping(value = "delete_affair")
    public Affair copyAffair(@RequestParam(name = "id") UUID id) {
        Affair affair = affairRepository.findById(id).orElseThrow();
        DeletedAffair deletedAffair = new DeletedAffair();
        deletedAffair.setAffairDescription(affair.getAffairDescription());
        deletedAffair.setAffairPriority(affair.getAffairPriority());
        deletedAffair.setId(affair.getId());
        affairRepository.deleteById(affair.getId());
        deletedAffairRepository.save(deletedAffair);
        return affair;
    }

    @GetMapping(value = "deleted_affairs")
    public List<DeletedAffair> deletedAffairs(){
        return deletedAffairRepository.findAll();
    }


}
