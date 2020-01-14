import React from "react";
import { BrowserRouter, Route, Redirect } from "react-router-dom";
import "./Login.css";

class Login extends React.Component {
  state = { pin: Number };
  passwordChange = event => {
    let a = parseInt(event.target.value);
    this.setState({ pin: a });
  };

  doLogin = () => {
    if (this.state.pin === 123) {
      this.props.onSubmit(true);
      this.props.history.push({ pathname: "/MainMenu" });
    } else {
      alert("Pin Salah ");
    }
  };

  render() {
    return (
      //   <div className="form">
      //     <div class="form-group col-md-5 ">
      //       <label for="inputPassword2" class="sr-only">
      //         PIN
      //       </label>
      //       <input
      //         type="password"
      //         class="form-control"
      //         id="inputPassword2"
      //         placeholder="PIN"
      //         onChange={this.passwordChange}
      //       />
      //     </div>
      //     <div>
      //       <button type="submit" class="btn btn-primary" onClick={this.doLogin}>
      //         SUBMIT
      //       </button>
      //     </div>
      //   </div>
      <div class="container2" style={{ border: "green solid 9px" }}>
        <div style={{ width: "100%", height: "50px" }}>
          <div
            style={{
              color: "white",
              textAlign: "center",
              fontSize: 45,
              marginTop: "10%"
            }}
          >
            WELCOME
          </div>
          <div className="form2" style={{ width: "100%" }}>
            <div class="form-group col-md-5 ">
              <label for="input" class="sr-only"></label>
              <input
                style={{ width: "100%" }}
                type="password"
                class="form-control"
                id="input"
                placeholder="PIN"
                onChange={this.passwordChange}
              />
            </div>
            <div>
              <div>
                <button
                  type="submit"
                  class="btn btn-primary mr-3"
                  onClick={this.doLogin}
                >
                  {"SUBMIT"}
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
export default Login;
