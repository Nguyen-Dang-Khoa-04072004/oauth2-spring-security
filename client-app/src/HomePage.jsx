import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function HomePage() {

  return (
    <>
      <div>
        <a href="https://vite.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <h1>Vite + React</h1>
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
