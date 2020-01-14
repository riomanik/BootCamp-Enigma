import { createConnection, getRepository, getConnection } from "typeorm";
import ProductSchema from "../entities/product.schema";
import UserSchema from "../entities/user.schema";
import UserInfoSchema from "../entities/userInfo.schema";
import CategorySchema from "../entities/category.schema";
import StatusSchema from "../entities/status.schema";

export const init = async () => {
  const connection = await createConnection({
    type: "sqlite",
    database: ":memory:",
    dropSchema: true,
    synchronize: true,
    entities: [
      UserSchema,
      UserInfoSchema,
      StatusSchema,
      CategorySchema,
      ProductSchema
    ]
  });

  await initData();
};

const initData = async () => {
  await getRepository(UserSchema).save([
    {
      idUser: 1,
      username: "idroes1",
      password: "imoet1",
      userInfo: 1
    }
  ]);

  await getRepository(UserInfoSchema).save({
    phone: 88127382,
    idUserInfo: 1,
    idUser: 1,
    userFullName: "idroes imoet",
    userAddress: "cirebon",
    userEmail: "idroesimoet69Versi1@gmail.com"
  });

  await getRepository(StatusSchema).save({
    idStatus: 1,
    nameStatus: "Available"
  });

  await getRepository(CategorySchema).save({
    id: 1,
    categoryName: "Buah",
    status: 1
  });

  await getRepository(ProductSchema).save({
    productId: 1,
    productName: "Mangga",
    price: 1000,
    status: 1,
    category: 1
  });
};
export const clearance = () => {
  let conn = getConnection();
  return conn.close();
};

describe("Sample Test", () => {
  it("should test that true === true", () => {
    expect(true).toBe(true);
  });
});
