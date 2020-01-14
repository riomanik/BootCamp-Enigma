import { EntitySchema } from "typeorm";
import Status from "../model/status.model";

const StatusSchema = new EntitySchema({
  name: "Status",
  target: Status,
  tableName: "status",
  columns: {
    idStatus: {
      name: "id_status",
      primary: true,
      type: "int"
    },
    nameStatus: {
      name: "name_status",
      type: "varchar"
    }
  },
  relations: {
    product: {
      target: "Product",
      type: "one-to-many",
      inverseSide: "status"
    },
    category: {
      target: "Category",
      type: "one-to-many",
      inverseSide: "status"
    }
  }
});
export default StatusSchema;
