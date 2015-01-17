Ext.define('MyApp.Application', {
    extend: 'Ext.app.Application',

    name: 'MyApp',

    stores: [
        // TODO: add global/shared stores here
        'User','CompanyStore', 'ComputerStore'
    ],

    models : [
       'User', 'Company', 'Computer'
    ],
    controllers : [
        'MyApp.controller.MainController'
    ],

    launch: function () {
        // TODO - Launch the application
    }
});