const HOST_ORIGIN = "http://192.168.1.33:8080";
const AUTH_LOGIN_URL = HOST_ORIGIN + "/auth/login";

export async function getUserToken(login, password) {
    return await fetch(AUTH_LOGIN_URL, {method: "POST", headers: {"Content-Type": "application/json"}, body: JSON.stringify({login: login, password: password})})
        .then(data => data.json()).then(data => data.token);
}