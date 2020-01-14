import request from "supertest";
import { server } from "../server";
// import { Table } from "typeorm";
import { clearance, init } from "./initialized.test";

server.listen(process.env.APP_PORT);
// const userCredentials = {
//   username: "rio",
//   password: "manik"
// };

// var authenticatedUser = request.agent(server);
beforeAll(async done => {
  await init();
  done();
  //   authenticatedUser
  //     .post("/auth")
  //     .send(userCredentials)
  //     .end((err, response) => {
  //       expect(response.statusCode).toEqual(200);
  //       done();
  //     });
});
afterAll(async done => {
  await clearance();
  done();
});

describe("Category Router Test", () => {
  it("should call /", done => {
    request(server)
      .get("/category/all")
      .end((err, response) => {
        expect(response.statusCode).toEqual(200);
        expect(response.body).toEqual([
          {
            id: 1,
            categoryName: "Buah",
            status: {
              idStatus: 1,
              nameStatus: "Available"
            }
          }
        ]);
        done();
      });
  });
  it("should call /", done => {
    request(server)
      .get("/category/all-by-category-id/1")
      .end((err, response) => {
        expect(response.statusCode).toEqual(200);
        expect(response.body).toEqual([
          {
            id: 1,
            categoryName: "Buah",
            status: {
              idStatus: 1,
              nameStatus: "Available"
            }
          }
        ]);
        done();
      });
  });
});
describe("Category Router Test", () => {
  it("should call negative test", done => {
    request(server)
      .get("/category/abc")
      .end((err, response) => {
        expect(response.statusCode).toEqual(404);
        expect(response.body).toEqual({
          message: "Not Found"
        });
        done();
      });
  });
});

describe("Category Router Test", () => {
  it("should call add category", done => {
    request(server)
      .post("/category/add")
      .send({
        id: 1,
        categoryName: "Buah",
        status: 1
      })
      .expect(200)
      .set("Accept", "application/json")
      .expect("Content-Type", /json/)
      .end(function(err, res) {
        expect(res.body).toEqual([
          {
            id: 1,
            categoryName: "Buah",
            status: {
              idStatus: 1,
              nameStatus: "Available"
            }
          }
        ]);
        if (err) return done(err);
        done();
      });
  });
  it("should call update category", done => {
    request(server)
      .put("/category/update")
      .send({
        id: 1,
        categoryName: "Buah",
        status: 1
      })
      .expect(200)
      .set("Accept", "application/json")
      .expect("Content-Type", /json/)
      .end(function(err, res) {
        expect(res.body).toEqual([
          {
            id: 1,
            categoryName: "Buah",
            status: {
              idStatus: 1,
              nameStatus: "Available"
            }
          }
        ]);
        if (err) return done(err);
        done();
      });
  });
  it("should call deleted category", done => {
    request(server)
      .delete("/category/delete")
      .send({
        id: 5
      })
      .expect(200)
      .set("Accept", "application/json")
      .expect("Content-Type", /json/)
      .end(function(err, res) {
        expect(res.body).toEqual([
          {
            id: 1,
            categoryName: "Buah",
            status: {
              idStatus: 1,
              nameStatus: "Available"
            }
          }
        ]);
        if (err) return done(err);
        done();
      });
  });
});
