import { logErrorEvent } from "../events/logging.event";
import CategoryRepository from "../repository/CategoryRepository";

const categoryRepository = new CategoryRepository();

export const getAllCategory = async (req, res, categoryService) => {
  try {
    const rows = await categoryService
      .setRepository(categoryRepository)
      .getAllCategory();
    return res.status(200).json(rows);
  } catch (error) {
    logErrorEvent.emit("CONTROLLER", error, res);
  }
};

export const getAllById = async (req, res, categoryService) => {
  try {
    const rows = await categoryService
      .setRepository(categoryRepository)
      .getAllCategoryByCategoryId(req.params.id);
    return res.status(200).json(rows);
  } catch (err) {
    logErrorEvent.emit("CONTROLLER", err, res);
  }
};

export const addCategory = async (req, res, categoryService) => {
  try {
    const category = { ...req.body };
    const result = await categoryService
      .setRepository(categoryRepository)
      .saveCategory(category);
    return res.status(200).json(result);
  } catch (err) {
    logErrorEvent.emit("CONTROLLER", err, res);
  }
};

export const updateCategory = async (req, res, categoryService) => {
  try {
    const category = { ...req.body };
    const result = await categoryService
      .setRepository(categoryRepository)
      .updateCategory(category);
    return res.status(200).json(result);
  } catch (err) {
    logErrorEvent.emit("CONTROLLER", err, res);
  }
};

export const deleteCategory = async (req, res, categoryService) => {
  try {
    const category = { id: req.body.id };
    console.log(category);
    const result = await categoryService
      .setRepository(categoryRepository)
      .deleteCategory(category);
    return res.status(200).json(result);
  } catch (err) {
    logErrorEvent.emit("CONTROLLER", err, res);
  }
};
