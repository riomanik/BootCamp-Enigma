import dotenv from "dotenv";

export default function configure() {
  dotenv.config();
  if (!process.env.APP_NAME) {
    console.error("ERROR BRO");
    process.exit(1);
  } else {
    return {
      appName: process.env.APP_NAME,
      appPort: process.env.APP_PORT,
      dbType: process.env.DB_TYPE,
      dbPort: process.env.DB_PORT,
      dbHost: process.env.DB_HOST,
      dbUser: process.env.DB_USERNAME,
      dbPassword: process.env.DB_PASSWORD,
      dbName: process.env.DB_NAME
    };
  }
}
