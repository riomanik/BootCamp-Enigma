import React from "react";
import { Link } from "react-router-dom";
import "./Login.css";

class MainMenu extends React.Component {
  render() {
    return (
      <div className="container3" style={{ border: "green solid 9px" }}>
        <div className="container">
          <Link to="/CekSaldo">
            <button class="btn btn-success">Cek Saldo</button>
          </Link>
          <Link to="/Pembayaran">
            <button class="btn btn-success">Pembayaran</button>
          </Link>
        </div>

        <div className="container">
          <Link to="/TarikTunai">
            <button class="btn btn-success">TarikTunai</button>
          </Link>
          <Link to="/SetorTunai">
            <button class="btn btn-success">SetorTunai</button>
          </Link>
        </div>

        <div className="container">
          <Link to="/Transfer">
            <button class="btn btn-success">Transfer</button>
          </Link>
          <Link to="/Laporan">
            <button class="btn btn-success">Laporan</button>
          </Link>
        </div>
      </div>
    );
  }
}
export default MainMenu;
