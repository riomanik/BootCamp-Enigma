import { Router } from "express";
import UserService from "../service/UserService";

const UserRouter = Router()
  .get("/all", async (req, res, next) => {
    const rows = await new UserService().getAllUser();
    res.json(rows);
  })
  .get("/all-by-user-id/:id", async (req, res, next) => {
    const rows = await new UserService().getAllUserById(req.params.id);
    res.json(rows);
  })
  .post("/add", async (req, res, next) => {
    await console.log("masuk");
    const user = { ...req.body };
    const result = await new UserService().saveUser(user);
    res.json(result);
  });
export default UserRouter;
