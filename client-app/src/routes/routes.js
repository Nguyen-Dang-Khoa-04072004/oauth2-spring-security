import Callback from "../page/Callback";
import HomePage from "../page/HomePage";
import ProductPageLayout from "../layout/ProductPageLayout/ProductPageLayout";
import ProductPage from "../page/product/ProductPage";

export const routes = [
  {
    path: "/",
    label: "Home",
    component: HomePage,
    layout: null,
    isAuth: false,
  },
  {
    path: "/products",
    label: "product",
    component: ProductPage,
    layout: ProductPageLayout,
    isAuth: true,
  },
  {
    path: "/callback",
    label: "",
    component: Callback,
    layout: null,
    isAuth: false,
  },
];
