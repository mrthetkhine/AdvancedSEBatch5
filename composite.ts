type Composite = View | ViewGroup;
type View = {
    id : string,
    draw:()=>any
}
type ViewGroup = {
    id:string,
    children: Composite[],
    draw:()=>any,
}

let viewGroup : Composite = {
    id : 'Main Group',
    children: [
        {
            id:'Child view 1',
            draw()
            {
                console.log('Child view 1 draw');
            }
        },
        {
            id:'Child composite 2',
            children:[
                {
                    id:'Child level 2',
                    draw()
                    {
                        console.log('Child level 2 draw');
                    }
                },
            ],
            draw()
            {
                console.log('Child view 1 draw');
                for(let view of this.children)
                {
                    view.draw();
                }
            }
        },
    ],
    draw()
    {
        console.log('Draw main');
        for(let view of this.children)
        {
            view.draw();
        }
    }
}
viewGroup.draw();