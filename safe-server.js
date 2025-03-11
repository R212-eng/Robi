const express= require("express");
const app= express();
const bodyParser= require ("body-parser");
const https= require("https");
const { request } = require("http");
const { dirname } = require("path");
const mongoose = require("mongoose");
const { exit } = require("process");
// var mongo = require('mongodb');

//mongodb connect using mongoose
mongoose.set('strictQuery', true);
mongoose.connect('mongodb://127.0.0.1:27017/safeDB', {useNewUrlParser: true});
const contactSchema = new mongoose.Schema(
      { fName: String,
        email: String,
        phone: Number,
        message: String  
      }
      );
const donorSchema = new mongoose.Schema(
    { fullName: String,
      Email: String,
      PhoneNum: Number,
      payDeadline: String,
      donAmount: Number,
      donCurrency: String,
      donPurpose: String  
    }
    );
    const donorModel= mongoose.model("Donor", donorSchema);
    const contactModel= mongoose.model("Contacts", contactSchema);
//
app.use(bodyParser.urlencoded({extended:true}));
app.listen(3000, function () {
    console.log("Server running on port 3000")
} )
console.log(__dirname);

app.use(express.static(__dirname));
app.use(express.static("public"));

app.get("/Donate", function (req,res){

    res.sendFile(__dirname + "/Donate.html");
    });
app.get("/Subscribe", function (req,res){
    res.sendFile(__dirname + "/Subscribe.html");
    });

app.post("/Saved", function (req,res) {
        var name= req.body.name;
        var email= req.body.email;
        var phone= req.body.phone;
        var Message= req.body.message;
    
        if (name=="" || email=="" || phone=="" || Message=="")
        {
            console.log("Please enter all required fields.");
        }
    else{ 
     const contact = new contactModel ({
        fName: name,
        email: email,
        phone: phone,
        message: Message    
    });
    if(contact.save()){
        res.sendFile(__dirname + "/consuccess.html" );
    }
}});

app.post("/Registered", function (req,res) {
    var name= req.body.name;
    var email= req.body.email;
    var phone= req.body.phone;
    var date= req.body.date;
    var amount= req.body.amount;
    var currency= req.body.currency;
    var purpose= req.body.purpose;

    if (name=="" || email=="" || phone=="" || date=="" || amount=="" || currency=="" || purpose=="")
    {
        console.log("Please enter all required fields.");
    }
else{
 const donor = new donorModel ({
   fullName: name,
   Email: email,
   PhoneNum: phone,
   payDeadline: date,
   donAmount: amount,
   donCurrency: currency,
   donPurpose: purpose   
});
// console.log(name, email, phone, date, amount, currency, purpose);
if(donor.save()){
    res.sendFile(__dirname + "/donsuccess.html" ); 
}
else{
res.sendFile(__dirname + "/donfailure.html" ); 
    }}
});

app.post("/Subscribed", function (req,res) {
    var name= req.body.name;
    var email= req.body.email;
    if (name=="" || email=="")
    {
        res.sendFile(__dirname + "/failure.html" ); 
    }
else{
    var data= {
        members: [
            {
            email_address: email,
            status: "subscribed",
            FNAME: name,
            }
        ]
        }

   const jsonData= JSON.stringify(data);

const url= "https://us21.api.mailchimp.com/3.0/lists/15b9b76ff3";
const options = {
    method: "POST",
    auth: 'Robi:a5db9bbf61b3d10a2f58db4644312236-us21',
    update_existing: 'true'
}
// const checks={
//     method: "GET",
//     auth: 'Robi:a5db9bbf61b3d10a2f58db4644312236-us21'
// }

  const request = https.request(url, options, function(response){
    console.log(response.statusCode);
    if (response.statusCode==200) {
        
     res.sendFile(__dirname + "/success.html" );   
       }
        else {  
            res.sendFile(__dirname + "/failure.html" ); 
        }
  response.on("data", function (data){
console.log(JSON.parse(data))
  })

  })

 request.write(jsonData);
 request.end(); 
}
// console.log("Mr/Ms " + name + " with email of " + email + " successfully subscribed" )
});


app.post("/", function (req,res){
    res.redirect("/");
    // res.sendFile(__dirname + "/Subscribe.html")
});
// API a5db9bbf61b3d10a2f58db4644312236-us21 
//Audience ID : 15b9b76ff3