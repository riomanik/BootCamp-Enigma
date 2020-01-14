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

describe("User Router Test", () => {
  it("should call /", done => {
    request(server)
      .get("/user/all")
      .end((err, response) => {
        expect(response.statusCode).toEqual(200);
        expect(response.body).toEqual([
          {
            idUser: 1,
            username: "idroes1",
            password: "imoet1",
            userInfo: {
              phone: 88127382,
              idUserInfo: 1,
              idUser: 1,
              userFullName: "idroes imoet",
              userAddress: "cirebon",
              userEmail: "idroesimoet69Versi1@gmail.com"
            }
          }
        ]);
        done();
      });
  });
});
it("should call /", done => {
  request(server)
    .get("/user/all-by-user-id/1")
    .end((err, response) => {
      expect(response.statusCode).toEqual(200);
      expect(response.body).toEqual([
        {
          idUser: 1,
          username: "idroes1",
          password: "imoet1",
          userInfo: {
            phone: 88127382,
            idUserInfo: 1,
            idUser: 1,
            userFullName: "idroes imoet",
            userAddress: "cirebon",
            userEmail: "idroesimoet69Versi1@gmail.com"
          }
        }
      ]);
      done();
    });
});

describe("User Router Test", () => {
  it("should call negative test", done => {
    request(server)
      .get("/user/abc")
      .end((err, response) => {
        expect(response.statusCode).toEqual(404);
        expect(response.body).toEqual({
          message: "Not Found"
        });
        done();
      });
  });
});

describe("User Router Test", () => {
  it("should call add user", done => {
    request(server)
      .post("/user/add")
      .send({
        idUser: 1,
        username: "idroes1",
        password: "imoet1",
        userInfo: {
          phone: 88127382,
          idUserInfo: 1,
          idUser: 1,
          userFullName: "idroes imoet",
          userAddress: "cirebon",
          userEmail: "idroesimoet69Versi1@gmail.com"
        }
      })
      .expect(200)
      .set("Accept", "application/json")
      .expect("Content-Type", /json/)
      .end(function(err, res) {
        expect(res.body).toEqual({
          idUser: 1,
          username: "idroes1",
          password: "imoet1",
          userInfo: {
            phone: 88127382,
            idUserInfo: 1,
            idUser: 1,
            userFullName: "idroes imoet",
            userAddress: "cirebon",
            userEmail: "idroesimoet69Versi1@gmail.com"
          }
        });
        if (err) return done(err);
        done();
      });
  });
});
