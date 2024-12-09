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
        phone.setImageUrl("https://www.istockphoto.com/vector/3d-realistic-high-quality-smartphone-mockup-with-isolated-background-smart-phone-gm1569559602-527836142");
        phone.setPrice(699.99);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("High-performance laptop for work and play");
        laptop.setImageUrl("https://www.istockphoto.com/photo/laptop-blank-screen-on-wood-table-with-blurred-coffee-shop-cafe-interior-background-gm1389603578-446846126");
        laptop.setPrice(999.99);
        laptop.setCategory(electronics);

        Product tablet = new Product();
        tablet.setName("Tablet");
        tablet.setDescription("Lightweight and portable tablet");
        tablet.setImageUrl("https://www.istockphoto.com/photo/digital-tablet-pc-smartphone-template-isolated-on-white-gm1004165346-271239909");
        tablet.setPrice(399.99);
        tablet.setCategory(electronics);

        Product tshirt = new Product();
        tshirt.setName("T-Shirt");
        tshirt.setDescription("Comfortable cotton t-shirt in various sizes");
        tshirt.setImageUrl("https://www.istockphoto.com/photo/portrait-of-friendly-young-man-gm1378996666-442722015");
        tshirt.setPrice(19.99);
        tshirt.setCategory(clothing);

        Product jeans = new Product();
        jeans.setName("Jeans");
        jeans.setDescription("Stylish and durable denim jeans");
        jeans.setImageUrl("https://www.istockphoto.com/photo/jeans-gm1132154377-300017708");
        jeans.setPrice(49.99);
        jeans.setCategory(clothing);

        Product jacket = new Product();
        jacket.setName("Jacket");
        jacket.setDescription("Warm and cozy winter jacket");
        jacket.setImageUrl("https://www.istockphoto.com/photo/male-coat-isolated-on-the-white-gm163208487-23290189");
        jacket.setPrice(89.99);
        jacket.setCategory(clothing);

        Product blender = new Product();
        blender.setName("Blender");
        blender.setDescription("Powerful blender for smoothies and more");
        blender.setImageUrl("https://www.istockphoto.com/photo/blender-appliance-with-glass-container-isolated-on-white-background-3d-realistic-gm1384863054-443932092");
        blender.setPrice(59.99);
        blender.setCategory(home);

        Product toaster = new Product();
        toaster.setName("Toaster");
        toaster.setDescription("Compact 2-slice toaster");
        toaster.setImageUrl("https://www.istockphoto.com/photo/silver-toaster-gm147019976-7331744");
        toaster.setPrice(29.99);
        toaster.setCategory(home);

        Product cookwareSet = new Product();
        cookwareSet.setName("Cookware Set");
        cookwareSet.setDescription("Non-stick cookware set for all your cooking needs");
        cookwareSet.setImageUrl("https://www.istockphoto.com/photo/clean-saucepan-on-a-gas-stove-in-kitchen-gm1223414833-359365222");
        cookwareSet.setPrice(99.99);
        cookwareSet.setCategory(home);
        // Save all products
        productRepository.saveAll(Arrays.asList(phone, laptop, tablet, tshirt, jeans, jacket, blender, toaster, cookwareSet));
    }
}
