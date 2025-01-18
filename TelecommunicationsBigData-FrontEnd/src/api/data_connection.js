import myAxios from "../utils/request.js";

// getDistribution
export const getDistribution = async (params) => {
    const res = await myAxios.request({
        url: "/datalinks/Distribution",
        method: "POST",
        data: params,
    });
    return res;
}

// getStatistics
export const getStatistics = async (params) => {
    const res = await myAxios.request({
        url: "/datalinks/statistics",
        method: "POST",
        data: params,
    });
    return res;
}


