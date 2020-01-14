import { logErrorEvent } from "../events/logging.event";
import ProductRepository from "../repository/ProductRepository";

const productRepository = new ProductRepository();

export const getAllProduct = async (req, res, productService) => {
  try {
    const rows = await productService
      .setRepository(productRepository)
      .getAllProduct();
    return res.status(200).json(rows);
  } catch (error) {
    logErrorEvent.emit("CONTROLLER", error, res);
  }
};

export const getAllById = async (req, res, productService) => {
  try {
    const rows = await productService
      .setRepository(productRepository)
      .getAllProductByProductId(req.params.id);
    return res.status(200).json(rows);
  } catch (error) {
    logErrorEvent.emit("CONTROLLER", error, res);
  }
};

export const addProduct = async (req, res, productService) => {
  try {
    const product = { ...req.body };
    const result = await productService
      .setRepository(productRepository)
      .saveProduct(product);
    return res.status(200).json(result);
  } catch (error) {
    logErrorEvent.emit("CONTROLLER", error, res);
  }
};

export const updateProduct = async (req, res, productService) => {
  try {
    const product = { ...req.body };
    const result = await productService
      .setRepository(productRepository)
      .updateProduct(product);
    return res.status(200).json(result);
  } catch (error) {
    logErrorEvent.emit("CONTROLLER", error, res);
  }
};

export const deleteProduct = async (req, res, productService) => {
  try {
    const product = { productId: req.body.productId };
    const result = await productService
      .setRepository(productRepository)
      .deleteProduct(product);
    return res.status(200).json(result);
  } catch (error) {
    logErrorEvent.emit("CONTROLLER", error, res);
  }
};
