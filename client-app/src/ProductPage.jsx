import { useEffect, useState } from "react";


function ProductPage() {
    const [products, setProducts] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8082/api/v1/products", {
      headers: {
        "Content-Type": "application/json",
        "Authorization": `Bearer ${localStorage.getItem("accessToken")}`,
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
    <div>
      {products.map(product => <h3 key={product.id}>{product.productName}</h3>)}
    </div>
  );
}
export default ProductPage;
