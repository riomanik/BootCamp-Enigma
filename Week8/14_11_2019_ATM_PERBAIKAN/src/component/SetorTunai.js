import React from "react";
import { Link } from "react-router-dom";
import "./Login.css";

class SetorTunai extends React.Component {
  state = { Setor: null };

  DoSetor = () => {
    window.localStorage.setItem("Setor", this.state.Setor);
    const Saldo = window.localStorage.getItem("saldo");
    const Setor = window.localStorage.getItem("Setor");
    const SaldoUpdate = parseInt(Saldo) + parseInt(Setor);
    window.localStorage.setItem("saldoAkhir", Number(SaldoUpdate));
    alert("Setor Berhasil");
  };

  //   SetorTunai = Setor => {
  //     let LastSetor = JSON.parse(window.localStorage.getItem("Setor"));
  //     const Saldo = window.localStorage.getItem("saldo");
  //     if (LastSetor) {
  //       const SaldoUpdate = parseInt(Saldo) + parseInt(Setor);
  //       window.localStorage.setItem(
  //         "LastSetor",
  //         JSON.stringify([...LastSetor, { product: product, qty: qty }])
  //       );
  //     } else {
  //       lastKeranjang = [{ product: product, qty: qty }];
  //       window.localStorage.setItem("keranjang", JSON.stringify(lastKeranjang));
  //     }
  //     this.props.history.push({ pathname: "/MainMenu" });
  //   };

  Setor = event => {
    let a = event.target.value;
    this.setState({ Setor: a });
    console.log(this.state.Setor);
  };

  render() {
    return (
      <div class="container2" style={{ border: "green solid 9px" }}>
        <div style={{ width: "100%", height: "50px" }}>
          <div
            style={{
              color: "white",
              textAlign: "center",
              fontSize: 45,
              marginTop: "10%"
            }}
          >
            SETOR TUNAI
          </div>
          <div className="form2" style={{ width: "100%" }}>
            <div class="form-group col-md-5 ">
              <label for="input" class="sr-only"></label>
              <input
                style={{ width: "100%" }}
                type="text"
                class="form-control"
                id="input"
                placeholder="SETOR TUNAI"
                onChange={this.Setor}
              />
            </div>
            <div>
              <div>
                <button
                  type="submit"
                  class="btn btn-primary mr-3"
                  onClick={this.DoSetor}
                >
                  {"SUBMIT"}
                </button>
                <Link to="/MainMenu">
                  <button type="submit" class="btn btn-primary">
                    Back
                  </button>
                </Link>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
export default SetorTunai;
