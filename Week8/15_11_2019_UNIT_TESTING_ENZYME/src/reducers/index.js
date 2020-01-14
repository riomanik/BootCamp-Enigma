import { combineReducers } from "redux";

const AUTH = (auth = false, action) => {
  if (action.type === "AUTH") {
    return action.payload;
  }
  return auth;
};

const AUTHENTICATION = (auth = false, action) => {
  if (action.type === "AUTHENTICATION") {
    return action.payload;
  }
  return auth;
};

export default combineReducers({
  auth: AUTH,
  authentication: AUTHENTICATION
});
