export const handleRefreshToken = async (err) => {
  const originalRequest = err.config;
  if (err.response.status === 401 && !originalRequest._retry) {
    originalRequest._retry = true;
    try {
      await refreshToken();
      return userApi(originalRequest);
    } catch (err) {
      console.log(err);
      window.location.replace("/");
    }
  }
};
