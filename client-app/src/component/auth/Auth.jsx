import { useEffect } from "react";
import { useDispatch} from "react-redux";
import { useNavigate } from "react-router";
import { setAuth, setUser } from "../../slices/user";
function AuthProvider({ children }) {
  const navigate = useNavigate();
  const dispatch = useDispatch();
  useEffect(() => {
    fetch("http://localhost:8081/userinfo", {
      headers: {
        "Content-Type": "application/json",
        "Authorization": `Bearer ${localStorage.getItem("accessToken")}`,
      },
    })
      .then((res) => {
        if (res.ok) {
          return res.json();
        }else{
            navigate("/")
        }
      })
      .then((json) => {
        console.log(json);
        dispatch(setAuth(true));
        dispatch(
          setUser({
            id: json.sub,
            username: json.username,
            email: json.email,
            imageProfile: json.imageProfile,
          })
        );
      })
      .catch((err) => console.log(err));
  }, []);
  return children;
}
export default AuthProvider;
