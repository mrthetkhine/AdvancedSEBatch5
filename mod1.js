const auth = require('./auth');

auth.register.on('register',(event)=>{
    console.log('Register event ',event);
});
console.log(auth);