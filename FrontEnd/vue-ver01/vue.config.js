module.exports = {
    devServer: {
        port: 8080,
        host: "0.0.0.0",
        proxy: {
            '/api': {
                target: 'http://121.46.19.26:8288/ForeSee/',
                ws: true,
                changeOrigin: true,
                pathRewrite: {
                    '^/api': ''
                }
            },
        }
    },

    publicPath: "./",
    outputDir: undefined,
    assetsDir: 'static',
    runtimeCompiler: undefined,
    productionSourceMap: undefined,
    parallel: undefined,
    css: undefined
};