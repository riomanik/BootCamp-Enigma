// Action Creator
export const AUTHENTICHATION = action => {
  return {
    type: "AUTH",
    payload: action
  };
};

export const userInfo = userInfo => {
  return {
    type: "USERINFO",
    payload: userInfo
  };
};

export const product = product => {
  return {
    type: "PRODUCT",
    payload: product
  };
};
