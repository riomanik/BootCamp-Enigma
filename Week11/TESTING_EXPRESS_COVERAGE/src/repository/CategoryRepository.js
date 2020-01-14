import { getRepository } from "typeorm";
import Category from "../model/category.model";

export default class CategoryRepository {
  categoryRepository() {
    return getRepository(Category);
  }

  async findAllCategory() {
    const category = await this.categoryRepository().find();
    return category;
  }

  async findOne(id) {
    const category = await this.categoryRepository().find({
      where: { id: id }
    });
    return category;
  }

  // async findAllCategoryProduct() {
  //   const category = await this.categoryRepository().find({
  //     relations: ["product"]
  //   });
  //   return category;
  // }

  async saveCategory(category) {
    const saveCategory = await this.categoryRepository().save(category);
    return saveCategory;
  }
  async updateCategory(category) {
    const updateCategory = await this.categoryRepository().save(category);
    return updateCategory;
  }
  async deleteCategory(category) {
    const deleteCategory = await this.categoryRepository().delete(category);
    console.log(JSON.stringify(deleteCategory) + "ini deleted");
    console.log("deleted");
    return deleteCategory;
  }
  // async disableCategory(category) {
  //   let categoryWantDisable = await {
  //     id: category[0].id,
  //     categoryName: category[0].categoryName,
  //     status: {
  //       idStatus: 4
  //     }
  //   };
  //   const deleteCategory = await this.categoryRepository().save(
  //     categoryWantDisable
  //   );
  //   return deleteCategory;
  // }
}
