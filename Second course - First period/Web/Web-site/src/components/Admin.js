import React, { Component } from 'react';

import { isOnline } from '../helpers/index';
import { addArticle } from '../helpers/news';


export default class Admin extends Component {

    formIsValidated({ title, fullText, shortText, image }) {
        const FIRST_CASE = title.value.trim().length !== 0 && fullText.value.trim().length !== 0;
        const SECOND_CASE = shortText.value.trim().length !== 0 && image.files && image.files[0];

        return FIRST_CASE && SECOND_CASE;
    }


    changeImagePreview() {
        const { image } = this.refs;

        if (image.files && image.files[0]) {
            let reader = new FileReader();

            reader.addEventListener('load', e => {
                console.log(e);
                this.refs.imagePreview.setAttribute('src', e.target.result);
            });

            reader.readAsDataURL(image.files[0]);
        }
    }


    sendArticle() {

        if (!this.formIsValidated(this.refs)) {
            alert('Заповніть усі поля!');
            return null;
        }

        const { title, fullText, shortText, image } = this.refs;

        if (!isOnline()) {
            console.log('N/A');
        } else {
            console.log(image.files[0]);

            addArticle({
                title: title.value.trim(),
                fullText: fullText.value.trim(),
                shortText: shortText.value.trim(),
                image: image.files[0]
            });
        }

        this.refs.title.value = this.refs.shortText.value = this.refs.fullText.value = '';
        this.refs.imagePreview.setAttribute('src', '#');

        alert('Статтю успішно опубліковано!');
    }


    render() {
        const SUBMIT_BUTTON_PROPS = {
            className: 'fade-animation',
            type: 'submit',
            value: 'Опублікувати новину',
            onClick: this.sendArticle.bind(this)
        };

        const IMAGE_INPUT_PROPS = {
            ref: 'image',
            type: 'file',
            accept: 'image/*',
            onChange: this.changeImagePreview.bind(this)
        };

        return (
            <div className="content--box">
                <div className="content--title">Додати новину</div>
                <section>
                    <div className="create-article-form">
                        <div className="create-article-form--row">
                            <input ref="title" type="text" placeholder="Заголовок" />
                            <label className="custom-file-upload fade-animation">
                                <input { ...IMAGE_INPUT_PROPS } />
                                <span>Додати зображення</span>
                            </label>
                        </div>
                        <img id="imagePreview" src="#" ref="imagePreview" />
                        <textarea ref="shortText" className="short" placeholder="Короткий опис новини"></textarea>
                        <textarea ref="fullText" className="full" placeholder="Довгий опис новини"></textarea>
                        <input { ...SUBMIT_BUTTON_PROPS } />
                    </div>
                </section>
            </div>
        )
    }
}
