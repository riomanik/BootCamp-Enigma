export const userActiveReducer = (userActive = {}, action) => {
  if (action.type === "AUTH_USER") {
    return action.payload;
  }
  return userActive;
};
export const userInfoReducer = (userInfo = {}, action) => {
  if (action.type === "USER_INFO") {
    return action.payload;
  }
  return userInfo;
};
