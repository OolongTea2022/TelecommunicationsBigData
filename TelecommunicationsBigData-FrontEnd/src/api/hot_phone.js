import myAxios from "../utils/request.js";

// getDistribution
export const getDistribution = async (params) => {
    const res = await myAxios.request({
        url: "/popularMobile/distribution",
        method: "POST",
        data: params,
    });
    return res;
}


// getOSDistribution
export const getOSDistribution = async (params) => {
    const res = await myAxios.request({
        url: "/popularMobile/osDistribution",
        method: "POST",
        data: params,
    });
    return res;
}


// getOSTrafficRank
export const getOSTrafficRank = async (params) => {
    const res = await myAxios.request({
        url: "/popularMobile/osTrafficRank",
        method: "POST",
        data: params,
    });
    return res;
}



// getQualityRank
export const getQualityRank = async (params) => {
    const res = await myAxios.request({
        url: "/popularMobile/qualityRank",
        method: "POST",
        data: params,
    });
    return res;
}


// getTrafficDistribution
export const getTrafficDistribution = async (params) => {
    const res = await myAxios.request({
        url: "/popularMobile/trafficDistribution",
        method: "POST",
        data: params,
    });
    return res;
}



// getTrafficRank
export const getTrafficRank = async (params) => {
    const res = await myAxios.request({
        url: "/popularMobile/trafficRank",
        method: "POST",
        data: params,
    });
    return res;
}
