import myAxios from "../utils/request.js";

// 注册
export const userRegister = async (params) => {
    const res = await myAxios.request({
        url: "/user/register",
        method: "POST",
        data: params,
    });
    return res;
}


// 登录
export const userLogin = async (params) => {
    const res = await myAxios.request({
        url: "/user/login",
        method: "POST",
        data: params
    });
    return res;
}


// 登出
export const userLogout = async () => {
    const res = await myAxios.request({
        url: "/user/logout",
        method: "POST"
    });
    return res;
}
