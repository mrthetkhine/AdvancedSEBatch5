const EventEmitter = require('node:events');
const eventEmitter = new EventEmitter();
console.log("Init auth");
setInterval(()=>{
    //console.log('Register');
    eventEmitter.emit('register',{
        register: new Date()
    })
},1000);
exports.register = eventEmitter
