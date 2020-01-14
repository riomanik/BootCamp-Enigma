import API from "../api";
export function getAcountNasabah() {
  return API.get("/nasabah");
}
