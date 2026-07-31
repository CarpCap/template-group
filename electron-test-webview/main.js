const { app, BrowserWindow, session } = require('electron');
const path = require('path');

function createWindow() {

    const discordSession = session.fromPartition(
        'persist:discord-webview'
    );

    const win = new BrowserWindow({
        width: 1280,
        height: 800,
        frame: false,
        webPreferences: {
            // 预加载脚本，在网页加载前执行
            // 用于注入 JS、暴露 Electron API、修改网页行为等
            // preload: this.preload,

            // 开启上下文隔离
            // preload 和网页运行在不同 JS 环境，需要通过 contextBridge 通信
            contextIsolation: true,

            // 是否允许网页直接使用 Node.js API（require、fs、process 等）
            // 开启后网页拥有 Node 权限，安全风险较高
            nodeIntegration: true,

            // 是否启用 Chromium 插件支持（例如旧版 Flash）
            plugins: true,

            // 是否关闭网页安全策略
            // false：开启同源策略/CORS限制
            // true：允许跨域请求
            webSecurity: false,

            // 是否允许使用 <webview> 标签嵌入网页
            // 例如：
            // <webview src="https://discord.com/app">
            webviewTag: true,

            // 是否关闭 Chromium 的网页安全限制
            // 主要影响跨域、iframe 等安全策略
            chromeWebSecurity: false,

            // 是否允许 iframe 子页面也使用 Node.js
            // 风险较高，一般不要开启
            nodeIntegrationInSubFrames: true,

            // 是否允许 HTTPS 页面加载 HTTP 内容
            // 例如 https://xxx.com 加载 http://xxx.com/test.js
            allowRunningInsecureContent: true,

            // 网页数据存储隔离空间
            // persist:xxx 表示持久化保存
            // 保存 Cookie、LocalStorage、IndexedDB、缓存等
            // 相同 partition 的页面共享登录状态
            partition: 'persist:home',
        }
    });

    win.loadFile('index.html');

    win.webContents.openDevTools();
}


app.whenReady().then(() => {
    createWindow();
});


app.on('window-all-closed', () => {
    if (process.platform !== 'darwin') {
        app.quit();
    }
});