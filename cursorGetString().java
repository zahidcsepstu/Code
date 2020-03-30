public String tableToString(SQLiteDatabase db, String tableName) {
    Log.d("","tableToString called");
    String tableString = String.format("Table %s:\n", tableName);
    Cursor allRows  = db.rawQuery("SELECT * FROM " + tableName, null);
    tableString += cursorToString(allRows);
    return tableString;
}

public String cursorToString(Cursor cursor){
    String cursorString = "";
    if (cursor.moveToFirst() ){
        String[] columnNames = cursor.getColumnNames();
        for (String name: columnNames) 
            cursorString += String.format("%s ][ ", name);
        cursorString += "\n";
        do {
            for (String name: columnNames) {
                cursorString += String.format("%s ][ ",
                        cursor.getString(cursor.getColumnIndex(name)));
            }
            cursorString += "\n";
        } while (cursor.moveToNext());
    }
    return cursorString;
}