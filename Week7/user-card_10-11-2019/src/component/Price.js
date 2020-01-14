import React from "react";

class Price extends React.Component {
  // const Content = props => {
  // console.log(props);

  doClosePrice = () => {
    this.props.changePrice();
  };

  render() {
    return (
      <div className="newcontainer">
        <div class="contact1">
          <div class="container-contact1">
            <div class="contact1-pic js-tilt" data-tilt>
              <img src="./enigma.jpg" alt="IMG" />
            </div>

            <form class="contact1-form validate-form">
              <span class="contact1-form-title">Get in touch</span>

              <div
                class="wrap-input1 validate-input"
                data-validate="Name is required"
              >
                <input
                  class="input1"
                  type="text"
                  name="name"
                  placeholder="Name"
                />
                <span class="shadow-input1"></span>
              </div>

              <div
                class="wrap-input1 validate-input"
                data-validate="Valid email is required: ex@abc.xyz"
              >
                <input
                  class="input1"
                  type="text"
                  name="email"
                  placeholder="Email"
                />
                <span class="shadow-input1"></span>
              </div>

              <div
                class="wrap-input1 validate-input"
                data-validate="Subject is required"
              >
                <input
                  class="input1"
                  type="text"
                  name="subject"
                  placeholder="Subject"
                />
                <span class="shadow-input1"></span>
              </div>

              <div
                class="wrap-input1 validate-input"
                data-validate="Message is required"
              >
                <textarea
                  class="input1"
                  name="message"
                  placeholder="Message"
                ></textarea>
                <span class="shadow-input1"></span>
              </div>

              <div class="container-contact1-form-btn">
                <button class="contact1-form-btn">
                  <span>
                    Send Email
                    <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
                  </span>
                </button>
              </div>
            </form>
          </div>
        </div>
        <div className="container-login100-form-btn1">
          <br></br>
          <button className="login100-form-btn1" onClick={this.doClosePrice}>
            {"CLOSED"}
          </button>
        </div>
        <br></br>
      </div>
    );
  }
}
export default Price;
