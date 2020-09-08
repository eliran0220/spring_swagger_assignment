package com.example.SwaggerApiExposer.Controller;


import java.util.List;

import com.example.SwaggerApiExposer.ExceptionHandling.ItemExistsException;
import com.example.SwaggerApiExposer.ExceptionHandling.ItemNotFoundException;
import com.example.SwaggerApiExposer.ExceptionHandling.NegativeQuantityException;
import com.example.SwaggerApiExposer.Model.Item;
import com.example.SwaggerApiExposer.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * The controller class which takes care of mapping request
 * data to the defined request handler method.
 */
@CrossOrigin
@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/api/items")
    public List<Item> getListItems() {
        List<Item> items = itemService.getListItems();
        return items;
    }


    @PostMapping("/api/items/add")
    public ResponseEntity<?> addItem(Long amount, Long inventory_code, String name) throws ItemExistsException {
        return itemService.addItem(amount, inventory_code, name);
    }

    @GetMapping("/api/items/getItem")
    public ResponseEntity<Item> getItem(String itemId) throws ItemNotFoundException {
        return itemService.getItem(itemId);
    }

    @PutMapping("/api/items/withdraw")
    public ResponseEntity<?> windrawQuantity(String item_no, long quantity) throws NegativeQuantityException, ItemNotFoundException {
        return itemService.withdrawQuantity(item_no, quantity);
    }

    @DeleteMapping("/api/items/delete")
    public ResponseEntity<?> deleteItem(String item_no) throws ItemNotFoundException {
        return itemService.deleteItem(item_no);
    }

    @PutMapping("/api/items/deposit")
    public ResponseEntity<?> depositQuantity(String item_no, Long quantity) throws ItemNotFoundException {
        return itemService.depositQuantity(item_no, quantity);
    }
}
