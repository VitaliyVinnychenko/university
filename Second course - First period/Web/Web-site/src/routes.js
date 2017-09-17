import React from 'react';
import { Router, Route, IndexRoute, hashHistory } from 'react-router';

import App from './components/App';
import Main from './components/Main';
import Admin from './components/Admin';
import Contacts from './components/Contacts';
import Schedule from './components/Schedule';
import Feedback from './components/Feedback';
import News from './components/News';


const Routes = () => (
    <Router history={ hashHistory }>
        <Route path="/" component={ App } >

            <IndexRoute component={ Main } />

            <Route path="news" component={ News } />
            <Route path="admin" component={ Admin } />
            <Route path="contacts" component={ Contacts } />
            <Route path="schedule" component={ Schedule } />
            <Route path="feedback" component={ Feedback } />
        </Route>
    </Router>
);

export default Routes;
