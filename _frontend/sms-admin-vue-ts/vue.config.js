// import devServer from './utils/devServer'
// eslint-disable-next-line @typescript-eslint/no-var-requires
const devServer = require('./utils/devServer')
// eslint-disable-next-line @typescript-eslint/no-var-requires
// const favicons = require('./utils/favicon')
const outputDir = 'dist'

module.exports = {
  // favicons,
  pwa: {
    iconPaths: {
      favicon32: 'favicon.ico',
      favicon16: 'favicon.ico',
      appleTouchIcon: 'favicon.ico',
      maskIcon: 'favicon.ico',
      msTileImage: 'favicon.ico'
    }
  },
  publicPath: process.env.NODE_ENV !== 'production' ? '/' : './',
  productionSourceMap: false,
  outputDir,
  devServer,
  transpileDependencies: [
    'vue-echarts'
  ],
  chainWebpack: config => {
    const obj = {
      'echarts/lib/echarts': 'echarts'
    }
    if (process.env.NODE_ENV === 'production') {
      obj.vue = 'Vue'
      obj['element-ui'] = 'ELEMENT'
    }
    config
    .externals(obj)
    // .plugin('process-env')
    // .tap(args => {
    //   return args
    // })
  }
}