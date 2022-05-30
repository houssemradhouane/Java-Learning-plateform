import './App.css';
import {BrowserRouter as Router,Routes,Route, Link} from 'react-router-dom';
import Login from './pages/Login';
import Register from './pages/Register';
import Contact from './pages/Contact';
import Learn from './pages/Learn';
import Error from './pages/Error';



function App() {
  return (
    <div className="App">
      <Router>
        <ul>
          <li><Link to="/Login">Login</Link></li>
          <li><Link to="/Register">Register</Link></li>
          <li><Link to="/Contact">Contact</Link></li>
          <li><Link to="/Learn">Learn</Link></li>
        </ul>

        <Routes>
          <Route path='/Login' element={<Login/>}/>
          <Route path='/Register' element={<Register/>}/>
          <Route path='/Contact' element={<Contact/>}/>
          <Route path='/Learn' element={<Learn/>}/>
          <Route path='/*' element={<Error/>}/>

        </Routes>
      </Router>
    </div>
  );
}

export default App;
