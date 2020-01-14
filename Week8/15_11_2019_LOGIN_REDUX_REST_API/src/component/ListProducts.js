import React from "react";
import { Link } from "react-router-dom";
import { getProduct } from "../api/user";
import { product } from "../action";
import { connect } from "react-redux";

class ListProducts extends React.Component {
  state = { product: [] };

  doCloseListProducts = event => {
    this.props.changeListProducts(event);
  };

  onGetProduct = async () => {
    const response = await getProduct();
    const data = await response.json();
    this.props.Product(data);
    console.log(this.props.product);
    // this.setState({ product: data });
  };

  componentDidMount() {
    this.onGetProduct();
  }

  render() {
    console.log(this.props.product);
    let listKeranjang = this.props.product.map(k => {
      return (
        <tr>
          <th scope="row">{k.id}</th>
          <td>{k.productName}</td>
          <td>{k.price}</td>
        </tr>
      );
    });
    return (
      <div>
        <div className="container">
          <table className="table">
            <thead>
              <tr>
                <th scope="col">ID PRODUCT</th>
                <th scope="col">NAMA PRODUCT</th>
                <th scope="col">HARGA PRODUCT</th>
              </tr>
            </thead>
            <tbody>{listKeranjang}</tbody>
          </table>
        </div>
        {/* <div className="container-login100-form-btn1">
          <br></br>
          <Link className="login100-form-btn1" to="/Product">
            {"CLOSED"}
          </Link>
        </div> */}
        <br></br>
      </div>
    );
  }
}

const mapStateToProps = state => {
  return { product: state.listProduct };
};
export default connect(mapStateToProps, {
  Product: product
})(ListProducts);
