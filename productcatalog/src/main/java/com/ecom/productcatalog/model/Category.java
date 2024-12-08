package com.ecom.productcatalog.model;

import jakarta.persistence.*;
import java.util.Set;

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;

    @OneToMany(mappedBy = "category",
    cascade = CascadeType.ALL,
    fetch =FetchType.LAZY)

    private Set<Product> products;
}
