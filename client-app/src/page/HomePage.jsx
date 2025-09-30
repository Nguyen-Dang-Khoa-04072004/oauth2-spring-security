import springLogo from "../../public/favicon.svg"

function HomePage() {

  return (
    <>
      <div>
        <a target="_blank">
          <img src={springLogo} className="logo react" alt="Spring logo" />
        </a>
      </div>
      <h1>Oauth2 Spring Security</h1>
      <div className="card">
        <button onClick={() => window.location.replace("http://localhost:8081/oauth2/authorize?response_type=code&client_id=client&scope=openid&redirect_uri=http://localhost:5173/callback")}>
            Login with Spring Boot 
        </button>
        <p>
          Edit <code>src/HomePage.jsx</code> and save to test HMR
        </p>
      </div>
      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
    </>
  )
}

export default HomePage
