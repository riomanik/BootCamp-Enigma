import request from "supertest";
import { server } from "../server";
import { clearance, init } from "./initialized.test";

server.listen(process.env.APP_PORT);
beforeAll(async done => {
  await init();
  done();
});
afterAll(async done => {
  await clearance();
  done();
});

describe("Product Router Test", () => {
  it("should call /", done => {
    request(server)
      .get("/product/all")
      .end((err, response) => {
        expect(response.statusCode).toEqual(200);
        expect(response.body).toEqual([
          {
            productId: 1,
            productName: "Mangga",
            price: 1000,
            status: {
              idStatus: 1,
              nameStatus: "Available"
            },
            category: {
              id: 1,
              categoryName: "Buah",
              status: {
                idStatus: 1,
                nameStatus: "Available"
              }
            }
          }
        ]);
        done();
      });
  });
  it("should call /", done => {
    request(server)
      .get("/product/all-by-product-id/1")
      .end((err, response) => {
        expect(response.statusCode).toEqual(200);
        expect(response.body).toEqual([
          {
            productId: 1,
            productName: "Mangga",
            price: 1000,
            status: {
              idStatus: 1,
              nameStatus: "Available"
            },
            category: {
              id: 1,
              categoryName: "Buah",
              status: {
                idStatus: 1,
                nameStatus: "Available"
              }
            }
          }
        ]);
        done();
      });
  });
});

describe("Product Router Test", () => {
  it("should call negative test", done => {
    request(server)
      .get("/product/abc")
      .end((err, response) => {
        expect(response.statusCode).toEqual(404);
        expect(response.body).toEqual({
          message: "Not Found"
        });
        done();
      });
  });
});

describe("Product Router Test", () => {
  it("should call add product", done => {
    request(server)
      .post("/product/add")
      .send({
        productId: 1,
        productName: "Mangga",
        price: 1000,
        status: 1,
        category: 1
      })
      .expect(200)
      .set("Accept", "application/json")
      .expect("Content-Type", /json/)
      .end(function(err, res) {
        expect(res.body).toEqual([
          {
            productId: 1,
            productName: "Mangga",
            price: 1000,
            status: {
              idStatus: 1,
              nameStatus: "Available"
            },
            category: {
              id: 1,
              categoryName: "Buah",
              status: {
                idStatus: 1,
                nameStatus: "Available"
              }
            }
          }
        ]);
        if (err) return done(err);
        done();
      });
  });
  it("should call update product", done => {
    request(server)
      .put("/product/update")
      .send({
        productId: 1,
        productName: "Apple",
        price: 1000,
        status: 1,
        category: 1
      })
      .expect(200)
      .set("Accept", "application/json")
      .expect("Content-Type", /json/)
      .end(function(err, res) {
        expect(res.body).toEqual([
          {
            productId: 1,
            productName: "Mangga",
            price: 1000,
            status: {
              idStatus: 1,
              nameStatus: "Available"
            },
            category: {
              id: 1,
              categoryName: "Buah",
              status: {
                idStatus: 1,
                nameStatus: "Available"
              }
            }
          }
        ]);
        if (err) return done(err);
        done();
      });
  });
  it("should call deleted product", done => {
    request(server)
      .delete("/product/delete")
      .send({
        productId: 1
      })
      .expect(200)
      .set("Accept", "application/json")
      .expect("Content-Type", /json/)
      .end(function(err, res) {
        expect(res.body).toEqual([]);
        if (err) return done(err);
        done();
      });
  });
});
