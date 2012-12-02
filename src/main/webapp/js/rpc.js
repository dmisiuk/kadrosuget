var rpcUrl = "/rpc";
var methods = [
    "getFilmDto"
];

var rpc = new zebra.io.JRPC(rpcUrl, methods);

rpc.print = function (jo) {
    return JSON.stringify(jo, null, '\t');
}
