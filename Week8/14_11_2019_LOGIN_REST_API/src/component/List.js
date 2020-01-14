import React from "react";
import { Link, Route } from "react-router-dom";

class List extends React.Component {
  doCloseList = () => {
    this.props.changeList();
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
          <Link className="login100-form-btn1" to="/Product">
            {"ClOSE"}
          </Link>
        </div>
        <br></br>
      </div>
    );
  }
}
export default List;
