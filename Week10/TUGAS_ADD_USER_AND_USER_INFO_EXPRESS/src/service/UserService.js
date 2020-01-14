import UserRepository from "../repository/UserRepository";
import UserInfoRepository from "../repository/UserInfoRepository";
export default class UserService {
  async getAllUser() {
    return await new UserRepository().findAllUser();
  }
  async getAllUserById(UserId) {
    return await new UserRepository().findOne(UserId);
  }
  async saveUser(user) {
    await console.log(user);
    return await new UserRepository().saveUser(user);
    // await new UserInfoRepository().saveUserInfo(user.userInfo);
    // return await new UserRepository().findOne(user.idUser);
  }
}
