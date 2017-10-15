const { Pool, Client } = require('pg');

const DB_OPTIONS = {
  user: 'cleancity',
  database: 'cleancity',
};


module.exports = {
    client: new Client(DB_OPTIONS),
    pool: new Pool(DB_OPTIONS)
};
