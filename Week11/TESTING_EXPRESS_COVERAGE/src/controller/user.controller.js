import { logErrorEvent } from "../events/logging.event";
import UserRepository from "../repository/UserRepository";

const userRepository = new UserRepository();

export const getAllUser = async (req, res, userService) => {
  try {
    const rows = await userService.setRepository(userRepository).getAllUser();
    return res.status(200).json(rows);
  } catch (error) {
    logErrorEvent.emit("CONTROLLER", error, res);
  }
};

export const getAllUserById = async (req, res, userService) => {
  try {
    const rows = await userService
      .setRepository(userRepository)
      .getAllUserById(req.params.id);
    return res.status(200).json(rows);
  } catch (err) {
    logErrorEvent.emit("CONTROLLER", err, res);
  }
};

export const addUser = async (req, res, userService) => {
  try {
    const user = { ...req.body };
    const result = await userService
      .setRepository(userRepository)
      .saveUser(user);
    return res.status(200).json(result);
  } catch (err) {
    logErrorEvent.emit("CONTROLLER", err, res);
  }
};
