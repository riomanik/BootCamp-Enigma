import { Router } from "express";
import UserInfoService from "../service/UserInfoService";
import {
  getAllUserInfo,
  getAllUserInfoById
} from "../controller/userInfo.controller";

const UserInfoRouter = Router()
  .get("/all", (req, res) => getAllUserInfo(req, res, new UserInfoService()))
  .get("/all-by-user-info-id/:id", (req, res) =>
    getAllUserInfoById(req, res, new UserInfoService())
  );
export default UserInfoRouter;
