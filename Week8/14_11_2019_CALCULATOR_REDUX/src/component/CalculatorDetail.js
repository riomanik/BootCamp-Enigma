import React from "react";
import { connect } from "react-redux";
import { penjumlahan } from "../action";
import { pengurangan } from "../action";
import { pengalian } from "../action";
import { pembagian } from "../action";

class CalculatorDetail extends React.Component {
  state = { a: null, b: null };
  onchangeA = event => {
    let a = event.target.value;
    this.setState({ a: Number(a) });
  };
  onchangeB = event => {
    let a = event.target.value;
    this.setState({ b: Number(a) });
  };

  render() {
    return (
      <div className="container">
        <div className="container mt3">
          <div></div>
          <h1 className="row justify-content-center ">Calculator</h1>
          <div className="row justify-content-center ">
            <div
              className="col-md-6 border rounded"
              style={{ border: " black solid 5px" }}
            >
              <h1>{this.props.Calculator}</h1>
            </div>
          </div>
          <div className="row mt-3 justify-content-center">
            <div
              className="col-md-6 border rounded p-4 text-center"
              style={{
                display: "flex",
                justifyContent: "space-between",
                fontSize: "large"
              }}
            >
              <input
                type="text"
                onChange={this.onchangeA}
                style={{ border: " green solid 2px" }}
              />
              <input
                type="text"
                onChange={this.onchangeB}
                style={{ border: " green solid 2px" }}
              />
            </div>
          </div>
          <div className="row justify-content-center">
            <div className="col-md-6 border rounded p-4 text-center">
              <button
                class="btn btn-primary btn-lg active"
                role="button"
                aria-pressed="true"
                onClick={() =>
                  this.props.penjumlahan(this.state.a, this.state.b)
                }
              >
                +
              </button>
            </div>
          </div>

          <div className="row justify-content-center">
            <div className="col-md-6 border rounded p-4 text-center">
              <button
                class="btn btn-primary btn-lg active"
                role="button"
                aria-pressed="true"
                onClick={() =>
                  this.props.pengurangan(this.state.a, this.state.b)
                }
              >
                -
              </button>
            </div>
          </div>
          <div className="row justify-content-center">
            <div className="col-md-6 border rounded p-4 text-center">
              <button
                class="btn btn-primary btn-lg active"
                role="button"
                aria-pressed="true"
                onClick={() => this.props.pembagian(this.state.a, this.state.b)}
              >
                /
              </button>
            </div>
          </div>
          <div className="row justify-content-center">
            <div className="col-md-6 border rounded p-4 text-center">
              <button
                class="btn btn-primary btn-lg active"
                role="button"
                aria-pressed="true"
                onClick={() => this.props.pengalian(this.state.a, this.state.b)}
              >
                *
              </button>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

const mapStateToProps = state => {
  return { Calculator: state.calculator };
};

export default connect(mapStateToProps, {
  penjumlahan: penjumlahan,
  pengurangan: pengurangan,
  pengalian: pengalian,
  pembagian: pembagian
})(CalculatorDetail);
