package com.example.SwaggerApiExposer.Service;

import java.util.List;

import com.example.SwaggerApiExposer.ExceptionHandling.ItemExistsException;
import com.example.SwaggerApiExposer.ExceptionHandling.ItemNotFoundException;
import com.example.SwaggerApiExposer.ExceptionHandling.NegativeQuantityException;
import com.example.SwaggerApiExposer.Model.Item;
import org.springframework.http.ResponseEntity;

/*
This is the service interface which holds all the implementations a basic
Item class should implement.
 */
public interface ItemService {
    public List<Item> getListItems();

    public ResponseEntity<?> addItem(Long amount, Long inventory_code, String name) throws ItemExistsException;

    public ResponseEntity<Item> getItem(String item_no) throws  ItemNotFoundException;

    public ResponseEntity<?> withdrawQuantity(String item_no, Long quantity) throws NegativeQuantityException, ItemNotFoundException;

    public ResponseEntity<?> deleteItem(String item_no) throws ItemNotFoundException;

    public ResponseEntity<?> depositQuantity(String item_no, Long quantity) throws ItemNotFoundException;


}
