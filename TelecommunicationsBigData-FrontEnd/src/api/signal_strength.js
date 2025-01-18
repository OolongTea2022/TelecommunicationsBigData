import myAxios from "../utils/request.js";

// getDistribution
export const getDistribution = async (params) => {
    const res = await myAxios.request({
        url: "/SignalStrength/Distribution",
        method: "POST",
        data: params,
    });
    return res;
}


// getTypicalSignalStrengthTrackingByLandmark
export const getTypicalSignalStrengthTrackingByLandmark = async (params) => {
    const res = await myAxios.request({
        url: "/SignalStrength/TypicalSignalStrengthStatistics",
        method: "POST",
        data: params
    });
    return res;
}


// getTypicalSignalStrengthTracking
export const getTypicalSignalStrengthTracking = async (params) => {
    const res = await myAxios.request({
        url: "/SignalStrength/TypicalSignalStrengthTracking",
        method: "POST",
        data: params
    });
    return res;
}
