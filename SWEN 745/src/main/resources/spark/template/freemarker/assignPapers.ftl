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
                            <form method="POST" action="/postAssignPapers">
                                <input name="paper" value="${n}" type="radio"> ${n} </input>
                                <div class="author details">
                                    <br />
                                    *Hold down CTRL or CMD to select multiple authors* <br />
                                        <select name="assignedAuthor">
                                            <#list samCenter.getPCMUsernameList() as entry>
                                                <option value="${entry.getPCMName()}"> ${entry.getPCMName()} </option>
                                            </#list>
                                        </select>
                                    <input type="submit" value="Submit">
                                </div> <!-- end of author div -->
                            </form> <!-- end of selection form -->
                        </div> <!-- end of blank div -->
                    </#list> <!-- end of papers list -->
                </ol>
            </#if> <!-- end of if papers exist -->
        </div> <!-- end of div page -->
    </body>
</html>

