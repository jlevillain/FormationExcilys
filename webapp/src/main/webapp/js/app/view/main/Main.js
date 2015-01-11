Ext.define('MyApp.view.main.Main', {
    extend: 'Ext.container.Container',
    xtype:'app-main',
    alias:"widget.main",
    layout: {
        type: 'border'
    },
    items: [{
        xtype: 'panel',
        bind: {
            title: '{name}'
        },
        region: 'west',
        html: '<ul>...</ul>',
        width: 250,
        split: true,
        tbar: [{
            xtype:"button",
            text: 'Button',
            handler: 'onClickButton'
        }]
    },{
        region: 'center',
        xtype: 'tabpanel',
        items:[{
            title: 'Tab 1',
            html: '<h2>Content ...</h2>'
        }]
    }]
});
