import { Router } from "express";
import {
  getAllProduct,
  getAllById,
  addProduct,
  updateProduct,
  deleteProduct
} from "../controller/product.controller";
import ProductService from "../service/ProductService";

const ProductRouter = Router()
  .get("/all", (req, res) => getAllProduct(req, res, new ProductService()))
  .get("/all-by-product-id/:id", (req, res) =>
    getAllById(req, res, new ProductService())
  )
  .post("/add", (req, res) => addProduct(req, res, new ProductService()))
  .put("/update", (req, res) => updateProduct(req, res, new ProductService()))
  .delete("/delete", (req, res) =>
    deleteProduct(req, res, new ProductService())
  );

export default ProductRouter;
