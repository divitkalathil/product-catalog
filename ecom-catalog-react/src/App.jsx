import { useEffect, useState } from 'react';
import './App.css';
import ProductList from './ProductList';
import CategoryFilter from './CategoryFilter';

function App() {
  const [products, setProducts] = useState([]);
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [searchTerm, setSearchTerm] = useState("");
  const [sortOrder, setSortOrder] = useState("asc");

  useEffect(() => {
    // Fetch products
    fetch('http://localhost:8080/api/products')
      .then(response => response.json())
      .then(data => setProducts(data));

    // Fetch categories
    fetch('http://localhost:8080/api/categories')
      .then(response => response.json())
      .then(data => setCategories(data));
  }, []);

  const handleCategorySelect = (categoryId) => {
    setSelectedCategory(categoryId ? Number(categoryId) : null);
  };

  const handleSearchChange = (event) => {
    setSearchTerm(event.target.value);
  };

  const handleSortChange = (event) => {
    setSortOrder(event.target.value);
  };

  const filteredProducts = products
    .filter(product => (
      (selectedCategory ? product.category.id === selectedCategory : true) &&
      product.name.toLowerCase().includes(searchTerm.toLowerCase())
    ))
    .sort((a, b) => sortOrder === 'asc' ? a.price - b.price : b.price - a.price);

  return (
    <div className="container my-5">
      <h1 className="text-center mb-4 text-primary">Product Catalog</h1>

      <div className="row align-items-center mb-4">
        {/* Category Filter */}
        <div className="col-md-3 col-sm-12 mb-3">
          <CategoryFilter categories={categories} onSelect={handleCategorySelect} />
        </div>

        {/* Search Input */}
        <div className="col-md-5 col-sm-12 mb-3">
          <input
            type="text"
            className="form-control"
            placeholder="Search for Products"
            value={searchTerm}
            onChange={handleSearchChange}
          />
        </div>

        {/* Sort Select */}
        <div className="col-md-4 col-sm-12 mb-3">
          <select
            className="form-control"
            value={sortOrder}
            onChange={handleSortChange}
          >
            <option value="asc">Sort by Price: Low to High</option>
            <option value="desc">Sort by Price: High to Low</option>
          </select>
        </div>
      </div>

      {/* Product List */}
      <div>
        {filteredProducts.length ? (
          <ProductList products={filteredProducts} />
        ) : (
          <div className="text-center text-muted">
            <p>No Products Found</p>
          </div>
        )}
      </div>
    </div>
  );
}

export default App;
