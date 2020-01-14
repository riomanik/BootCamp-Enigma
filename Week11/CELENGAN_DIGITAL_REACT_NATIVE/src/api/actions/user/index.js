export const authUser = user => {
  return {
    type: "AUTH_USER",
    payload: user
  };
};

export const userInfo = user => {
  return {
    type: "USER_INFO",
    payload: user
  };
};

export const acountNasabah = nasabah => {
  return {
    type: "ACOUNT_NASABAH",
    payload: nasabah
  };
};

export const logout = () => {
  return {
    type: "LOGOUT"
  };
};
