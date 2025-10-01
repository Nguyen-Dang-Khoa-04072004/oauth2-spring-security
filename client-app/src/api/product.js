import axios from "axios";

export const productApi = axios.create({
  baseURL: "http://localhost:8082/api/v1",
  headers: {
    "Content-Type": "application/json",
  },
});

productApi.interceptors.request.use((config) => {
    const accessToken = localStorage.getItem('accessToken')
    if(accessToken){
        config.headers.Authorization = `Bearer ${accessToken}`
        return config
    }else{
        window.location.replace("/")
    }
})