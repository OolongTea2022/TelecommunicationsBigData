import myAxios from "../utils/request.js";

// getDistribution
export const userRegister = async (params) => {
    const res = await myAxios.request({
        url: "/SignalStrength/Distribution",
        method: "POST",
        data: params,
    });
    return res;
}


// getTypicalSignalStrengthTrackingByLandmark
export const userLogin = async (params) => {
    const res = await myAxios.request({
        url: "/SignalStrength/TypicalSignalStrengthStatistics",
        method: "POST",
        data: params
    });
    return res;
}


// getTypicalSignalStrengthTracking
export const userLogout = async (params) => {
    const res = await myAxios.request({
        url: "/SignalStrength/TypicalSignalStrengthTracking",
        method: "POST",
        data: params
    });
    return res;
}
