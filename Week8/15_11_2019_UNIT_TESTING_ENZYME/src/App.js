import React from "react";
import Login from "./component/Login";
import HOME from "./component/Home";
import { connect } from "react-redux";
import { BrowserRouter, Route, Redirect } from "react-router-dom";

const routes = [
  {
    id: 1,
    path: "/Login",
    component: Login
  },
  {
    id: 2,
    path: "/HOME",
    component: HOME
  }
];

class App extends React.Component {
  render() {
    let a = routes.map(route => {
      return (
        <Route
          key={route.id}
          path={route.path}
          render={props => {
            return this.props.Auth ? (
              <route.component {...props} />
            ) : (
              <Redirect to="/" />
            );
          }}
        />
      );
    });

    return (
      <div>
        <BrowserRouter>
          <Route path="/" exact render={props => <Login {...props} />} />
          {a}
        </BrowserRouter>
      </div>
    );
  }
}
const mapStateToProps = state => {
  return { Auth: state.authentication };
};
export default connect(mapStateToProps)(App);
