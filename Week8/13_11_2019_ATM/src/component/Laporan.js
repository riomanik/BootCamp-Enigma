import React from "react";
import { Link } from "react-router-dom";

class Laporan extends React.Component {
  state = { isiKeranjang: [] };

  componentDidMount() {
    const keranjang = JSON.parse(window.localStorage.getItem("keranjang"));
    if (keranjang) {
      this.setState({ isiKeranjang: keranjang });
    }
  }

  render() {
    //   <div>
    //     <div class="jumbotron jumbotron-fluid">
    //       <div class="container">
    //         <h1 class="display-4">404 NOT FOUND</h1>
    //         <p class="lead">Your Site is unreachable</p>
    //       </div>
    //       <Link to="/MainMenu">
    //         <div className="container">
    //           <button type="button" class="btn btn-primary btn-lg">
    //             Back
    //           </button>
    //         </div>
    //       </Link>
    //     </div>
    //   </div>
    let totalQty = 0;
    let totalPrice = 0;

    if (this.state.isiKeranjang.length > 0) {
      let listKeranjang = this.state.isiKeranjang.map(k => {
        const { product, qty } = k;
        totalQty = totalQty + Number(qty);
        totalPrice = totalPrice + Number(qty) * Number(product.price);
        return (
          <tr>
            <td>{product.id}</td>
            <td>{product.nama}</td>
            <td>{qty}</td>
            <td>{product.price}</td>
          </tr>
        );
      });
      return (
        <div className="container">
          <h2>Daftar Transaksi Anda</h2>
          <table className="table">
            <thead>
              <tr>
                <th>Pilihan</th>
                <th>Nominal</th>
                <th>SaldoAwal</th>
                <th>SaldoAkhir</th>
              </tr>
            </thead>
            <tbody>
              {listKeranjang}
              <tr>
                <td colSpan="4" style={{ textAlign: "right" }}>
                  <Link to="/MainMenu">
                    <button type="button" className="btn btn-success mr-2">
                      Transaksi Lagi
                    </button>
                  </Link>
                  <Link to="/MainMenu">
                    <div className="container">
                      <button type="button" class="btn btn-primary btn-lg">
                        Back
                      </button>
                    </div>
                  </Link>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      );
    } else {
      return (
        <div className="container">
          <h2>Anda Belum Melakukan transaksi Apapun</h2>
          <Link to="/MainMenu">Mulai Transaksi</Link>
        </div>
      );
    }
  }
}
export default Laporan;
