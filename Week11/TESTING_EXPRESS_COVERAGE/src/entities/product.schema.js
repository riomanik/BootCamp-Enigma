import { EntitySchema } from "typeorm";
import Product from "../model/product.model";

const ProductSchema = new EntitySchema({
  name: "Product",
  target: Product,
  tableName: "product",
  columns: {
    productId: {
      name: "product_id",
      primary: true,
      type: "int",
      generated: true
    },
    // productId: {
    //   name: "product_id",
    //   type: "varchar"
    // },
    productName: {
      name: "product_name",
      type: "varchar",
      length: "10"
    },
    price: {
      name: "price",
      type: "decimal"
    }
    // ,
    // status: {
    //   name: "status",
    //   type: "varchar"
    // }
  },
  relations: {
    category: {
      target: "Category",
      type: "many-to-one",
      eager: true,
      joinColumn: { name: "category_id" }
    },
    status: {
      target: "Status",
      type: "many-to-one",
      eager: true,
      joinColumn: { name: "status" }
    }
  }
});
export default ProductSchema;
