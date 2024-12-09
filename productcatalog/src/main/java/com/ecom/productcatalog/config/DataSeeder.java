package com.ecom.productcatalog.config;

import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.CategoryRepository;
import com.ecom.productcatalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ecom.productcatalog.model.Category;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Clear all existing data
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        // Create Categories
        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home = new Category();
        home.setName("Home and Kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics, clothing, home));

        // Create Products for Electronics
        Product phone = new Product();
        phone.setName("Smartphone");
        phone.setDescription("Latest model smartphone with amazing features");
        phone.setImageUrl("phone_image_url");
        phone.setPrice(699.99);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("High-performance laptop for work and play");
        laptop.setImageUrl("laptop_image_url");
        laptop.setPrice(999.99);
        laptop.setCategory(electronics);

        Product tablet = new Product();
        tablet.setName("Tablet");
        tablet.setDescription("Lightweight and portable tablet");
        tablet.setImageUrl("tablet_image_url");
        tablet.setPrice(399.99);
        tablet.setCategory(electronics);

        // Create Products for Clothing
        Product tshirt = new Product();
        tshirt.setName("T-Shirt");
        tshirt.setDescription("Comfortable cotton t-shirt in various sizes");
        tshirt.setImageUrl("tshirt_image_url");
        tshirt.setPrice(19.99);
        tshirt.setCategory(clothing);

        Product jeans = new Product();
        jeans.setName("Jeans");
        jeans.setDescription("Stylish and durable denim jeans");
        jeans.setImageUrl("jeans_image_url");
        jeans.setPrice(49.99);
        jeans.setCategory(clothing);

        Product jacket = new Product();
        jacket.setName("Jacket");
        jacket.setDescription("Warm and cozy winter jacket");
        jacket.setImageUrl("jacket_image_url");
        jacket.setPrice(89.99);
        jacket.setCategory(clothing);

        // Create Products for Home and Kitchen
        Product blender = new Product();
        blender.setName("Blender");
        blender.setDescription("Powerful blender for smoothies and more");
        blender.setImageUrl("blender_image_url");
        blender.setPrice(59.99);
        blender.setCategory(home);

        Product toaster = new Product();
        toaster.setName("Toaster");
        toaster.setDescription("Compact 2-slice toaster");
        toaster.setImageUrl("toaster_image_url");
        toaster.setPrice(29.99);
        toaster.setCategory(home);

        Product cookwareSet = new Product();
        cookwareSet.setName("Cookware Set");
        cookwareSet.setDescription("Non-stick cookware set for all your cooking needs");
        cookwareSet.setImageUrl("cookware_set_image_url");
        cookwareSet.setPrice(99.99);
        cookwareSet.setCategory(home);

        // Save all products
        productRepository.saveAll(Arrays.asList(phone, laptop, tablet, tshirt, jeans, jacket, blender, toaster, cookwareSet));
    }
}
