import { getRepository } from "typeorm";
import User from "../model/user.model";

export default class UserRepository {
  userRepository() {
    return getRepository(User);
  }

  async findAllUser() {
    const user = await this.userRepository().find({
      relations: ["userInfo"]
    });
    // console.log(user);
    return user;
  }

  async findOne(id) {
    const user = await this.userRepository().find({
      where: { idUser: id }
    });
    return user;
  }

  async saveUser(user) {
    await console.log(user);
    const saveUser = await this.userRepository().save(user);
    await console.log(saveUser);
    return saveUser;
  }
}
