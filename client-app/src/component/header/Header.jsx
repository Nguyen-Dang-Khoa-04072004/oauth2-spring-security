import { useSelector } from "react-redux";
import "./header.css";
import logoImg from "../../../public/logo.png"
import { HiOutlineShoppingCart } from "react-icons/hi";
import { BsSearch } from "react-icons/bs";
import { LuShoppingCart } from "react-icons/lu";
function Header() {
  const { user } = useSelector((state) => state.user);
  return (
    <div className="header">
      <div className="header__main">
          <div className="header__logo">
            <HiOutlineShoppingCart color="white" size={35}/>
            <img
              src={logoImg}
              alt=""
            />
          </div>
          <div className="header__search-bar">
            <div className="search-bar__input-bar">
              <BsSearch size={20} color="#F37021" style={{cursor: 'pointer'}}/>
              <input type="text" placeholder="Nhập tên sản phẩm cần tìm"/>
              <LuShoppingCart size={25} color="#F37021" style={{cursor: 'pointer'}}/>
            </div>
          </div>
        <div className="header__userinfo">
          <div className="header__username">{user?.username}</div>
          <div className="header__image-profile">
            <img src={user?.imageProfile} alt="" />
          </div>
        </div>
      </div>
    </div>
  );
}
export default Header;
