package ra.bussiness;

import ra.bussinessImp.Catalog;

import java.util.List;
import java.util.Scanner;

public interface IShop {
    public static final float RATE = 1.3F;
    public void inputData(Scanner scanner, List<Catalog> list);
    public void displayData();
}
