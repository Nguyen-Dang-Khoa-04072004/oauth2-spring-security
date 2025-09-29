import { useEffect } from "react";
import { useSearchParams } from "react-router";
function Callback() {
  const [params, setParams] = useSearchParams();
  useEffect(() => {
    const code = params.get("code");
    console.log(code);
    const headers = new Headers();
    headers.append("Content-Type", "application/x-www-form-urlencoded");
    headers.append("Authorization", `Basic ${btoa("client:secrets")}`);

    const urlencoded = new URLSearchParams();
    urlencoded.append("client_id", "client");
    urlencoded.append("redirect_uri", "http://localhost:5173/callback");
    urlencoded.append("grant_type", "authorization_code");
    urlencoded.append("code", code);
    const requestOptions = {
      method: "POST",
      headers: headers,
      body: urlencoded.toString(),
      redirect: "follow",
    };
    console.log(requestOptions);
    fetch("http://localhost:8081/oauth2/token", requestOptions)
      .then((response) => {
        if (response.ok) {
          return response.json();
        }
      })
      .then((json) => {
        console.log(json);
        localStorage.setItem("accessToken", json["access_token"]);
        setParams("");
        window.location.replace("/products")
      })
      .catch((err) => console.log(err));
  }, []);
}
export default Callback;
