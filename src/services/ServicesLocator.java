package services;
import utiles.DataBaseConnection;
import java.sql.SQLException;

public class ServicesLocator {
    public static ContractService contractQ = null;
    public static DailyActivityService dailyActivityService = null;
    public static HotelRoomSeasonService hotel_room_season_service = null;
    public static Hotel_Service hotelQ = null;
    public static KmCostService km_costService = null;
    public static Km_Hours_Cost_Service km_hours_cost_service = null;
    public static MealPlanService meal_planService = null;
    public static PackageService packageService = null;
    public static RoleService roleService = null;
    public static RoomService roomService = null;
    public static RouteService routeService = null;
    public static SeasonService seasonService = null;
    public static TransportationModelService transportation_model_service = null;
    public static TransportationService transportationService = null;
    public static UserService userService = null;
    public static VehicleService vehicleService = null;

    public static java.sql.Connection getConnection() {
        DataBaseConnection connection = null;
        try {
            connection = new DataBaseConnection("localhost", "conozco_cuba" , "postgres", "jmspg2023");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection.getConnection();
    }

    public static ContractService getContractQ() {
        if (contractQ == null) {
            contractQ = new ContractService();
        }
        return contractQ;
    }

    public static Hotel_Service getHotelQ() {
        if (hotelQ == null) {
            hotelQ = new Hotel_Service();
        }
        return hotelQ;
    }


    public static DailyActivityService getDailyActivityService() {
        if (dailyActivityService == null) {
            dailyActivityService = new DailyActivityService();
        }
        return dailyActivityService;
    }

    public static HotelRoomSeasonService getHotel_room_season_service() {
        if (hotel_room_season_service == null) {
            hotel_room_season_service = new HotelRoomSeasonService();
        }
        return hotel_room_season_service;
    }

    public static KmCostService getKm_costService() {
        if (km_costService == null) {
            km_costService = new KmCostService();
        }
        return km_costService;
    }

    public static Km_Hours_Cost_Service getKm_hours_cost_service() {
        if (km_hours_cost_service == null) {
            km_hours_cost_service = new Km_Hours_Cost_Service();
        }
        return km_hours_cost_service;
    }

    public static MealPlanService getMeal_planService() {
        if (meal_planService == null) {
            meal_planService = new MealPlanService();
        }
        return meal_planService;
    }

    public static PackageService getPackageService() {
        if (packageService == null) {
            packageService = new PackageService();
        }
        return packageService;
    }

    public static RoomService getRoomService() {
        if (roomService == null) {
            roomService = new RoomService();
        }
        return roomService;
    }

    public static RouteService getRouteService() {
        if (routeService == null) {
            routeService = new RouteService();
        }
        return routeService;
    }

    public static SeasonService getSeasonService() {
        if (seasonService == null) {
            seasonService = new SeasonService();
        }
        return seasonService;
    }

    public static TransportationModelService getTransportation_model_service() {
        if (transportation_model_service == null) {
            transportation_model_service = new TransportationModelService();
        }
        return transportation_model_service;
    }

    public static TransportationService getTransportationService() {
        if (transportationService == null) {
            transportationService = new TransportationService();
        }
        return transportationService;
    }

    public static VehicleService getVehicleService() {
        if (vehicleService == null) {
            vehicleService = new VehicleService();
        }
        return vehicleService;
    }

    public static UserService getUserService(){
        if(userService == null){
            userService= new UserService();
        }
        return userService;
    }
    public static RoleService getRoleService(){
        if(roleService == null){
            roleService = new RoleService();
        }
        return roleService;
    }
}
