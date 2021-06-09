package com.milan.dukan.utils;

import com.milan.dukan.models.Category;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {

    public static final ArrayList<Category> categories = new ArrayList<>(
            Arrays.asList(
                    new Category("CAT01", "Beverages", "Drinks like Coffee, Tea, Juice or Soda", "ic_cat_beverages"),
                    new Category("CAT02", "Bread", "Breads like Sandwich Loaves, Dinner Rolls, Tortillas, Bagels", "ic_cat_bread"),
                    new Category("CAT03", "Canned", "Vegetables, Spaghetti Sauce, Ketchup", "ic_cat_canned_food"),
                    new Category("CAT04", "Dairy", "Cheeses, Eggs, Milk, Yogurt, Butter", "ic_cat_dairy"),
                    new Category("CAT05", "Dry", "Cereals, Flour, Sugar, Pasta, Mixes", "ic_cat_dry_food"),
                    new Category("CAT06", "Frozen", "Waffles, Vegetables, Individual Meals, Ice Cream", "ic_cat_frozen_food"),
                    new Category("CAT08", "Produce", "Fruits, Vegetables", "ic_cat_produce"),
                    new Category("CAT09", "Cleaners", "Laundry Detergent, DishWashing Liquid/Detergent", "ic_cat_cleaners"),
                    new Category("CAT10", "Paper Goods", "Paper Towels, Toilet Paper, Aluminum Foil, Sandwich Bags", "ic_cat_paper_goods"),
                    new Category("CAT11", "Personal Care", "Shampoo, Soap, Hand Soap, Shaving Cream", "ic_cat_personal_care"),
                    new Category("CAT12", "Other", "Baby Items, Pet Items, Batteries, Greeting Cards", "ic_cat_others")
            )
    );
}
