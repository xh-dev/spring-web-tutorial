package org.example.web.controller;

import org.example.web.domain.Item;
import org.example.web.repo.ItemRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/v1/some")
@CrossOrigin(origins = "http://localhost:4200")
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
    public Item delete(@PathVariable Integer id){
        Optional<Item> itemOpt = itemRepo.findById(id);
        if(itemOpt.isPresent()){
            itemRepo.delete(itemOpt.get());
            return itemOpt.get();
        } else {
            return Item.builder().id(id).name("").build();
        }
    }


}
