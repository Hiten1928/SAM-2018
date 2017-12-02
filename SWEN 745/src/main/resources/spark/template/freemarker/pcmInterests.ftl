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
                <a href="/pcc">Home Page</a> -
                <a href="/assignPapers">Assign Papers</a> -
                <a href="/reviewedPapers">Reviewed Papers</a> -
                <a href="/pcmInterests">PCM Interests</a> -
                <a href="/">Sign Out</a>
            </div><br /><br />

            <h2>
                <div class="body">
                    PCM Interests
                </div>
            </h2>

            <#if interestsList??>
                <br />
                PCM Paper Interests:
                <br />
                <ol>
                        <#list pcmName as pcmName>
                            <li> PCM Username: ${pcmName} </li>
                            <ul>
                                <li> Interests: </li>
                                <ul>
                                    <#list interestsList as n>
                                        <li> Paper: <i>${n}</i> </li>
                                    </#list>
                                </ul>
                            </ul>
                        </#list>
                </ol>
            </#if>
        </div>
    </body>
</html>