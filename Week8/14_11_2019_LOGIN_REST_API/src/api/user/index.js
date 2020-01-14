export function getUserInfo() {
  //   return fetch("http://localhost:3000/user", {
  //     method: "GET"
  //   });
  return fetch(process.env.REACT_APP_WS_URL + "/user", {
    method: "GET"
  });
}

export function getUserPassword() {
  return fetch(process.env.REACT_APP_WS_URL + "/Login", {
    method: "POST"
  });
}

export function getProduct() {
  return fetch(process.env.REACT_APP_WS_URL + "/Product", {
    method: "GET"
  });
}

export function PostUsername(usernamevalidasi) {
  return fetch(process.env.REACT_APP_WS_URL + "/PostUsername", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      username: usernamevalidasi
    })
  });
}

export function PostPassword(passwordvalidasi) {
  return fetch(process.env.REACT_APP_WS_URL + "/PostPassword", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      password: passwordvalidasi
    })
  });
}

// export function getUser() {
//   return fetch(process.env.REACT_APP_WS_URL + "/GetLoginUsername", {
//     method: "GET"
//   });
// }

// export function getPassword() {
//   return fetch(process.env.REACT_APP_WS_URL + "/GetLoginPassword", {
//     method: "GET"
//   });
// }

// export function PostLogin(fullName, address) {
//   return fetch(process.env.REACT_APP_WS_URL + "/PostLogin", {
//     method: "POST",
//     headers: { "Content-Type": "application/json" },
//     body: JSON.stringify({
//       usernameBck: fullName,
//       passwordBck: address
//     })
//   });
// }

//   export function Login(fullName, address) {
//     return fetch(process.env.REACT_APP_WS_URL + "/user", {
//       method: "POST",
//       headers: { "Content-Type": "application/json" },
//       body: JSON.stringify({
//         namaLengkap: fullName,
//         alamat: address
//       })
//     });
// }
