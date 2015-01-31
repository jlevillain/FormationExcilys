Ext.define('MyApp.Application', {
    extend: 'Ext.app.Application',

    name: 'MyApp',

    defaultToken:'home',



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
    views:[
        'MyApp.view.home.HomeView','MyApp.view.home.HomeController',
        'MyApp.view.computer.AddComputer','MyApp.view.computer.AddComputerController',
        'MyApp.view.computer.UpdateComputer','MyApp.view.computer.UpdateComputerController', 'MyApp.view.computer.UpdateComputerModel'

    ],

    launch: function () {
        // TODO - Launch the application
    }
    /*
    onUser: function() {
        //var main = Ext.getCmp('main');//('MyApp.view.computer.addComputer');
        this.addContentToCenterRegion({
            xtype: 'addcomputer'
        });
    }*/
});