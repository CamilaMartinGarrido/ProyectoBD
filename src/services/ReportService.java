package services;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.util.HashMap;

public class ReportService {
    public static ReportService reports = new ReportService();
    private java.sql.Connection myConnection = null;

    public ReportService() {
        super();
        this.myConnection = ServicesLocator.getConnection();
    }

    public void loadReport1(){
        try {
            JasperPrint print = JasperFillManager.fillReport("src/reports/Report_1_list_of_hotels_contract.jasper", null, myConnection);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
        } catch (JRException e2) {
            e2.printStackTrace();
        }
    }

    public void loadReport2(){
        try {
            JasperPrint print = JasperFillManager.fillReport("src/reports/Report_2_list_of_hotel_season_contracts.jasper", null, myConnection);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
        } catch (JRException e2) {
            e2.printStackTrace();
        }
    }

    public void loadReport3(){
        try {
            JasperPrint print = JasperFillManager.fillReport("src/reports/Report_3_list_of_transportation_contracts.jasper", null, myConnection);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
        } catch (JRException e2) {
            e2.printStackTrace();
        }
    }

    public void loadReport4(){
        try {
            JasperPrint print = JasperFillManager.fillReport("src/reports/Report_4_list_of_services_contract.jasper", null, myConnection);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
        } catch (JRException e2) {
            e2.printStackTrace();
        }
    }
   public void loadReport5(String chain_h, String province_h){
        HashMap<Object, String> myParameters = new HashMap<Object,String>();
        myParameters.put("chain_h", chain_h);
        myParameters.put("province_h", province_h);
       //JasperPrint print = JasperFillManager.fillReport("src/reports/Report_5_list_of_active_hotels.jasper", myParameters, myConnection);
       //JasperViewer view = new JasperViewer(print, false);
       //view.setVisible(true);
   }

    public void loadReport6(){
        try {
            JasperPrint print = JasperFillManager.fillReport("src/reports/Report_6_list_of_package_itinerary.jasper", null, myConnection);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
        } catch (JRException e2) {
            e2.printStackTrace();
        }
    }

    public void loadReport7(){
        try {
            JasperPrint print = JasperFillManager.fillReport("src/reports/Report_7_list_of_packages_sales_income_plan.jasper", null, myConnection);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
        } catch (JRException e2) {
            e2.printStackTrace();
        }
    }

    public void loadReport8(){
        try {
            JasperPrint print = JasperFillManager.fillReport("src/reports/Report_8_list_of_inactive_hotels.jasper", null, myConnection);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
        } catch (JRException e2) {
            e2.printStackTrace();
        }
    }


}
