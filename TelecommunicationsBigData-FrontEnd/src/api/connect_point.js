import myAxios from "../utils/request.js";

// getDistribution
export const getDistribution = async (params) => {
    const res = await myAxios.request({
        url: "/connectPoint/distribution",
        method: "POST",
        data: params,
    });
    return res;
}

// getRank
export const getRank = async (params) => {
    const res = await myAxios.request({
        url: "/connectPoint/rank",
        method: "POST",
        data: params,
    });
    return res;
}


