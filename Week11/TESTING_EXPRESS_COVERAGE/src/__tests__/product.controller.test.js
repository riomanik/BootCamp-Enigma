import ProductService from "../service/ProductService";
import {
  getAllProduct,
  addProduct,
  getAllById,
  updateProduct,
  deleteProduct
} from "../controller/product.controller";
let mockResponse;
let mockRequest;
let mockRequestId;
beforeAll(async () => {
  mockResponse = () => {
    const res = {};
    res.status = jest.fn().mockReturnValue(res);
    res.json = jest.fn().mockReturnValue(res);
    return res;
  };
  mockRequest = () => {
    const res = {};
    return res;
  };
  mockRequestId = () => {
    const res = { params: { id: 1 } };
    return res;
  };
});
describe("Product Controller Test", () => {
  it("should call find all product", async () => {
    const req = mockRequest();
    const res = mockResponse();
    const productService = new ProductService();
    productService.getAllProduct = jest.fn(() => [{ id: "1" }]);
    await getAllProduct(req, res, productService);
    expect(res.json).toHaveBeenCalledWith([{ id: "1" }]);
    expect(res.status).toHaveBeenCalledWith(200);
  });
  it("should call find all negative product", async () => {
    const req = mockRequest();
    const res = mockResponse();
    const productService = new ProductService();
    productService.getAllPrsadasoduct = jest.fn(() => [{ id: "1" }]);
    await getAllProduct(req, res, productService);
    expect(res.err);
  });
});

it("should call product by id", async () => {
  const req = mockRequestId();
  const res = mockResponse();
  const productService = new ProductService();
  productService.getAllProductByProductId = jest.fn(() => {
    return { id: req.params.id };
  });
  await getAllById(req, res, productService);
  expect(res.json).toHaveBeenCalledWith({ id: req.params.id });
  expect(res.status).toHaveBeenCalledWith(200);
});
it("should call negative product by id", async () => {
  const req = mockRequestId();
  const res = mockResponse();
  const productService = new ProductService();
  productService.getAllProkmkmductByProductId = jest.fn(() => {
    return { id: req.params.id };
  });
  await getAllById(req, res, productService);
  expect(res.err);
});

it("should call create product", async () => {
  const req = mockRequest();
  const res = mockResponse();
  const productService = new ProductService();
  productService.saveProduct = jest.fn(() => [{ id: "1" }]);
  await addProduct(req, res, productService);
  expect(res.json).toHaveBeenCalledWith([{ id: "1" }]);
  expect(res.status).toHaveBeenCalledWith(200);
});

it("should call create product", async () => {
  const req = mockRequest();
  const res = mockResponse();
  const productService = new ProductService();
  productService.saveProdasdauct = jest.fn(() => [{ id: "1" }]);
  await addProduct(req, res, productService);
  expect(res.err);
});

it("should call update product", async () => {
  const req = mockRequest();
  const res = mockResponse();
  const productService = new ProductService();
  productService.updateProduct = jest.fn(() => [{ id: "1" }]);
  await updateProduct(req, res, productService);
  expect(res.json).toHaveBeenCalledWith([{ id: "1" }]);
  expect(res.status).toHaveBeenCalledWith(200);
});
it("should call negative update product", async () => {
  const req = mockRequest();
  const res = mockResponse();
  const productService = new ProductService();
  productService.updateProdsaduct = jest.fn(() => [{ id: "1" }]);
  await updateProduct(req, res, productService);
  expect(res.err);
});

it("should call delete product", async () => {
  const req = mockRequest();
  const res = mockResponse();
  const productService = new ProductService();
  productService.deleteProduct = jest.fn(() => [{ id: "1" }]);
  await deleteProduct(req, res, productService);
  expect(res.err);
});
it("should call negative delete product", async () => {
  const req = mockRequest();
  const res = mockResponse();
  const productService = new ProductService();
  productService.deleteProsadasduct = jest.fn(() => [{ id: "1" }]);
  await deleteProduct(req, res, productService);
  expect(res.err);
});
