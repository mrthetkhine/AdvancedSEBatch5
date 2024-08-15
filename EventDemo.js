class Event
{
    handlers= [];// event handlers

    on(handler)
    {
       this.handlers.push(handler);
    }
    emit(event)
    {
        for(let handler of this.handlers)
        {
            handler(event);
        }
    }
}
let event = new Event();
event.on((evt)=>console.log('Handler 1',evt));
event.on((evt)=>console.log('Handler 2',evt));
event.emit({
    name :'Event1'
})