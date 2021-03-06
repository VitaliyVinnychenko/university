import React, { Component } from 'react';
import { findDOMNode, render } from 'react-dom';
import { Link } from 'react-router';

import LocalDatabase from '../helpers/LocalDatabase';
import { getAllItems, isOnline, USE_LOCAL_STORAGE } from '../helpers/index';


export default class Main extends Component {

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
            <section className="main--news-container">
                { data.reverse().slice(0, 2).map(({ title, short_text }) => (
                    (<div className="main--news-item">
                        <article>
                            <div className="main--news-item-title">{ title }</div>
                            <p>{ short_text }</p>
                            <Link className="main--news-link">Читати далі...</Link>
                        </article>
                    </div>)
                )) }
            </section>
        );
    }

    render() {
        return (
            <div className="content--box">
                <div className="content--title">Про предмет</div>
                <section>
                    <p><strong>Назва:</strong> Іпотечні відносини в нотаріальній практиці</p>
                    <p><strong>Мета:</strong> засвоєння студентами значення норм, які регулюють іпотечні правові
                    відносини, їх характер; показати роль та значення іпотеки на сучасному етапі
                    розвитку України в умовах гармонізації законодавства в умовах інтеграції України в
                    Європейський Союз; продемонструвати нерозривний зв&#39;язок матеріальних норм
                    приватного та публічного характеру з їх практичним застосуванням.</p>
                    <p><strong>Зміст:</strong> Поняття, предмет, принципи та система спецкурсу «Іпотечні відносини в
                    нотаріальній практиці». Джерела правового регулювання іпотечних правовідносин.
                    Іпотека як вид забезпечення виконання зобов’язань. Елементи іпотечних
                    правовідносин. Іпотечний договір. Особливості іпотеки будівлі, споруди, об’єктів
                    незавершеного будівництва. Особливості іпотеки земельної ділянки. Особливості
                    іпотеки підприємства як єдиного майнового комплексу. Іпотека як вид забезпечення
                    грошових зобов’язань. Правове регулювання іпотечного ринку в Україні. Іпотечне
                    кредитування: особливості оформлення іпотеки, яка забезпечує грошове
                    зобов’язання, договір про іпотечний борг. Правові наслідки невиконання чи
                    неналежного виконання основного зобов’язання, забезпеченого іпотекою.</p>
                    <p><strong>Місце у навчальному процесі</strong> - вибіркова, 1 семестр.</p>
                    <p>У результаті вивчення дисципліни <em>«Іпотечні відносини в нотаріальній практиці» </em>
                    здобувач вищої освіти повинен <strong>знати</strong>:</p>
                    <p>
                        <ul>
                            <li>основні проблеми науки іпотечного права та основні джерела, необхідні для
                            його вивчення; питання захисту суб’єктами іпотечних правовідносин своїх прав та
                            інтересів;</li>
                            <li>порядок регулювання договірних відносин щодо забезпечення іпотекою
                            різних видів зобов’язань, порядок та проблемні питання звернення стягнення на
                            предмет іпотеки та забезпечення вимог кредиторів за рахунок предмету іпотеки
                            тощо.</li>
                        </ul>
                    </p>
                    <p>У результаті вивчення дисципліни <em>«Іпотечні відносини в нотаріальній практиці» </em>
                    здобувач вищої освіти повинен <strong>вміти</strong>:</p>
                    <p>
                        <ul>
                            <li>використовувати знання отримані в процесі вивчення даного спецкурсу у вирішенні
                            професійних завдань;</li>
                            <li>застосовувати принципи та норми іпотечного права;</li>
                            <li>дати юридичну оцінку іпотечним правовідносинам;</li>
                            <li>тлумачити норми чинного іпотечного
                            законодавства України та використовувати роз’яснення вищих судових та інших
                            органів у процесі застосування норм права;</li>
                            <li>складати документи, щоопосередковують виникнення, зміну чи припинення
                            іпотечних правовідносин;</li>
                            <li>вирішувати справи, пов’язані з іпотекою.</li>
                        </ul>
                    </p>
                </section>
                <div className="content--title">Останні новини</div>
                <div ref="articlesList">{ this.renderArticles() }</div>
                <Link className="main--news-page-link fade-animation" to="/news">Більше новин</Link>
            </div>
        )
    }
}
