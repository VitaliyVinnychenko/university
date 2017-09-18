import React, { Component } from 'react';


export default class Admin extends Component {

    render() {
        return (
            <div className="content--box">
                <div className="content--title">Додати новину</div>
                <section>
                    <form className="create-article-form">
                        <div className="create-article-form--row">
                            <input type="text" placeholder="Заголовок" />
                            <label className="custom-file-upload fade-animation">
                                <input type="file" accept="image/*" />
                                Додати зображення
                            </label>
                        </div>
                        <textarea placeholder="Стаття"></textarea>
                        <input className="fade-animation" type="submit" value="Опублікувати новину" />
                    </form>
                </section>
            </div>
        )
    }
}
