package org.kodluyoruz.group1.library.model.enums;

public enum LanguagesEnum {

    TURKISH(1,"Türkçe"),
    DANISH(2, "Danimarkaca"),
    FINNISH(3, "Fince"),
    FRENCH(4 ,"Fransızca"),
    GERMAN(5 ,"Almanca"),
    GREEK(6 ,"Yunanca"),
    ARABIC(7 ,"Arapça"),
    ITALIAN(8 ,"İtalyanca"),
    DUTCH(9 ,"Almanca"),
    PORTUGUESE(10 ,"Portekizce"),
    SPANISH(11 ,"İspanyolca"),
    ENGLISH(12 ,"İngilizce"),
    ICELANDIC(13 ,"İzlandaca"),
    NORWEGIAN(14 ,"Norveççe"),
    BULGARIAN(15 ,"Bulgarca"),
    CZECH(16 ,"Çekce"),
    ESTONIAN(17 ,"Estonyaca"),
    HUNGARIAN(18 ,"Macarca"),
    IRISH(19 ,"İrlandaca"),
    OTHER(20 ,"Diğer");

    private final Integer id;
    private final String value;

    LanguagesEnum(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
