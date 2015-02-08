var SCRIPT_FR = 'Ext.onReady(function(){if(Ext.Date){Ext.Date.shortMonthNames=["Janv","Févr","Mars","Avr","Mai","Juin","Juil","Août","Sept","Oct","Nov","Déc"];Ext.Date.getShortMonthName=function(a){return Ext.Date.shortMonthNames[a]};Ext.Date.monthNames=["Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre"];Ext.Date.monthNumbers={Janvier:0,Janv:0,"Février":1,"Févr":1,Mars:2,Avril:3,Avr:3,Mai:4,Juin:5,Juillet:6,Juil:6,"Août":7,Septembre:8,Sept:8,Octobre:9,Oct:9,Novembre:10,Nov:10,"Décembre":11,"Déc":11};Ext.Date.getMonthNumber=function(a){return Ext.Date.monthNumbers[Ext.util.Format.capitalize(a)]};Ext.Date.dayNames=["Dimanche","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi"];Ext.Date.getShortDayName=function(a){return Ext.Date.dayNames[a].substring(0,3)};Ext.Date.parseCodes.S.s="(?:er)";Ext.Date.getSuffix=function(){return(this.getDate()==1)?"er":""}}if(Ext.util&&Ext.util.Format){Ext.apply(Ext.util.Format,{thousandSeparator:".",decimalSeparator:",",currencySign:"\u20ac",dateFormat:"d/m/Y"})}});Ext.define("Ext.locale.fr.view.View",{override:"Ext.view.View",emptyText:""});Ext.define("Ext.locale.fr.grid.plugin.DragDrop",{override:"Ext.grid.plugin.DragDrop",dragText:"{0} ligne{1} sélectionnée{1}"});Ext.define("Ext.locale.fr.tab.Tab",{override:"Ext.tab.Tab",closeText:"Fermer cette onglet"});Ext.define("Ext.locale.fr.view.AbstractView",{override:"Ext.view.AbstractView",loadingText:"En cours de chargement..."});Ext.define("Ext.locale.fr.picker.Date",{override:"Ext.picker.Date",todayText:"Aujourd\'hui",minText:"Cette date est antérieure à la date minimum",maxText:"Cette date est postérieure à la date maximum",disabledDaysText:"",disabledDatesText:"",nextText:"Mois suivant (CTRL+Flèche droite)",prevText:"Mois précédent (CTRL+Flèche gauche)",monthYearText:"Choisissez un mois (CTRL+Flèche haut ou bas pour changer d\'année.)",todayTip:"{0} (Barre d\'espace)",format:"d/m/y",startDay:1});Ext.define("Ext.locale.fr.picker.Month",{override:"Ext.picker.Month",okText:"&#160;OK&#160;",cancelText:"Annuler"});Ext.define("Ext.locale.fr.toolbar.Paging",{override:"Ext.PagingToolbar",beforePageText:"Page",afterPageText:"sur {0}",firstText:"Première page",prevText:"Page précédente",nextText:"Page suivante",lastText:"Dernière page",refreshText:"Actualiser la page",displayMsg:"Page courante {0} - {1} sur {2} ordinateurs",emptyMsg:"Aucune donnée à afficher"});Ext.define("Ext.locale.fr.form.Basic",{override:"Ext.form.Basic",waitTitle:"Veuillez patienter..."});Ext.define("Ext.locale.fr.form.field.Base",{override:"Ext.form.field.Base",invalidText:"La valeur de ce champ est invalide"});Ext.define("Ext.locale.fr.form.field.Text",{override:"Ext.form.field.Text",minLengthText:"La longueur minimum de ce champ est de {0} caractère(s)",maxLengthText:"La longueur maximum de ce champ est de {0} caractère(s)",blankText:"Ce champ est obligatoire",regexText:"",emptyText:null});Ext.define("Ext.locale.fr.form.field.Number",{override:"Ext.form.field.Number",decimalPrecision:2,minText:"La valeur minimum de ce champ doit être de {0}",maxText:"La valeur maximum de ce champ doit être de {0}",nanText:"{0} n\'est pas un nombre valide",negativeText:"La valeur de ce champ ne peut être négative"});Ext.define("Ext.locale.fr.form.field.File",{override:"Ext.form.field.File",buttonText:"Parcourir..."});Ext.define("Ext.locale.fr.form.field.Date",{override:"Ext.form.field.Date",disabledDaysText:"Désactivé",disabledDatesText:"Désactivé",minText:"La date de ce champ ne peut être antérieure au {0}",maxText:"La date de ce champ ne peut être postérieure au {0}",invalidText:"{0} n\'est pas une date valide - elle doit être au format suivant: {1}",format:"d/m/y",altFormats:"d/m/Y|d-m-y|d-m-Y|d/m|d-m|dm|dmy|dmY|d|Y-m-d"});Ext.define("Ext.locale.fr.form.field.ComboBox",{override:"Ext.form.field.ComboBox",valueNotFoundText:undefined},function(){Ext.apply(Ext.form.field.ComboBox.prototype.defaultListConfig,{loadingText:"En cours de chargement..."})});Ext.define("Ext.locale.fr.form.field.VTypes",{override:"Ext.form.field.VTypes",emailText:\'Ce champ doit contenir une adresse email au format: "usager@example.com"\',urlText:\'Ce champ doit contenir une URL au format suivant: "http://www.example.com"\',alphaText:"Ce champ ne peut contenir que des lettres et le caractère souligné (_)",alphanumText:"Ce champ ne peut contenir que des caractères alphanumériques ainsi que le caractère souligné (_)"});Ext.define("Ext.locale.fr.form.field.HtmlEditor",{override:"Ext.form.field.HtmlEditor",createLinkText:"Veuillez entrer l\'URL pour ce lien:"},function(){Ext.apply(Ext.form.field.HtmlEditor.prototype,{buttonTips:{bold:{title:"Gras (Ctrl+B)",text:"Met le texte sélectionné en gras.",cls:Ext.baseCSSPrefix+"html-editor-tip"},italic:{title:"Italique (Ctrl+I)",text:"Met le texte sélectionné en italique.",cls:Ext.baseCSSPrefix+"html-editor-tip"},underline:{title:"Souligné (Ctrl+U)",text:"Souligne le texte sélectionné.",cls:Ext.baseCSSPrefix+"html-editor-tip"},increasefontsize:{title:"Agrandir la police",text:"Augmente la taille de la police.",cls:Ext.baseCSSPrefix+"html-editor-tip"},decreasefontsize:{title:"Réduire la police",text:"Réduit la taille de la police.",cls:Ext.baseCSSPrefix+"html-editor-tip"},backcolor:{title:"Couleur de surbrillance",text:"Modifie la couleur de fond du texte sélectionné.",cls:Ext.baseCSSPrefix+"html-editor-tip"},forecolor:{title:"Couleur de police",text:"Modifie la couleur du texte sélectionné.",cls:Ext.baseCSSPrefix+"html-editor-tip"},justifyleft:{title:"Aligner à gauche",text:"Aligne le texte à gauche.",cls:Ext.baseCSSPrefix+"html-editor-tip"},justifycenter:{title:"Centrer",text:"Centre le texte.",cls:Ext.baseCSSPrefix+"html-editor-tip"},justifyright:{title:"Aligner à droite",text:"Aligner le texte à droite.",cls:Ext.baseCSSPrefix+"html-editor-tip"},insertunorderedlist:{title:"Liste à puce",text:"Démarre une liste à puce.",cls:Ext.baseCSSPrefix+"html-editor-tip"},insertorderedlist:{title:"Liste numérotée",text:"Démarre une liste numérotée.",cls:Ext.baseCSSPrefix+"html-editor-tip"},createlink:{title:"Lien hypertexte",text:"Transforme en lien hypertexte.",cls:Ext.baseCSSPrefix+"html-editor-tip"},sourceedit:{title:"Code source",text:"Basculer en mode édition du code source.",cls:Ext.baseCSSPrefix+"html-editor-tip"}}})});Ext.define("Ext.locale.fr.grid.header.Container",{override:"Ext.grid.header.Container",sortAscText:"Tri croissant",sortDescText:"Tri décroissant",columnsText:"Colonnes"});Ext.define("Ext.locale.fr.grid.GroupingFeature",{override:"Ext.grid.feature.Grouping",emptyGroupText:"(Aucun)",groupByText:"Grouper par ce champ",showGroupsText:"Afficher par groupes"});Ext.define("Ext.locale.fr.grid.PropertyColumnModel",{override:"Ext.grid.PropertyColumnModel",nameText:"Propriété",valueText:"Valeur",dateFormat:"d/m/Y",trueText:"vrai",falseText:"faux"});Ext.define("Ext.locale.fr.form.field.Time",{override:"Ext.form.field.Time",minText:"L\'heure de ce champ ne peut être antérieure à {0}",maxText:"L\'heure de ce champ ne peut être postérieure à {0}",invalidText:"{0} n\'est pas une heure valide",format:"H:i",altFormats:"g:ia|g:iA|g:i a|g:i A|h:i|g:i|H:i|ga|h a|g a|g A|gi|hi|Hi|gia|hia|g|H"});Ext.define("Ext.locale.fr.form.CheckboxGroup",{override:"Ext.form.CheckboxGroup",blankText:"Vous devez sélectionner au moins un élément dans ce groupe"});Ext.define("Ext.locale.fr.form.RadioGroup",{override:"Ext.form.RadioGroup",blankText:"Vous devez sélectionner au moins un élément dans ce groupe"});Ext.define("Ext.locale.fr.window.MessageBox",{override:"Ext.window.MessageBox",buttonText:{ok:"OK",cancel:"Annuler",yes:"Oui",no:"Non"}});Ext.define("Ext.locale.fr.Component",{override:"Ext.Component"});';
var SCRIPT_EN = 'Ext.onReady(function(){if(Ext.data&&Ext.data.Types){Ext.data.Types.stripRe=/[\$,%]/g}if(Ext.Date){Ext.Date.monthNames=["January","February","March","April","May","June","July","August","September","October","November","December"];Ext.Date.getShortMonthName=function(a){return Ext.Date.monthNames[a].substring(0,3)};Ext.Date.monthNumbers={Jan:0,Feb:1,Mar:2,Apr:3,May:4,Jun:5,Jul:6,Aug:7,Sep:8,Oct:9,Nov:10,Dec:11};Ext.Date.getMonthNumber=function(a){return Ext.Date.monthNumbers[a.substring(0,1).toUpperCase()+a.substring(1,3).toLowerCase()]};Ext.Date.dayNames=["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];Ext.Date.getShortDayName=function(a){return Ext.Date.dayNames[a].substring(0,3)};Ext.Date.parseCodes.S.s="(?:st|nd|rd|th)"}if(Ext.util&&Ext.util.Format){Ext.apply(Ext.util.Format,{thousandSeparator:",",decimalSeparator:".",currencySign:"$",dateFormat:"m/d/Y"})}});Ext.define("Ext.locale.en.view.View",{override:"Ext.view.View",emptyText:""});Ext.define("Ext.locale.en.grid.plugin.DragDrop",{override:"Ext.grid.plugin.DragDrop",dragText:"{0} selected row{1}"});Ext.define("Ext.locale.en.view.AbstractView",{override:"Ext.view.AbstractView",loadingText:"Loading..."});Ext.define("Ext.locale.en.picker.Date",{override:"Ext.picker.Date",todayText:"Today",minText:"This date is before the minimum date",maxText:"This date is after the maximum date",disabledDaysText:"",disabledDatesText:"",nextText:"Next Month (Control+Right)",prevText:"Previous Month (Control+Left)",monthYearText:"Choose a month (Control+Up/Down to move years)",todayTip:"{0} (Spacebar)",format:"m/d/y",startDay:0});Ext.define("Ext.locale.en.picker.Month",{override:"Ext.picker.Month",okText:"&#160;OK&#160;",cancelText:"Cancel"});Ext.define("Ext.locale.en.toolbar.Paging",{override:"Ext.PagingToolbar",beforePageText:"Page",afterPageText:"of {0}",firstText:"First Page",prevText:"Previous Page",nextText:"Next Page",lastText:"Last Page",refreshText:"Refresh",displayMsg:"Displaying {0} - {1} of {2} computers",emptyMsg:"No data to display"});Ext.define("Ext.locale.en.form.Basic",{override:"Ext.form.Basic",waitTitle:"Please Wait..."});Ext.define("Ext.locale.en.form.field.Base",{override:"Ext.form.field.Base",invalidText:"The value in this field is invalid"});Ext.define("Ext.locale.en.form.field.Text",{override:"Ext.form.field.Text",minLengthText:"The minimum length for this field is {0}",maxLengthText:"The maximum length for this field is {0}",blankText:"This field is required",regexText:"",emptyText:null});Ext.define("Ext.locale.en.form.field.Number",{override:"Ext.form.field.Number",decimalPrecision:2,minText:"The minimum value for this field is {0}",maxText:"The maximum value for this field is {0}",nanText:"{0} is not a valid number"});Ext.define("Ext.locale.en.form.field.Date",{override:"Ext.form.field.Date",disabledDaysText:"Disabled",disabledDatesText:"Disabled",minText:"The date in this field must be after {0}",maxText:"The date in this field must be before {0}",invalidText:"{0} is not a valid date - it must be in the format {1}",format:"m/d/y",altFormats:"m/d/Y|m-d-y|m-d-Y|m/d|m-d|md|mdy|mdY|d|Y-m-d"});Ext.define("Ext.locale.en.form.field.ComboBox",{override:"Ext.form.field.ComboBox",valueNotFoundText:undefined},function(){Ext.apply(Ext.form.field.ComboBox.prototype.defaultListConfig,{loadingText:"Loading..."})});Ext.define("Ext.locale.en.form.field.VTypes",{override:"Ext.form.field.VTypes",emailText:\'This field should be an e-mail address in the format "user@example.com"\',urlText:\'This field should be a URL in the format "http://www.example.com"\',alphaText:"This field should only contain letters and _",alphanumText:"This field should only contain letters, numbers and _"});Ext.define("Ext.locale.en.form.field.HtmlEditor",{override:"Ext.form.field.HtmlEditor",createLinkText:"Please enter the URL for the link:"},function(){Ext.apply(Ext.form.field.HtmlEditor.prototype,{buttonTips:{bold:{title:"Bold (Ctrl+B)",text:"Make the selected text bold.",cls:Ext.baseCSSPrefix+"html-editor-tip"},italic:{title:"Italic (Ctrl+I)",text:"Make the selected text italic.",cls:Ext.baseCSSPrefix+"html-editor-tip"},underline:{title:"Underline (Ctrl+U)",text:"Underline the selected text.",cls:Ext.baseCSSPrefix+"html-editor-tip"},increasefontsize:{title:"Grow Text",text:"Increase the font size.",cls:Ext.baseCSSPrefix+"html-editor-tip"},decreasefontsize:{title:"Shrink Text",text:"Decrease the font size.",cls:Ext.baseCSSPrefix+"html-editor-tip"},backcolor:{title:"Text Highlight Color",text:"Change the background color of the selected text.",cls:Ext.baseCSSPrefix+"html-editor-tip"},forecolor:{title:"Font Color",text:"Change the color of the selected text.",cls:Ext.baseCSSPrefix+"html-editor-tip"},justifyleft:{title:"Align Text Left",text:"Align text to the left.",cls:Ext.baseCSSPrefix+"html-editor-tip"},justifycenter:{title:"Center Text",text:"Center text in the editor.",cls:Ext.baseCSSPrefix+"html-editor-tip"},justifyright:{title:"Align Text Right",text:"Align text to the right.",cls:Ext.baseCSSPrefix+"html-editor-tip"},insertunorderedlist:{title:"Bullet List",text:"Start a bulleted list.",cls:Ext.baseCSSPrefix+"html-editor-tip"},insertorderedlist:{title:"Numbered List",text:"Start a numbered list.",cls:Ext.baseCSSPrefix+"html-editor-tip"},createlink:{title:"Hyperlink",text:"Make the selected text a hyperlink.",cls:Ext.baseCSSPrefix+"html-editor-tip"},sourceedit:{title:"Source Edit",text:"Switch to source editing mode.",cls:Ext.baseCSSPrefix+"html-editor-tip"}}})});Ext.define("Ext.locale.en.grid.header.Container",{override:"Ext.grid.header.Container",sortAscText:"Sort Ascending",sortDescText:"Sort Descending",columnsText:"Columns"});Ext.define("Ext.locale.en.grid.GroupingFeature",{override:"Ext.grid.feature.Grouping",emptyGroupText:"(None)",groupByText:"Group by this field",showGroupsText:"Show in Groups"});Ext.define("Ext.locale.en.grid.PropertyColumnModel",{override:"Ext.grid.PropertyColumnModel",nameText:"Name",valueText:"Value",dateFormat:"m/j/Y",trueText:"true",falseText:"false"});Ext.define("Ext.locale.en.grid.BooleanColumn",{override:"Ext.grid.BooleanColumn",trueText:"true",falseText:"false",undefinedText:"&#160;"});Ext.define("Ext.locale.en.grid.NumberColumn",{override:"Ext.grid.NumberColumn",format:"0,000.00"});Ext.define("Ext.locale.en.grid.DateColumn",{override:"Ext.grid.DateColumn",format:"m/d/Y"});Ext.define("Ext.locale.en.form.field.Time",{override:"Ext.form.field.Time",minText:"The time in this field must be equal to or after {0}",maxText:"The time in this field must be equal to or before {0}",invalidText:"{0} is not a valid time",format:"g:i A",altFormats:"g:ia|g:iA|g:i a|g:i A|h:i|g:i|H:i|ga|ha|gA|h a|g a|g A|gi|hi|gia|hia|g|H"});Ext.define("Ext.locale.en.form.field.File",{override:"Ext.form.field.File",buttonText:"Browse..."});Ext.define("Ext.locale.en.form.CheckboxGroup",{override:"Ext.form.CheckboxGroup",blankText:"You must select at least one item in this group"});Ext.define("Ext.locale.en.form.RadioGroup",{override:"Ext.form.RadioGroup",blankText:"You must select one item in this group"});Ext.define("Ext.locale.en.window.MessageBox",{override:"Ext.window.MessageBox",buttonText:{ok:"OK",cancel:"Cancel",yes:"Yes",no:"No"}});Ext.define("Ext.locale.en.Component",{override:"Ext.Component"});';
var SCRIPT_TEXT_EN = 'if (MyApp.view.main.Main) {    Ext.apply(MyApp.view.main.Main.prototype, {        homeTile:"Application - Computer Database"    });}if (MyApp.view.home.HomeView) {    Ext.apply(MyApp.view.home.HomeView.prototype, {        columnName:"Name",        columnIntroduced:"Introduced",        columnDiscontinued:"Discontinued",        columnCompany:"Company",        homeTitle:"Computers found",        buttonAdd:"Add computer",        tooltipDelete:"Delete"    });}if (MyApp.view.home.HomeController) {    Ext.apply(MyApp.view.home.HomeController.prototype, {        deletedText:" deleted"    });}if (MyApp.view.computer.UpdateComputer) {    Ext.apply(MyApp.view.computer.UpdateComputer.prototype, {        homeTile:"Update computer",        fieldName:"Computer Name",        fieldIntroduced:"Introduced Date",        fieldDiscontinued:"Discountinued Date",        fieldCompany:"Company",        buttonSave:"Save",        buttonCancel:"Cancel"    });}if (MyApp.view.computer.AddComputer) {    Ext.apply(MyApp.view.computer.AddComputer.prototype, {        homeTile:"Add computer",        fieldName:"Computer Name",        fieldIntroduced:"Introduced Date",        fieldDiscontinued:"Discountinued Date",        fieldCompany:"Company",        buttonAdd:"Add",        buttonCancel:"Cancel"    });}if (MyApp.view.computer.AddComputerController) {    Ext.apply(MyApp.view.computer.AddComputerController.prototype, {        successTitle:"Success",        successText:"success",        failTitle:"Failed",        failText:"fail"    });}if (MyApp.view.computer.UpdateComputerController) {    Ext.apply(MyApp.view.computer.UpdateComputerController.prototype, {        successTitle:"Success",        successText:"success",        failTitle:"Failed",        failText:"fail"    });}';
var SCRIPT_TEXT_FR = 'if (MyApp.view.main.Main) {    Ext.apply(MyApp.view.main.Main.prototype, {        homeTile:"Application - Base de données d\'ordinateurs"    });}if (MyApp.view.home.HomeView) {    Ext.apply(MyApp.view.home.HomeView.prototype, {        columnName:"Nom de l\'ordinateur",        columnIntroduced:"Date d\'introduction",        columnDiscontinued:"Date d\'interruption",        columnCompany:"Companie",        homeTitle:"Ordinateurs trouvés",        buttonAdd:"Ajout d\'un ordinateur",        tooltipDelete:"Effacer"    });}if (MyApp.view.home.HomeController) {    Ext.apply(MyApp.view.home.HomeController.prototype, {        deletedText:" supprimée"    });}if (MyApp.view.computer.UpdateComputer) {    Ext.apply(MyApp.view.computer.UpdateComputer.prototype, {        homeTile:"Modification d\'ordinateur",        fieldName:"Nom de l\'ordinateur",        fieldIntroduced:"Date d\'introduction",        fieldDiscontinued:"Date d\'interruption",        fieldCompany:"Companie",        buttonSave:"Sauvegarder",        buttonCancel:"Annuler"    });}if (MyApp.view.computer.AddComputer) {    Ext.apply(MyApp.view.computer.AddComputer.prototype, {        homeTile:"Ajouter un ordinateur",        fieldName:"Nom de l\'ordinateur",        fieldIntroduced:"Date d\'introduction",        fieldDiscontinued:"Date d\'interruption",        fieldCompany:"Companie",        buttonAdd:"Ajouter",        buttonCancel:"Annuler"    });}if (MyApp.view.computer.AddComputerController) {    Ext.apply(MyApp.view.computer.AddComputerController.prototype, {        successTitle:"Succès",        successText:"succès",        failTitle:"Erreur",        failText:"erreur"    });}if (MyApp.view.computer.UpdateComputerController) {    Ext.apply(MyApp.view.computer.UpdateComputerController.prototype, {        successTitle:"Succès",        successText:"succès",        failTitle:"Erreur",        failText:"erreur"    });}';
var homeTitleEn="Application - Computer Database";
var homeTitleFr="Application - Base de données d\'ordinateurs";
/* EN
if (MyApp.view.main.Main) {
    Ext.apply(MyApp.view.main.Main.prototype, {
        homeTile:"Application - Computer Database"
    });
}
if (MyApp.view.home.HomeView) {
    Ext.apply(MyApp.view.home.HomeView.prototype, {
        columnName:"Name",
        columnIntroduced:"Introduced",
        columnDiscontinued:"Discontinued",
        columnCompany:"Company",
        homeTitle:"Computers found",
        buttonAdd:"Add computer",
        tooltipDelete:"Delete"
    });
}
if (MyApp.view.home.HomeController) {
    Ext.apply(MyApp.view.home.HomeController.prototype, {
        deletedText:" deleted"
    });
}
if (MyApp.view.computer.UpdateComputer) {
    Ext.apply(MyApp.view.computer.UpdateComputer.prototype, {
        homeTile:"Update computer",
        fieldName:"Computer Name",
        fieldIntroduced:"Introduced Date",
        fieldDiscontinued:"Discountinued Date",
        fieldCompany:"Company",
        buttonSave:"Save",
        buttonCancel:"Cancel"
    });
}
if (MyApp.view.computer.AddComputer) {
    Ext.apply(MyApp.view.computer.AddComputer.prototype, {
        homeTile:"Add computer",
        fieldName:"Computer Name",
        fieldIntroduced:"Introduced Date",
        fieldDiscontinued:"Discountinued Date",
        fieldCompany:"Company",
        buttonAdd:"Add",
        buttonCancel:"Cancel"
    });
}
if (MyApp.view.computer.AddComputerController) {
    Ext.apply(MyApp.view.computer.AddComputerController.prototype, {
        successTitle:"Success",
        successText:"success",
        failTitle:"Failed",
        failText:"fail"
    });
}
if (MyApp.view.computer.UpdateComputerController) {
    Ext.apply(MyApp.view.computer.UpdateComputerController.prototype, {
        successTitle:"Success",
        successText:"success",
        failTitle:"Failed",
        failText:"fail"
    });
}
*/

/* FR
if (MyApp.view.main.Main) {
    Ext.apply(MyApp.view.main.Main.prototype, {
        homeTile:"Application - Base de données d'ordinateurs"
    });
}
if (MyApp.view.home.HomeView) {
    Ext.apply(MyApp.view.home.HomeView.prototype, {
        columnName:"Nom de l\'ordinateur",
        columnIntroduced:"Date d\'introduction",
        columnDiscontinued:"Date d\'interruption",
        columnCompany:"Companie",
        homeTitle:"Ordinateurs trouvés",
        buttonAdd:"Ajout d\'un ordinateur",
        tooltipDelete:"Effacer"
    });
}
if (MyApp.view.home.HomeController) {
    Ext.apply(MyApp.view.home.HomeController.prototype, {
        deletedText:" supprimée"
    });
}
if (MyApp.view.computer.UpdateComputer) {
    Ext.apply(MyApp.view.computer.UpdateComputer.prototype, {
        homeTile:"Modification d'ordinateur",
        fieldName:"Nom de l\'ordinateur",
        fieldIntroduced:"Date d\'introduction",
        fieldDiscontinued:"Date d\'interruption",
        fieldCompany:"Companie",
        buttonSave:"Sauvegarder",
        buttonCancel:"Annuler"
    });
}
if (MyApp.view.computer.AddComputer) {
    Ext.apply(MyApp.view.computer.AddComputer.prototype, {
        homeTile:"Ajouter un ordinateur",
        fieldName:"Nom de l\'ordinateur",
        fieldIntroduced:"Date d\'introduction",
        fieldDiscontinued:"Date d\'interruption",
        fieldCompany:"Companie",
        buttonAdd:"Ajouter",
        buttonCancel:"Annuler"
    });
}
if (MyApp.view.computer.AddComputerController) {
    Ext.apply(MyApp.view.computer.AddComputerController.prototype, {
        successTitle:"Succès",
        successText:"succès",
        failTitle:"Erreur",
        failText:"erreur"
    });
}
if (MyApp.view.computer.UpdateComputerController) {
    Ext.apply(MyApp.view.computer.UpdateComputerController.prototype, {
        successTitle:"Succès",
        successText:"succès",
        failTitle:"Erreur",
        failText:"erreur"
    });
}
*/