/**
 * Created by eron on 24/01/15.
 */
Ext.define('MyApp.view.home.HomeController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.home',
    deletedText:' deleted',
    confirm:'Confirm',
    confirmQuestion:'Are you sure?',
    rowIndex:-1,
    grid:null,
    init:function() {
        console.log('init home')
    },
    AddComputer:function() {
        this.redirectTo('user/'+LOCALE);
    },
    DeleteComputer:function(grid, rowIndex, colIndex) {
        this.rowIndex = rowIndex;
        this.grid = grid;
        Ext.Msg.confirm(this.confirm, this.confirmQuestion, 'onConfirm', this);

    },

    onConfirm: function (choice) {
        me = this;
        if (choice === 'yes') {
            var store = this.grid.getStore();
            var rec = store.getAt(this.rowIndex);
            rec.erase({success:function() {
                alert(rec.get('name')+me.deletedText);
            }});
        }
    }
});