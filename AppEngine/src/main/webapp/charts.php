<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Carra Le Pirate Faché</title>

    <!-- Load c3.css -->
    <link href="./libs/c3-0.4.10/c3.css" rel="stylesheet" type="text/css">

    <!-- Load d3.js and c3.js -->
    <script src="//d3js.org/d3.v3.min.js" charset="utf-8"></script>
    <script src="./libs/c3-0.4.10/c3.min.js"></script>
</head>

<body>

<h1></h1>

<div id="chart"></div>

<script type="application/javascript">


    var chart = c3.generate({
        bindto: '#chart',
        data: {
            columns: [
                ['data1', 30, 200, 100, 400, 150, 250],
                ['data2', 50, 20, 10, 40, 15, 25]
            ]
        }
    });
</script>
</body>
</html>
