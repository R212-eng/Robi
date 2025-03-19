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
  <body class="body">
  <div id="home" class="home">
    <div class="topdiv">
      <img class="logo" src="download.jpeg" alt="logo image" />
      <nav class="Nav1">  
          <div id="navbar" class="Nav">
            <a class="anchor" href="home.php" style="color: whitesmoke"><input type="submit" value="Home" class="inputdecor"></a>
            <a class="anchor" href="about.php" style="color: whitesmoke"><input type="submit" value="About Us" class="inputdecor"></a>
            <a class="anchor" href="recent_events.php" style="color: whitesmoke"><input type="submit" value="Events" class="inputdecor"/></a>
            <a class="anchor" href="after_login.php" style="color: whitesmoke"><input type="submit" value="Account" class="inputdecor"></a>
      </div>
      </nav>
    </div>
  </div>
  <div> 
    <div>
    <div style="text-align:center; padding:15%;">
      <p  style="font-size:50px; font-weight:bold;">
       <h1>Hello  
       <?php
        session_start();       
        include("connect.php");
        if(isset($_SESSION['email'])){
          $email=$_SESSION['email'];
          $query=mysqli_query($conn, "SELECT * FROM Users WHERE Email='$email'");
          $row=mysqli_fetch_array($query);
          print_r($row['First_Name']);
          // while($row=mysqli_fetch_array($query)){
          //     echo $row['fname'].' '.$row['lname'];
          // }
         }
       ?>
       </h1>
       <br> 
    <h2>  We're thrilled to have you join our school community. As a new member, you now have access to a range of features and updates designed to enhance your educational experience.
<br>
Take some time to explore our resources, including the library of study materials, tutorials, and guides that will support your learning journey. Stay informed with the latest school news and updates in our announcements section, where you'll find important information about upcoming events, deadlines, and activities.
<br>
We understand that starting at a new school can be both exciting and challenging, so don't hesitate to reach out if you need any assistance. Our dedicated support team, including teachers and staff, is here to help you navigate your new environment, answer your questions, and provide the support you need to succeed.
<br>
We’re committed to making your experience here enriching and enjoyable. Dive in, connect with your peers, and take advantage of all the opportunities available to you. Welcome to our school community!
      </p>
<p>For more join us on: 
  <br><br>
  <div>
                    <a href="https://www.youtube.com/@ECE20894" class="iocnlink"><i class="fa fa-youtube icons" aria-hidden="true"></i></a> 
                    <a href="https://www.facebook.com/BeteSebAcademy/" class="iocnlink"><i class="fa fa-facebook icons" aria-hidden="true"></i></a>
                     <i class="fa fa-telegram icons" aria-hidden="true"></i>
                     <a href="https://et.linkedin.com/company/beteseb-academy"class="iocnlink"><i class="fa fa-linkedin icons" aria-hidden="true"></i></a>
                </div></h2>
  <br><br><br><br><br><br>
      <a href="logout.php">Logout</a>
    </div>
          <br><br><br><br><br><br>
        <footer class="fotterset3">
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
        </body>
             </html>