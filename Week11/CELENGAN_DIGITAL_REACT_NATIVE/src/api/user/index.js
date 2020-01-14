import API from "../api";
export function doAuth(name, password) {
  return API.post("/auth", { username: name, password: password });
}
