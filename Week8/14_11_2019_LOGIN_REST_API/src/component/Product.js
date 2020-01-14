import React from "react";
import Lisst from "./List";
import ListProducts from "./ListProducts";
import Prices from "./Price";
import { Link, Route } from "react-router-dom";

class Product extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      list: false,
      listProduct: false,
      price: false
    };
  }
  setList = action => {
    this.setState({ list: action, listProduct: false, price: false });
  };
  setProduct = action => {
    this.setState({ listProduct: action, list: false, price: false });
  };
  setPrice = action => {
    this.setState({ price: action, list: false, listProduct: false });
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
  // toContent = event => {
  //   this.props.Logout(false);
  //   event.preventDefault();
  // };

  render() {
    let List = this.state.list;
    let Product = this.state.listProduct;
    let Price = this.state.price;
    return (
      <div>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          {/* <a class="navbar-brand" href="" > */}
          <Link to="/Content">{"GO-STORE"}</Link>
          {/* </a> */}
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
                <Link class="nav-link" href="#" onClick={this.changeList}>
                  {"Home"}
                </Link>
                <span class="sr-only">(current)</span>
              </li>
              <li class="nav-item">
                <Link class="nav-link" href="" onClick={this.changeProducts}>
                  {"ListProducts"}
                </Link>
              </li>
              <li class="nav-item">
                <Link class="nav-link" href="#" onClick={this.changePrice}>
                  {"Pricing"}
                </Link>
              </li>
            </ul>
            <span class="navbar-text">
              {"Navbar text with an inline element"}
            </span>
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
