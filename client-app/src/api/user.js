import axios from "axios";
const userApi = axios.create({
  baseURL: "http://localhost:8081",
  headers: {
    "Content-Type": "application/json",
  },
});

const refreshTokenApi = axios.create({
    baseURL:"http://localhost:8081/oauth2",
    headers:{
        "Content-Type":"application/x-www-form-urlencoded",
        "Authorization": `Basic ${btoa("client:secrets")}` 
    }
})

const refreshToken = async () => {
    refreshTokenApi.post("/token",{
        "client_id":"client",
        "refresh_token": localStorage.getItem('refreshToken'),
        "grant_type":"refresh_token"
    })
    .then(res => {
        if(res.status === 200){
            const data = res.data
            localStorage.setItem("tokenId",data["id_token"])
            localStorage.setItem("accessToken", data["access_token"]);
            localStorage.setItem("refreshToken",data["refresh_token"])
        }else{
            window.location.replace("/")
        }
    })
    .catch(err => console.log(err))
}


userApi.interceptors.request.use((config) => {
    const accessToken = localStorage.getItem('accessToken')
    if(accessToken){
        config.headers.Authorization = `Bearer ${accessToken}`
        return config
    }else{
        window.location.replace("/")
    }
})
userApi.interceptors.response.use(
    (response) => response, 
    async (err) => {
        const originalRequest  = err.config
        if(err.response.status === 401 && !originalRequest._retry){
            originalRequest._retry = true
                await refreshToken()
                const accessToken = localStorage.getItem('accessToken')
                originalRequest.headers.Authorization = accessToken
                return userApi(originalRequest)
        }else{
            window.location.replace("/")
        }
    });
export { userApi };
