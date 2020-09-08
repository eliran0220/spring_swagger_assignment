package com.example.SwaggerApiExposer.Model;


import javax.persistence.*;

/*
The basic Item class which holds all the information the item should have.

 */
@Entity
@Table(name = "ITEMS")
public class Item {
    @Id
    private String item_no;

    private Long amount;

    private String name;

    private Long inventory_code;

    public Item() {
    }

    /*
    A constructor for creating a new item.
     */
    public Item(Long amount, String name, Long inventory_code) {
        this.amount = amount;
        this.name = name;
        this.inventory_code = inventory_code;
    }

    @Override
    public String toString() {
        return String.format(
                "Item[id=%d, name='%s, amount=%d, item no='%s]", item_no, name, amount, inventory_code
        );
    }


    public String getItem_no() {
        return this.item_no;
    }

    public void setItem_no(String item_no) {
        this.item_no = item_no;
    }


    public Long getAmount() {
        return this.amount;
    }

    public String getName() {
        return this.name;
    }

    public Long getInventory_code() {
        return this.inventory_code;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInventory_code(Long inventory_code) {
        this.inventory_code = inventory_code;
    }
}
