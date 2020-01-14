import express from "express";
import ProductRouter from "./ProductRouter";
import CategoryRouter from "./CategoryRouter";
import UserRouter from "./UserRouter";
import UserInfoRouter from "./UserInfoRouter";

export default express
  .Router()
  .use("/product", ProductRouter)
  .use("/category", CategoryRouter)
  .use("/user", UserRouter)
  .use("/user-info", UserInfoRouter)
  .use((req, res, next) => {
    res.status(404).json({ message: "Not Found." });
  });
