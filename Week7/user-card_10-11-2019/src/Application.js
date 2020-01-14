import React from "react";
import Login from "./component/Login";
import Product from "./component/Product";
import Content from "./component/Content";

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

  UserSession = action => {
    this.setState({ Login: action });
  };
  UserProduct = action => {
    this.setState({ Product: action });
  };
  UserAbout = action => {
    this.setState({ About: action });
  };
  UsernameInfo = term => {
    this.setState({ username: term });
    console.log(this.state.username);
  };
  PasswordInfo = term => {
    this.setState({ password: term });
    // console.log(this.state.password);
  };

  render() {
    if (this.state.Product === true) {
      return <Product Logout={this.UserProduct} />;
    }
    if (this.state.Login === true) {
      if (this.state.password === "admin") {
        return (
          <div>
            <h1>{"Selamat Datang Kembali " + this.state.username}</h1>
            <Content
              ChangeLogout={this.UserSession}
              ChangeProduct={this.UserProduct}
            />
          </div>
        );
      } else {
        alert("Username dan Password Salah");
        return (
          <div>
            <Login
              onSubmitUsername={this.UsernameInfo}
              onSubmitPassword={this.PasswordInfo}
              ChangeSession={this.UserSession}
            />
          </div>
        );
      }
    }
    if (this.state.Login === false) {
      return (
        <Login
          onSubmitUsername={this.UsernameInfo}
          onSubmitPassword={this.PasswordInfo}
          ChangeSession={this.UserSession}
        />
      );
    }
  }
}
export default App;

// PEMANGGILAN
