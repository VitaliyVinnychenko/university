import React, { Component } from 'react';
import { findDOMNode, render } from 'react-dom';

import { addFeedback } from '../helpers/feedback';
import LocalDatabase from '../helpers/LocalDatabase';
import { isOnline, setZeroBefore, getAllItems, USE_LOCAL_STORAGE } from '../helpers/index';


export default class Feedback extends Component {

    db = new LocalDatabase('test');

    formIsValidated({ name, text }) {
        return name.value.trim().length !== 0 && text.value.trim().length !== 0;
    }

    sendFeedback() {

        if (!this.formIsValidated(this.refs)) {
            alert('Заповніть усі поля!');
            return null;
        }

        const { text, name } = this.refs;
        const FEEDBACK_DATA = {
            text: text.value.trim(),
            name: name.value.trim()
        };


        if (isOnline()) {
            fetch('http://localhost:8080/api/feedback', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(FEEDBACK_DATA)
            });
        } else {
            if (USE_LOCAL_STORAGE) {
                addFeedback(FEEDBACK_DATA);
            } else {
                this.db.insert('feedback', FEEDBACK_DATA);
            }
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

        if (isOnline()) {
            let xhr = new XMLHttpRequest();

            xhr.open('GET', 'http://localhost:8080/api/feedback', false);
            xhr.send();

            if (xhr.status !== 200) {
                console.error( xhr.status + ': ' + xhr.statusText );
            } else {
                return this.feedbackListTemplate(JSON.parse(xhr.responseText));
            }
        } else {
            if (USE_LOCAL_STORAGE) {
                let feedbackList = getAllItems('feedback');

                if (feedbackList === null) {
                    return null;
                }

                return this.feedbackListTemplate(feedbackList.items.reverse());
            } else {
                const db = this.db.connectToDatabase();

                db.onerror = err => console.log(err);

                db.onsuccess = e => {
                    const transaction = e.target.result.transaction(['feedback'], 'readwrite');
                    const objectStore = transaction.objectStore('feedback');

                    transaction.onerror = error => console.error(error);

                    const request = objectStore.getAll();

                    request.onsuccess = event => {
                        let result = event.target.result.reverse();

                        render(this.feedbackListTemplate(result), findDOMNode(this.refs.feedbackList));
                    };
                };
            }
        }
    }


    feedbackListTemplate(data) {
        return (
            <section className="feedback--content">
                { data.map((item, index) => this.renderFeedbackItem(item, index)) }
            </section>
        )
    }


    renderFeedbackItem({ name, text, created_at }, index) {
        created_at = this.dateToString(created_at);

        return (
            <article className="feedback--item" key={ index }>
                <div className="feedback--top-panel">
                    <span className="feedback--title">{ name }</span>
                    <span className="feedback--date">{ created_at }</span>
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
                <div ref="feedbackList">{ this.renderFeedbackList() }</div>
            </div>
        )
    }
}
