package com.ws.config;

public class AlipayConfig {

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ APPID（填自己的，下面都是改过的~）
    public static String app_id = "2016092800613767";

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 生成公钥时对应的私钥（填自己的，下面都是改过的~）
    public static String private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDALglH3i49l0sPiJ9R2KKbd9vaURSVrfbek62hJNYFj0CgiAO2/xIIgbbI7vAyqAfE4+VG51A+kNHuXrYuKmTwr5PYXQvaLEuACychpeEDsUBHYNEMPcLwxUKKmPhvNCASYpQ+a2fI64pQorUyfzKFj2740f4YWDhkZXkpbXwend9OgkrlcM+8GKNXal4R8l5Bsi8f02cI9H92jCjsqV3EX9eePjjKBauWPSgtomRj10JNXb29zOQ3wUJvz4J0c/7RFVHrXmb2hMQCI7h6E/Pog4hBAqygvOWDNcrdCYWTjmEt39Fu0GHsL65pH2d9uzOt1q3gplv7cZtB5XAYqa1jAgMBAAECggEAdkNePrXBavGRpWuD75AK8PVffAftTPcTNoFWlhXfBujS8ncBIjnxVP7OBvTTJ7kznrxHucxbG0VviusJ3XsFRwAlUT5hLs+XXqJ+YDx+LhGD5ujzfD79mcEqY7QjHfvLyMSVSZw67+/S3DBkpUCVTI+p0MEZRs3zVgUD/LR9bzDScUP0JXkTASP1YsscHFL8mxzXystUn76f2SL2YnNHg3sRByZYGps/DWxC60z6Q0uthSIAIMaGhGeM9IcnVrCqyZN2l4mT4pCa96ULnphAXZLCVWZn8Iey3F3rw65KPXULmEgMgixbcWD4qFFas0nNhrtQwJilZ1MzPeX7/d1+EQKBgQDqjXYBmMH1JDh6fF/TFnEpS2vgXO0FNj3X00Nnct8RWcleuSkdcstqUSxHm+8b5bua34EZiGGmrvoAhwjjf8S+Tnfi/dwxpFth1JnuYBFyCvU1ZkjLu52OGy4O+UXcbpFE20n08W55OvlRhO8yKUyME69gfkVui7hRRB6Ss8h3zwKBgQDRwLCkmEaL61qDYXsbJ0ihgYHRO5ywlyOvMWpMuJvIhTtA6EkfwK21Nh2BwEEn0DIrlOph5XkBq5NdAB8r1g0FxIb2LUAe0vO1/YzQy1aLORToH9Jb8bsqvnehETAHKs7EKIP7OT3Rmen2aDGPbIzQP77F0yeLfh3LON2QjPMCLQKBgA108EBHM1mNKnBckmLZ9sQXv6ivrCmQYxvu0v8sZ//m1tbIaMN3wpPm9FNnbuB63biU+iMs3+1gPJerJ6dlvTPt7JLpXai7dUK3n909RcL1PfxCUgreSLvOc2YIhymObmc07ZlQALaT25oBtnd6RxoCRx2SIQmmmnyPG/HuvqGhAoGAG0zrMOEo/XkqlMMRVN1uFKdYkDUkFc/2Mw1Jeqbkj9rXdYFGUz2u3lEm0gaF9HqirQ163DcT4uXEDmy/oeMAWunTbyNAn0JxuhRAScTNhN1vHS9XH+R8qfmUdIBaMfSeaOWlGAPBShCwZQP2v2YvhcNmPzVWhk9p7VN/cxsFXhkCgYAxh7earLjChuwbGHHik8rAPgjtQZ3zLknDib9bqRbb1inMFlYetMZNs84q0uGJVMnTqdXEQD+bdN6NArkKY1l53QHpA7OD3ZxNjQcgYk2RIEbJq2rBKCSRSDEKYW09iC7KST/p6KTn6iXDsAAYP82jz8k/XKpGO/SzsPJMiUXYeg==";

    //Controller Mapping:得放到服务器上，且使用域名解析 IP
    public static String notify_url = "http://localhost:8080/alipay/alipayReturnNotice.action";

    //Controller Mapping:得放到服务器上，且使用域名解析 IP
    public static String return_url = "http://localhost:8080/alipay/alipayReturnNotice.action";

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 支付宝网关（注意沙箱alipaydev，正式则为 alipay）
    public static String url = "https://openapi.alipaydev.com/gateway.do";

    public static String charset = "UTF-8";

    public static String format = "json";

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 公钥（填自己的，下面都是改过的~）
    public static String public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwC4JR94uPZdLD4ifUdiim3fb2lEUla323pOtoSTWBY9AoIgDtv8SCIG2yO7wMqgHxOPlRudQPpDR7l62Lipk8K+T2F0L2ixLgAsnIaXhA7FAR2DRDD3C8MVCipj4bzQgEmKUPmtnyOuKUKK1Mn8yhY9u+NH+GFg4ZGV5KW18Hp3fToJK5XDPvBijV2peEfJeQbIvH9NnCPR/dowo7KldxF/Xnj44ygWrlj0oLaJkY9dCTV29vczkN8FCb8+CdHP+0RVR615m9oTEAiO4ehPz6IOIQQKsoLzlgzXK3QmFk45hLd/RbtBh7C+uaR9nfbszrdat4KZb+3GbQeVwGKmtYwIDAQAB";

    public static String signtype = "RSA2";


}
