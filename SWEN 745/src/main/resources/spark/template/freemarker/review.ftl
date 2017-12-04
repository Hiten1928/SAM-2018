<!DOCTYPE html>
<head xmlns="http://www.w3.org/1999/html">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <title>${title} | SAM 2018</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
    <body>
        <div class="page">
            <h1> - Software Architecture Mining 2018 - </h1>

            <div class="navigation">
                <a href="/pcm">Home Page</a> -
                <a href="/submittedPapers">Papers Submitted</a> -
                <a href="/reviewPapers">Papers for Review</a> -
                <a href="/">Sign Out</a>
            </div><br /><br />

            <h2>
                <div class="body">
                    Paper Review Assignments
                </div>
            </h2>

            <#if paperName??>
                <ol>
                    Paper: <i>${paperName}</i> <br />
                    <ul>
                        Assigned PCMs: <br />
                        <#list PCM_list as pcm>
                            &nbsp;&nbsp;&nbsp;&nbsp; - ${pcm} <br />
                        </#list>
                    </ul>
                </ol>
            </#if>

        </div>
    </body>
</html>