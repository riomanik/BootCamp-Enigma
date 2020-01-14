import React from "react";
import ReactDOM from "react-dom";
import App from "./Application";
import { Provider } from "react-redux";
import { createStore } from "redux";
import reducers from "./reducers";
import "./import.js";

ReactDOM.render(
  <Provider store={createStore(reducers)}>
    <App />
  </Provider>,
  document.querySelector("#root")
);
