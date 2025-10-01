import { useLayoutEffect } from "react";
import { useDispatch } from "react-redux";
import { setAuth, setUser } from "../../slices/user";
import { userApi } from "../../api/user";
function AuthProvider({ children }) {
  const dispatch = useDispatch();
  useLayoutEffect(() => {
    userApi
      .get("/userinfo")
      .then((res) => {
        const data = res.data;
        dispatch(setAuth(true));
        dispatch(
          setUser({
            id: data.sub,
            username: data.username,
            email: data.email,
            imageProfile: data.imageProfile,
          })
        );
      })
      .catch((err) => console.log(err));
  }, [dispatch]);

  return children;
}
export default AuthProvider;
