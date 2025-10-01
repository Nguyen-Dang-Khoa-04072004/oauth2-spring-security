import { HiOutlineShoppingCart } from "react-icons/hi";
import logoImg from "../../../public/logo.png";
import "./home.css";
function HomePage() {
  return (
    <div className="homepage">
      <div className="homepage__card">
        <div className="homepage__logo">
          <HiOutlineShoppingCart color="white" size={35} />
          <img src={logoImg} alt="" />
        </div>
        <div className="homepage__content">
          <div className="homepage__content__title">Welcome to FPT Food Store</div>
          <div className="homepage__content__image">
            <img src="https://inkythuatso.com/uploads/thumbnails/800/2021/11/logo-fpt-inkythuatso-1-01-01-14-33-35.jpg" alt="" />
          </div>
          <div className="homepage__content__introduce">Log in with a FPT Food Store Account to discover our food world where you will find a wide variety of choice including meals, vegetables, beverages, snacks and more</div>
        </div>
        <button
          className="homepage__login-btn"
          onClick={() =>
            window.location.replace(
              "http://localhost:8081/oauth2/authorize?response_type=code&client_id=client&scope=openid&redirect_uri=http://localhost:5173/callback"
            )
          }
        >
          LOG IN
        </button>
      </div>
    </div>
  );
}

export default HomePage;
