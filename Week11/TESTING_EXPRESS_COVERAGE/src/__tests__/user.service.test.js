import UserService from "../service/UserService";
import UserRepository from "../repository/UserRepository";

let userRepository;
let userService;

beforeAll(async () => {
  userRepository = new UserRepository();
  userService = new UserService();
});

describe("user service test ", () => {
  it("should call get all user", async () => {
    userRepository.findAllUser = jest.fn(() => {
      return {
        idUser: 2,
        username: "idroes2",
        password: "imoet2",
        userInfo: {
          phone: 88127382,
          idUserInfo: 2,
          idUser: 2,
          userFullName: "idroes imoet2",
          userAddress: "cirebon",
          userEmail: "idroesimoet69Versi2@gmail.com"
        }
      };
    });

    userService.setRepository(userRepository);

    expect(userService.getAllUser()).toEqual({
      idUser: 2,
      username: "idroes2",
      password: "imoet2",
      userInfo: {
        phone: 88127382,
        idUserInfo: 2,
        idUser: 2,
        userFullName: "idroes imoet2",
        userAddress: "cirebon",
        userEmail: "idroesimoet69Versi2@gmail.com"
      }
    });
  });
  it("should call get all user by id", async () => {
    userRepository.findOne = jest.fn(() => {
      return {
        idUser: 2,
        username: "idroes2",
        password: "imoet2",
        userInfo: {
          phone: 88127382,
          idUserInfo: 2,
          idUser: 2,
          userFullName: "idroes imoet2",
          userAddress: "cirebon",
          userEmail: "idroesimoet69Versi2@gmail.com"
        }
      };
    });

    userService.setRepository(userRepository);

    expect(userService.getAllUserById(2)).toEqual({
      idUser: 2,
      username: "idroes2",
      password: "imoet2",
      userInfo: {
        phone: 88127382,
        idUserInfo: 2,
        idUser: 2,
        userFullName: "idroes imoet2",
        userAddress: "cirebon",
        userEmail: "idroesimoet69Versi2@gmail.com"
      }
    });
  });
});

it("should create user", async () => {
  const user = {
    idUser: 2,
    username: "idroes2",
    password: "imoet2",
    userInfo: {
      phone: 88127382,
      idUserInfo: 2,
      idUser: 2,
      userFullName: "idroes imoet2",
      userAddress: "cirebon",
      userEmail: "idroesimoet69Versi2@gmail.com"
    }
  };
  userRepository.saveUser = jest.fn(user => {
    return user;
  });
  userService.setRepository(userRepository);
  expect(userService.saveUser(user)).toEqual(user);
});
