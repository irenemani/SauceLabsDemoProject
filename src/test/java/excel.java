import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class excel{
    public static void main(String[] args) {
        try {
            FileInputStream fp = new FileInputStream("C:\\Users\\IRENE\\Desktop\\IRENE\\DataFile.xlsx");
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fp);
            XSSFSheet sheet = xssfWorkbook.getSheetAt(1);

            Map<String, String> map = new HashMap<>();

            for (int i = 1; i <4; i++) {
                String userId = null;
                String password=null;
                for (int j = 1; j < 3; j++) {
                    Row row = sheet.getRow(i);
                   Cell cell = row.getCell(j);
                    if (j == 1) {
                        userId = cell.getStringCellValue();
                    } else {
                        password = cell.getStringCellValue();
                    }
                    map.put(userId, password);
                }
            }
            for ( String i: map.keySet()){
                System.out.println(i+" "+map.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

