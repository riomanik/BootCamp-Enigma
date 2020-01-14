import React from "react";
import Content from "./Content";

class Login extends React.Component {
  doLogin = () => {
    this.props.ChangeSession(true);
  };
  // Login="MEMBER LOGIN"
  // UserName="USERNAME"
  // UserPassword="PASSWORD"
  // Info="We'll never share your email with anyone else."
  // Check="Check me out"
  // Submit="LOGIN"

  render() {
    return (
      <div className="limiter">
        <div className="container-login100">
          <div className="wrap-login100">
            <form className="login100-form validate-form" />
            <span className="login100-form-title">MEMBER LOGIN</span>

            <div
              className="wrap-input100 validate-input"
              data-validate="Valid email is required: ex@abc.xyz"
            >
              <input
                className="input100"
                type="text"
                name="email"
                placeholder={"USERNAME"}
              />
              <span className="focus-input100"></span>
              <span className="symbol-input100">
                <i className="fa fa-envelope" aria-hidden="true"></i>
              </span>
            </div>

            <div
              className="wrap-input100 validate-input"
              data-validate="Password is required"
            >
              <input
                className="input100"
                type="password"
                name="pass"
                placeholder={"PASSWORD"}
              />
              <span className="focus-input100"></span>
              <span className="symbol-input100">
                <i className="fa fa-lock" aria-hidden="true"></i>
              </span>
            </div>

            <div className="container-login100-form-btn">
              <button className="login100-form-btn" onClick={this.doLogin}>
                {"SUBMIT"}
              </button>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Login;
