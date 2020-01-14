import React from "react";
import { Link } from "react-router-dom";
import { PostUsername, PostPassword } from "../api/user";
import { connect } from "react-redux";
import { AUTHENTICHATION } from "../action";
import { userInfo } from "../action";
class Login extends React.Component {
  state = {
    validasi: true,
    userInfo: null,
    userInput: "",
    passwordInput: ""
  };

  onValidasiUsername = async e => {
    const responseUsername = await PostUsername(this.state.userInput);
    const dataUsername = await responseUsername.json();
    console.log(dataUsername);
    if (dataUsername.LoginBenar) {
      await this.setState({ validasi: false });
    } else {
      alert("Username salah");
    }
  };

  handleKeyDownUsername = async e => {
    if (e.key === "Enter") {
      await this.onValidasiUsername();
    }
  };

  handleKeyDownPassword = async e => {
    if (e.key === "Enter") {
      await this.onValidasiPassword();
    }
  };

  onValidasiPassword = async () => {
    const responsePassword = await PostPassword(this.state.passwordInput);
    const dataPassword = await responsePassword.json();
    if (dataPassword.LoginBenar) {
      this.props.userInfo(dataPassword.Nama);
      this.props.auth(true);
      this.props.history.push({ pathname: "/Content" });
    } else {
      alert("Password salah");
    }
  };

  usernameChange = event => {
    let a = event.target.value;
    this.setState({ userInput: a });
  };
  passwordChange = event => {
    let a = event.target.value;
    this.setState({ passwordInput: a });
    console.log(this.state.passwordInput);
  };

  render() {
    let validasi = this.state.validasi;
    return (
      <div className="container-login100">
        <div className="wrap-login1001 wrap-login100">
          <form className="login100-form validate-form" />
          <span className="login100-form-title">MEMBER LOGIN</span>
          {validasi ? (
            <div>
              <input
                type="text"
                pattern="rio"
                value={this.state.userInput}
                className="input100"
                name="email"
                placeholder={"USERNAME"}
                onChange={this.usernameChange}
                onKeyDown={this.handleKeyDownUsername}
              />
              <span className="focus-input100"></span>
              <div className="container-login100-form-btn1">
                <Link
                  className="login100-form-btn1"
                  onClick={this.onValidasiUsername}
                >
                  {"SUBMIT"}
                </Link>
              </div>
            </div>
          ) : (
            <div>
              <input
                value={this.state.passwordInput}
                className="input100"
                type="password"
                name="pass"
                placeholder={"PASSWORD"}
                onChange={this.passwordChange}
                onKeyDown={this.handleKeyDownPassword}
              />
              <span className="focus-input100"></span>
              <div className="container-login100-form-btn1">
                <Link
                  className="login100-form-btn1"
                  onClick={this.onValidasiPassword}
                >
                  "SUBMIT"
                </Link>
              </div>
            </div>
          )}
        </div>
      </div>
    );
  }
}

export default connect(null, {
  auth: AUTHENTICHATION,
  userInfo: userInfo
})(Login);
