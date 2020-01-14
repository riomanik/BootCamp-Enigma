import { Router } from "express";
import ProductService from "../service/ProductService";

const ProductRouter = Router()
  .get("/all", async (req, res, next) => {
    const rows = await new ProductService().getAllProduct();
    res.json(rows);
  })
  .get("/all-by-product-id/:id", async (req, res, next) => {
    const rows = await new ProductService().getAllProductByProductId(
      req.params.id
    );
    res.json(rows);
  })
  .post("/add", async (req, res, next) => {
    const product = { ...req.body };
    const result = await new ProductService().saveProduct(product);
    res.json(result);
  })
  .put("/update", async (req, res, next) => {
    const product = { ...req.body };
    const result = await new ProductService().updateProduct(product);
    res.json(result);
  })
  .delete("/delete", async (req, res, next) => {
    const product = { productId: req.body.productId };
    const result = await new ProductService().deleteProduct(product);
    res.json(result);
  })
  .delete("/disable-product", async (req, res, next) => {
    const product = { productId: req.body.productId };
    const result = await new ProductService().productWantDisable(product);
    res.json(result);
  });

export default ProductRouter;
