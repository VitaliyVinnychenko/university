import React from 'react';
import PropTypes from 'prop-types';


const Icon = props => (
    <svg className={ props.className }>
        <use xlinkHref={ "../images/sprite.svg#" + props.name }></use>
    </svg>
);

Icon.propTypes = {
    name: PropTypes.string.isRequired,
    className: PropTypes.string
};

export default Icon;
