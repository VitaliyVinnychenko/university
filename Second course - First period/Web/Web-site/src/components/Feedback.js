import React, { Component } from 'react';


export default class Feedback extends Component {

    validateFeedbackForm() {
        const { name, text } = this.refs;

        if (name.value.trim().length !== 0 && text.value.trim().length !== 0) {
            this.refs.name.value = this.refs.text.value = '';
            alert('Надіслано');
        } else {
            alert('Заповніть усі поля!');
        }
    }

    render() {
        const SUBMIT_BUTTON_PROPS = {
            className: 'fade-animation',
            type: 'submit',
            value: 'Надіслати відгук',
            onClick: this.validateFeedbackForm.bind(this)
        };

        return (
            <div className="content--box">
                <div className="content--title">Відгуки</div>
                <div className="feedback--input-form-wrapper">
                    <div className="feedback--input-form">
                        <div className="feedback--input-form-title">Оформити відгук</div>
                        <input ref="name" type="text" placeholder="Ваше ім'я" />
                        <textarea ref="text" placeholder="Опишіть свої враження"></textarea>
                        <input { ...SUBMIT_BUTTON_PROPS } />
                    </div>
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
