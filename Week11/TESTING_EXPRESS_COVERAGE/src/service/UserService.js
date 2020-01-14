export default class UserService {
  setRepository(repo) {
    this.repo = repo;
    return this;
  }
  getAllUser() {
    return this.repo.findAllUser();
  }
  getAllUserById(UserId) {
    console.log(UserId);
    return this.repo.findOne(UserId);
  }
  saveUser(user) {
    return this.repo.saveUser(user);
  }
}
