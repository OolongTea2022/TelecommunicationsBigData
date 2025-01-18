import myAxios from "../utils/request.js";

// getRank
export const getRank = async (params) => {
    const res = await myAxios.request({
        url: "/nwQuality/rank",
        method: "POST",
        data: params,
    });
    return res;
}


// getQualityStatistics
export const getQualityStatistics = async (params) => {
    const res = await myAxios.request({
        url: "/nwQuality/Statistics",
        method: "POST",
        data: params,
    });
    return res;
}


// getTypicalStatistics
export const getTypicalStatistics = async (params) => {
    const res = await myAxios.request({
        url: "/nwQuality/TypicalStatistics",
        method: "POST",
        data: params,
    });
    return res;
}



// getTypicalTracking
export const getTypicalTracking = async (params) => {
    const res = await myAxios.request({
        url: "/nwQuality/TypicalTracking",
        method: "POST",
        data: params,
    });
    return res;
}
