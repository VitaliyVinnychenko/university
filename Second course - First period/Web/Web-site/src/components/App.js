import React, { PureComponent } from 'react';
import { Link } from 'react-router';

import Icon from './Icon';

export default class App extends PureComponent {

    render() {
        return (
            <main>
                <header className="header--wrapper">
                    <div className="header--container">
                        <nav className="header--navigation">
                            <Link to="/" className="header--link-box">
                                <Icon name="home"/>
                                <span>Головна</span>
                            </Link>
                            <Link to="/news" className="header--link-box">
                                <Icon name="news"/>
                                <span>Новини</span>
                            </Link>
                            <Link to="/schedule" className="header--link-box">
                                <Icon name="student"/>
                                <span>Карта курсів</span>
                            </Link>
                            <Link to="/feedback" className="header--link-box">
                                <Icon name="feedback"/>
                                <span>Відгуки</span>
                            </Link>
                            <Link to="/contacts" className="header--link-box">
                                <Icon name="contacts"/>
                                <span>Контакти</span>
                            </Link>
                            <Link to="/admin" className="header--link-box">
                                <Icon name="admin"/>
                                <span>Адмін</span>
                            </Link>
                        </nav>
                    </div>
                </header>
                <section className="content--wrapper">{ this.props.children }</section>
            </main>
        )
    }
}
