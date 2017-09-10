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
      sprite: 'sprite.svg'
    }
  }
};

export const HTML_MIN_CONFIG = {
  removeComments: true,
  collapseWhitespace: true,
  collapseBooleanAttributes: true,
  removeAttributeQuotes: true,
  removeRedundantAttributes: true,
  removeEmptyAttributes: true,
  removeScriptTypeAttributes: true,
  removeStyleLinkTypeAttributes: true,
  removeOptionalTags: true
};

export const IMAGE_MIN_CONFIG = {
  progressive: true,
  interlaced: true
};
