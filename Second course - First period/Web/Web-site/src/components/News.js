import React, { Component } from 'react';
import { findDOMNode, render } from 'react-dom';
import { Link } from 'react-router';

import LocalDatabase from '../helpers/LocalDatabase';
import { getAllItems, isOnline, USE_LOCAL_STORAGE } from '../helpers/index';


export default class News extends Component {

    db = new LocalDatabase('test');

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
            if (USE_LOCAL_STORAGE) {
                let articles = getAllItems('articles');

                if (articles === null) {
                    return null;
                }

                return this.articlesTemplate(articles.items);
            } else {
                const db = this.db.connectToDatabase();

                db.onerror = err => console.log(err);

                db.onsuccess = e => {
                    const transaction = e.target.result.transaction(['articles'], 'readwrite');
                    const objectStore = transaction.objectStore('articles');

                    transaction.onerror = error => console.error(error);

                    const request = objectStore.getAll();

                    request.onsuccess = event => {
                        let result = event.target.result;

                        render(this.articlesTemplate(result), findDOMNode(this.refs.articlesList));
                    };
                };
            }
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
                <div ref="articlesList">{ this.renderArticles() }</div>
            </div>
        )
    }
}
