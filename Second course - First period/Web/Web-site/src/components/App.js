import React, { Component } from 'react';
import { Link } from 'react-router';

import Icon from './Icon';

export default class App extends Component {

    onMenuButtonClick() {
        
        if (this.refs.nav.classList.contains('visible')) {
            this.refs.nav.classList.remove('visible');
        } else {
            this.refs.nav.classList.add('visible');
        }
    }

    componentDidMount() {
        window.addEventListener('online', () => console.log('ONLINE'));
        window.addEventListener('offline', () => console.log('OFFLINE'));
    }

    componentWillUnmount() {
        window.removeEventListener('online', () => console.log('ONLINE'));
        window.removeEventListener('offline', () => console.log('OFFLINE'));
    }

    render() {
        return (
            <main>
                <header className="header--wrapper">
                    <div className="header--container">
                        <div className="menu-button" onClick={ this.onMenuButtonClick.bind(this) }>
                            <Icon name="menu"/>
                        </div>
                        <nav className="header--navigation" ref="nav">
                            <Link to="/" className="header--link-box" onClick={ this.onMenuButtonClick.bind(this) }>
                                <Icon name="home"/>
                                <span>Головна</span>
                            </Link>
                            <Link to="/news" className="header--link-box" onClick={ this.onMenuButtonClick.bind(this) }>
                                <Icon name="news"/>
                                <span>Новини</span>
                            </Link>
                            <div className="header--link-box no-link">
                                <div className="container">
                                    <Icon name="student"/>
                                    <span>Студентам</span>
                                </div>
                                <div className="floating-list">
                                    <Link to="/schedule" onClick={ this.onMenuButtonClick.bind(this) }>Карта курсів</Link>
                                    <Link to="/schedule" onClick={ this.onMenuButtonClick.bind(this) }>Навчальний план</Link>
                                    <a href="/text.html">Лабораторні</a>
                                </div>
                            </div>
                            <Link to="/feedback" className="header--link-box" onClick={ this.onMenuButtonClick.bind(this) }>
                                <Icon name="feedback"/>
                                <span>Відгуки</span>
                            </Link>
                            <Link to="/contacts" className="header--link-box" onClick={ this.onMenuButtonClick.bind(this) }>
                                <Icon name="contacts"/>
                                <span>Контакти</span>
                            </Link>
                            <Link to="/admin" className="header--link-box" onClick={ this.onMenuButtonClick.bind(this) }>
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
