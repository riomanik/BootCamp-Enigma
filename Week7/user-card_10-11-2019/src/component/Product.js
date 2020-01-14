import React from "react";
import Lisst from "./List";
import ListProducts from "./ListProducts";
import Prices from "./Price";

class Product extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      list: false,
      listProduct: false,
      price: false
      // logout: false,
    };
  }
  setList = action => {
    this.setState({ list: action });
  };
  setProduct = action => {
    this.setState({ listProduct: action });
  };
  setPrice = action => {
    this.setState({ price: action });
  };
  changeList = () => {
    this.setList(!this.state.list);
  };
  changeProducts = event => {
    this.setProduct(!this.state.listProduct);
    event.preventDefault();
  };
  changePrice = () => {
    this.setPrice(!this.state.price);
  };
  toContent = event => {
    this.props.Logout(false);
    event.preventDefault();
  };
  // UserProduct = action => {
  //   this.setState({ Product: action, Login: false });
  // };

  // const Content = props => {
  // console.log(props);

  render() {
    let List = this.state.list;
    let Product = this.state.listProduct;
    let Price = this.state.price;
    return (
      <div>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <a class="navbar-brand" href="" onClick={this.toContent}>
            GO-STORE
          </a>
          <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarText"
            aria-controls="navbarText"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item active">
                <a class="nav-link" href="#" onClick={this.changeList}>
                  Home <span class="sr-only">(current)</span>
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="" onClick={this.changeProducts}>
                  List Products
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#" onClick={this.changePrice}>
                  Pricing
                </a>
              </li>
            </ul>
            <span class="navbar-text">Navbar text with an inline element</span>
          </div>
        </nav>
        {List ? <Lisst changeList={this.changeList} /> : ""}
        {Product ? (
          <ListProducts changeListProducts={this.changeProducts} />
        ) : (
          ""
        )}
        {Price ? <Prices changePrice={this.changePrice} /> : ""}
      </div>
    );
  }
}

export default Product;
