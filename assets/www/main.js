

document.addEventListener('deviceready', function(){
    window.plugins.nfc.id(
        function(tag){
            $('#nfc_tag').append(tag.id).css('font-size','40pt');
        },
        function(e){
            log(e);
        });
    
}, true);
