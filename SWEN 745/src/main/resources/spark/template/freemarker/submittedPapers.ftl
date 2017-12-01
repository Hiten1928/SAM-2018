<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <title>${title} | SAM 2018</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="page">

    <h1> - Software Architecture Mining 2018 - </h1>

    <div class="navigation">
        <a href="/">Home Page</a> -
        <a href="/papersList">Papers Submitted</a> -
        <a href="/reviewPapers">Papers for Review</a> -
        <a href="/">Sign Out</a>
    </div><br /><br />

    <h2>
        <div class="body">
            Submitted Papers
        </div>
    </h2>

    <#if papersSubmitted??>
        <br />
        Submitted Papers:
        <br />
        <ol>
            <#list papersSubmitted as n>
                <li> ${n} </li>
            </#list>
        </ol>
    </#if>


</div>
</body>
</html>