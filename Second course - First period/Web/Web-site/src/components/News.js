import React, { Component } from 'react';
import { Link } from 'react-router';

import { getAllItems, isOnline } from '../helpers/index';


export default class News extends Component {

    renderArticles() {

        if (isOnline()) {
            let xhr = new XMLHttpRequest();

            xhr.open('GET', 'http://localhost:8080/api/articles', false);
            xhr.send();

            if (xhr.status !== 200) {
                console.error( xhr.status + ': ' + xhr.statusText );
            } else {
                return this.articlesTemplate(JSON.parse(xhr.responseText));
            }
        } else {
            let articles = getAllItems('articles');

            if (articles === null) {
                return null;
            }

            return this.articlesTemplate(articles.items);
        }
    }

    articlesTemplate(data) {
        return (
            <section>
                { data.reverse().map(({ title, short_text, image }) => (
                    (<article className="news--article">
                        <div className="news--title">{ title }</div>
                        <img src={ image } alt="" />
                        <p>{ short_text }</p>
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
