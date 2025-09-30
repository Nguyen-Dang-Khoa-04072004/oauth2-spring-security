import Footer from "../../component/footer/Footer";
import Header from "../../component/header/Header";
import Sidebar from "../../component/sidebar/Sidebar";
import "./product-layout.css";
function ProductPageLayout({ children }) {
  return (
    <div className="container">
      <Header />
      <main className="content">
        <Sidebar />
        {children}
      </main>
      <Footer/>
    </div>
  );
}
export default ProductPageLayout;
