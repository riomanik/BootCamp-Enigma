import React from "react";

class ListProducts extends React.Component {
  // const Content = props => {
  // console.log(props);

  doCloseListProducts = event => {
    this.props.changeListProducts(event);
  };

  render() {
    return (
      <div>
        <form>
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
            <button
              className="login100-form-btn1"
              onClick={this.doCloseListProducts}
            >
              {"CLOSED"}
            </button>
          </div>
          <br></br>
        </form>
      </div>
    );
  }
}
export default ListProducts;
