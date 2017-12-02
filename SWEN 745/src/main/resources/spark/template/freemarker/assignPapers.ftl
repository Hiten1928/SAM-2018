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
                <a href="/assignPapers">Assign Papers</a> -
                <a href="/reviewedPapers">Reviewed Papers</a> -
                <a href="/">Sign Out</a>
            </div><br /><br />

            <h2>
                <div class="body">
                    Assign Papers
                </div>
            </h2>

            <#if papersSubmitted??>
                <br />
                Assign Papers:
                <br />
                <ol>
                    <#list papersSubmitted as n>
                        <div>
                            <input name="papers" value="${n}" type="radio" > ${n} </input>

                            <div class="author details">
                                <br />
                                *CTRL+C to select multiple authors* <br />

                                <select multiple>
                                    <option value="a">Author Name</option>
                                    <option value="b">Author Name</option>
                                    <option value="c">Author Name</option>
                                </select>
                            </div>
                        </div>
                    </#list>
                </ol>
            </#if>
        </div>
    </body>
</html>

