<script type="text/javascript">
    var rpcUrl = "admin/jsonrpc";
    var methods = [
        "createFilm",
        "readFilm",
        "createTrailer",
        "readTrailer"
    ];

    var rpc = new zebra.io.JRPC(rpcUrl, methods);

    rpc.print = function (jo) {
        return JSON.stringify(jo, null, '\t');
    }
</script>