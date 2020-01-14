import bunyan from "bunyan";

export const log = bunyan.createLogger({
  name: "hello-world-db",
  streams: [
    {
      level: "info",
      stream: process.stdout
    },
    {
      level: "error",
      path: "E:/express-database/latihan_database/log/myapp-error.log"
    }
  ],
  level: "info"
});
