import React from "react";
import { Link } from "react-router-dom";

class CekSaldo extends React.Component {
  render() {
    const Saldo = window.localStorage.getItem("saldoAkhir");
    return (
      <div class="jumbotron jumbotron-fluid">
        <div class="container">
          <h1 class="display-4">SALDO ANDA</h1>
          <h1>Rp.{Saldo}</h1>
        </div>
        <Link to="/MainMenu">
          <div className="container">
            <button type="button" class="btn btn-primary btn-lg">
              Back
            </button>
          </div>
        </Link>
      </div>
    );
  }
}
export default CekSaldo;
