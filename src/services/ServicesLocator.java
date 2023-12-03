package services;

import conection.DataBaseConnection;

import java.sql.SQLException;

public class ServicesLocator {
    public static ContractService contractQ = null;
    public static HotelService hotelQ = null;
    public static BusinessModelService businessModelQ = null;
    public static DailyActivityService dailyActivityService = null;
    public static Hotel_Room_Season_Service hotel_room_season_service = null;
    public static Km_CostService km_costService = null;
    public static Km_Hours_Cost_Service km_hours_cost_service = null;
    public static Meal_PlanService meal_planService = null;
    public static PackageService packageService = null;
    public static RoomService roomService = null;
    public static RouteService routeService = null;
    public static SeasonService seasonService = null;
    public static Transportation_Model_Service transportation_model_service = null;
    public static TransportationService transportationService = null;
    public static VehicleService vehicleService = null;

    public static java.sql.Connection getConnection() {
        DataBaseConnection connection = null;
        try {
            connection = new DataBaseConnection("localhost", "proyecto_bd_cnozco_cuba", "postgres", "R@gn@r");
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

    public static HotelService getHotelQ() {
        if (hotelQ == null) {
            hotelQ = new HotelService();
        }
        return hotelQ;
    }

    public static BusinessModelService getBusinessModelQ() {
        if (businessModelQ == null) {
            businessModelQ = new BusinessModelService();
        }
        return businessModelQ;
    }

    public static DailyActivityService getDailyActivityService() {
        if (dailyActivityService == null) {
            dailyActivityService = new DailyActivityService();
        }
        return dailyActivityService;
    }

    public static Hotel_Room_Season_Service getHotel_room_season_service() {
        if (hotel_room_season_service == null) {
            hotel_room_season_service = new Hotel_Room_Season_Service();
        }
        return hotel_room_season_service;
    }

    public static Km_CostService getKm_costService() {
        if (km_costService == null) {
            km_costService = new Km_CostService();
        }
        return km_costService;
    }

    public static Km_Hours_Cost_Service getKm_hours_cost_service() {
        if (km_hours_cost_service == null) {
            km_hours_cost_service = new Km_Hours_Cost_Service();
        }
        return km_hours_cost_service;
    }

    public static Meal_PlanService getMeal_planService() {
        if (meal_planService == null) {
            meal_planService = new Meal_PlanService();
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

    public static Transportation_Model_Service getTransportation_model_service() {
        if (transportation_model_service == null) {
            transportation_model_service = new Transportation_Model_Service();
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
}
