import React, { Component } from 'react';


export default class Admin extends Component {

    validateArticleForm() {
        const { title, fullText, shortText, image } = this.refs;

        if (
            title.value.trim().length != 0 && fullText.value.trim().length != 0
            && shortText.value.trim().length != 0 && image.files && image.files[0]
        ) {
            this.refs.title.value = this.refs.shortText.value = this.refs.fullText.value = '';
            this.refs.imagePreview.setAttribute('src', '#');
            alert('Статтю успішно опубліковано!');
        } else {
            alert('Заповніть усі поля!');
        }
    }

    changeImagePreview() {
        const { image } = this.refs;

        if (image.files && image.files[0]) {
            let reader = new FileReader();

            reader.addEventListener('load', e => {
                this.refs.imagePreview.setAttribute('src', e.target.result);
            });

            reader.readAsDataURL(image.files[0]);
        }
    }

    render() {
        const SUBMIT_BUTTON_PROPS = {
            className: 'fade-animation',
            type: 'submit',
            value: 'Опублікувати новину',
            onClick: this.validateArticleForm.bind(this)
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
