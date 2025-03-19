// ignore_for_file: import_of_legacy_library_into_null_safe

//import 'dart:html';
import 'dart:async';
import 'dart:io';
import 'package:devoproject/About.dart';
import 'package:devoproject/AboutPage.dart';
//import 'package:date_format/date_format.dart';
import 'package:devoproject/HomePage.dart';
import 'package:devoproject/SinglePage.dart';
//import 'package:devoproject/firebase_options.dart';
//import 'dart:html';
import 'package:flutter_local_notifications/flutter_local_notifications.dart';
import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:intl/intl.dart';
//import 'HomePage.dart';

//import 'package:firebase_core/firebase_core.dart';
//FirebaseFirestore firestore = FirebaseFirestore.instance;

class App extends StatefulWidget {
  createState() {
    //return AppState();
    return AppState(HomePage(), AboutPage(About()));
  }
}

class AppState extends State<App> {
  final AboutPage reader;
  //final DateTime someDateTime = DateTime(2017, 9, 7, 17, 30);
  String refdate = DateFormat.yMMMd('en_US').format(DateTime.now()).toString();
  String reftime = DateFormat.jms().format(DateTime.now()).toString();
  String reqtime = "10:40:00 PM";
  String reqdate = "Oct 2, 2022";
  late FlutterLocalNotificationsPlugin fltrNotification;
  final HomePage collection1;
  //AppState(this.collection1);
  AppState(this.collection1, this.reader);

  //AppState(this.reader);
  var duration = const Duration(seconds: 5);
  @override
  void initState() {
    super.initState();
    var androidInitialize = new AndroidInitializationSettings('ab');
    var iOSinitialize = new IOSInitializationSettings();
    var initializationsSettings = new InitializationSettings(
        android: androidInitialize, iOS: iOSinitialize);
    fltrNotification = new FlutterLocalNotificationsPlugin();
    fltrNotification.initialize(initializationsSettings,
        onSelectNotification: notificationSelected);
  }

  showNotifications() async {
    var androidDetails = new AndroidNotificationDetails(
        "Channel ID", "Desi programmer",
        importance: Importance.max);
    var IOSDetails = new IOSNotificationDetails();
    var generalNotificationDetails =
        new NotificationDetails(android: androidDetails, iOS: IOSDetails);

    await fltrNotification.show(0, "Artios Devotion",
        "Today's reading ${collection1.Title}", generalNotificationDetails);
  }

  List<Object> devolist = [];
  List<Object> aboutlist = [];
  //final controller = PageController(initialPage: 1);
  @override
  void didChangeDependencies() {
    super.didChangeDependencies();
    getdevotion();
  }

  Widget build(BuildContext context) {
    VoidCallback onClicked;

    return MaterialApp(
        debugShowCheckedModeBanner: false,
        home: Scaffold(
          appBar: AppBar(
            centerTitle: true,
            title: Text(
                '\u{12A0}\u{122D}\u{1275}\u{12EE}\u{1235} \u{12F2}\u{126E}\u{123D}\u{1295}'),
            actions: <Widget>[
              PopupMenuButton<String>(
                onSelected: handleClick,
                itemBuilder: (BuildContext context) {
                  return {
                    '\u{12A0}\u{130B}\u{122B}',
                    '\u{1235}\u{1208} \u{12F2}\u{126E}\u{123D}\u{1291}'
                  }.map((String choice) {
                    return PopupMenuItem<String>(
                      value: choice,
                      child: Text(choice),
                    );
                  }).toList();
                },
              ),
            ],
          ),
          body: /*PageView(
          controller: controller, 
          children: [
          Row(
              mainAxiildAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Container(
                    padding: const EdgeInsets.only(top: 18),
                    alignment: Alignment.topCenter,
                    child: new IconButton(
                        icon: const Icon(Icons.arrow_back),
                        onPressed: () => controller.previousPage(
                            duration: const Duration(seconds: 1),
                            curve: Curves.easeInOut))),
                //Spacer(),
                Container(
                    padding: const EdgeInsets.only(top: 25), child: (Text(''))),
                Container(
                  padding: const EdgeInsets.only(top: 18),
                  alignment: Alignment.topCenter,
                  child: new IconButton(
                      icon: const Icon(Icons.arrow_forward),
                      onPressed: () => controller.nextPage(
                          duration: const Duration(seconds: 1),
                          curve: Curves.easeInOut)),
                )
              ]),*/

              PageView(children: [
            //if (refdate == collection1.Date &&
            //  DateFormat.jms().format(DateTime.now()).toString() == reqtime)
            /* int itemCount1 = devolist.length;
                    if (refdate == {collection1.Date}) {
                      return SinglePage(devolist[index] as HomePage);
                    } else {
                      return Text("null");
                    }*/
            PageView.builder(
                scrollDirection: Axis.horizontal,
                itemCount: devolist.length,
                itemBuilder: (context, index) {
                  //final doc = snapshot.docs[index];
                  return SinglePage(devolist[index] as HomePage);
                }),
          ]),
          drawer: Drawer(
            child: ListView(
              padding: EdgeInsets.zero,
              children: [
                const DrawerHeader(
                  decoration: BoxDecoration(
                    color: Colors.blue,
                    /*image: DecorationImage(
                      image: AssetImage(""), fit: BoxFit.cover)*/
                  ),
                  child: Text(
                    '\u{120C}\u{120E}\u{127D} \u{12A0}\u{121B}\u{122B}\u{132E}\u{127D}',
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 24,
                    ),
                  ),
                ),
                ListTile(
                  title: const Text('ተወዳጅ'),
                  onTap: () {
                    // Update the state of the app.
                    // ...
                  },
                ),
                ListTile(
                  title: const Text('መርሀ ግብር'),
                  onTap: () {
                    // Update the state of the app.
                    // ...
                  },
                ),
                ListTile(
                  title: const Text('Settings'),
                  onTap: () {
                    showNotifications();
                    // Update the state of the app.
                    // ...
                  },
                ),
                ListTile(
                  title: const Text(
                      '\u{1235}\u{1208} \u{12F2}\u{126E}\u{123D}\u{1291}'),
                  onTap: () {
                    /*PageView.builder(
                        scrollDirection: Axis.horizontal,
                        itemCount: devolist.length,
                        itemBuilder: (context, index) {
                          //final doc = snapshot.docs[index];
                          return AboutPage(aboutlist as About);
                        });*/
                    Navigator.push(
                        context,
                        MaterialPageRoute(
                            builder: (context) => AboutPage(About())));

                    // Update the state of the app.
                    // ...
                  },
                ),
              ],
            ),
          ),
        ));
    //);
  }
//Future notificationSelected(String payload) async {

  Future notificationSelected(String? payload) async {
    showDialog(
      context: context,
      builder: (context) =>
          AlertDialog(content: Text("Notification clicked $payload ")),
    );
  }

  Future getdevotion() async {
    var data = await FirebaseFirestore.instance
        .collection("HomePage")
        .orderBy("Key", descending: false)
        .get();
    setState(() {
      devolist = List.from(data.docs.map((doc) => HomePage.fromSnapshot(doc)));
    });
  }

  Future getabot() async {
    var data = await FirebaseFirestore.instance.collection("About").get();
    setState(() {
      aboutlist = List.from(data.docs.map((doc) => About.fromSnapshot(doc)));
    });
  }

  void handleClick(String value) {
    switch (value) {
      case 'share':
        break;
      case 'help':
        break;
    }
  }
}
