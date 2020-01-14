export default class CategoryService {
  setRepository(repo) {
    this.repo = repo;
    return this;
  }

  getAllCategory() {
    return this.repo.findAllCategory();
  }
  getAllCategoryByCategoryId(categoryId) {
    return this.repo.findOne(categoryId);
  }
  saveCategory(category) {
    this.repo.saveCategory(category);
    // const idCategory = category.categoryId;
    return this.getAllCategory();
  }
  updateCategory(category) {
    this.repo.updateCategory(category);
    // const idCategory = category.categoryId;
    return this.getAllCategory();
  }
  deleteCategory(category) {
    this.repo.deleteCategory(category);
    return this.getAllCategory();
  }
  // categoryWantDisable(category) {
  //   const idCategory = await category.categoryId;
  //   const categoryDisable = await new CategoryRepository().findOne(idCategory);
  //   await new CategoryRepository().disableCategory(categoryDisable);
  //   return await new CategoryRepository().findAllCategory();
  // }
}
