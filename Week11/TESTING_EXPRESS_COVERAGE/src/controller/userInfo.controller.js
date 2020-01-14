import { logErrorEvent } from "../events/logging.event";
import UserInfoRepository from "../repository/UserInfoRepository";

const userInfoRepository = new UserInfoRepository();

export const getAllUserInfo = async (req, res, userInfoService) => {
  try {
    const rows = await userInfoService
      .setRepository(userInfoRepository)
      .getAllUserInfo();
    return res.status(200).json(rows);
  } catch (error) {
    logErrorEvent.emit("CONTROLLER", error, res);
  }
};

export const getAllUserInfoById = async (req, res, userInfoService) => {
  try {
    const rows = await userInfoService
      .setRepository(userInfoRepository)
      .getAllUserInfoById(req.params.id);
    return res.status(200).json(rows);
  } catch (err) {
    logErrorEvent.emit("CONTROLLER", err, res);
  }
};
