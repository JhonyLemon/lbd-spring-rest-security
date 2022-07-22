package pl.fissst.lbd.restsecurity.security;

public enum Permissions {

    DECIMAL_READ,
    DECIMAL_WRITE,
    MULTIPLIER_READ,
    MULTIPLIER_WRITE,
    ACCESS_ALL;

    public static String getName(Permissions permissions){
        return permissions.name();
    }

}
