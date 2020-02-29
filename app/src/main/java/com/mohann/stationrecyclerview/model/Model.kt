package com.mohann.stationrecyclerview.model

import com.google.gson.annotations.SerializedName

data class BD(
    val total: Int
)

data class CNG(
    val total: Int
)

data class E85(
    val total: Int
)

data class ELEC(
    val stations: Stations,
    val total: Int
)

data class EvNetworkIds(
    val ports: List<String>,
    val posts: List<String>
)

data class Fuels(
    @SerializedName("BD")
    val bD: BD,
    @SerializedName("CNG")
    val cNG: CNG,
    @SerializedName("E85")
    val e85: E85,
    @SerializedName("ELEC")
    val eLEC: ELEC,
    @SerializedName("HY")
    val hY: HY,
    @SerializedName("LNG")
    val lNG: LNG,
    @SerializedName("LPG")
    val lPG: LPG
)

data class FuelStation(
    @SerializedName("access_code")
    val accessCode: String,
    @SerializedName("access_days_time")
    val accessDaysTime: String,
    @SerializedName("access_days_time_fr")
    val accessDaysTimeFr: Any,
    @SerializedName("access_detail_code")
    val accessDetailCode: String,
    @SerializedName("bd_blends")
    val bdBlends: Any,
    @SerializedName("bd_blends_fr")
    val bdBlendsFr: Any,
    @SerializedName("cards_accepted")
    val cardsAccepted: String,
    val city: String,
    @SerializedName("cng_dispenser_num")
    val cngDispenserNum: Any,
    @SerializedName("cng_fill_type_code")
    val cngFillTypeCode: Any,
    @SerializedName("cng_psi")
    val cngPsi: Any,
    @SerializedName("cng_renewable_source")
    val cngRenewableSource: Any,
    @SerializedName("cng_total_compression")
    val cngTotalCompression: Any,
    @SerializedName("cng_total_storage")
    val cngTotalStorage: Any,
    @SerializedName("cng_vehicle_class")
    val cngVehicleClass: Any,
    val country: String,
    @SerializedName("date_last_confirmed")
    val dateLastConfirmed: String,
    @SerializedName("e85_blender_pump")
    val e85BlenderPump: Any,
    @SerializedName("e85_other_ethanol_blends")
    val e85OtherEthanolBlends: Any,
    @SerializedName("ev_connector_types")
    val evConnectorTypes: List<String>,
    @SerializedName("ev_dc_fast_num")
    val evDcFastNum: Any,
    @SerializedName("ev_level1_evse_num")
    val evLevel1EvseNum: Int,
    @SerializedName("ev_level2_evse_num")
    val evLevel2EvseNum: Int,
    @SerializedName("ev_network")
    val evNetwork: String,
    @SerializedName("ev_network_ids")
    val evNetworkIds: EvNetworkIds,
    @SerializedName("ev_network_web")
    val evNetworkWeb: String,
    @SerializedName("ev_other_evse")
    val evOtherEvse: String,
    @SerializedName("ev_pricing")
    val evPricing: String,
    @SerializedName("ev_pricing_fr")
    val evPricingFr: Any,
    @SerializedName("ev_renewable_source")
    val evRenewableSource: Any,
    @SerializedName("expected_date")
    val expectedDate: Any,
    @SerializedName("facility_type")
    val facilityType: String,
    @SerializedName("fuel_type_code")
    val fuelTypeCode: String,
    @SerializedName("geocode_status")
    val geocodeStatus: String,
    @SerializedName("groups_with_access_code")
    val groupsWithAccessCode: String,
    @SerializedName("groups_with_access_code_fr")
    val groupsWithAccessCodeFr: String,
    @SerializedName("hy_is_retail")
    val hyIsRetail: Any,
    @SerializedName("hy_pressures")
    val hyPressures: Any,
    @SerializedName("hy_standards")
    val hyStandards: Any,
    @SerializedName("hy_status_link")
    val hyStatusLink: Any,
    val id: Int,
    @SerializedName("intersection_directions")
    val intersectionDirections: String,
    @SerializedName("intersection_directions_fr")
    val intersectionDirectionsFr: Any,
    val latitude: Double,
    @SerializedName("lng_renewable_source")
    val lngRenewableSource: Any,
    @SerializedName("lng_vehicle_class")
    val lngVehicleClass: Any,
    val longitude: Double,
    @SerializedName("lpg_nozzle_types")
    val lpgNozzleTypes: Any,
    @SerializedName("lpg_primary")
    val lpgPrimary: Any,
    @SerializedName("ng_fill_type_code")
    val ngFillTypeCode: Any,
    @SerializedName("ng_psi")
    val ngPsi: Any,
    @SerializedName("ng_vehicle_class")
    val ngVehicleClass: Any,
    @SerializedName("open_date")
    val openDate: String,
    @SerializedName("owner_type_code")
    val ownerTypeCode: String,
    val plus4: Any,
    val state: String,
    @SerializedName("station_name")
    val stationName: String,
    @SerializedName("station_phone")
    val stationPhone: String,
    @SerializedName("status_code")
    val statusCode: String,
    @SerializedName("street_address")
    val streetAddress: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    val zip: String
)

data class HY(
    val total: Int
)

data class LNG(
    val total: Int
)

data class LPG(
    val total: Int
)


data class StationCounts(
    val fuels: Fuels,
    val total: Int
)

data class Stations(
    val total: Int
)

data class StationResponse(
    @SerializedName("fuel_stations")
    val fuelStations: List<FuelStation>,
    @SerializedName("station_counts")
    val stationCounts: StationCounts,
    @SerializedName("station_locator_url")
    val stationLocatorUrl: String,
    @SerializedName("total_results")
    val totalResults: Int
)