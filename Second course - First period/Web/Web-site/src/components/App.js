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
                            <div className="header--link-box no-link">
                                <div className="container">
                                    <Icon name="student"/>
                                    <span>Студентам</span>
                                </div>
                                <div className="floating-list">
                                    <Link to="/schedule">Карта курсів</Link>
                                    <Link to="/schedule">Навчальний план</Link>
                                    <a href="/text.html">Лабораторні</a>
                                </div>
                            </div>
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
                <footer className="footer--wrapper">
                    <div className="footer--box">
                        <span>Copyright &copy; 2017 &mdash; Vitaliy Vinnychenko</span>
                    </div>
                </footer>
            </main>
        )
    }
}
