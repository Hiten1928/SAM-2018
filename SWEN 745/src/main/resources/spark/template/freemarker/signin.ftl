<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <title>${title} | SAM 2018</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/game.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

</head>
    <body>
        <div class="page">

            <h1> - Software Architecture Mining 2018 - </h1>

            <div class="navigation">
                <a href="/">Home Page</a>
                <a href="/signin">Sign In</a>
            </div>

            <h3> Welcome conference member! Enter your username below. </h3>

            <form action="/name" method="POST">
                <br/>
                Username: <input name="username" />
                <br/><br/>
                <button type="submit"> Sign In </button>
            </form>
        </div>


    </body>
</html>
