import React, { Component } from 'react';

import { addFeedback } from '../helpers/feedback';
import { isOnline, setZeroBefore, getAllItems } from '../helpers/index';


export default class Feedback extends Component {

    formIsValidated({ name, text }) {
        return name.value.trim().length !== 0 && text.value.trim().length !== 0;
    }

    sendFeedback() {

        if (!this.formIsValidated(this.refs)) {
            alert('Заповніть усі поля!');
            return null;
        }

        const { text, name } = this.refs;

        if (!isOnline()) {
            console.log('N/A');
        } else {
            addFeedback({
                text: text.value.trim(),
                name: name.value.trim()
            });
        }

        this.refs.name.value = this.refs.text.value = '';
        alert('Відгук успішно надіслано');

        this.forceUpdate();
    }


    dateToString(date) {
        date = new Date(date);

        const day = setZeroBefore(date.getDay());
        const month = setZeroBefore(date.getMonth());
        const year = date.getFullYear();

        const hours = setZeroBefore(date.getHours());
        const minutes = setZeroBefore(date.getMinutes());

        return `${ day }.${ month }.${ year } ${ hours }:${ minutes }`;
    }


    renderFeedbackList() {
        let feedbackList = getAllItems('feedback');

        if (feedbackList === null) {
            return null;
        }

        return (
            <section className="feedback--content">
                { feedbackList.items.reverse().map(item => this.renderFeedbackItem(item)) }
            </section>
        )
    }


    renderFeedbackItem({ name, text, date }) {
        date = this.dateToString(date);

        return (
            <article className="feedback--item">
                <div className="feedback--top-panel">
                    <span className="feedback--title">{ name }</span>
                    <span className="feedback--date">{ date }</span>
                </div>
                <p>{ text }</p>
            </article>
        )
    }


    render() {
        const SUBMIT_BUTTON_PROPS = {
            className: 'fade-animation',
            type: 'submit',
            value: 'Надіслати відгук',
            onClick: this.sendFeedback.bind(this)
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
                { this.renderFeedbackList() }
            </div>
        )
    }
}
