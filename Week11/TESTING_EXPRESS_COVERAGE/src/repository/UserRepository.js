import { getRepository } from "typeorm";
import User from "../model/user.model";

export default class UserRepository {
  userRepository() {
    return getRepository(User);
  }

  async findAllUser() {
    const user = await getRepository(User)
      .createQueryBuilder("User")
      .innerJoinAndSelect("User.userInfo", "p");

    // console.log(user()

    const data = user.getMany();
    return data;
  }

  // async findAll() {
  //   const user = await this.userRepository().find();
  //   return user;
  // }

  // async findOne(id) {
  //   const user = await this.userRepository()
  //     .createQueryBuilder("user")
  //     .innerJoinAndSelect(("UserInfo.user", "user").getOne());
  //   return user;
  // }

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
