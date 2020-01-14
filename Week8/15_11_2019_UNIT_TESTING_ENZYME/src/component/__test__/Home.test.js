import React from "react";
import Login from "../Login";
import { shallow } from "enzyme";
import HOME from "../Home";

describe("App Component", () => {
  it("should render", () => {
    const wrapper = shallow(<HOME />);
    expect(wrapper.find(Login).length).toEqual(1);
  });
});
