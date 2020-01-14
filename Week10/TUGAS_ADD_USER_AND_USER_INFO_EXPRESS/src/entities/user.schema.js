import { EntitySchema } from "typeorm";
import User from "../model/user.model";

const UserSchema = new EntitySchema({
  name: "User",
  target: User,
  tableName: "user",
  columns: {
    idUser: {
      name: "id_user",
      primary: true,
      type: "int"
    },
    username: {
      name: "username",
      type: "varchar"
    },
    password: {
      name: "password",
      type: "varchar"
    }
  },
  relations: {
    userInfo: {
      target: "UserInfo",
      type: "one-to-one",
      cascade: true,
      inverseSide: "user"
    }
  }
});
export default UserSchema;
