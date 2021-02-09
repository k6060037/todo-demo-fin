package com.yeah.tododemo.controllers;

import com.yeah.tododemo.entity.Affair;
import com.yeah.tododemo.repository.AffairRepository;
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

}
