import { combineReducers } from "redux";

const kalkulator = (state = 0, action) => {
  switch (action.type) {
    case "TAMBAH":
      return action.payload.num1 + action.payload.num2;
    case "KURANG":
      return action.payload.num1 - action.payload.num2;
    case "KALI":
      return action.payload.num1 * action.payload.num2;
    case "BAGI":
      return action.payload.num1 / action.payload.num2;
    default:
      return state;
  }
};

export default combineReducers({
  calculator: kalkulator
});

// const { createStore, combineReducers } = Redux;

// const kalkulatorSaya = combineReducers({
//   kalkulator_tambah2an_reducer,
//   kalkulator_kali2an_reducer
// });

// const kalkulator = createStore(kalkulatorSaya);

// kalkulator.dispatch(penjumlahan(1, 3));
// kalkulator.dispatch(pengurangan(7, 2));
// // kalkulator.dispatch(pengalian(3, 5));

// console.log(kalkulator.getState());

// const selectedSongReducer = (selectSong = null, action) => {
//   if (action.type === "SONG_SELECTED") {
//     return action.payload;
//   }
//   return selectSong;
// };

// export default combineReducers({
//   songs: songReducer,
//   selectedSong: selectedSongReducer
// });
