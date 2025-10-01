import Callback from "../page/Callback";
import HomePage from "../page/hone/HomePage";
import ProductPageLayout from "../layout/ProductPageLayout/ProductPageLayout";
import ProductPage from "../page/product/ProductPage";
import LandingPageLayout from "../layout/LandingPageLayout/LandingPageLayout";

export const routes = [
  {
    path: "/",
    label: "Home",
    component: HomePage,
    layout: LandingPageLayout,
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
