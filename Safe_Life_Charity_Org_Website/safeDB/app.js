const mongoose = require('mongoose');
mongoose.set('strictQuery', true);
mongoose.connect('mongodb://127.0.0.1:27017/safeDB', {useNewUrlParser: true});


const donorSchema = new mongoose.Schema(
    { fName: String,
      email: String,
      PhoneNum: Number,
      payDeadline: Date,
      amount: Number,
      currency: String,
      purpose: String  
    }
    );
const contactSchema = new mongoose.Schema(
      { fName: String,
        email: String,
        phone: Number,
        message: String  
      }
      );
const contactModel= mongoose.model("Contacts", contactSchema);
const donorModel= mongoose.model("Donor", donorSchema);

// const donor = new donorModel ({
//     fName: fName,
//     email:email,
//     payDeadline: "10/02/2023",
//     amount: 200,
//     currency: "birr",
//     purpose: "charity event"   
// })

// donor.save();

console.log("connected to mongodb.")