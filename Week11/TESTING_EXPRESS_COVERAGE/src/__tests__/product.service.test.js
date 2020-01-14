import ProductService from "../service/ProductService";
import ProductRepository from "../repository/ProductRepository";

let productRepository;
let productService;

beforeAll(async () => {
  productRepository = new ProductRepository();
  productService = new ProductService();
});

describe("product service test ", () => {
  it("should call get all product", async () => {
    productRepository.findAllProduct = jest.fn(() => {
      return {
        productId: 2,
        productName: "apple",
        price: "10000",
        status: {
          idStatus: 1,
          nameStatus: "available"
        },
        category: {
          id: 1,
          categoryName: "buah",
          status: {
            idStatus: 1,
            nameStatus: "available"
          }
        }
      };
    });

    productService.setRepository(productRepository);

    expect(productService.getAllProduct()).toEqual({
      productId: 2,
      productName: "apple",
      price: "10000",
      status: {
        idStatus: 1,
        nameStatus: "available"
      },
      category: {
        id: 1,
        categoryName: "buah",
        status: {
          idStatus: 1,
          nameStatus: "available"
        }
      }
    });
  });
  it("should call get all product", async () => {
    productRepository.findOne = jest.fn(() => {
      return {
        productId: 2,
        productName: "apple",
        price: "10000",
        status: {
          idStatus: 1,
          nameStatus: "available"
        },
        category: {
          id: 1,
          categoryName: "buah",
          status: {
            idStatus: 1,
            nameStatus: "available"
          }
        }
      };
    });

    productService.setRepository(productRepository);

    expect(productService.getAllProductByProductId(2)).toEqual({
      productId: 2,
      productName: "apple",
      price: "10000",
      status: {
        idStatus: 1,
        nameStatus: "available"
      },
      category: {
        id: 1,
        categoryName: "buah",
        status: {
          idStatus: 1,
          nameStatus: "available"
        }
      }
    });
  });
});

it("should create product", async () => {
  const product = {
    productId: 2,
    productName: "apple",
    price: "10000",
    status: 1,
    category: 1
  };
  productRepository.saveProduct = jest.fn(product => {
    return product;
  });
  productService.setRepository(productRepository);
  expect(productService.saveProduct(product)).toEqual({
    productId: 2,
    productName: "apple",
    price: "10000",
    status: {
      idStatus: 1,
      nameStatus: "available"
    },
    category: {
      id: 1,
      categoryName: "buah",
      status: {
        idStatus: 1,
        nameStatus: "available"
      }
    }
  });
});

it("should update product", async () => {
  const product = {
    productId: 2,
    productName: "apple",
    price: "10000",
    status: 1,
    category: 1
  };
  productRepository.updateProduct = jest.fn(product => {
    return product;
  });
  productService.setRepository(productRepository);
  expect(productService.updateProduct(product)).toEqual({
    productId: 2,
    productName: "apple",
    price: "10000",
    status: {
      idStatus: 1,
      nameStatus: "available"
    },
    category: {
      id: 1,
      categoryName: "buah",
      status: {
        idStatus: 1,
        nameStatus: "available"
      }
    }
  });
});
it("should deleted product", async () => {
  const product = [{ productId: 5 }];
  productRepository.deleteProduct = jest.fn(product => {
    return product;
  });
  productService.setRepository(productRepository);
  expect(productService.deleteProduct()).toEqual({
    productId: 2,
    productName: "apple",
    price: "10000",
    status: {
      idStatus: 1,
      nameStatus: "available"
    },
    category: {
      id: 1,
      categoryName: "buah",
      status: {
        idStatus: 1,
        nameStatus: "available"
      }
    }
  });
});
