import React from "react";

class Product extends React.Component {
  constructor(props) {
    super(props);
    this.state = { list: false, harga: false, product: false };
  }

  UbahList = action => {
    this.setState({ product: action });
    action.preventDefault();
  };

  changeProduct = action => {
    this.state.product(true);
    action.preventDefault();
  };

  toContent = action => {
    this.props.Logout(false);
    action.preventDefault();
  };
  // UserProduct = action => {
  //   this.setState({ Product: action, Login: false });
  // };

  // const Content = props => {
  // console.log(props);

  render() {
    if (this.state.list === false) {
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
                  <a class="nav-link" href="#">
                    Home <span class="sr-only">(current)</span>
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="" onClick={this.UbahList}>
                    List Products
                  </a>
                </li>
                <div>
                  <a class="nav-link" href="#">
                    <p>DAFTAR BARANG</p>
                  </a>
                </div>
                <li class="nav-item">
                  <a class="nav-link" href="#">
                    Pricing
                  </a>
                </li>
              </ul>
              <span class="navbar-text">
                Navbar text with an inline element
              </span>
            </div>
          </nav>
        </div>
      );
    }
  }
}

export default Product;
