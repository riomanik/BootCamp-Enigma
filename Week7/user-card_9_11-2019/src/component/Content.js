import React from "react";

class Content extends React.Component {
  // const Content = props => {
  // console.log(props);

  doLogout = () => {
    this.props.ChangeLogout(false);
  };
  doProduct = () => {
    this.props.ChangeProduct(true);
  };
  doShowAbout = () => {
    this.props.doShowAbout(true);
  };

  render() {
    return (
      <div>
        <br></br>
        <p className="styleContent"></p>
        <br></br>
        <div className="container-login100-form-btn">
          <button className="login100-form-btn" onClick={this.doLogout}>
            {"KELUAR"}
          </button>
        </div>
        <br></br>
        <div className="container-login100-form-btn">
          <br></br>
          <button className="login100-form-btn" onClick={this.doProduct}>
            {"PRODUCT"}
          </button>
        </div>
        <br></br>
        <div className="container-login100-form-btn">
          <button className="login100-form-btn" onClick={this.doShowAbout}>
            {"ABOUT"}
          </button>
        </div>
      </div>
    );
  }
}
export default Content;
