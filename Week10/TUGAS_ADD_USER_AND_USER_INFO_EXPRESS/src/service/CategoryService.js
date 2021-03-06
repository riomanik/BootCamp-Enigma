import CategoryRepository from "../repository/CategoryRepository";

export default class CategoryService {
  async getAllCategory() {
    return await new CategoryRepository().findAllCategory();
  }
  async getAllCategoryByCategoryId(categoryId) {
    return await new CategoryRepository().findOne(categoryId);
  }
  async saveCategory(category) {
    await new CategoryRepository().saveCategory(category);
    const idCategory = category.categoryId;
    return await new CategoryRepository().findOne(idCategory);
  }
  async updateCategory(category) {
    await new CategoryRepository().updateCategory(category);
    const idCategory = category.categoryId;
    return await new CategoryRepository().findOne(idCategory);
  }
  async deleteCategory(category) {
    await new CategoryRepository().deleteCategory(category);
    return await new CategoryRepository().findAllCategory();
  }
  async categoryWantDisable(category) {
    const idCategory = await category.categoryId;
    const categoryDisable = await new CategoryRepository().findOne(idCategory);
    await new CategoryRepository().disableCategory(categoryDisable);
    return await new CategoryRepository().findAllCategory();
  }
}
