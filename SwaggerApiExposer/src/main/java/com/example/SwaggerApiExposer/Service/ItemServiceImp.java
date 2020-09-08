package com.example.SwaggerApiExposer.Service;

import com.example.SwaggerApiExposer.ExceptionHandling.ItemExistsException;
import com.example.SwaggerApiExposer.ExceptionHandling.ItemNotFoundException;
import com.example.SwaggerApiExposer.ExceptionHandling.NegativeQuantityException;
import com.example.SwaggerApiExposer.Model.Item;
import com.example.SwaggerApiExposer.Etc.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.List;
import java.util.Optional;

/*
 * This class implements all the functions in the ItemService interface.
 * Each method returns a ResponseEntity which indicateds if the operation
 * has been succesfull or failed.
 */
@Service
public class ItemServiceImp implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    /*
     * Sets the item repository given by the params.
     * @param itemRepository the given repository
     * @return void
     */
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    /*
     * Returns all the items in the database.
     * @return List
     */
    public List<Item> getListItems() {
        List<Item> items = itemRepository.findAll();
        return items;
    }

    /*
     * Adds a new item to the database
     * @param Item the given item to be added
     * @return ResponseEntity The response
     */
    public ResponseEntity<?> addItem(Long amount, Long inventory_code, String name) throws ItemExistsException {
        Item item = new Item(amount, name, inventory_code);
        String id;
        while (true) {
            String temp_id = UUID.randomUUID().toString();
            Optional<Item> temp = itemRepository.findById(temp_id);
            if (temp.isEmpty()) {
                id = temp_id;
                break;
            }
        }
        item.setItem_no(id);
        itemRepository.save(item);
        return ResponseEntity.ok().body(item);
    }

    /*
     * Get an item from the database
     * @param item_no the item id
     * @return ResponseEntity The response
     */
    @Override
    public ResponseEntity<Item> getItem(String item_no) throws ItemNotFoundException {
        Item item = itemRepository.findById(item_no).orElseThrow(ItemNotFoundException::new);
        return ResponseEntity.ok().body(item);
    }

    /*
     * Withdraw a specific quantity from the database of given item
     * @param Item the given item to be added
     * @return ResponseEntity The response
     */
    @Override
    public ResponseEntity<?> withdrawQuantity(String item_no, Long quantity) throws
            ItemNotFoundException, NegativeQuantityException {
        Item item = itemRepository.findById(item_no).orElseThrow(ItemNotFoundException::new);

        Long updatedAmount = item.getAmount() - quantity;
        if (updatedAmount < 0) {
            throw new NegativeQuantityException();
        }
        item.setAmount(item.getAmount() - quantity);
        final Item updatedItem = itemRepository.save(item);
        return ResponseEntity.ok().body(updatedItem);
    }

    /*
     * Delete an item from the database
     * @param Item the given item to be added
     * @return ResponseEntity The response
     */
    @Override
    public ResponseEntity<?> deleteItem(String item_no) throws ItemNotFoundException {
        Item item = itemRepository.findById(item_no).orElseThrow(ItemNotFoundException::new);
        itemRepository.delete(item);
        return ResponseEntity.ok().body(item);
    }

    /*
     * Deposit a given quantity to an item in the database
     * @param Item the given item to be added
     * @return ResponseEntity The response
     */
    @Override
    public ResponseEntity<?> depositQuantity(String item_no, Long quantity) throws ItemNotFoundException {
        Item item = itemRepository.findById(item_no).orElseThrow(ItemNotFoundException::new);
        Long currentAmount = item.getAmount();
        item.setAmount(currentAmount + quantity);
        itemRepository.save(item);
        return ResponseEntity.ok().body(item);
    }
}
