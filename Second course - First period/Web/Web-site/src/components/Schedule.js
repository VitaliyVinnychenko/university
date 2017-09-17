import React, { Component } from 'react';


const DATA = [[[
    {name: 'АНГЛІЙСЬКА МОВА, Ч.1', credits: 3},
    {name: 'ІСТОРІЯ ДЕРЖАВНОСТІ ТА КУЛЬТУРИ УКРАЇНИ', credits: 4},
    {name: 'ВИЩА МАТЕМАТИКА, Ч.1 (ЛІНІЙНА АЛГЕБРА ТА АНАЛІТИЧНА ГЕОМЕТРІЯ)', credits: 4},
    {name: 'ВИЩА МАТЕМАТИКА, Ч.2 (МАТЕМАТИЧНИЙ АНАЛІЗ, Ч.1)', credits: 4},
    {name: 'ФІЗИКА, Ч.1', credits: 4},
    {name: 'ВСТУП У СПЕЦІАЛЬНІСТЬ', credits: 3},
    {name: 'АЛГОРИТМІЗАЦІЯ ТА ПРОГРАМУВАННЯ, Ч.1', credits: 5},
    {name: 'КОМАНДНА РОБОТА І ПРЕЗЕНТАЦІЙНІ НАВИЧКИ', credits: 3}
], [
    {name: 'УКРАЇНСЬКА МОВА ЗА ПРОФЕСІЙНИМ СПРЯМУВАННЯМ', credits: 3},
    {name: 'АНГЛІЙСЬКА МОВА, Ч.2', credits: 3},
    {name: 'ВИЩА МАТЕМАТИКА, Ч.3 (МАТЕМАТИЧНИЙ АНАЛІЗ, Ч.2)', credits: 6},
    {name: 'ФІЗИКА, Ч.2', credits: 4},
    {name: 'АЛГОРИТМІЗАЦІЯ ТА ПРОГРАМУВАННЯ, Ч.2 (ОБ’ЄКТНО-ОРІЄНТОВАНЕ ПРОГРАМУВАННЯ)', credits: 5},
    {name: 'ЕЛЕКТРОТЕХНІКА ТА ЕЛЕКТРОНІКА', credits: 3},
    {name: 'ДИСКРЕТНА МАТЕМАТИКА', credits: 6}
]], [[
    {name: 'ФІЛОСОФІЯ', credits: 3},
    {name: 'ДИФЕРЕНЦІАЛЬНІ РІВНЯННЯ', credits: 4},
    {name: 'АЛГОРИТМІЗАЦІЯ ТА ПРОГРАМУВАННЯ, Ч. 3 (СТРУКТУРИ ДАНИХ ТА АЛГОРИТМИ)', credits: 3},
    {name: 'КОМП’ЮТЕРНА ЕЛЕКТРОНІКА', credits: 4},
    {name: 'ЧИСЕЛЬНІ МЕТОДИ', credits: 4},
    {name: 'ТЕОРІЯ ЙМОВІРНОСТІ, ЙМОВІРНІСНІ ПРОЦЕСИ ТА МАТЕМАТИЧНА СТАТИСТИКА', credits: 4},
    {name: 'ВЕБ ТЕХНОЛОГІЇ ТА ВЕБ ДИЗАЙН', credits: 4},
    {name: 'ОРГАНІЗАЦІЯ БАЗ ДАНИХ, Ч.1', credits: 4}
], [
    {name: 'ПОЛІТОЛОГІЯ', credits: 3},
    {name: 'ВІЛЬНИЙ ВИБІР СТУДЕНТА', credits: 3},
    {name: 'МІКРОКОНТРОЛЕРИ, Ч.1', credits: 6},
    {name: 'ЦИФРОВА СХЕМОТЕХНІКА', credits: 6},
    {name: 'ТЕОРІЯ ІНФОРМАЦІЇ ТА КОДУВАННЯ', credits: 4},
    {name: 'КОМП’ЮТЕРНІ МЕРЕЖІ', credits: 4},
    {name: 'ОПЕРАЦІЙНІ СИСТЕМИ', credits: 4}
]], [[
    {name: 'ВІЛЬНИЙ ВИБІР СТУДЕНТА', credits: 3},
    {name: 'ХМАРНІ ТЕХНОЛОГІЇ', credits: 3},
    {name: 'ПРОГРАМУВАННЯ МОБІЛЬНИХ ДОДАТКІВ', credits: 4},
    {name: 'СИСТЕМНИЙ АНАЛІЗ (АКА ІНЖЕНЕРІЯ ПРОГРАМНОГО ЗАБЕЗПЕЧЕННЯ)', credits: 4},
    {name: 'КОМП’ЮТЕРНА ГРАФІКА', credits: 4},
    {name: 'МІКРОКОНТРОЛЕРИ, Ч.2', credits: 5},
    {name: 'ПРОЕКТУВАННЯ ЕЛЕКТРОННИХ СХЕМ ТА ДРУКОВАНИХ ПЛАТ', credits: 3},
    {name: 'СЕНСОРИ І ВИКОНАВЧІ ЕЛЕМЕНТИ', credits: 4}
], [
    {name: 'ОСНОВИ ЦИФРОВОЇ ОБРОБКИ СИГНАЛІВ', credits: 5},
    {name: 'ТЕХНОЛОГІЇ ЗАХИСТУ ІНФОРМАЦІЇ', credits: 5},
    {name: 'АНАЛІТИЧНІ ТА НЕРЕЛЯЦІЙНІ БАЗИ ДАНИХ', credits: 5},
    {name: 'ІНТЕРФЕЙСИ ТА ПРОТОКОЛИ ПЕРЕДАЧІ ДАНИХ', credits: 5},
    {name: 'ПРОЕКТУВАННЯ ІНТЕРНЕТ РЕЧЕЙ', credits: 4},
    {name: 'ДОКУМЕНТУВАННЯ ПРОГРАМНОГО ЗАБЕЗПЕЧЕННЯ ТА ШАБЛОНИ ПРОЕКТУВАННЯ', credits: 4},
    {name: 'ВІЛЬНИЙ ВИБІР СТУДЕНТА', credits: 3}
]], [[
    {name: 'ОСНОВИ ОХОРОНИ ПРАЦІ ТА БЕЗПЕКА ЖИТТЄДІЯЛЬНОСТІ', credits: 3},
    {name: 'МІКРОЕКОНОМІКА В ІТ-ГАЛУЗІ', credits: 3},
    {name: 'ВІЛЬНИЙ ВИБІР СТУДЕНТА', credits: 3},
    {name: 'ПЛАТФОРМИ ІНТЕРНЕТУ РЕЧЕЙ', credits: 4},
    {name: 'КОРИСТУВАЦЬКІ ІНТЕРФЕЙСИ', credits: 4},
    {name: 'МАТЕМАТИЧНІ МЕТОДИ ДОСЛІДЖЕННЯ ОПЕРАЦІЙ', credits: 4},
    {name: 'КОНСТРУЮВАННЯ ТА НАДІЙНІСТЬ ІНТЕРНЕТ РЕЧЕЙ', credits: 4},
    {name: 'ОСНОВИ РОБОТОТЕХНІКИ', credits: 5}
], [
    {name: 'ІНТЕЛЕКТУАЛЬНИЙ АНАЛІЗ ДАНИХ', credits: 4},
    {name: 'МЕТОДИ ТА ЗАСОБИ ШТУЧНОГО ІНТЕЛЕКТУ', credits: 3.5},
    {name: 'УПРАВЛІННЯ ІТ-ПРОЕКТАМИ', credits: 3},
    {name: 'ІТ-ПРАВО', credits: 3},
    {name: 'ПРАКТИКА ЗА ТЕМОЮ БАКАЛАВРСЬКОЇ ПРОГРАМИ', credits: 4.5},
    {name: 'ВИКОНАННЯ БАКАЛАВРСЬКОЇ ПРОГРАМИ', credits: 9},
    {name: 'ЗАХИСТ БАКАЛАВРСЬКОЇ РОБОТИ', credits: 3}
]]];


/*const HalfYear = (props) => props.data.map((item, index) => {

});*/

export default class Schedule extends Component {

    renderSchedule() {
        return (
            <div>
                { DATA.map((item, index) => (
                    <div className="schedule--item">
                        <div className="schedule--title">{ index + 1 } курс</div>
                        { this.renderHalfYear(item) }
                    </div>
                )) }
            </div>
        )
    }

    renderHalfYear(data) {
        return (
            <div>
                { data.map((item, index) => (
                    <div>
                        <div className="schedule--subtitle">{ index + 1 } семестр</div>
                        <div className="schedule--box">
                            { this.renderItems(item) }
                        </div>
                    </div>
                )) }
            </div>
        )
    }

    renderItems(data) {
        return (
            <div>
                { data.map((item, index) => (
                    <div className="schedule--row">
                        <div className="schedule--row-item">{ item.name }</div>
                        <div className="schedule--row-item">{
                            `${item.credits} ${item.credits > 4 ? 'кредитів' : 'кредити'}`
                        }</div>
                    </div>
                ))}
            </div>
        )
    }

    render() {
        return (
            <div className="content--box">
                <div className="content--title">Карта курсів</div>
                <section>{ this.renderSchedule() }</section>
            </div>
        )
    }
}
