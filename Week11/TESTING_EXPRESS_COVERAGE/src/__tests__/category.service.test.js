import CategoryService from "../service/CategoryService";
import CategoryRepository from "../repository/CategoryRepository";

let categoryRepository;
let categoryService;

beforeAll(async () => {
  categoryRepository = new CategoryRepository();
  categoryService = new CategoryService();
});

describe("Category service test ", () => {
  it("should call get all category", async () => {
    categoryRepository.findAllCategory = jest.fn(() => {
      return [{ id: 1, categoryName: "anything" }];
    });

    categoryService.setRepository(categoryRepository);

    expect(categoryService.getAllCategory()).toEqual([
      { id: 1, categoryName: "anything" }
    ]);
  });
  it("should call get by id category", async () => {
    categoryRepository.findOne = jest.fn(() => {
      return [{ id: 1, categoryName: "anything" }];
    });

    categoryService.setRepository(categoryRepository);

    expect(categoryService.getAllCategoryByCategoryId()).toEqual([
      { id: 1, categoryName: "anything" }
    ]);
  });
});

it("should create category", async () => {
  const category = [{ id: 1, categoryName: "anything" }];
  categoryRepository.saveCategory = jest.fn(category => {
    return category;
  });
  categoryService.setRepository(categoryRepository);
  expect(categoryService.saveCategory(category)).toEqual(category);
});

it("should update category", async () => {
  const category = [{ id: 1, categoryName: "anything" }];
  categoryRepository.updateCategory = jest.fn(category => {
    return category;
  });
  categoryService.setRepository(categoryRepository);
  expect(categoryService.updateCategory(category)).toEqual(category);
});
it("should deleted category", async () => {
  const category = [{ id: 5 }];
  categoryRepository.deleteCategory = jest.fn(category => {
    return category;
  });
  categoryService.setRepository(categoryRepository);
  expect(categoryService.deleteCategory(1)).toEqual([
    { id: 1, categoryName: "anything" }
  ]);
});
