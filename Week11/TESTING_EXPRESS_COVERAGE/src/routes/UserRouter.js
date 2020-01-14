import { Router } from "express";
import {
  getAllUser,
  getAllUserById,
  addUser
} from "../controller/user.controller";
import UserService from "../service/UserService";

const UserRouter = Router()
  .get("/all", (req, res) => getAllUser(req, res, new UserService()))
  .get("/all-by-user-id/:id", (req, res) =>
    getAllUserById(req, res, new UserService())
  )
  .post("/add", (req, res) => addUser(req, res, new UserService()));
export default UserRouter;
