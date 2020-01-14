import React from "react";
import App from "../../App";
import Login from "../Login";
import { shallow } from "enzyme";

describe("App Component", () => {
  it("should render", () => {
    const wrapper = shallow(<App />);
    expect(wrapper.find(Login).length).toEqual(1);
  });
});
