import React from "react";
// import About from "./About";
import { Link } from "react-router-dom";
import { connect } from "react-redux";

class Content extends React.Component {
  // constructor(props) {
  //   super(props);
  //   this.state = {
  //     About: false
  //   };

  // doLogout = () => {
  //   this.props.ChangeLogout(false);
  // };
  // doProduct = () => {
  //   this.props.ChangeProduct(true);
  // };

  // doAbout = action => {
  //   this.setState({ About: action });
  // };

  // showAbout = () => {
  //   this.doAbout(!this.state.About);
  // };

  render() {
    // let isLoggedIn = this.state.About;
    console.log(this.props.userInfo + " ini username props ");
    return (
      <div>
        <div>
          <h1> WELCOME BACK {this.props.userInfo} </h1>
        </div>
        <br></br>
        <p className="styleContent"></p>
        <br></br>
        <div className="container-login100-form-btn1">
          <Link className="login100-form-btn1" to="/">
            {"KELUAR"}
          </Link>
        </div>
        <br></br>
        <div className="container-login100-form-btn1">
          <br></br>
          <Link className="login100-form-btn1" to="/Product">
            {"PRODUCTS"}
          </Link>
        </div>
        <br></br>
        <div className="container-login100-form-btn1">
          <Link className="login100-form-btn1" to="/About">
            {"ABOUT"}
          </Link>
        </div>
        {/* {isLoggedIn ? <About changeAbout={this.showAbout} /> : ""} */}
      </div>
    );
  }
}
const mapStateToProps = state => {
  return { userInfo: state.userInfo };
};
export default connect(mapStateToProps)(Content);
