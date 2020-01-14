import { getRepository } from "typeorm";
import UserInfo from "../model/userInfo.model";

export default class UserInfoRepository {
  userInfoRepository() {
    return getRepository(UserInfo);
  }

  async findAllUserInfo() {
    const userInfo = await this.userInfoRepository().find();
    return userInfo;
  }

  async findOne(id) {
    const userInfo = await this.userInfoRepository().find({
      where: { idUserInfo: id }
    });
    return userInfo;
  }
}
