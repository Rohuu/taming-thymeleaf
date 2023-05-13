const gulp = require('gulp');
const babel = require("gulp-babel");
const watch = require('gulp-watch');
const browserSync = require('browser-sync').create();
const environments = require('gulp-environments');
const terser = require('gulp-terser');
const production = environments.production;

gulp.task('watch', () => {
  browserSync.init({
  proxy: 'localhost:8080',
  });
  gulp.watch(['src/main/resources/**/*.html'], gulp.series('copy-html-and-reload'));
  gulp.watch(['src/main/resources/**/*.js'], gulp.series('copy-js-and-reload'));
});

gulp.task('copy-html', () =>
  gulp.src(['src/main/resources/**/*.html'])
  .pipe(gulp.dest('build/resources/main/'))
);

gulp.task('copy-js', () =>
  gulp.src(['src/main/resources/**/*.js'])
  .pipe(babel())
  .pipe(production(terser()))
  .pipe(gulp.dest('build/resources/main/'))
);

gulp.task('copy-html-and-reload', gulp.series('copy-html', reload));
gulp.task('copy-js-and-reload', gulp.series('copy-js', reload));
gulp.task('build', gulp.series('copy-html', 'copy-js'));
gulp.task('default', gulp.series('watch'));

function reload(done) {
  browserSync.reload();
  done();
}