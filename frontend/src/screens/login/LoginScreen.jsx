import React, {useRef, useState} from 'react'
import cs from './LoginScreen.module.css'
import {getUserToken} from '../../network/network'
import {useNavigate} from "react-router-dom";

const LoginScreen = () => {
    const login = useRef();
    const password = useRef();

    const nav = useNavigate();

    function onSubmit() {
        getUserToken(login.current.value, password.current.value).then(r => {
            if (r) {
                nav("/stub");
            }
        });
    }

    return (
        <div className={cs.main}>
            <input type="text" placeholder="login" name="login" ref={login} />
            <input type="password" placeholder="password" name="password" ref={password} />
            <button onClick={onSubmit}>Submit</button>
        </div>
    );
}

export default LoginScreen;