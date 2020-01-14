import UserInfoRepository from "../repository/UserInfoRepository";
export default class UserInfoService {
  async getAllUserInfo() {
    return await new UserInfoRepository().findAllUserInfo();
  }

  async getAllUserInfoById(UserInfoId) {
    return await new UserInfoRepository().findOne(UserInfoId);
  }
}
