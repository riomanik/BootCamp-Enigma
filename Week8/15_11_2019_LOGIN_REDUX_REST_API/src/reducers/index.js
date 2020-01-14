import { combineReducers } from "redux";

const AUTH = (auth = false, action) => {
  if (action.type === "AUTH") {
    return action.payload;
  }
  return auth;
};

const USERINFO = (userInfo = null, user) => {
  if (user.type === "USERINFO") {
    return user.payload;
  }
  return userInfo;
};

const product = (productInfo = [], action) => {
  if (action.type === "PRODUCT") {
    return action.payload;
  }
  return productInfo;
};

export default combineReducers({
  auth: AUTH,
  userInfo: USERINFO,
  listProduct: product
});
