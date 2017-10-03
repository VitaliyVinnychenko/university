import React, { Component } from 'react';
import { Link } from 'react-router';

import { getAllItems } from '../helpers/index';


export default class News extends Component {

    renderArticles() {
        let articles = getAllItems('articles');

        if (articles === null) {
            return null;
        }

        return (
            <section>
                { articles.items.reverse().map(({ title, shortText, image }) => (
                    (<article className="news--article">
                        <div className="news--title">{ title }</div>
                        <img src={ image } alt="" />
                        <p>{ shortText }</p>
                        <Link to="/" className="news--link">Читати далі...</Link>
                    </article>)
                )) }
            </section>
        );
    }

    render() {
        return (
            <div className="content--box">
                <div className="content--title">Новини</div>
                { this.renderArticles() }
            </div>
        )
    }
}
