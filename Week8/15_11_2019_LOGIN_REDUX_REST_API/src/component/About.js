import React from "react";
import { Link } from "react-router-dom";

class About extends React.Component {
  // doCloseAbout = () => {
  //   this.props.changeAbout();
  // };

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
          <Link className="login100-form-btn1" to="/Content">
            {"CLOSE"}
          </Link>
        </div>
        <br></br>
      </div>
    );
  }
}
export default About;
