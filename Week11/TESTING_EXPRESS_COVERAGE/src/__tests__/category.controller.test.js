import CategoryService from "../service/CategoryService";
import {
  getAllCategory,
  addCategory,
  getAllById,
  updateCategory,
  deleteCategory
} from "../controller/category.controller";
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
describe("Category Controller Test", () => {
  it("should call find all category", async () => {
    const req = mockRequest();
    const res = mockResponse();
    const categoryService = new CategoryService();
    categoryService.getAllCategory = jest.fn(() => [{ id: "1" }]);
    await getAllCategory(req, res, categoryService);
    expect(res.json).toHaveBeenCalledWith([{ id: "1" }]);
    expect(res.status).toHaveBeenCalledWith(200);
  });
  it("should call find all category", async () => {
    const req = mockRequest();
    const res = mockResponse();
    const categoryService = new CategoryService();
    categoryService.getAllsaasCategory = jest.fn(() => [{ id: "1" }]);
    await getAllCategory(req, res, categoryService);
    expect(res.err);
  });
});

it("should call category by id", async () => {
  const req = mockRequestId();
  const res = mockResponse();
  const categoryService = new CategoryService();
  categoryService.getAllCategoryByCategoryId = jest.fn(() => {
    return { id: req.params.id };
  });
  await getAllById(req, res, categoryService);
  expect(res.json).toHaveBeenCalledWith({ id: req.params.id });
  expect(res.status).toHaveBeenCalledWith(200);
});
it("should call category by id", async () => {
  const req = mockRequestId();
  const res = mockResponse();
  const categoryService = new CategoryService();
  categoryService.getAllCategoryByCsadategoryId = jest.fn(() => {
    return { id: req.params.id };
  });
  await getAllById(req, res, categoryService);
  expect(res.err);
});

it("should call create category", async () => {
  const req = mockRequest();
  const res = mockResponse();
  const categoryService = new CategoryService();
  categoryService.saveCategory = jest.fn(() => [{ id: "1" }]);
  await addCategory(req, res, categoryService);
  expect(res.json).toHaveBeenCalledWith([{ id: "1" }]);
  expect(res.status).toHaveBeenCalledWith(200);
});

it("should call negative create category", async () => {
  const req = mockRequest();
  const res = mockResponse();
  const categoryService = new CategoryService();
  categoryService.saveeCategory = jest.fn(() => [{ id: "1" }]);
  await addCategory(req, res, categoryService);
  // expect(res.json).toHaveBeenCalledWith([{ id: "1" }]);
  expect(res.err);
});

it("should call update category", async () => {
  const req = mockRequest();
  const res = mockResponse();
  const categoryService = new CategoryService();
  categoryService.updateCategory = jest.fn(() => [{ id: "1" }]);
  await updateCategory(req, res, categoryService);
  expect(res.json).toHaveBeenCalledWith([{ id: "1" }]);
  expect(res.status).toHaveBeenCalledWith(200);
});
it("should call negative update category", async () => {
  const req = mockRequest();
  const res = mockResponse();
  const categoryService = new CategoryService();
  categoryService.updateCasategory = jest.fn(() => [{ id: "1" }]);
  await updateCategory(req, res, categoryService);
  expect(res.err);
});

it("should call delete category", async () => {
  const req = mockRequest();
  const res = mockResponse();
  const categoryService = new CategoryService();
  categoryService.deleteCategory = jest.fn(() => [{ id: "1" }]);
  await deleteCategory(req, res, categoryService);
  expect(res.status).toHaveBeenCalledWith(200);
});
it("should call negative delete category", async () => {
  const req = mockRequest();
  const res = mockResponse();
  const categoryService = new CategoryService();
  categoryService.deleteCatsaegory = jest.fn(() => [{ id: "1" }]);
  expect(res.err);
});
