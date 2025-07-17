const http = require("http");
const path = require("path");

// TODO 1: In the below line, replace '' with code to import/require transactions data from './data/transactions.json'
// ✅ TODO 1: Load transactions.json file content
const transactionsPath = path.join(__dirname, "data", "transactions.json");
let transactions = [];

const server = http.createServer((req, res) => {
  if (req.url === "/") {
    // ✅ TODO 2: Respond to '/' with "Hello PayPal"
    res.writeHead(200, { "Content-Type": "text/plain" });
    res.end("Hello PayPal");
  } else if (req.url === "/transactions") {
    // ✅ TODO 3: Respond to '/transactions' with JSON
    res.writeHead(200, { "Content-Type": "application/json" });
    res.end(JSON.stringify(transactions));
  } else {
    res.writeHead(404, { "Content-Type": "text/plain" });
    res.end("404 Not Found");
  }
});

const PORT = process.env.PORT || 3000;
server.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
