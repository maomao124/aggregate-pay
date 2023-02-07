const path = require('path')
const devServerPort = 7123
const name = '聚合支付'
const host = 'http://localhost:56010'
// const host = 'http://xfc.nat300.top'
// const host = 'http://211.103.136.242:7280/'
// const host = 'https://mock.boxuegu.com/mock/602'

module.exports = {
    publicPath: '/',
    lintOnSave: process.env.NODE_ENV === 'development',
    devServer: {
        port: devServerPort,
        open: true,
        overlay: {
            warnings: false,
            errors: true
        },
        proxy: {
            [process.env.VUE_APP_BASE_API + '/merchant']: {
              target: host,
              changeOrigin: true, // needed for virtual hosted sites
              ws: true, // proxy websockets
              pathRewrite: {
                ['^' + process.env.VUE_APP_BASE_API + '/merchant']: '/merchant'
              }
            },
            [process.env.VUE_APP_BASE_API + '/uaa']: {
              target: host,
              changeOrigin: true, // needed for virtual hosted sites
              ws: true, // proxy websockets
              pathRewrite: {
                ['^' + process.env.VUE_APP_BASE_API + '/uaa']: '/uaa'
              }
            },
            [process.env.VUE_APP_BASE_API + '/user']: {
              target: host,
              changeOrigin: true, // needed for virtual hosted sites
              ws: true, // proxy websockets
              pathRewrite: {
                ['^' + process.env.VUE_APP_BASE_API + '/user']: '/user'
              }
            },
            [process.env.VUE_APP_BASE_API + '/operation']: {
              target: host,
              changeOrigin: true, // needed for virtual hosted sites
              ws: true, // proxy websockets
              pathRewrite: {
                ['^' + process.env.VUE_APP_BASE_API + '/operation']: '/operation'
              }
            },
            [process.env.VUE_APP_BASE_API + '/zuul']: {
              target: host,
              changeOrigin: true, // needed for virtual hosted sites
              ws: true, // proxy websockets
              pathRewrite: {
                ['^' + process.env.VUE_APP_BASE_API + '/zuul']: '/zuul'
              }
            }

        }
    },
    pwa: {
        name: name
    },
    pluginOptions: {
        'style-resources-loader': {
            preProcessor: 'scss',
            patterns: [
                path.resolve(__dirname, 'src/styles/_variables.scss'),
                path.resolve(__dirname, 'src/styles/_mixins.scss')
            ]
        }
    },
    chainWebpack(config) {
        // Provide the app's title in webpack's name field, so that
        // it can be accessed in index.html to inject the correct title.
        config.set('name', name)
    }
}
