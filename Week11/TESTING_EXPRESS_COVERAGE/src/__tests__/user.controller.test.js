import UserService from "../service/UserService";
import {
  getAllUser,
  getAllUserById,
  addUser
} from "../controller/user.controller";
let mockResponse;
let mockRequest;
let mockRequestId;
beforeAll(async () => {
  mockResponse = () => {
    const res = {};
    res.status = jest.fn().mockReturnValue(res);
    res.json = jest.fn().mockReturnValue(res);
    return res;
  };
  mockRequest = () => {
    const res = {};
    return res;
  };
  mockRequestId = () => {
    const res = { params: { id: 1 } };
    return res;
  };
});
describe("User Controller Test", () => {
  it("should call find all user", async () => {
    const req = mockRequest();
    const res = mockResponse();
    const userService = new UserService();
    userService.getAllUser = jest.fn(() => [{ id: "1" }]);
    await getAllUser(req, res, userService);
    expect(res.json).toHaveBeenCalledWith([{ id: "1" }]);
    expect(res.status).toHaveBeenCalledWith(200);
  });
  it("should call find negative all user", async () => {
    const req = mockRequest();
    const res = mockResponse();
    const userService = new UserService();
    userService.getAllUssadaser = jest.fn(() => [{ id: "1" }]);
    await getAllUser(req, res, userService);
    expect(res.err);
  });
});

it("should call user by id", async () => {
  const req = mockRequestId();
  const res = mockResponse();
  const userService = new UserService();
  userService.getAllUserById = jest.fn(() => {
    return { id: req.params.id };
  });
  await getAllUserById(req, res, userService);
  expect(res.json).toHaveBeenCalledWith({ id: req.params.id });
  expect(res.status).toHaveBeenCalledWith(200);
});
it("should call negative user by id", async () => {
  const req = mockRequestId();
  const res = mockResponse();
  const userService = new UserService();
  userService.getAllUssadsaerById = jest.fn(() => {
    return { id: req.params.id };
  });
  await getAllUserById(req, res, userService);
  expect(res.err);
});

it("should call create user", async () => {
  const req = mockRequest();
  const res = mockResponse();
  const userService = new UserService();
  userService.saveUser = jest.fn(() => [{ id: "1" }]);
  await addUser(req, res, userService);
  expect(res.json).toHaveBeenCalledWith([{ id: "1" }]);
  expect(res.status).toHaveBeenCalledWith(200);
});
it("should call negative create user", async () => {
  const req = mockRequest();
  const res = mockResponse();
  const userService = new UserService();
  userService.saveUsadasser = jest.fn(() => [{ id: "1" }]);
  await addUser(req, res, userService);
  expect(res.err);
});
