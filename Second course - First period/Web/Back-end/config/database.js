const { Pool, Client } = require('pg');

const DB_OPTIONS = {
  user: 'dbuser',
  host: 'database.server.com',
  database: 'mydb',
  password: 'secretpassword',
  port: 3211,
};


module.exports = {
    client: new Client(DB_OPTIONS),
    pool: new Pool(DB_OPTIONS)
};
