import React from "react";
import { Link } from "react-router-dom";

class Pembayaran extends React.Component {
  render() {
    return (
      <div class="container">
        <h1 class="display-4">PEMBAYARAN</h1>
        <p>Menu masih dalam perbaikan atau belum dikerjakan</p>
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
export default Pembayaran;
