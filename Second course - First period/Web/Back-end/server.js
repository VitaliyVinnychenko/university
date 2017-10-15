let express    = require('express');
let app        = express();
let bodyParser = require('body-parser');
let db = require('./config/database');

let port = process.env.PORT || 8080;
let router = express.Router();


app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

router.get('/', function(req, res) {
    res.json({ message: 'hooray! welcome to our api!' });
});

app.use('/api', router);

app.listen(port);
console.log(`Server is listening ${ port } port!`);
