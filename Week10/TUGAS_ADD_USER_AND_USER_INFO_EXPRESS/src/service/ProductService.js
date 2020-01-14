import ProductRepository from "../repository/ProductRepository";

export default class ProductService {
  async getAllProduct() {
    return await new ProductRepository().findAllProduct();
  }
  async getAllProductByProductId(productId) {
    return await new ProductRepository().findOne(productId);
  }
  async saveProduct(products) {
    await new ProductRepository().saveProduct(products);
    const idProduct = products.productId;
    return await new ProductRepository().findOne(idProduct);
  }
  async updateProduct(products) {
    await new ProductRepository().updateProduct(products);
    const idProduct = products.productId;
    return await new ProductRepository().findOne(idProduct);
  }
  async deleteProduct(products) {
    await new ProductRepository().deleteProduct(products);
    return await new ProductRepository().findAllProduct();
  }
  async productWantDisable(products) {
    await new ProductRepository().disableProduct(products);
    console.log(products.productId);
    return new ProductRepository().findOne(products.productId);
  }
}
