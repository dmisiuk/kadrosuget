<script type="text/javascript">
    var rpcUrl = "adminrpc";
    var methods = [
        "createFilm",
        "readAllFilms"

    ];

    var rpc = new zebra.io.JRPC(rpcUrl, methods);

    rpc.print = function (jo) {
        return JSON.stringify(jo, null, '\t');
    }
</script>