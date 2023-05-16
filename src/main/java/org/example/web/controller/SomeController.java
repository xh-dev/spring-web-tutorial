package org.example.web.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.web.domain.Item;
import org.example.web.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/v1/some")
public class SomeController {

    private ItemRepo itemRepo;

    public SomeController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @GetMapping("")
    public List<Item> get(){
        return StreamSupport
                .stream(itemRepo.findAll().spliterator(), false)
                .toList();
    }


    // may or may not Idempotent
    @PostMapping("")
    public Item post(@RequestBody Item i){
        i.setId(null);
        return itemRepo.save(i);
    }

    // Idempotent
    @PutMapping("/{id}")
    public Item put(@PathVariable Integer id ,@RequestBody Item i){
        var item = Item.builder().id(id).name(i.getName()).build();
        return itemRepo.save(item);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        Optional<Item> itemOpt = itemRepo.findById(id);
        if(itemOpt.isPresent()){
            itemRepo.delete(itemOpt.get());
        }
        return "OK";
    }


}
