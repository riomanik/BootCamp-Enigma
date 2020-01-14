import UserInfoService from "../service/UserInfoService";
import {
  getAllUserInfo,
  getAllUserInfoById
} from "../controller/userInfo.controller";
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
describe("UserInfo Controller Test", () => {
  it("should call find all userInfo", async () => {
    const req = mockRequest();
    const res = mockResponse();
    const userInfoService = new UserInfoService();
    userInfoService.getAllUserInfo = jest.fn(() => [{ id: "1" }]);
    await getAllUserInfo(req, res, userInfoService);
    expect(res.json).toHaveBeenCalledWith([{ id: "1" }]);
    expect(res.status).toHaveBeenCalledWith(200);
  });
  it("should call find negative all userInfo", async () => {
    const req = mockRequest();
    const res = mockResponse();
    const userInfoService = new UserInfoService();
    userInfoService.getAllUsadaserInfo = jest.fn(() => [{ id: "1" }]);
    await getAllUserInfo(req, res, userInfoService);
    expect(res.err);
  });
});

it("should call userInfo by id", async () => {
  const req = mockRequestId();
  const res = mockResponse();
  const userInfoService = new UserInfoService();
  userInfoService.getAllUserInfoById = jest.fn(() => {
    return { id: req.params.id };
  });
  await getAllUserInfoById(req, res, userInfoService);
  expect(res.json).toHaveBeenCalledWith({ id: req.params.id });
  expect(res.status).toHaveBeenCalledWith(200);
});
it("should call negative userInfo by id", async () => {
  const req = mockRequestId();
  const res = mockResponse();
  const userInfoService = new UserInfoService();
  userInfoService.getAllUsasdaserInfoById = jest.fn(() => {
    return { id: req.params.id };
  });
  await getAllUserInfoById(req, res, userInfoService);
  expect(res.err);
});
