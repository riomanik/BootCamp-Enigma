import Login from "../Login";
import { shallow } from "enzyme";
import React from "react";

let wrapper;
beforeAll(() => {
  wrapper = shallow(<Login />);
});

describe("Login Component", () => {
  it("should render", () => {
    expect(wrapper.find("label").length).toEqual(2);

    const inputContainer = wrapper.find("input");
    expect(inputContainer).toHaveLength(2);

    const buttonContainer = wrapper.find("button");
    expect(buttonContainer).toHaveLength(1);
  });

  it("should render input for user name & paword also button sign in", () => {
    expect(wrapper.find('[name="userName"]')).toHaveLength(1);
    expect(wrapper.find('[name="userPassword"]')).toHaveLength(1);

    const buttonContainer = wrapper.find("button");
    expect(buttonContainer.text()).toEqual("submit");
    expect(buttonContainer.prop("disabled")).toEqual(true);
  });

  it("should have state set properly", () => {
    expect(wrapper.state().UsernameInput).toEqual("");
    expect(wrapper.state().PasswordInput).toEqual("");
  });

  it("input user name event & set state", () => {
    wrapper
      .find("input")
      .at(0)
      .simulate("change", { target: { value: "rio" } });
    expect(wrapper.instance().state.UsernameInput).toEqual("rio");

    wrapper
      .find("input")
      .at(1)
      .simulate("change", { target: { value: "rio" } });
    expect(wrapper.instance().state.PasswordInput).toEqual("rio");
  });
});
