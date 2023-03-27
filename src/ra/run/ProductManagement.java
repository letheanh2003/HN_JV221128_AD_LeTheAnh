package ra.run;

import ra.bussinessImp.Catalog;
import ra.bussinessImp.Product;

import java.util.*;

public class ProductManagement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Catalog> listCatalog = new ArrayList<Catalog>();
        List<Product> listProduct = new ArrayList<Product>();

        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-2-MENU***************\n" +
                    "1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục \n" +
                    "2. Nhập số sản phẩm và nhập thông tin các sản phẩm \n" +
                    "3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator) \n" +
                    "4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm \n" +
                    "5. Thoát ");
            System.out.println("Nhập vào lựa chọn ");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    //Nhập Danh Muc
                    createCatalog(listCatalog, input);
                    break;
                case 2:
                    //nhập sản phẩm
                    createProduct(listProduct, input, listCatalog);
                    break;
                case 3:
                    // Sắp xếp theo giá sản phẩm tăng
                    sortByExportPrice(listProduct);
                    break;
                case 4:
                    //Tìm kiếm thoe tên danh mục
                    searchByCatalogName(listProduct, input);
                    break;
                case 5:
                    System.out.println("Thoát");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Nhập Sai Rồi");
                    break;
            }
        }
    }


    private static void createCatalog(List<Catalog> list, Scanner sc) {
        // Nhập số danh mục cần thêm mới
        System.out.println("Nhập số danh mục cần thêm mới: ");
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập danh mục thứ " + (i + 1));
            Catalog newCatalog = new Catalog();
            newCatalog.inputData(sc, list);
            if (list.size() == 0) {
                newCatalog.setCatalogId(1);
            } else {
                int newCatalogId = list.get(list.size() - 1).getCatalogId() + 1;
                newCatalog.setCatalogId(newCatalogId);
            }
            list.add(newCatalog);

        }
        System.out.println("Thêm Mới Danh Mục Thành Công !!!");
        displayCatalog(list);

    }

    private static void createProduct(List<Product> listProduct, Scanner sc, List<Catalog> listCatalog) {
        //Nhập số sản pẩm cần thêm mới
        System.out.println("Nhập số lượng sản phẩm cần thêm mới: ");
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập sản phẩm thứ " + (i + 1));
            Product newProduct = new Product();
            newProduct.inputData(sc, listCatalog);
            if (listProduct.size() == 0) {
                newProduct.setProductId(1);
            } else {
                newProduct.setProductId(listProduct.get(listProduct.size() - 1).getProductId() + 1);
            }
            listProduct.add(newProduct);

        }
        System.out.println("Thêm sản phẩm thành công");
        displayListProduct(listProduct);
    }

    private static void sortByExportPrice(List<Product> list) {
        Collections.sort(list);
        displayListProduct(list);
    }

    private static void searchByCatalogName(List<Product> list, Scanner scanner) {
        System.out.println("Nhập tên danh mục cần tìm kiếm ");
        String searchName = scanner.nextLine();
        List<Product> listSearch = new ArrayList<>();
        for (Product product : list) {
            if (product.getCatalog().getCatalogName().contains(searchName)) {
                listSearch.add(product);
            }
        }
        System.out.println("Danh sách cần tìm kiếm là: ");
        displayListProduct(listSearch);
    }

    public static void displayListProduct(List<Product> list) {
        for (Product product : list) {
            product.displayData();
        }
    }

    public static void displayCatalog(List<Catalog> list) {
        for (Catalog catalog : list) {
            catalog.displayData();
        }
    }
}