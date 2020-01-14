import React from "react";
import ReactDOM from "react-dom";

const Login = () => {
  const formLogin = {
    label1: { text1: "Username: " },
    label2: { text2: "Password :  " },
    button: { login: " Submit" }
  };

  const style = { backgroundColor: "green  ", color: "white" };

  return (
    <div>
      <label class="label1" forname="userName">
        {formLogin.label1.text1}
      </label>
      <input id="name" type="text" />
      <br></br>
      <label class="label2" forname="userPassword">
        {formLogin.label2.text2}
      </label>
      <input id="name" type="text" />
      <br></br>
      <button style={style}>{formLogin.button.login}</button>
    </div>
  );
};

const Content = () => {
  const formContent = {
    content1: {
      conten2:
        "Dari mana saya bisa mendapatkannya ada banyak variasi tulisan Lorem Ipsum yang tersedia, tapi kebanyakan sudah mengalami perubahan bentuk, entah karena unsur humor atau kalimat yang diacak hingga nampak sangat tidak masuk akal."
    }
  };

  const styleContent = {
    position: "relative  ",
    width: "400px",
    height: "200px",
    border: "3px solid #73AD21"
  };
  return (
    <div>
      <br></br>
      <p style={styleContent}>{formContent.content1.conten2}</p>
    </div>
  );
};

const Application = () => {
  return (
    <div>
      <Login />
      <Content />
    </div>
  );
};
ReactDOM.render(<Application />, document.querySelector("#root"));
