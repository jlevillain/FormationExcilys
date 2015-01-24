/**
 * Created by eron on 24/01/15.
 */
Ext.define('MyApp.view.computer.AddComputerController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.addcomputer',
    init:function() {

    },
    AddComputer:function() {
        alert("computer added");
    },
    Cancel:function() {
        this.redirectTo('home');
    }
});