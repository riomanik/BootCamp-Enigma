import { Router } from "express";
import {
  getAllCategory,
  getAllById,
  addCategory,
  updateCategory,
  deleteCategory
} from "../controller/category.controller";
import CategoryService from "../service/CategoryService";

const CategoryRouter = Router()
  .get("/all", (req, res) => getAllCategory(req, res, new CategoryService()))
  .get("/all-by-category-id/:id", (req, res) =>
    getAllById(req, res, new CategoryService())
  )
  .post("/add", (req, res) => addCategory(req, res, new CategoryService()))
  .put("/update", (req, res) => updateCategory(req, res, new CategoryService()))
  .delete("/delete", (req, res) =>
    deleteCategory(req, res, new CategoryService())
  );
export default CategoryRouter;
