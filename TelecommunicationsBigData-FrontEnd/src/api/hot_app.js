import myAxios from "../utils/request.js";

// getAppUserDistribution
export const getAppUserDistribution = async (params) => {
    const res = await myAxios.request({
        url: "/popularapp/getAppUserDistribution",
        method: "POST",
        data: params,
    });
    return res;
}

// getPopularAppDistribution
export const getPopularAppDistribution = async (params) => {
    const res = await myAxios.request({
        url: "/popularapp/getPopularAppDistribution",
        method: "POST",
        data: params,
    });
    return res;
}

// getPopularAppTrafficDistribution
export const getPopularAppTrafficDistribution = async (params) => {
    const res = await myAxios.request({
        url: "/popularapp/getPopularAppTrafficDistribution",
        method: "POST",
        data: params,
    });
    return res;
}


// getTrafficRank
export const getTrafficRank = async (params) => {
    const res = await myAxios.request({
        url: "/popularapp/getTrafficRank",
        method: "POST",
        data: params,
    });
    return res;
}

// getTrafficTracking
export const getTrafficTracking = async (params) => {
    const res = await myAxios.request({
        url: "/popularapp/getTrafficTracking",
        method: "POST",
        data: params,
    });
    return res;
}

// getTypicalLandmarkAppTrafficRank
export const getTypicalLandmarkAppTrafficRank = async (params) => {
    const res = await myAxios.request({
        url: "/popularapp/getTypicalLandmarkAppTrafficRank",
        method: "POST",
        data: params,
    });
    return res;
}
