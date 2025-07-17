const express = require("express");
const bodyParser = require("body-parser");
const morgan = require("morgan");
const routes = require("./routes");

const app = express();

app.use(morgan("dev"));
app.use(bodyParser.json());

routes(app); // Link routes
app.get("/", (req, res) => {
  res.send("Welcome to the Transactions API");
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`🚀 Server running at http://localhost:${PORT}`);
});
