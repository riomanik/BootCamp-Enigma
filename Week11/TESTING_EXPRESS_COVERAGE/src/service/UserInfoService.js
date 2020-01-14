export default class UserInfoService {
  setRepository(repo) {
    this.repo = repo;
    return this;
  }

  getAllUserInfo() {
    return this.repo.findAllUserInfo();
  }

  getAllUserInfoById(UserInfoId) {
    return this.repo.findOne(UserInfoId);
  }
}
