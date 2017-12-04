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
                <a href="/admin">Home Page</a> -
                <a href="/manageAccounts">Manage Accounts</a> -
                <a href="/manageDeadlines">Manage Deadlines</a> -
                <a href="/manageTemplates">Manage Templates</a> -
                <a href="/manageNotifications">Manage Notifications</a> -
                <a href="/">Sign Out</a>
            </div><br /><br />

            <h2>
                <div class="body">
                    Manage Accounts
                </div>
            </h2>

            Author Usernames:
            <#if authors??>
                <#list authors as a>
                    <ul>
                        <li>${a}</li>
                    </ul>
                </#list>
            </#if>

            PCM Usernames:
            <#if pcms??>
                <#list pcms as pcm>
                    <ul>
                        <li>${pcm}</li>
                    </ul>
                </#list>
            </#if>

            PCC Username:
            <#if pcc??>
                <#list pcc as pcc>
                    <ul>
                        <li>${pcc}</li>
                    </ul>
                </#list>
            </#if>

        </div>
    </body>
</html>