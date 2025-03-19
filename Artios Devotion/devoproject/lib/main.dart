//import 'dart:io';
//import 'package:flutter/foundation.dart';
import 'package:flutter/widgets.dart';
import 'package:flutter/material.dart';
import 'package:devoproject/app.dart';
import 'package:firebase_core/firebase_core.dart';

void main() async{ 
WidgetsFlutterBinding.ensureInitialized();
await Firebase.initializeApp();
runApp(App());
} 
