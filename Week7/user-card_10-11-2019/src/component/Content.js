import React from "react";
import About from "./About";

class Content extends React.Component {
  // state = { About: false };
  constructor(props) {
    super(props);
    this.state = {
      About: false
    };
  }
  doLogout = () => {
    this.props.ChangeLogout(false);
  };
  doProduct = () => {
    this.props.ChangeProduct(true);
  };

  doAbout = action => {
    this.setState({ About: action });
  };

  showAbout = () => {
    this.doAbout(!this.state.About);
  };

  render() {
    let isLoggedIn = this.state.About;
    return (
      <div>
        <br></br>
        <p className="styleContent"></p>
        <br></br>
        <div className="container-login100-form-btn1">
          <button className="login100-form-btn1" onClick={this.doLogout}>
            {"KELUAR"}
          </button>
        </div>
        <br></br>
        <div className="container-login100-form-btn1">
          <br></br>
          <button className="login100-form-btn1" onClick={this.doProduct}>
            {"PRODUCT"}
          </button>
        </div>
        <br></br>
        <div className="container-login100-form-btn1">
          <button className="login100-form-btn1" onClick={this.showAbout}>
            {"ABOUT"}
          </button>
        </div>
        {isLoggedIn ? <About changeAbout={this.showAbout} /> : ""}
      </div>
    );
  }
}
export default Content;
