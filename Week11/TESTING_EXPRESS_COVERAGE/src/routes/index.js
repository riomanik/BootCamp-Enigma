import express from "express";
import ProductRouter from "./ProductRouter";
import CategoryRouter from "./CategoryRouter";
import UserRouter from "./UserRouter";
import UserInfoRouter from "./UserInfoRouter";
import { logErrorEvent, logInfoEvent } from "../events/logging.event";
import fs from "fs";

export default express
  .Router()
  // .use("/auth", AuthRouter)
  // .use(function(req, res, next) {
  //   if (req.session.name) {
  //     next();
  //   } else {
  //     logErrorEvent.emit("SESSION", res);
  //   }
  // })
  // .user(function (req, res, next) {
  // solve 1
  // log.info({ transType: "USERACCESS" }, req);

  // solve 2
  // logInfoEvent.emit("ACCESS", req.originalUrl);
  // next();
  // })
  .use("/product", ProductRouter)
  .use("/category", CategoryRouter)
  .use("/user", UserRouter)
  .use("/user-info", UserInfoRouter)
  .use("/stream", (req, res) => {
    const file =
      "E:\\ENIGMACAMP_RIO\\Chou Ikimonobakari ~Ten-nen Kinen Members BEST Selection~ [Best Of] (2016.03.15)\\01 SAKURA.m4a";
    fs.exists(file, exists => {
      if (exists) {
        fs.createReadStream(file).pipe(res);
      } else {
        res.send("Error -404");
      }
    });
  })

  // .user(function(req, res, next) {
  //   res.body = res.body + "modified";
  //   next();
  // })
  .use((req, res, next) => {
    // solve 1
    // log.error({ transType: "USERACCESS-FAILED" }, req);
    // res.status(404).json({ message: "Not Found." });

    // solve 2
    logErrorEvent.emit("ROUTE", req, res);
  });
