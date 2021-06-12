package com.milan.dukan.utils;

import com.milan.dukan.models.Category;
import com.milan.dukan.models.Product;

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

    public static final ArrayList<Product> products = new ArrayList<>(
            Arrays.asList(
                    new Product("PRD", "Nescafe Sunrise Instant Coffee (200 g)", "Savour the rich and refreshing aroma of NESCAFE Sunrise Instant Coffee and commence your day on the right note. Made with a delightful blend of 70% coffee and 30% chicory, this stimulating coffee can leave you feeling energetic, pumped, and ready for the day.", "https://rukminim1.flixcart.com/image/416/416/korijrk0/coffee/j/r/1/sunrise-instant-coffee-pouch-nescafe-original-imag355mhq6jc4xz.jpeg?q=70", 299.0, "CAT01"),
                    new Product("PRD", "Tata Gold Tea Vacuum Pack (1 kg)", "A hot and strong cup of Tata Gold Tea can kick-start your mornings on an energetic note. This tea has a blend of gently-rolled long aromatic leaves and Assam CTC leaves. Carefully selected and blended by the tea experts, a flavourful cup of Tata Gold Tea will elevate your senses with its inviting and invigorating aroma. Specially made for passionate tea lovers, this refreshing beverage can refresh you with each sip you take.", "https://rukminim1.flixcart.com/image/416/416/kkimfm80/tea/k/o/y/gold-vacuum-pack-regular-tea-leaves-tata-original-imafzuf3yj9zgykb.jpeg?q=70", 543.0, "CAT01"),
                    new Product("PRD", "Maaza Mango (1.2 L)", "Enjoy the juicy pulp of mangoes anytime, anywhere with the Maaza mango drink from the Coca-Cola Company. This universally loved drink is made from real pulp of handpicked Alphonso mangoes.", "https://rukminim1.flixcart.com/image/416/416/k4irzbk0/drinks-juice/a/5/4/1-2-mango-plastic-bottle-maaza-original-imafkh8tzsqywcjh.jpeg?q=70", 52.0, "CAT01"),
                    new Product("PRD", "Kinley Soda Extra Punch PET Bottle (750 ml)", "Add an extra punch to your day with this light and refreshing club soda from Kinley. You can make delicious cocktails or add fizz to your lemonades and fruit drinks with this Kinley soda water.", "https://rukminim1.flixcart.com/image/416/416/jqzitu80/aerated-drink/e/d/g/750-soda-extra-punch-plastic-bottle-kinley-original-imafcvvq3gqyzxrf.jpeg?q=70", 16.0, "CAT01"),
                    new Product("PRD", "Mountain Dew Plastic Bottle (750 ml)", "Enjoy a bottle of Mountain Dew and feel refreshed with its citrusy taste. This drink is for the bold and adventurous. So, if you’re ready to be pumped with energy, take a sip.", "https://rukminim1.flixcart.com/image/416/416/jh9fy4w0/aerated-drink/g/j/6/750-na-plastic-bottle-mountain-dew-original-imaf5bkxpgheff5h.jpeg?q=70", 30.0, "CAT01"),
                    new Product("PRD", "Britannia 100% Whole Wheat Bread (450 g)", "Make delicious sandwiches and toasts with Britannia 100% Whole Wheat Bread. This bread is made from finest ingredients that are baked to perfection to make this soft & spongy bread. Go ahead, buy this product online now!", "https://www.jiomart.com/images/product/420x420/491127282/britannia-100-whole-wheat-bread-400-g-0-20200826.jpg", 37.20, "CAT02"),
                    new Product("PRD", "Wibs Bread (400 g)", "Make delicious Sandwhiches with Country Wibs Browny Whole Wheat Bread. This bread is made from finest ingredients that are baked to perfection to make this soft & spongy bread. Go ahead, buy this product online now!", "https://www.jiomart.com/images/product/420x420/490626261/wibs-bread-400-g-0-20210310.jpg", 26.40, "CAT02"),
                    new Product("PRD", "King's Hawaiian Original Sweet Rolls", "King's Hawaiian Original Sweet Rolls, 16 Rolls Per Bag, Pack Of 2 Bags", "https://images-na.ssl-images-amazon.com/images/I/71I%2Bw2rY8FL._SL1500_.jpg", 100.0, "CAT02"),
                    new Product("PRD", "Habanero Tortilla Wrap, 3x6 pcs Multipack", "Soft and made to perfection, this tortilla wraps have a genuine 'homemade' taste and texture. Enjoy the tortilla wraps with your favourite fillings and flavours. This 8 inch wraps a perfect option for lunch, breakfast and even for a picnic.", "https://www.bigbasket.com/media/uploads/p/l/1212314_2-habanero-tortilla-wrap.jpg", 465.85, "CAT02"),
                    new Product("PRD", "Fresho Signature Bagel - Plain, 250 g (Pack of 3)", "Dense and chewy with a crisp exterior, have your bagels Plain with traditional lox and cream cheese or spiced with cinnamon. Made with premium quality ingredients, the taste is surely going to tame your tastebuds. Enjoy this sweet delight and say bye to small hunger pangs.", "https://www.bigbasket.com/media/uploads/p/l/40037503_1-fresho-signature-bagel-plain.jpg", 55.0, "CAT02"),
                    new Product("PRD", "Heinz Tomato Ketchup Top Down (Imported), 910g", "Our classic Tomato Ketchup has been a staple at mealtimes since 1886. It's the unmistakable taste of our sun-ripened tomatoes, along with our passion and knowledge that gives our recipe its unique flavour", "https://images-na.ssl-images-amazon.com/images/I/71wFxTH8SXL._SL1500_.jpg", 250.0, "CAT03"),
                    new Product("PRD", "HABIT SWEET CORN (410 g)", "Sweet Corn by Habit", "https://rukminim1.flixcart.com/image/416/416/kcgk1ow0/canned-food/z/6/z/410-sweet-corn-410g-corn-habit-original-imaftkxpppuyaf8j.jpeg?q=70", 150.0, "CAT03"),
                    new Product("PRD", "Del Monte Pitted Green Olives (450 g)", "Taste the best quality olives with Del Monte Pitted Green Olives. It’s hygienically packed and contains no preservatives. You can add it to your salads or pizzas or into a recipe of your choice. It’s healthy and tasty at the same time. It has got the aroma intact that olive lovers often look for. So, go ahead and buy Del Monte Pitted Green Olives online now!", "https://rukminim1.flixcart.com/image/416/416/kox8b680/canned-food/j/9/j/pitted-green-olives-del-monte-original-imag39uq5rxzgjuu.jpeg?q=70", 179.0, "CAT03"),
                    new Product("PRD", "Del Monte Baked Beans - In Sauce (450 g)", "DelMonte Baked Beans is source of protein, an essential building block for healthy muscles and bones. Baked beans provide energy while being low in fat which makes it a perfect accompaniment", "https://www.bigbasket.com/media/uploads/p/l/40102161_2-del-monte-baked-beans-in-sauce.jpg", 110.0, "CAT03"),
                    new Product("PRD", "American Classic All Peeled Spears White Asparagus Tin, 430g", "American Classic All Peeled Spears White Asparagus", "https://images-na.ssl-images-amazon.com/images/I/715cepeJKAL._SL1500_.jpg", 594.0, "CAT03"),
                    new Product("PRD", "Amul Processed Blend Pizza Cheese, 200 g", "Amul pizza cheese has moist, soft, elastic texture and has a very timely surface sheen and when fresh, It has a slightly salty blandish taste and pleasant aroma. Because of its stretchability, i.E. Ability to form strings when hot, this cheese is ideal for preparing lasagna, and as a topping on pizzas.", "", 105.0, "CAT04"),
                    new Product("PRD", "", "", "", 0.0, "CAT04"),
                    new Product("PRD", "", "", "", 0.0, "CAT04"),
                    new Product("PRD", "", "", "", 0.0, "CAT04"),
                    new Product("PRD", "", "", "", 0.0, "CAT04"),
                    new Product("PRD", "", "", "", 0.0, "CAT05"),
                    new Product("PRD", "", "", "", 0.0, "CAT05"),
                    new Product("PRD", "", "", "", 0.0, "CAT05"),
                    new Product("PRD", "", "", "", 0.0, "CAT05"),
                    new Product("PRD", "", "", "", 0.0, "CAT05"),
                    new Product("PRD", "", "", "", 0.0, "CAT06"),
                    new Product("PRD", "", "", "", 0.0, "CAT06"),
                    new Product("PRD", "", "", "", 0.0, "CAT06"),
                    new Product("PRD", "", "", "", 0.0, "CAT06"),
                    new Product("PRD", "", "", "", 0.0, "CAT06"),
                    new Product("PRD", "", "", "", 0.0, "CAT07"),
                    new Product("PRD", "", "", "", 0.0, "CAT07"),
                    new Product("PRD", "", "", "", 0.0, "CAT07"),
                    new Product("PRD", "", "", "", 0.0, "CAT07"),
                    new Product("PRD", "", "", "", 0.0, "CAT07"),
                    new Product("PRD", "", "", "", 0.0, "CAT08"),
                    new Product("PRD", "", "", "", 0.0, "CAT08"),
                    new Product("PRD", "", "", "", 0.0, "CAT08"),
                    new Product("PRD", "", "", "", 0.0, "CAT08"),
                    new Product("PRD", "", "", "", 0.0, "CAT08"),
                    new Product("PRD", "", "", "", 0.0, "CAT09"),
                    new Product("PRD", "", "", "", 0.0, "CAT09"),
                    new Product("PRD", "", "", "", 0.0, "CAT09"),
                    new Product("PRD", "", "", "", 0.0, "CAT09"),
                    new Product("PRD", "", "", "", 0.0, "CAT09"),
                    new Product("PRD", "", "", "", 0.0, "CAT10"),
                    new Product("PRD", "", "", "", 0.0, "CAT10"),
                    new Product("PRD", "", "", "", 0.0, "CAT10"),
                    new Product("PRD", "", "", "", 0.0, "CAT10"),
                    new Product("PRD", "", "", "", 0.0, "CAT10"),
                    new Product("PRD", "", "", "", 0.0, "CAT11"),
                    new Product("PRD", "", "", "", 0.0, "CAT11"),
                    new Product("PRD", "", "", "", 0.0, "CAT11"),
                    new Product("PRD", "", "", "", 0.0, "CAT11"),
                    new Product("PRD", "", "", "", 0.0, "CAT11"),
                    new Product("PRD", "", "", "", 0.0, "CAT12"),
                    new Product("PRD", "", "", "", 0.0, "CAT12"),
                    new Product("PRD", "", "", "", 0.0, "CAT12"),
                    new Product("PRD", "", "", "", 0.0, "CAT12"),
                    new Product("PRD", "", "", "", 0.0, "CAT12")
            )
    );

    public static ArrayList<Product> insertFakeProducts() {
        ArrayList<Product> products = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setId("PRD" + i);
            product.setDescription("This is description for Product #" + i);
            product.setPrice(200.0 + i);
            if (i % 4 == 0) {
                product.setTitle("Beverage #" + i);
                product.setImageUrl("https://images.unsplash.com/photo-1542291026-7eec264c27ff?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=750&q=80");
                product.setCategoryId("CAT01");
            } else if (i % 4 == 1) {
                product.setTitle("Canned #" + i);
                product.setImageUrl("https://images.unsplash.com/photo-1581235720704-06d3acfcb36f?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTJ8fHByb2R1Y3R8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60");
                product.setCategoryId("CAT03");
            } else if (i % 4 == 2) {
                product.setTitle("Dairy #" + i);
                product.setImageUrl("https://images.unsplash.com/photo-1491637639811-60e2756cc1c7?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTR8fHByb2R1Y3R8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60");
                product.setCategoryId("CAT04");
            } else {
                product.setTitle("Frozen #" + i);
                product.setImageUrl("https://images.unsplash.com/photo-1513116476489-7635e79feb27?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fHByb2R1Y3R8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60");
                product.setCategoryId("CAT06");
            }
            products.add(product);
        }

        return products;
    }
}
