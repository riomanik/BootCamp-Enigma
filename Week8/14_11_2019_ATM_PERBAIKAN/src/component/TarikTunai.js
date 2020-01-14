import React from "react";
import { Link } from "react-router-dom";

class TarikTunai extends React.Component {
  state = { Tarik: null };

  DoTarik = () => {
    window.localStorage.setItem("tarik", this.state.Tarik);
    const Saldo = Number(window.localStorage.getItem("saldo"));
    const Tarik = Number(window.localStorage.getItem("tarik"));

    if (Saldo >= Tarik) {
      const SaldoUpdate = parseInt(Saldo) - parseInt(Tarik);
      window.localStorage.setItem("saldoAkhir", Number(SaldoUpdate));
      alert("Penarikan Berhasil");
    } else {
      alert("Saldo anda tidak cukup");
    }
  };

  Tarik = event => {
    let a = event.target.value;
    this.setState({ Tarik: a });
    console.log(this.state.Tarik);
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
            TARIK TUNAI
          </div>
          <div className="form2" style={{ width: "100%" }}>
            <div class="form-group col-md-5 ">
              <label for="input" class="sr-only"></label>
              <input
                style={{ width: "100%" }}
                type="text"
                class="form-control"
                id="input"
                placeholder="TARIK TUNAI"
                onChange={this.Tarik}
              />
            </div>
            <div>
              <div>
                <button
                  type="submit"
                  class="btn btn-primary mr-3"
                  onClick={this.DoTarik}
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
export default TarikTunai;
