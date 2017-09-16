export const SRC_PATHS = {
    sass: {
        input: ['src/scss/Default.scss', 'src/scss/**/*.scss'],
        output: 'index.min.css',
        dest: 'public'
    },
    svg: {
        input: 'src/svg/**/*.svg',
        output: 'sprite.svg',
        dest: 'public/images'
    },
    js: {
        input: 'src/javascript/**/*.js',
        output: 'index.min.js',
        dest: 'public'
    }
};

export const AUTOPREFIXER_CONFIG = [
    'ie >= 10',
    'ie_mob >= 10',
    'ff >= 30',
    'chrome >= 34',
    'safari >= 7',
    'opera >= 23',
    'ios >= 7',
    'android >= 4.4',
    'bb >= 10'
];

export const SVG_SPRITE_CONFIG = {
    mode: {
        symbol: {
            dest: '.',
            sprite: SRC_PATHS.svg.output
        }
    }
};

export const BABEL_CONFIG = {
    presets: ['env']
};
