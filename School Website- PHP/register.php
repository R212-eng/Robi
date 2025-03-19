<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="ALL.css" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <link rel="icon" href="download.jpeg"  />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <title>Register
    </title>
    <div class="body">
    </div>
  </head>
  <body>
    <div id="home" class="home">
      <div class="topdiv">
        <img class="logo" src="download.jpeg" alt="logo image" />
        <nav class="Nav1">  
          <div id="navbar" class="Nav">
            <a class="anchor" href="home.php" style="color: whitesmoke"><input type="submit" value="Home" class="inputdecor"></a>
            <a class="anchor" href="about.php" style="color: whitesmoke"><input type="submit" value="About Us" class="inputdecor"></a>
            <a class="anchor" href="recent_events.php" style="color: whitesmoke"><input type="submit" value="Events" class="inputdecor"/></a>
            <a class="anchor" href="login.php" style="color: whitesmoke"><input type="submit" value="Login" class="inputdecor"></a>
      </div>
      </nav>
      </div>
    </div>
    <link rel="stylesheet" href="login.css"/>
    <br><br><br>
    <fieldset class="containor">
        <form class="insidec" action="post_function.php" method="post">
          <h1 class="welcomeGg">Register form</h1>
          <br>
          <div class="formset">
        <label for="fname">First name</label>   
        <input type="text" placeholder="First name" name="fname" id="fname" required/>
       </div>
       <div class="formset">
       <label for="lname">Last name</label>                  
        <input type="text" placeholder="Last name" name="lname" id="lname" required/>
       </div>
       <div class="formset">
     <label for="email">Email</label>
     <input type="email" placeholder="@gmail.com" name="email" id="email" required/>
      </div>
      <div class="formset">
     <label for="password">Password</label>  
     <input type="password" name="password" id="password" placeholder="password" required/>
      </div>
      <br>
      <div class="formset">
        <input type="submit" name="signUp" id="signUp" class="submitset" value="Sign Up"/>  Already have account?<a class="linkdecor" href="login.php">Signin</a>
      </div>
      </form>
    </fieldset>
  </div>
  <footer class="fotterset">
    <div class="footer-cls p-3">
      <label class="contacti">Contact us:_</label>
              <a href="https://www.youtube.com/@ECE20894" class="iocnlink"><i class="fa fa-youtube icons" aria-hidden="true"></i></a> 
              <a href="https://www.facebook.com/BeteSebAcademy/" class="iocnlink"><i class="fa fa-facebook icons" aria-hidden="true"></i></a>
               <i class="fa fa-telegram icons" aria-hidden="true"></i>
               <a href="https://et.linkedin.com/company/beteseb-academy"class="iocnlink"><i class="fa fa-linkedin icons" aria-hidden="true"></i></a>
          </div>
    <!-- Copyright -->
    <div class="text-center text-black">
      © 2024 Copyright
    </div>
    <!-- Copyright -->
  </footer>
  <script src="backenf.js"></script>
  </body>
       </html>

