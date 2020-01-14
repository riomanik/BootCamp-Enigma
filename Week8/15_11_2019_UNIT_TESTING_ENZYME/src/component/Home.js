import React from "react";
import { connect } from "react-redux";

class HOME extends React.Component {
  render() {
    return (
      <div>
        <h1>WELCOME BACK {this.props.userInfo}</h1>
      </div>
    );
  }
}
const mapStateToProps = state => {
  return { userInfo: state.auth };
};
export default connect(mapStateToProps)(HOME);
