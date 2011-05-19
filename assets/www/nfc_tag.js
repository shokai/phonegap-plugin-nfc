var nfc_tag = {};
nfc_tag.id = function(){
    try{
        var pairs = location.href.split("?")[1].split("&");
        for(var i = 0; i < pairs.length; i++){
            var pair = pairs[i].split("=");
            if(pair[0]=="nfc_tag" && pair[1].length > 0) return pair[1];
        }
    }
    catch(e){
        return null;
    }
    return null;
}();
