import configure from "../config";
import { createConnection } from "typeorm";
import ProductSchema from "../entities/product.schema";
import CategorySchema from "../entities/category.schema";
import StatusSchema from "../entities/status.schema";
import UserSchema from "../entities/user.schema";
import UserInfoSchema from "../entities/userInfo.schema";

const { dbType, dbHost, dbPort, dbUser, dbPassword, dbName } = configure();

const createDbConnection = async () => {
  const connection = await createConnection({
    type: dbType || "mysql",
    host: dbHost || "localhost",
    port: dbPort || 3306,
    username: dbUser || "root",
    password: dbPassword || "",
    database: dbName || "express_database",
    // debug:true,
    entities: [
      ProductSchema,
      CategorySchema,
      StatusSchema,
      UserSchema,
      UserInfoSchema
    ]
  });

  return connection;
};

export default createDbConnection;
