import UserInfoService from "../service/UserInfoService";
import UserInfoRepository from "../repository/UserInfoRepository";

let userInfoRepository;
let userInfoService;

beforeAll(async () => {
  userInfoRepository = new UserInfoRepository();
  userInfoService = new UserInfoService();
});

describe("userInfo service test ", () => {
  it("should call get all userInfo", async () => {
    userInfoRepository.findAllUserInfo = jest.fn(() => {
      return {
        phone: 88127382,
        idUserInfo: 1,
        idUser: 1,
        userFullName: "idroes imoet",
        userAddress: "cirebon",
        userEmail: "idroesimoet69Versi1@gmail.com"
      };
    });

    userInfoService.setRepository(userInfoRepository);

    expect(userInfoService.getAllUserInfo()).toEqual({
      phone: 88127382,
      idUserInfo: 1,
      idUser: 1,
      userFullName: "idroes imoet",
      userAddress: "cirebon",
      userEmail: "idroesimoet69Versi1@gmail.com"
    });
  });
  it("should call get all userInfo by id", async () => {
    userInfoRepository.findOne = jest.fn(() => {
      return {
        phone: 88127382,
        idUserInfo: 1,
        idUser: 1,
        userFullName: "idroes imoet",
        userAddress: "cirebon",
        userEmail: "idroesimoet69Versi1@gmail.com"
      };
    });

    userInfoService.setRepository(userInfoRepository);

    expect(userInfoService.getAllUserInfoById(2)).toEqual({
      phone: 88127382,
      idUserInfo: 1,
      idUser: 1,
      userFullName: "idroes imoet",
      userAddress: "cirebon",
      userEmail: "idroesimoet69Versi1@gmail.com"
    });
  });
});
