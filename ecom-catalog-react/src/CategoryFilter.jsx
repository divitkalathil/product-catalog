const CategoryFilter = ({categories, onSelect}) => {
    return(
        <>
        <select id="categorySelect" className="form-control" onChange={(e)=> onSelect(e.target.value)}>
            <option value="">All Categories</option>
            
        </select>
        </>
    )
}
 
export default ProductList;