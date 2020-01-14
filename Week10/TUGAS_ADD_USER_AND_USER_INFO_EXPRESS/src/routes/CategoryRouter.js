import { Router } from "express";
import CategoryService from "../service/CategoryService";

const CategoryRouter = Router()
  .get("/all", async (req, res, next) => {
    const rows = await new CategoryService().getAllCategory();
    res.json(rows);
  })
  .get("/all-by-category-id/:id", async (req, res, next) => {
    const rows = await new CategoryService().getAllCategoryByCategoryId(
      req.params.id
    );
    res.json(rows);
  })
  .post("/add", async (req, res, next) => {
    const category = { ...req.body };
    const result = await new CategoryService().saveCategory(category);
    res.json(result);
  })
  .put("/update", async (req, res, next) => {
    const category = { ...req.body };
    const result = await new CategoryService().updateCategory(category);
    res.json(result);
  })
  .delete("/delete", async (req, res, next) => {
    const category = { id: req.body.id };
    const result = await new CategoryService().deleteCategory(category);
    res.json(result);
  })
  .delete("/disable-category", async (req, res, next) => {
    const category = { categoryId: req.body.categoryId };
    const result = await new CategoryService().categoryWantDisable(category);
    res.json(result);
  });

export default CategoryRouter;
