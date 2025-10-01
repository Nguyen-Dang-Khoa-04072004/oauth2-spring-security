import axios from "axios";
const userApi = axios.create({
  baseURL: "http://localhost:8081",
  headers: {
    "Content-Type": "application/json",
  },
});

const refreshTokenApi = axios.create({
  baseURL: "http://localhost:8081/oauth2",
  headers: {
    "Content-Type": "application/x-www-form-urlencoded",
    Authorization: `Basic ${btoa("client:secrets")}`,
  },
});

export const refreshToken = async () => {
  console.log("Call get new access token");
  try{
    const res = await refreshTokenApi.post("/token", {
       client_id: "client",
       refresh_token: localStorage.getItem("refreshToken"),
       grant_type: "refresh_token",
     })
     localStorage.setItem('accessToken',res.data['access_token'])
     localStorage.setItem('refreshToken',res.data['refresh_token'])
     localStorage.setItem('tokenId',res.data['id_token'])
  }catch(err){
    console.log(err)
    window.location.replace("/")
  }
}

userApi.interceptors.request.use((config) => {
  const accessToken = localStorage.getItem("accessToken");
  if (accessToken) {
    config.headers.Authorization = `Bearer ${accessToken}`;
    return config;
  } else {
    window.location.replace("/");
  }
});
userApi.interceptors.response.use(
  (response) => response,
  async (err) => {
    const originalRequest = err.config;
    console.log(err.response)
    if (err.response.status === 401 && !originalRequest._retry) {
      originalRequest._retry = true;
      try{
          console.log("refresh token");
          await refreshToken();
          console.log("new acess token: " + localStorage.getItem('accessToken') )
          console.log("accessToken is new:" + originalRequest.headers.Authorization !== `Bearer ${localStorage.getItem('accessToken')}`)
          return userApi(originalRequest);
      }catch(refreshErr){
        console.log(refreshErr)
      }
    } 
    return Promise.reject(err)
  }
);
export { userApi };
