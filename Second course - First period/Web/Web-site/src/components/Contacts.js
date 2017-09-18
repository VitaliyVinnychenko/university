import React, { PureComponent } from 'react';
import scriptLoader from 'react-async-script-loader';


const GOOGLE_MAPS_API_URI = 'https://maps.googleapis.com/maps/api/js?key=AIzaSyDsiKb2ZnfXxmWfEMsR3bnvf56x-mQKIX0&language=uk';


@scriptLoader(GOOGLE_MAPS_API_URI)
export default class Contacts extends PureComponent {

    componentWillReceiveProps({ isScriptLoadSucceed, isScriptLoaded }) {

        if (!this.props.isScriptLoaded && isScriptLoaded) {
            if (isScriptLoadSucceed) {
                const COORDS = { lat: 49.835159, lng: 24.008544 };

                let map = new window.google.maps.Map(this.refs.map, {
                    zoom: 16,
                    center: COORDS,
                    streetViewControl: false,
                    disableDefaultUI: true
                });

                var marker = new window.google.maps.Marker({
                    position: COORDS,
                    map: map
                });
            }
        }

    }

    render() {
        return (
            <div className="content--box">
                <div className="content--title">Контакти</div>
                <section className="contacts--wrapper">
                    <div className="contacts--content-wrapper">
                        <div className="contacts--content">
                            <div className="contacts--content-item">
                                <div className="contacts--content-title">Наша адреса:</div>
                                <p className="contacts--content-text">
                                    Національний університет “Львівська політехніка“<br/>
                                    Інститут комп’ютерних технологій, автоматики та метрології (ІКТА)<br/>
                                    Кафедра “Комп’ютеризовані системи автоматики“<br/>
                                    м. Львів, вул. Степана Бандери 28а<br/>
5                                   корпус, 6 поверх, кімната 601
                                </p>
                            </div>
                            <div className="contacts--content-item">
                                <div className="contacts--content-title">Email:</div>
                                <p className="contacts--content-text">
                                    <a href="mailto:info@iot-ua.com">info@iot-ua.com</a>
                                </p>
                            </div>
                            <div className="contacts--content-item">
                                <div className="contacts--content-title">Телефони:</div>
                                <p className="contacts--content-text">
                                    <a href="tel:+380322582464">+38 (032) 258-2464</a>
                                </p>
                                <p className="contacts--content-text">
                                    <a href="tel:+380322582197">+38 (032) 258-2197</a>
                                </p>
                            </div>
                            <div className="contacts--content-item">
                                <div className="contacts--content-title">Web:</div>
                                <p className="contacts--content-text">
                                    <a href="//iot.lviv.ua">iot.lviv.ua</a>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div className="contacts--map" ref="map" />
                </section>
            </div>
        )
    }
}
