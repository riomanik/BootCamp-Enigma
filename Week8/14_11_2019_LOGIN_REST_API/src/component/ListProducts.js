import React from "react";
import { Link, Route } from "react-router-dom";
import { getProduct } from "../api/user";

class ListProducts extends React.Component {
  state = { product: [] };

  doCloseListProducts = event => {
    this.props.changeListProducts(event);
  };

  onGetProduct = async () => {
    const response = await getProduct();
    const data = await response.json();
    this.setState({ product: data });
    console.log(this.state.product);
  };

  componentDidMount() {
    this.onGetProduct();
  }

  render() {
    let listKeranjang = this.state.product.map(k => {
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
          <table class="table">
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
        <div className="container-login100-form-btn1">
          <br></br>
          <Link className="login100-form-btn1" to="/Product">
            {"CLOSED"}
          </Link>
        </div>
        <br></br>
      </div>
    );
  }
}
export default ListProducts;
