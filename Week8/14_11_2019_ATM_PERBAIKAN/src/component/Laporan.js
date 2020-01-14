import React from "react";
import { Link } from "react-router-dom";

class Laporan extends React.Component {
  state = { Transaksi: [] };

  componentDidMount() {}
  listKeranjang = () => {
    const saldoAwal = window.localStorage.getItem("saldoAwal");
    const saldoditarik = window.localStorage.getItem("tarik");
    const saldodisetor = window.localStorage.getItem("Setor");
    const saldoAkhir = window.localStorage.getItem("saldoAkhir");
    console.log(saldoAwal);
    return (
      <tr>
        <th scope="row">{saldoAwal}</th>
        <td>{saldoditarik}</td>
        <td>{saldodisetor}</td>
        <td>{saldoAkhir}</td>
      </tr>
    );
  };

  render() {
    return (
      <div>
        <div className="container">
          <table class="table">
            <thead>
              <tr>
                <th scope="col">Saldo Awal</th>
                <th scope="col">Saldo Ditarik</th>
                <th scope="col">Saldo Disetor</th>
                <th scope="col">Saldo Akhir</th>
              </tr>
            </thead>
            <tbody>{this.listKeranjang()}</tbody>
          </table>
        </div>
        <div className="container">
          <Link className="btn btn-success" to="/MainMenu">
            {"CLOSED"}
          </Link>
        </div>
      </div>
    );
  }
}
export default Laporan;
