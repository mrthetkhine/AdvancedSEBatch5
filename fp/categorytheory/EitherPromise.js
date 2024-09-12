Promise.resolve(100)
        .then( data=>data*2, error=>0)
        .then(console.log)