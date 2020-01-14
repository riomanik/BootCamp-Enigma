import React from "react";

class About extends React.Component {
  // const Content = props => {
  // console.log(props);

  doShowAbout = () => {
    this.props.doAbout(false);
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
        <div className="container-login100-form-btn">
          <br></br>
          <button className="login100-form-btn" onClick={this.doShowAbout}>
            {"CLOSED"}
          </button>
        </div>
        <br></br>
      </div>
    );
  }
}
export default About;
