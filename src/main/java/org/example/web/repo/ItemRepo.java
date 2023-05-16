package org.example.web.repo;

import org.example.web.domain.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepo extends CrudRepository<Item, Integer> {
    List<Item> findAllByName(String name);
}
