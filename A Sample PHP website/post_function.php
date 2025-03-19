<?php

include 'connect.php';
if(isset($_POST['signUp'])){
    $firstName=$_POST['fname'];
    $lastName=$_POST['lname'];
    $email=$_POST['email'];
    $password=$_POST['password'];
    $password=md5($password);

     $checkEmail="SELECT * From Users where Email='$email'";
     $result=$conn->query($checkEmail);
     if($result->num_rows>0){
        echo "Email Address Already Exists !";
     }
     else{
        $insertQuery="INSERT INTO Users(First_Name,Last_Name,Email,Password) 
             VALUES ('$firstName','$lastName','$email','$password')";
         // VALUES ('".$_POST['fname']."','".$_POST['lname']."','".$_POST['email']."','".$_POST['password']."')";
        
            if($conn->query($insertQuery)===TRUE){
                // header("location: Login.php");
                // print_r("data inserted");
                header('Location: after_login.php');
            }
            else{
                echo "Error:".$conn->error;
            }
     }
}

if(isset($_POST['signIn'])){
   $email=$_POST['email'];
   $password=$_POST['password'];
   $password=md5($password);
   $sql="SELECT * FROM Users WHERE Email='$email' and Password='$password'";
   $result=$conn->query($sql);
   if($result->num_rows>0){
    session_start();
    $row=$result->fetch_assoc();
    $_SESSION['email']=$row['Email'];
    header('Location: after_login.php');
    exit();
   }
   else{
    echo "Not Found, Incorrect email or password";
   }

}
?>