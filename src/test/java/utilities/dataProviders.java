package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class dataProviders {

    String path = "C:\\Users\\INE12400939\\Downloads\\git clone\\OpenCartV121\\testdata\\LoginData.xlsx";


    @DataProvider(name = "dp1")
    public Object[][] getData() throws IOException {

        excelUtility eutil = new excelUtility();
        int getTotalrows = eutil.getTotalRows(this.path,"Sheet1");
        int getTotalCols = eutil.getTotalCols(this.path,"Sheet1",1);

        String getDataArray[][] = new String[getTotalrows][getTotalCols];

        for(int i= 1;i<=getTotalrows;i++){
            for(int j=0;j<getTotalCols;j++)
            {
               getDataArray[i-1][j]= eutil.getCellData(this.path,"Sheet1",i,j);
            }
        }
        return getDataArray;




    }
}
