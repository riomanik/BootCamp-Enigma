import React from "react";
import { connect } from "react-redux";
import { AUTHENTICHATION, AUTH } from "../action";
import "./index.css";

class Login extends React.Component {
  state = { UsernameInput: "", PasswordInput: "", button: true };

  onchangeUsername = async event => {
    let a = event.target.value;
    await this.setState({ UsernameInput: a });
    this.setButton();
    console.log(this.state.UsernameInput);
  };

  onchangePassword = async event => {
    let a = event.target.value;
    await this.setState({ PasswordInput: a });
    this.setButton();
  };

  setButton = () => {
    if (
      this.state.UsernameInput === "rio" &&
      this.state.PasswordInput === "manik"
    ) {
      this.setState({ button: false });
    } else {
      this.setState({ button: true });
    }
  };

  onButtonClick = () => {
    if (
      this.state.UsernameInput === "rio" &&
      this.state.PasswordInput === "manik"
    ) {
      this.props.auth(this.state.UsernameInput);
      this.props.authentication(true);
      alert("berhasil");
      this.props.history.push({ pathname: "/Home" });
    } else {
      alert("gagal");
    }
  };

  render() {
    return (
      <div className="margin">
        <div className="container ">
          <div class="form-group">
            <label for="exampleInputEmail1">Username</label>
            <input
              type="email"
              class="form-control"
              id="exampleInputEmail1"
              aria-describedby="emailHelp"
              placeholder="Enter email"
              value={this.state.UsernameInput}
              onChange={this.onchangeUsername}
            />
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input
              type="password"
              class="form-control"
              id="exampleInputPassword1"
              placeholder="Password"
              value={this.state.PasswordInput}
              onChange={this.onchangePassword}
            />
          </div>
          <div class="form-check">
            <input
              type="checkbox"
              class="form-check-input"
              id="exampleCheck1"
            />
          </div>
          <button
            disabled={this.state.button}
            onClick={this.onButtonClick}
            type="submit"
            class="btn btn-primary"
          >
            submit
          </button>
        </div>
      </div>
      //   <div>
      //     <div>
      //       <label>Username</label>
      //       <input
      //         type="text"
      //         name="userName"
      //         value={this.state.UsernameInput}
      //         onChange={this.onchangeUsername}
      //       />
      //     </div>
      //     <div>
      //       <label>Password</label>
      //       <input
      //         type="text"
      //         name="userPassword"
      //         value={this.state.PasswordInput}
      //         onChange={this.onchangePassword}
      //       />
      //     </div>
      //     <div>
      //       <button disabled={this.state.button} onClick={this.onButtonClick}>
      //         submit
      //       </button>
      //     </div>
      //   </div>
    );
  }
}

export default connect(null, {
  auth: AUTHENTICHATION,
  authentication: AUTH
})(Login);
