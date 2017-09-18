import React, { Component } from 'react';


export default class Feedback extends Component {

    render() {
        return (
            <div className="content--box">
                <div className="content--title">Відгуки</div>
                <div className="feedback--input-form-wrapper">
                    <form className="feedback--input-form">
                        <div className="feedback--input-form-title">Оформити відгук</div>
                        <input type="text" placeholder="Ваше ім'я" />
                        <textarea placeholder="Опишіть свої враження"></textarea>
                        <input className="fade-animation" type="submit" value="Надіслати відгук" />
                    </form>
                </div>
                <section className="feedback--content">
                    <article className="feedback--item">
                        <div className="feedback--top-panel">
                            <span className="feedback--title">Вася Пупкін</span>
                            <span className="feedback--date">11.11.2017 14:39</span>
                        </div>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
                        ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                        laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
                        voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat
                        non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                    </article>
                    <article className="feedback--item">
                        <div className="feedback--top-panel">
                            <span className="feedback--title">Вася Пупкін</span>
                            <span className="feedback--date">11.11.2017 14:39</span>
                        </div>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
                        ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                        laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
                        voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat
                        non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                    </article>
                </section>
            </div>
        )
    }
}
