import { Router } from "express";
import UserInfoService from "../service/UserInfoService";

const UserInfoRouter = Router()
  .get("/all", async (req, res, next) => {
    const rows = await new UserInfoService().getAllUserInfo();
    res.json(rows);
  })
  .get("/all-by-user-info-id/:id", async (req, res, next) => {
    const rows = await new UserInfoService().getAllUserInfo(req.params.id);
    res.json(rows);
  });
export default UserInfoRouter;
