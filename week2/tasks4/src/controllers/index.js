const txnService = require("../services/index.js");

async function getTransactions(req, res) {
  const val = await txnService.getTransactions();
  return res.json(val);
}

async function getSingleTransaction(req, res) {
  const id = req.params.id;
  const txn = await txnService.getTransactions(id);
  if (!txn) {
    return res.status(404).json({ error: "Transaction not found" });
  }
  return res.json(txn);
}

async function createTransaction(req, res) {
  const details = req.body;
  const newId = await txnService.createTransaction(details);
  return res.status(201).json({ id: newId });
}

module.exports = { getTransactions, getSingleTransaction, createTransaction };
