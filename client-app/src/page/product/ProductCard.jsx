import "./product.css";
function ProductCard({ product }) {
  return (
    <div className="product-card">
      <div className="product-card__product-image">
        <img src={product.productImageUrl} alt="" />
      </div>
      <div className="product-card__product-info">
        <div className="product-card__product-name">{product.productName}</div>
        <div className="product-card__product-measure">{product.measure}g</div>
        <div className="product-card__product-price">{product.price}đ</div>
      </div>
        <button className="product-card__button">+</button>
    </div>
  );
}
export default ProductCard;
