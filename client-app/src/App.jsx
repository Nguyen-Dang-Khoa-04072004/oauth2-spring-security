import "./App.css";
import { Route, Routes } from "react-router";
import { routes } from "./routes/routes";
import React from "react";
import AuthProvider from "./component/auth/Auth";
function App() {
  return (
    <>
      <Routes>
        {routes.map((route) => {
          const Layout = route.layout ?? React.Fragment;
          const Page = route.component;
          return (
            <Route
              path={route.path}
              element={
                route.isAuth ? (
                  <AuthProvider>
                    <Layout>
                      <Page />
                    </Layout>
                  </AuthProvider>
                ) : (
                  <Layout>
                    <Page />
                  </Layout>
                )
              }
            />
          );
        })}
      </Routes>
    </>
  );
}

export default App;
