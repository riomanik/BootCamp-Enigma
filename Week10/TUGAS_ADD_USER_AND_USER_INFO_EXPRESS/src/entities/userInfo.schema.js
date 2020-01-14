import { EntitySchema } from "typeorm";
import UserInfo from "../model/userInfo.model";

const UserInfoSchema = new EntitySchema({
  name: "UserInfo",
  target: UserInfo,
  tableName: "user_info",
  columns: {
    idUserInfo: {
      name: "id_user_info",
      primary: true,
      type: "int"
    },
    idUser: {
      name: "id_user",
      type: "int"
    },
    userFullName: {
      name: "user_full_name",
      type: "varchar"
    },
    userAddress: {
      name: "user_address",
      type: "varchar"
    },
    userEmail: {
      name: "user_email",
      type: "varchar"
    },
    phone: {
      name: "phone",
      type: "int"
    }
  },
  relations: {
    user: {
      target: "User",
      type: "one-to-one",
      joinColumn: { name: "id_user" }
    }
  }
});
export default UserInfoSchema;
