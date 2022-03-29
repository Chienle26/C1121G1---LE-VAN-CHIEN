package service;

public class Regex {
    public static final String NAME_VIETNAM = "^[\\p{Lu}\\p{Ll}\\s]+$";
    public static final String EMAIL = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,}){1,}$";
    public static final String NUMBER = "^[0-9]+$";
    public static final String SO_THUC = "^[0]?[1-9]+[0-9]*([\\.]([0-9]+))?$";
    public static final String SO_DUONG = "^([0]*[1-9][0-9]*)|[1-9][0-9]*$";

    public static final String SDT_VN = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
    public static final String DATE_LEAP_YEAR = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    public static final String SO_THE_TIN_DUNG = "^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$";
    public static final String YYYY_MM_DD = "^\\d{4}[-]?((((0[13578])|(1[02]))[-]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[-]?(([0-2][0-9])|(30)))|(02[-]?[0-2][0-9]))$";
    public static final String YYYY_MM_DD2 = "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$";

    public static final String MA_KHACH_HANG = "^(KH-)[0-9]{4}$";
    public static final String MA_DICH_VU = "^(DV-)[0-9]{4}$";
    public static final String SO_DIEN_THOAI = "^((090)|(091)|([(](84)[)][+]90)|([(](84)[)][+]91))[0-9]{7}$";
    public static final String SO_CMND = "^[0-9]{9}$";

    /*
    //RegEX tên lớp học codegym:
    public static final String COGEGYM_NAME_CLASS =  "^[CA]((0[1-9])|(1[0-2]))\d{2}[GI]\d{1}$";


    public static final String EMAIL = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,}){1,}$";

    public static final String SDT_VN = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";

    public static final String DATE_LEAP_YEAR = "^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[13-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$";


    // tên vn
    public static final String VIETNAMESE_NAME_REGEX = "^[\p{Lu}\p{Ll}]+( [\p{Lu}\p{Ll}]+)*$";

    // tên không dấu
    public static final String NAME_REGEX = "^\w+( \w+)*$";

    // căn cước regex
    public static final String ID_CARD_REGEX = "^((\d{9})|(\d{12}))$";

    // số thực (tiền)
    public static final String REAL_NUMBER_REGEX = "^[0]*[1-9]+[0-9]*([\.]([0-9]+))?$";

    // số dương
    public static final String POSITIVE_NUMBER_REGEX = "^\d+(\.\d+)*$";

    // regex số thực hồ bơi > 30                                         v
    public static final String REGEX_AREA_POOL = "^([3-9]\d|[1-9]\d{2,})(.?[0-9]+)?$";

    // regex số nguyên dương
    public static final String INTEGER_REGEX = "^[0]?[1-9]+[0-9]*$";

    //vn phone number
    public static final String VIETNAM_PHONE_NUMBER_REGEX ="^(090\d{7})|(091\d{7})|(\(\+84\)90\d{7})|(\(\+84\)91\d{7})$";

    // color regex  (red, Blue, Green)
public static final String COLOR_REGEX = "^\w+(, \w+)*$"
Color cannot have any extra spaces or no characters
     */
}
