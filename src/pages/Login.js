import React from 'react'
import {BrowserRouter as Router,Routes,Route, Link} from 'react-router-dom';


function Home() {
  return (
    
    <div class="container">  
        <div id="contact">
        <h3>Java Learning Plateform</h3>
        <h4>Need an account ? <Link to="/Register">Register here</Link></h4>
        <input placeholder="Your Email" type="text" tabindex="1" required autofocus/>
        <input placeholder="Your Password" type="text" tabindex="2" required/>
        <button name="submit" type="submit">Login</button>
        </div>
    </div>
  
  )
}

export default Home