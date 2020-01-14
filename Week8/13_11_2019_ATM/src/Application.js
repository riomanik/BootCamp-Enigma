import React from "react";
import { BrowserRouter, Route, Redirect } from "react-router-dom";
import Login from "./component/Login";
import MainMenu from "./component/MainMenu";
import CekSaldo from "./component/CekSaldo";
import Laporan from "./component/Laporan";
import Pembayaran from "./component/Pembayaran";
import SetorTunai from "./component/SetorTunai";
import TarikTunai from "./component/TarikTunai";
import Transfer from "./component/Transfer";

class Application extends React.Component {
  state = { Login: false, Saldo: null };

  componentDidMount() {
    window.localStorage.setItem("saldo", Number("900000"));
    const Saldo = Number(window.localStorage.getItem("saldo"));
    this.setState({ Saldo: Saldo });
    window.localStorage.setItem("saldoAwal", Number("900000"));
  }

  ChangeSaldo = action => {
    this.setState({ Saldo: action });
  };

  Submit = action => {
    this.setState({ Login: action });
  };

  render() {
    return (
      <div>
        <BrowserRouter>
          <div>
            <Route
              path="/"
              exact
              render={props => <Login onSubmit={this.Submit} {...props} />}
            />
            <Route
              path="/CekSaldo"
              exact
              render={props => {
                return this.state.Login ? (
                  <div>
                    <CekSaldo cekSaldo={this.state.Saldo} {...props} />
                  </div>
                ) : (
                  <Redirect to="/" />
                );
              }}
            />
            <Route
              path="/Laporan"
              exact
              render={props => {
                return this.state.Login ? (
                  <div>
                    <Laporan {...props} />
                  </div>
                ) : (
                  <Redirect to="/" />
                );
              }}
            />
            <Route
              path="/MainMenu"
              exact
              render={props => {
                return this.state.Login ? (
                  <div>
                    <MainMenu {...props} />
                  </div>
                ) : (
                  <Redirect to="/" />
                );
              }}
            />
            <Route
              path="/Pembayaran"
              exact
              render={props => {
                return this.state.Login ? (
                  <div>
                    <Pembayaran {...props} />
                  </div>
                ) : (
                  <Redirect to="/" />
                );
              }}
            />
            <Route
              path="/SetorTunai"
              exact
              render={props => {
                return this.state.Login ? (
                  <div>
                    <SetorTunai Setor={this.ChangeSaldo} {...props} />
                  </div>
                ) : (
                  <Redirect to="/" />
                );
              }}
            />
            <Route
              path="/TarikTunai"
              exact
              render={props => {
                return this.state.Login ? (
                  <div>
                    <TarikTunai Tarik={this.ChangeSaldo} {...props} />
                  </div>
                ) : (
                  <Redirect to="/" />
                );
              }}
            />
            <Route
              path="/Transfer"
              exact
              render={props => {
                return this.state.Login ? (
                  <div>
                    <Transfer {...props} />
                  </div>
                ) : (
                  <Redirect to="/" />
                );
              }}
            />
          </div>
        </BrowserRouter>
      </div>
    );
  }
}
export default Application;
