import React from "react";

class About extends React.Component {
  // const Content = props => {
  // console.log(props);

  doCloseAbout = () => {
    this.props.changeAbout();
  };

  render() {
    return (
      <div>
        Lorem ipsum, dolor sit amet consectetur adipisicing elit. Ex officia
        error enim, totam, reiciendis voluptate, quibusdam ut beatae et ipsa
        amet corporis ipsam ducimus voluptatum doloribus non labore esse nisi.
        Lorem ipsum, dolor sit amet consectetur adipisicing elit. Ex officia
        error enim, totam, reiciendis voluptate, quibusdam ut beatae et ipsa
        amet corporis ipsam ducimus voluptatum doloribus non labore esse nisi.
        Lorem ipsum, dolor sit amet consectetur adipisicing elit. Ex officia
        error enim, totam, reiciendis voluptate, quibusdam ut beatae et ipsa
        amet corporis ipsam ducimus voluptatum doloribus non labore esse nisi.
        Lorem ipsum, dolor sit amet consectetur adipisicing elit. Ex officia
        error enim, totam, reiciendis voluptate, quibusdam ut beatae et ipsa
        amet corporis ipsam ducimus voluptatum doloribus non labore esse nisi.
        Lorem ipsum, dolor sit amet consectetur adipisicing elit. Ex officia
        error enim, totam, reiciendis voluptate, quibusdam ut beatae et ipsa
        amet corporis ipsam ducimus voluptatum doloribus non labore esse nisi.
        <br></br>
        <div className="container-login100-form-btn1">
          <br></br>
          <button className="login100-form-btn1" onClick={this.doCloseAbout}>
            {"CLOSED"}
          </button>
        </div>
        <br></br>
      </div>
    );
  }
}
export default About;
