var LOCALE="en";
Ext.define('MyApp.Application', {
    extend: 'Ext.app.Application',

    name: 'MyApp',
    browerSupport:'Your Browser Does Not Support Local Storage',
    //defaultToken:'home/en',



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
        'MyApp.view.Main',
        'MyApp.view.home.HomeView','MyApp.view.home.HomeController',
        'MyApp.view.computer.AddComputer','MyApp.view.computer.AddComputerController',
        'MyApp.view.computer.UpdateComputer','MyApp.view.computer.UpdateComputerController', 'MyApp.view.computer.UpdateComputerModel',
        'MyApp.view.login.Login','MyApp.view.login.LoginController'

    ],

    launch: function () {
        // TODO - Launch the application
        // Check whether the browser supports LocalStorage
        // It's important to note that this type of application could use
        // any type of storage, i.e., Cookies, LocalStorage, etc.
        var supportsLocalStorage = Ext.supports.LocalStorage,
            loggedIn;

        if (!supportsLocalStorage) {

            // Alert the user if the browser does not support localStorage
            Ext.Msg.alert(this.browerSupport);
            return;
        }

        // Check to see the current value of the localStorage key
        loggedIn = localStorage.getItem("LoggedIn");

        // This ternary operator determines the value of the TutorialLoggedIn key.
        // If TutorialLoggedIn isn't true, we display the login window,
        // otherwise, we display the main view
        Ext.widget(loggedIn ? 'app-main' : 'login');
        loggedIn = localStorage.getItem("LoggedIn");
        if(loggedIn) {
            this.redirectTo('home/'+LOCALE);
        }
    }
    /*
    onUser: function() {
        //var main = Ext.getCmp('main');//('MyApp.view.computer.addComputer');
        this.addContentToCenterRegion({
            xtype: 'addcomputer'
        });
    }*/
});