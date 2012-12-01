<script type="text/javascript">
    var rpcUrl = "admin/jsonrpc";
    var methods = [
        "createFilm",
        "readAllFilms",
        "createTrailerWithParent",
        "createTrailer"
    ];

    var rpc = new zebra.io.JRPC(rpcUrl, methods);

    rpc.print = function (jo) {
        return JSON.stringify(jo, null, '\t');
    }
</script>