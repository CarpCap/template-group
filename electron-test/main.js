const { app, BrowserWindow } = require('electron');

let mainWindow;


function createWindow() {
    mainWindow = new BrowserWindow({
        width: 1280,
        height: 800,

        webPreferences: {
            // 持久化存储
            partition: 'persist:discord',

            nodeIntegration: true,
            contextIsolation: true
        }
    });

    mainWindow.loadURL('https://x.com');

    // 打开调试
    // mainWindow.webContents.openDevTools();
}

app.whenReady().then(() => {
    createWindow();

    console.log(app.getPath('userData'));
    app.on('activate', () => {
        if (BrowserWindow.getAllWindows().length === 0) {
            createWindow();
        }
    });
});

app.on('window-all-closed', () => {
    if (process.platform !== 'darwin') {
        app.quit();
    }
});