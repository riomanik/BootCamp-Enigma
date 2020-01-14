export const acountNasabahReducer = (acountNasabah = {}, action) => {
  if (action.type === "ACOUNT_NASABAH") {
    return action.payload;
  }
  return acountNasabah;
};
