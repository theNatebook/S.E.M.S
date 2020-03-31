package com.example.sems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/*import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;*/

/*import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;*/

public class TempReadings extends AppCompatActivity implements SetValue.setValueListener {

    private Button room1temp, room2temp, room3temp;
    private TextView curr1temp, curr2temp, curr3temp;

    private String TAG = "TempReadings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_readings);

        //readExcelData();

        Button room1temp = (Button) findViewById(R.id.room1T);
        Button room2temp = (Button) findViewById(R.id.room2T);
        Button room3temp = (Button) findViewById(R.id.room3T);

        TextView curr1temp = (TextView) findViewById(R.id.room1temp);
        TextView curr2temp = (TextView) findViewById(R.id.room2temp);
        TextView curr3temp = (TextView) findViewById(R.id.room3temp);

        room1temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
        room2temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        room3temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    public void openDialog(){
        SetValue setValue = new SetValue();
        setValue.show(getSupportFragmentManager(),"Set New Value");
    }

    @Override
    public void applyText(String value) {
        Toast myToast = Toast.makeText(getApplicationContext(), "new value is set to " + value + "°C", Toast.LENGTH_SHORT);
        myToast.show();
    }



    /*private void readData(){
        InputStream is = getResources().openRawResource(R.raw.temp_inputs);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line = "";
        try{
            while ((line = reader.readLine()) !=null){
                String [] tokens = line.split(",");
                TemperatureData data = new TemperatureData();
                data.setRoom1data(tokens[0]);
                data.setRoom2data(tokens[1]);
                data.setRoom3data(tokens[2]);
                tempData.add(data);

                curr1temp.setText("Room 1: " + data );

                Log.d("MyActivity", "Just created: " + data);
            }
        } catch (IOException e){
            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
        }
    }*/

    //ArrayList<TemperatureData> data;

    /*private void readExcelData() {
        Log.d("TempReadings", "readExcelData: Reading Excel File.");

        try {
            InputStream inputStream = getResources().openRawResource(R.raw.rawtemp);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowsCount = sheet.getPhysicalNumberOfRows();
            FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
            StringBuilder sb = new StringBuilder();

            //outter loop, loops through rows
            for (int r = 1; r < rowsCount; r++) {
                Row row = sheet.getRow(r);
                int cellsCount = row.getPhysicalNumberOfCells();
                //inner loop, loops through columns
                for (int c = 0; c < cellsCount; c++) {
                    //handles if there are to many columns on the excel sheet.
                    if(c>3){
                        Log.e("TempReadings", "readExcelData: ERROR. Excel File Format is incorrect! " );
                        //toastMessage("ERROR: Excel File Format is incorrect!");
                        break;
                    }else{
                        String value = getCellAsString(row, c, formulaEvaluator);
                        String cellInfo = "r:" + r + "; c:" + c + "; v:" + value;
                        Log.d("TempReading", "readExcelData: Data from row: " + cellInfo);
                        sb.append(value + ", ");
                    }
                }
                sb.append(":");
            }
            Log.d("TempReadings", "readExcelData: STRINGBUILDER: " + sb.toString());

            parseStringBuilder(sb);

        }catch (FileNotFoundException e) {
            Log.e("TempReading", "readExcelData: FileNotFoundException. " + e.getMessage() );
        } catch (IOException e) {
            Log.e("TempReading", "readExcelData: Error reading inputstream. " + e.getMessage() );
        }
    }*/

    /*public void parseStringBuilder(StringBuilder mStringBuilder){
        Log.d(TAG, "parseStringBuilder: Started parsing.");

        // splits the sb into rows.
        String[] rows = mStringBuilder.toString().split(":");

        //Add to the ArrayList<XYValue> row by row
        for(int i=0; i<rows.length; i++) {
            //Split the columns of the rows
            String[] columns = rows[i].split(",");

            //use try catch to make sure there are no "" that try to parse into doubles.
            try{
                double room1 = Double.parseDouble(columns[0]);
                double room2 = Double.parseDouble(columns[1]);
                double room3 = Double.parseDouble(columns[2]);

                String cellInfo = "values are: (" + room1 + "," + room2 + "," + room3 + ")";
                Log.d(TAG, "ParseStringBuilder: Data from row: " + cellInfo);

                //add the the uploadData ArrayList
                data.add(new TemperatureData( room1, room2, room3));

            }catch (NumberFormatException e){

                Log.e(TAG, "parseStringBuilder: NumberFormatException: " + e.getMessage());

            }
        }

        printDataToLog();
    }*/

    /*private void printDataToLog() {
        Log.d(TAG, "printDataToLog: Printing data to log...");

        for(int i = 0; i< data.size(); i++){
            double room1temp = data.get(i).getRoom1temp();
            double room2temp = data.get(i).getRoom2temp();
            double room3temp = data.get(i).getRoom3temp();
            Log.d(TAG, "printDataToLog: (x,y): (" + room1temp + ","
                    + room2temp + "," + room3temp + ")");
        }
    }*/
    /*private String getCellAsString(Row row, int c, FormulaEvaluator formulaEvaluator) {
        String value = "";
        try {
            Cell cell = row.getCell(c);
            CellValue cellValue = formulaEvaluator.evaluate(cell);
            switch (cellValue.getCellType()) {
                case Cell.CELL_TYPE_BOOLEAN:
                    value = ""+cellValue.getBooleanValue();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    double numericValue = cellValue.getNumberValue();
                        value = ""+numericValue;
                    break;
                case Cell.CELL_TYPE_STRING:
                    value = ""+cellValue.getStringValue();
                    break;
                default:
            }
        } catch (NullPointerException e) {

            Log.e(TAG, "getCellAsString: NullPointerException: " + e.getMessage() );
        }
        return value;
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }*/

}
