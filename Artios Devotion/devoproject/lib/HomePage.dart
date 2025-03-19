class HomePage {
  int? Key;
  String? Date;
  String? Title;
  String? Verse;
  String? Reading;
  String? Internalize;
  HomePage();
  Map<String, dynamic> toJson() => {
        'Title': Title,
        'Verse': Verse,
        'Reading': Reading,
        'Internalize': Internalize,
        'Key': Key,
        'Date': Date,
      };
  HomePage.fromSnapshot(snapshot)
      : Title = snapshot.data()['Title'],
        Verse = snapshot.data()['Verse'].toString(),
        Reading = snapshot.data()['Reading'],
        Internalize = snapshot.data()['Internalize'].toString(),
        Key = snapshot.data()['Key'],
        Date = snapshot.data()['Date'];
}
