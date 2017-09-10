'use strict';


import gulp from 'gulp';
import del from 'del';
import runSequence from 'run-sequence';
import browserSync from 'browser-sync';
import gulpLoadPlugins from 'gulp-load-plugins';
import svg from 'gulp-svg-sprite';
import sass from 'gulp-sass';


import {
  SVG_SPRITE_CONFIG,
  AUTOPREFIXER_CONFIG,
  HTML_MIN_CONFIG,
  IMAGE_MIN_CONFIG
} from './gulp.config.babel';


const $ = gulpLoadPlugins();
const reload = browserSync.reload;


// Optimize images
gulp.task('images', () => (
  gulp.src('src/images/**/*.{png,jpg,jpeg}')
    .pipe($.cache($.imagemin(IMAGE_MIN_CONFIG)))
    .pipe(gulp.dest('dist/images'))
    .pipe($.size({title: 'images'}))
));


// Copy all files at the root level (src)
gulp.task('copy', () =>
  gulp.src([
    'src/*',
    '!src/*.html',
    'node_modules/apache-server-configs/dist/.htaccess'
  ], {
    dot: true
  }).pipe(gulp.dest('dist'))
    .pipe($.size({title: 'copy'}))
);


// Compile and automatically prefix stylesheets
gulp.task('styles', () => (
  gulp.src([
    'src/styles/default.scss',
    'src/styles/**/*.scss'
  ])
    .pipe($.newer('.tmp/styles'))
    .pipe($.sourcemaps.init())
    .pipe(sass.sync().on('error', sass.logError))
    .pipe($.autoprefixer(AUTOPREFIXER_CONFIG))
    .pipe($.concat('index.css'))
    .pipe(gulp.dest('.tmp/styles'))
    .pipe($.if('*.css', $.cssnano()))
    .pipe($.size({title: 'styles'}))
    .pipe($.sourcemaps.write('./'))
    .pipe(gulp.dest('dist/styles'))
));


gulp.task('scripts', () =>
    gulp.src([
      // Note: Since we are not using useref in the scripts build pipeline,
      //       you need to explicitly list your scripts here in the right order
      //       to be correctly concatenated
      './src/scripts/main.js'
      // Other scripts
    ])
      .pipe($.newer('.tmp/scripts'))
      .pipe($.sourcemaps.init())
      .pipe($.babel())
      .pipe($.sourcemaps.write())
      .pipe(gulp.dest('.tmp/scripts'))
      .pipe($.concat('main.min.js'))
      .pipe($.uglify({preserveComments: 'some'}))
      // Output files
      .pipe($.size({title: 'scripts'}))
      .pipe($.sourcemaps.write('.'))
      .pipe(gulp.dest('dist/scripts'))
);


// Scan your HTML for assets & optimize them
gulp.task('html', () => {
  return gulp.src('src/**/*.html')
    .pipe($.useref({
      searchPath: '{.tmp,src}',
      noAssets: true
    }))
    .pipe($.if('*.html', $.htmlmin(HTML_MIN_CONFIG) ))
    .pipe($.if('*.html', $.size({title: 'html', showFiles: true})))
    .pipe(gulp.dest('dist'));
});


//Svg sprites generator
gulp.task('svg', () =>
  gulp.src( 'src/images/svg/**/*.svg' )
    .pipe( svg(SVG_SPRITE_CONFIG) )
    .pipe( gulp.dest('dist') )
);


// Clean output directory
gulp.task('clean', () => del(['.tmp', 'dist/*', '!dist/.git'], {dot: true}));


// Watch files for changes & reload
gulp.task('serve', ['scripts', 'styles'], () => {
  browserSync({
    notify: false,
    logPrefix: 'WSK',
    server: ['.tmp', 'src'],
    port: 3000
  });

  gulp.watch(['src/**/*.html'], reload);
  gulp.watch(['src/styles/**/*.{scss,css}'], ['styles', reload]);
  gulp.watch(['src/scripts/**/*.js'], ['lint', 'scripts', reload]);
  gulp.watch(['src/images/svg/**/*.svg'], ['svg', reload]);
});


// Build production files, the default task
gulp.task('default', ['clean'], () =>
  runSequence(
    'styles',
    ['html', 'scripts', 'images', 'svg', 'copy']
  )
);
