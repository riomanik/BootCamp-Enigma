export default class ProductService {
  setRepository(repo) {
    this.repo = repo;
    return this;
  }

  getAllProduct() {
    // return this.repo.findAllCategory();
    return this.repo.findAllProduct();
  }
  getAllProductByProductId(productId) {
    console.log(productId);
    return this.repo.findOne(productId);
  }
  saveProduct(products) {
    this.repo.saveProduct(products);
    // const idProduct = products.productId;
    return this.getAllProduct();
  }
  updateProduct(products) {
    this.repo.updateProduct(products);
    // const idProduct = products.productId;
    return this.getAllProduct();
  }
  deleteProduct(products) {
    this.repo.deleteProduct(products);
    return this.getAllProduct();
  }
  // productWantDisable(products) {
  //   await new ProductRepository().disableProduct(products);
  //   console.log(products.productId);
  //   return new ProductRepository().findOne(products.productId);
  // }
}
