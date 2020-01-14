import events from "events";
import { log } from "../logger";

export const logErrorEvent = new events.EventEmitter();

// logErrorEvent.on("APP", function(err) {
//   log.error({ transType: "APP-FAILED" }, err);
// });

// logErrorEvent.on("DB", function(err) {
//   log.error({ transType: "DB-FAILED" }, err);
// });

logErrorEvent.on("ROUTE", function(err, res) {
  log.error({ transType: "ROUTE-FAILED" }, err);
  res.status(404).json({ message: "Not Found" });
});

// logErrorEvent.on("SESSION", function(res) {
//   res.sendStatus(401);
// });

logErrorEvent.on("CONTROLLER", function(err, res) {
  log.error({ transType: "CONTROLLER-FAILED" }, err);
  res
    .status(200)
    .json({ message: "We are sorry, your request can not be processed" });
});

export const logInfoEvent = new events.EventEmitter();

// logErrorEvent.on("ACCES", function(info) {
//   log.info({ transType: "USER-ROUTE" }, info);
// });
