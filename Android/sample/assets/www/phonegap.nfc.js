var Nfc = function(){};
Nfc.prototype.id = function(successCallback, failureCallback){
    return PhoneGap.exec(successCallback,
                         failureCallback,
                         "NfcPlugin",
                         "id",
                         [Math.random()]);
};

PhoneGap.addConstructor(function() {
    PhoneGap.addPlugin('nfc', new Nfc());
    PluginManager.addService("NfcPlugin","org.shokai.phonegap.plugin.nfc.NfcPlugin");
});