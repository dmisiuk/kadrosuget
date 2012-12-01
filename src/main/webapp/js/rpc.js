var rpcUrl = "/rpc";
var methods = [
    "getTenFilmsBefore",
    "getTenFilmsAfter",
    "readTrailer"
];

var rpc = new zebra.io.JRPC(rpcUrl, methods);

rpc.print = function (jo) {
    return JSON.stringify(jo, null, '\t');
}
