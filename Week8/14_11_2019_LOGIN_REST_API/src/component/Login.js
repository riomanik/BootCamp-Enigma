import React from "react";
import { Link } from "react-router-dom";
import { getUserPassword, PostUsername, PostPassword } from "../api/user";
class Login extends React.Component {
  state = {
    username: "",
    password: "",
    validasi: true,
    userInfo: null,
    userInput: "",
    passwordInput: "",
    usernamevalidasiBenar: { LoginBenar: false },
    usernamevalidasiSalah: { LoginSalah: true },
    passwordvalidasiBenar: { LoginBenar: true },
    passwordvalidasiSalah: { LoginSalah: false }
  };

  doLoginUsername = async e => {
    e.preventDefault();
    await this.onValidasiUsername();
    console.log(this.state.username);
    if (this.state.username.LoginBenar === false) {
      await this.validasiChange(false);
    } else {
      alert("Username Salah");
    }
  };

  onValidasiUsername = async () => {
    const responseUsername = await PostUsername(this.state.userInput);
    const dataUsername = await responseUsername.json();
    await this.setState({ username: dataUsername });
    // console.log(this.state.username.LoginBenar);
  };

  onValidasiPassword = async () => {
    const responsePassword = await PostPassword(this.state.passwordInput);
    const dataPassword = await responsePassword.json();
    this.setState({ password: dataPassword });
    console.log(this.state.password);
  };

  // componentDidMount() {
  //   this.onValidasiAcount();
  // }
  usernameChange = event => {
    let a = event.target.value;
    this.setState({ userInput: a });
  };
  passwordChange = event => {
    let a = event.target.value;
    this.setState({ passwordInput: a });
    console.log(this.state.passwordInput);
  };
  validasiChange = action => {
    this.setState({ validasi: action });
  };
  doLogin = async () => {
    await this.onValidasiPassword();
    if (this.state.password.LoginBenar === true) {
      this.props.onSubmit(true, this.state.userInput);
      this.props.history.push({ pathname: "/Content" });
    } else if (
      this.state.password.LoginSalah === this.state.passwordvalidasiSalah
    ) {
      alert("PasswordSalah");
    }
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
              />
              <span className="focus-input100"></span>
              <div className="container-login100-form-btn1">
                <Link
                  className="login100-form-btn1"
                  onClick={this.doLoginUsername}
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
              />
              <span className="focus-input100"></span>
              <div className="container-login100-form-btn1">
                <Link className="login100-form-btn1" onClick={this.doLogin}>
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

export default Login;
