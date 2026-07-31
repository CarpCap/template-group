const { contextBridge } = require('electron');


contextBridge.exposeInMainWorld(
    'testAPI',
    {
        hello(){
            console.log('hello');
        }
    }
);
console.log('hello--------------',contextBridge);