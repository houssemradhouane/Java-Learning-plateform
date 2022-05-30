import React from 'react'
import {BrowserRouter as Router,Routes,Route, Link} from 'react-router-dom';

import { useState } from "react"

function Register() {

    const[firstname, setFirstname] = useState("")
    const[lastname, setLastname] = useState("")
    const[tag, setTag] = useState("")
    const[email, setEmail] = useState("")
    const[password, setPassword] = useState("")

    const registerInfo = () => {
        console.log(email + password)
    }
  return (
    <div class="container">  
        <div id="contact">
        <h3>Java Learning Plateform</h3>
        <h4>Already Registered ? <Link to="/Login">Login here</Link></h4>

        <input placeholder="Your First Name" type="text" tabindex="1" 
            onChange={(event) => {setFirstname(event.target.value)}}
        required autofocus/>

        <input placeholder="Your Last Name" type="text" tabindex="1" 
            onChange={(event) => {setLastname(event.target.value)}}
        required autofocus/>

    <input placeholder="Student or Teacher" type="text" tabindex="1" 
            onChange={(event) => {setTag(event.target.value)}}
        required autofocus/>

        <input placeholder="Your Email" type="text" tabindex="1" 
            onChange={(event) => {setEmail(event.target.value)}}
        required autofocus/>

        <input placeholder="Your Password" type="text" tabindex="2" 
            onChange={(event) => {setPassword(event.target.value)}}
        required/>
        <button name="submit" type="submit" onClick={ registerInfo }>Register</button>
        </div>
    </div>
  )
}

export default Register