let express    = require('express');
let app        = express();
let bodyParser = require('body-parser');
let cors       = require('cors');

let db         = require('./config/database').pool;

let port = process.env.PORT || 8080;
let router = express.Router();


app.use(cors());
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json({limit: '50mb'}));

app.options('*', cors());



router.get('/feedback', (req, res) => {
    const QUERY = `SELECT * FROM feedback`;

    db.query(QUERY, (err, result) => {

        if (err) {
            console.error(err.stack);
            res.sendStatus(404);
        } else {
            res.json(result.rows);
        }
    });
});

router.get('/articles', (req, res) => {
    const QUERY = `SELECT * FROM articles`;

    db.query(QUERY, (err, result) => {

        if (err) {
            console.error(err.stack);
            res.sendStatus(404);
        } else {
            res.json(result.rows);
        }
    });
});


router.post('/articles', (req, res) => {
    const QUERY = `INSERT INTO articles(title, full_text, short_text, image) VALUES($1, $2, $3, $4)`;
    const { image, title, short_text, full_text } = req.body;

    db.query(QUERY, [title, full_text, short_text, image], (err, result) => {

        if (err) {
            console.error(err.stack);
            res.sendStatus(500);
        } else {
            res.sendStatus(201);
        }
    });
});

router.post('/feedback', (req, res) => {
    const QUERY = `INSERT INTO feedback(text, name) VALUES($1, $2)`;
    const { name, text } = req.body;

    db.query(QUERY, [text, name], (err, result) => {

        if (err) {
            console.error(err.stack);
            res.sendStatus(500);
        } else {
            res.sendStatus(201);
        }
    });
});


app.use('/api', router);
app.listen(port);

console.log(`Compiled successfully!\n`);
console.log(`The app is running at http://localhost:${ port }/`);
