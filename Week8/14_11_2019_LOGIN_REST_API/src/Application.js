import React from "react";
import Login from "./component/Login";
import Product from "./component/Product";
import Content from "./component/Content";
import List from "./component/List";
import About from "./component/About";
import ListProducts from "./component/ListProducts";
import {
  BrowserRouter,
  Link,
  Route,
  Redirect
  // HashRouter,
  // MemoryRouter
} from "react-router-dom";
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
      Login: false,
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
            return this.state.Login ? (
              <route.component username={this.state.username} {...props} />
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
            <Route
              path="/"
              exact
              render={props => <Login onSubmit={this.Submit} {...props} />}
            />
            {a}

            {/* <Route
              path="/Content"
              render={props => {
                return this.state.Login ? (
                  <div>
                    <h1>Welcome Back {this.state.username}</h1>
                    <Content {...props} />
                  </div>
                ) : (
                  <Redirect to="/" />
                );
              }}
            />
            <Route
              path="/About"
              render={props => {
                return this.state.Login ? (
                  <div>
                    <About {...props} />
                  </div>
                ) : (
                  <Redirect to="/" />
                );
              }}
            />
            <Route
              path="/Product"
              render={props => {
                return this.state.Login ? (
                  <div>
                    <Product {...props} />
                  </div>
                ) : (
                  <Redirect to="/" />
                );
              }}
            />
            <Route
              path="/List"
              render={props => {
                return this.state.Login ? (
                  <div>
                    <List {...props} />
                  </div>
                ) : (
                  <Redirect to="/" />
                );
              }}
            />
            <Route
              path="/ListProducts"
              render={props => {
                return this.state.Login ? (
                  <div>
                    <ListProducts {...props} />
                  </div>
                ) : (
                  <Redirect to="/" />
                );
              }}
            />
            <Route
              path="/Price"
              render={props => {
                return this.state.Login ? (
                  <div>
                    <Price {...props} />
                  </div>
                ) : (
                  <Redirect to="/" />
                );
              }}
            /> */}
            {/* <Route path="/Content" render={props => <Content {...props} />} /> */}
            {/* <Route path="/About" render={props => <About {...props} />} />
            <Route path="/Product/" render={props => <Product {...props} />} />
            <Route path="/List" render={props => <List {...props} />} />
            <Route
              path="/ListProducts"
              render={props => <ListProducts {...props} />}
            />
            <Route path="/Price" render={props => <Price {...props} />} /> */}
          </div>
        </BrowserRouter>
      </div>
    );

    // if (this.state.Product === true) {
    //   return <Product Logout={this.UserProduct} />;
    // }
    // if (this.state.Login === true) {
    //   if (this.state.password === "admin") {
    //     return (
    //       <div>
    //         <h1>{"Selamat Datang Kembali " + this.state.username}</h1>
    //         <Content
    //           ChangeLogout={this.UserSession}
    //           ChangeProduct={this.UserProduct}
    //         />
    //       </div>
    //     );
    //   } else {
    //     alert("Username dan Password Salah");
    //     return (
    //       <div>
    //         <Login
    //           onSubmitUsername={this.UsernameInfo}
    //           onSubmitPassword={this.PasswordInfo}
    //           ChangeSession={this.UserSession}
    //         />
    //       </div>
    //     );
    //   }

    //   if (this.state.Login === false) {
    //     return (
    //       <Login
    // onSubmitUsername={this.UsernameInfo}
    // onSubmitPassword={this.PasswordInfo}
    // ChangeSession={this.UserSession}
    //       />
    //     );
    //   }
    // }
  }
}
export default App;
