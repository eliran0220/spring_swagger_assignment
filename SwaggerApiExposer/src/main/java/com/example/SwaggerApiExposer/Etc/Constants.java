package com.example.SwaggerApiExposer.Etc;

/*
 * A constant class used for all the exceptions.
 */
public final class Constants {

    /******************************Numeric Constants******************************/
    public static final long ITEM_NOT_FOUND_CODE = 1;
    public static final long ITEM_FOUND_CODE = 2;
    public static final long NEGATIVE_WINDRAW_CODE = 3;

    /******************************String Constants******************************/

    public static final String ITEM_NOT_FOUND_MSG = "Item not found in stock.";
    public static final String NEGATIVE_QUANTITY_MSG = "Unable to withdraw more than in stock.";
    public static final String DELETE_SUCCESS_MSG = "Item has been deleted successfully.";
    public static final String WITHRDRAW_SUCCESS_MSG = "Successfully withdraw from stocks: ";
    public static final String EMPTY_LIST = "There are no items in the databse.";
    public static final String ITEM_EXISTS_MSG = "Item is already exists in the database.";
    public static final String ITEM_ADDED_MSG = "Item has been added successfully, item_no: ";
    public static final String QUANTITY_DEPOSIT_MSG = "Item quantity has been updated.";

}
