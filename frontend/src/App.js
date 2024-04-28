import React from 'react';
import {BrowserRouter, Navigate, Route, Routes} from "react-router-dom";
import LoginScreen from "./screens/login/LoginScreen";

function App() {
    return (
        <div className="App">
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Navigate to="/login" replace /> } />
                    <Route path="/login" element={<LoginScreen />} />
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
