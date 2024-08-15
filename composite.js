var viewGroup = {
    id: 'Main Group',
    children: [
        {
            id: 'Child view 1',
            draw: function () {
                console.log('Child view 1 draw');
            }
        },
        {
            id: 'Child composite 2',
            children: [
                {
                    id: 'Child level 2',
                    draw: function () {
                        console.log('Child level 2 draw');
                    }
                },
            ],
            draw: function () {
                console.log('Child view 1 draw');
            }
        },
    ],
    draw: function () {
        console.log('Draw main');
        for (var _i = 0, _a = this.children; _i < _a.length; _i++) {
            var view = _a[_i];
            view.draw();
        }
    }
};
viewGroup.draw();
