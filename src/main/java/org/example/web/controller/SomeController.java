package org.example.web.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/some")
public class SomeController {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static class Item{
        private Integer id;
        private String name;
    }

    AtomicInteger id = new AtomicInteger(0);
    public List<Item> list = new ArrayList<>();

    @GetMapping("")
    public List<Item> get(){
        return list;
    }


    // may or may not Idempotent
    @PostMapping("")
    public Item post(@RequestBody Item i){
        var item = Item.builder().id(id.incrementAndGet()).name(i.name).build();
        list.add(item);
        return item;
    }

    // Idempotent
    @PutMapping("/{id}")
    public Item put(@PathVariable Integer id ,@RequestBody Item i){
        var item = Item.builder().id(id).name(i.getName()).build();
        list = list.stream().filter(it->!it.getId().equals(id)).collect(Collectors.toList());
        list.add(item);
        return item;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        list = list.stream().filter(it->!it.id.equals(id)).toList();
        return "OK";
    }


}
