import React from "react";
import Content from "./Content";
class Login extends React.Component {
  state = { username: "", password: "" };

  doLogin = () => {
    this.props.ChangeSession(true);
    this.props.onSubmitUsername(this.state.username);
    this.props.onSubmitPassword(this.state.password);

    // console.log(this.props.state.data);
  };

  // onFormSubmit = event => {
  //   event.preventDefault();
  //   this.props.onSubmit(this.state.searchKeyword);
  // };

  usernameChange = event => {
    let a = event.target.value;
    this.setState({ username: a });
    // console.log(this.state.username);
  };

  passwordChange = event => {
    let a = event.target.value;
    this.setState({ password: a });
    // console.log(this.state.password);
  };

  render() {
    return (
      // <div className="limiter">
      <div className="container-login100">
        {/* <div className="wrap-login1001"></div> */}
        <div className="wrap-login1001 wrap-login100">
          <form className="login100-form validate-form" />
          <span className="login100-form-title">MEMBER LOGIN</span>
          <div
            className="wrap-input100 "
            data-validate="Valid email is required: ex@abc.xyz"
          >
            <input
              value={this.state.username}
              className="input100"
              type="text"
              name="email"
              placeholder={"USERNAME"}
              onChange={this.usernameChange}
            />
            <span className="focus-input100"></span>
          </div>

          <div
            className="wrap-input100 validate-input"
            data-validate="Password is required"
          >
            <input
              value={this.state.password}
              className="input100"
              type="password"
              name="pass"
              placeholder={"PASSWORD"}
              onChange={this.passwordChange}
            />
            <span className="focus-input100"></span>
          </div>

          <div
            className="container-login100-form-btn1"
            // onSubmit={this.onFormSubmit}
          >
            <button
              className="login100-form-btn1"
              onClick={this.doLogin}
              // onChange={this.onFormSubmit}
            >
              {"SUBMIT"}
            </button>
            {/* </div> */}
          </div>
        </div>
      </div>
    );
  }
}

export default Login;
