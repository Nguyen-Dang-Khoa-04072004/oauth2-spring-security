import { useEffect, useState } from "react";
import "./product.css";
import ProductCard from "./ProductCard";
function ProductPage() {
  const [products, setProducts] = useState([]);

    useEffect(() => {
      fetch("http://localhost:8082/api/v1/products", {
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${localStorage.getItem("accessToken")}`,
        },
      })
        .then((res) => {
          if (res.ok) {
            return res.json();
          }
        })
        .then((json) => {
          console.log(json);
          setProducts(json.products);
        })
        .catch((err) => console.log(err));
    }, []);
  return (
    <div className="product-page">
      {products.map((product) => (
        <ProductCard product={product} key={product.id}/>
      ))}
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
