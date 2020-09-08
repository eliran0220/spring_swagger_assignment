package com.example.SwaggerApiExposer.Etc;

import com.example.SwaggerApiExposer.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String>{

}