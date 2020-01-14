import configure from "./config";
import express from "express";
import createDbConnection from "./database/connection";
import appMiddleware from "./middlewares/app-middleware";
import AppRouter from "./routes";

configure();

createDbConnection()
  .then(connection => {
    if (connection.isConnected) {
      const app = express();
      app.use(appMiddleware);
      app.use(AppRouter);
      app.listen(process.env.APP_PORT, () => {
        console.log(
          `${process.env.APP_NAME} listening on port ${process.env.APP_PORT}!`
        );
      });
    }
  })
  .catch(error => {
    console.error("Error starting up server.");
    console.error(error);
  });

// connection.query("SELECT * from heroes", function(err, rows, fields) {
//   if (err) throw err;

//   console.log("data: ", rows);
//   let hero = rows;
//   let heroFilter = hero.filter(hero => hero.name === "rafaela");
//   console.log(JSON.stringify(hero[3]) + " ini adalah data ke 4 ");
//   console.log(JSON.stringify(hero[0].name) + " ini hero");
// });

// connection.end();
