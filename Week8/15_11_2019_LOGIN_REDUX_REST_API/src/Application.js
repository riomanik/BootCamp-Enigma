import React from "react";
import Login from "./component/Login";
import Product from "./component/Product";
import Content from "./component/Content";
import List from "./component/List";
import About from "./component/About";
import ListProducts from "./component/ListProducts";
import { connect } from "react-redux";
import { BrowserRouter, Route, Redirect } from "react-router-dom";
import Price from "./component/Price";

const routes = [
  {
    id: 1,
    path: "/Content",
    component: Content
  },
  {
    id: 2,
    path: "/Product",
    component: Product
  },
  {
    id: 3,
    path: "/List",
    component: List
  },
  {
    id: 4,
    path: "/ListProducts",
    component: ListProducts
  },
  {
    id: 5,
    path: "/Price",
    component: Price
  },
  {
    id: 6,
    path: "/About",
    component: About
  }
];

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      // Login: false,
      Product: false,
      contentAbout: null,
      username: "",
      password: ""
    };
  }

  Submit = (action1, action2, action3) => {
    this.setState({ Login: action1, username: action2, password: action3 });
  };

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
          <div>
            <Route path="/" exact render={props => <Login {...props} />} />
            {a}
          </div>
        </BrowserRouter>
      </div>
    );
  }
}
const mapStateToProps = state => {
  console.log(state.auth);
  return { Auth: state.auth };
};
export default connect(mapStateToProps)(App);
