import { getRepository } from "typeorm";
import Product from "../model/product.model";

export default class ProductRepository {
  productRepository() {
    return getRepository(Product);
  }

  async findAllProduct() {
    const product = await this.productRepository().find();
    return product;
  }

  async findOne(id) {
    console.log(id);
    const product = await this.productRepository().find({
      where: { productId: id }
    });
    return product;
  }

  async saveProduct(product) {
    const saveProduct = await this.productRepository().save(product);
    return saveProduct;
  }
  async updateProduct(product) {
    const updateProduct = await this.productRepository().save(product);
    return updateProduct;
  }
  async deleteProduct(product) {
    const deleteProduct = await this.productRepository().delete(product);
    return deleteProduct;
  }
  // async disableProduct(product) {
  //   const deleteProduct = await this.productRepository().query(
  //     "Update product set status = 2 where product_id = ?",
  //     [product.productId]
  //   );
  //   return deleteProduct;
  // }
}
