import React from "react";
import { Link } from "react-router-dom";

class Transfer extends React.Component {
  render() {
    return (
      <div class="jumbotron jumbotron-fluid">
        <div class="container">
          <h1 class="display-4">TRANSFER</h1>
          <p class="lead">Menu masih dalam proses</p>
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
export default Transfer;
