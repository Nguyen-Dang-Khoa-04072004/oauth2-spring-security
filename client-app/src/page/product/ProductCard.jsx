import "./product.css";
function ProductCard({product}) {
  return (
    <div className="product-card">
      <div className="product-card__product-image">
        <img
          src={product.productImageUrl}
          alt=""
        />
      </div>
      <div className="product-card__product-name">{product.productName}</div>
      <div className="product-card__product-price">
        {product.price}đ
        <span className="product-card__product-measure">/{product.measure}g</span>
      </div>
      <button className="product-card__button">Mua</button>
    </div>
  );
}
export default ProductCard;
