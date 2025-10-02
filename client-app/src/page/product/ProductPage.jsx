import { useEffect, useState } from "react";
import "./product.css";
import ProductCard from "./ProductCard";
import { productApi } from "../../api/product";
import { useSelector } from "react-redux";
function ProductPage() {
  const [products, setProducts] = useState([]);
  const { isAuth } = useSelector((state) => state.user);
  useEffect(() => {
    productApi
      .get("/products")
      .then((res) => {
        if (res.status === 200) {
          return res.data;
        }
      })
      .then((data) => {
        setProducts(data.products);
      })
      .catch((err) => console.log(err));
  }, [isAuth]);
  return (
    <div className="product-page">
      <div className="product-page__heading">Tất cả sản phẩm</div>
      <div className="product-page__content">
        {products.map((product) => (
          <ProductCard product={product} key={product.id} />
        ))}
      </div>
    </div>
  );
}
export default ProductPage;
{
  /* <button
        onClick={() =>
          window.location.replace(
            `http://localhost:8081/logout?token_id_hint${localStorage.getItem(
              "tokenId"
            )}`
          )
        }
      ></button> */
}
