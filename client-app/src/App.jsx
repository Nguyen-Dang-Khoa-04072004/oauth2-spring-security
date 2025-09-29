import './App.css'
import { Route, Routes } from 'react-router'
import HomePage from './HomePage'
import ProductPage from './ProductPage'
import Callback from './Callback'
function App() {

  return (
    <>
        <Routes>
            <Route path='/' element={<HomePage/>}/>    
            <Route path='/callback' element={<Callback/>}/>
            <Route path='/products' element={<ProductPage/>}/>
        </Routes> 
    </>
  )
}

export default App
