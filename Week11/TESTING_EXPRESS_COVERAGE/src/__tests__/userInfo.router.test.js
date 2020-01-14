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

describe("UserInfo Router Test", () => {
  it("should call /", done => {
    request(server)
      .get("/user-info/all")
      .end((err, response) => {
        expect(response.statusCode).toEqual(200);
        expect(response.body).toEqual([
          {
            phone: 88127382,
            idUserInfo: 1,
            idUser: 1,
            userFullName: "idroes imoet",
            userAddress: "cirebon",
            userEmail: "idroesimoet69Versi1@gmail.com"
          }
        ]);
        done();
      });
  });
});
it("should call /", done => {
  request(server)
    .get("/user-info/all-by-user-info-id/1")
    .end((err, response) => {
      expect(response.statusCode).toEqual(200);
      expect(response.body).toEqual([
        {
          phone: 88127382,
          idUserInfo: 1,
          idUser: 1,
          userFullName: "idroes imoet",
          userAddress: "cirebon",
          userEmail: "idroesimoet69Versi1@gmail.com"
        }
      ]);
      done();
    });
});

describe("UserInfo Router Test", () => {
  it("should call negative test", done => {
    request(server)
      .get("/user-info/abc")
      .end((err, response) => {
        expect(response.statusCode).toEqual(404);
        expect(response.body).toEqual({
          message: "Not Found"
        });
        done();
      });
  });
});
