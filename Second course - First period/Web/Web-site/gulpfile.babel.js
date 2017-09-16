import gulp from 'gulp';
import concat from 'gulp-concat';
import autoprefixer from 'gulp-autoprefixer';
import svgSprite from 'gulp-svg-sprite';
import sass from 'gulp-sass';
import babel from 'gulp-babel';
import minifyJs from 'gulp-uglify';
import minifyCss from 'gulp-clean-css';

import {
    SRC_PATHS,
    AUTOPREFIXER_CONFIG,
    BABEL_CONFIG,
    SVG_SPRITE_CONFIG
} from './gulp.config.babel';


gulp.task('sass', () =>
    gulp.src(SRC_PATHS.sass.input)
        .pipe(sass.sync().on('error', sass.logError))
        .pipe(autoprefixer(AUTOPREFIXER_CONFIG))
        .pipe(minifyCss())
        .pipe(concat(SRC_PATHS.sass.output))
        .pipe(gulp.dest(SRC_PATHS.sass.dest))
);

gulp.task('svg', () =>
    gulp.src(SRC_PATHS.svg.input)
        .pipe(svgSprite(SVG_SPRITE_CONFIG))
        .pipe(gulp.dest(SRC_PATHS.svg.dest))
);

gulp.task('js', () =>
    gulp.src(SRC_PATHS.js.input)
        .pipe(babel(BABEL_CONFIG))
        .pipe(minifyJs())
        .pipe(concat(SRC_PATHS.js.output))
        .pipe(gulp.dest(SRC_PATHS.js.dest))
);

gulp.task('default', ['sass', 'svg', 'js'], () => {
    gulp.watch(SRC_PATHS.sass.input, ['sass']);
    gulp.watch(SRC_PATHS.svg.input, ['svg']);
    gulp.watch(SRC_PATHS.js.input, ['js']);
});
