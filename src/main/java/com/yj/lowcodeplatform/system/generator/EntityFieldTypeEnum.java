package com.yj.lowcodeplatform.system.generator;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote mysql数据库类型对应java类型
 * 类型名称	        JAVA类型
 * 字符串相关
 * VARCHAR	        java.lang.String
 * CHAR	        java.lang.String
 * BLOB	        java.lang.byte[]
 * TEXT	        java.lang.String
 * ID	            java.lang.Long
 * 整数相关
 * INT             java.lang.Integer
 * INTEGER	        java.lang.Integer
 * BIGINT	        java.math.BigInteger
 * TINYINT	        java.lang.Integer
 * SMALLINT	    java.lang.Integer
 * MEDIUMINT	    java.lang.Integer
 * 浮点数相关
 * FLOAT	        java.lang.Float
 * DOUBLE	        java.lang.Double
 * DECIMAL	        java.math.BigDecimal
 * bool
 * BOOLEAN         java.lang.Boolean
 * BIT	            java.lang.Boolean
 * 时间相关
 * DATE	        java.sql.Date
 * TIME	        java.sql.Time
 * DATETIME        java.sql.Timestamp
 * TIMESTAMP	    java.sql.Timestamp
 * YEAR	        java.sql.Date
 * @since 2023/5/26 12:53
 */
@Getter
@AllArgsConstructor
public enum EntityFieldTypeEnum {
    VARCHAR("varchar", "java.lang.String"),
    CHAR("char", "java.lang.String"),
    BLOB("blob", "java.lang.byte[]"),
    TEXT("text", "java.lang.String"),

    ID("id", "java.lang.Long"),
    INT("int", "java.lang.Integer"),
    INTEGER("integer", "java.lang.Integer"),
    BIGINT("bigint", "java.math.BigInteger"),
    TINYINT("tinyint", "java.lang.Short"),
    SMALLINT("smallint", "java.lang.Byte"),
    MEDIUMINT("mediumint", "java.lang.Integer"),

    FLOAT("float", "java.lang.Float"),
    DOUBLE("double", "java.lang.Double"),
    DECIMAL("decimal", "java.math.BigDecimal"),

    BOOLEAN("boolean", "java.lang.Boolean"),
    BIT("bit", "java.lang.Boolean"),

    DATE("date", "java.time.LocalDate"),
    TIME("time", "java.time.LocalTime"),
    DATETIME("datetime", "java.time.LocalDateTime"),
    TIMESTAMP("timestamp", "java.time.LocalDateTime"),
    YEAR("year", "java.time.LocalDateTime"),
    ;

    private final String databaseType;

    private final String javaType;


    public static Optional<EntityFieldTypeEnum> ofDatabaseType(String databaseType) {
        for (EntityFieldTypeEnum entityFieldType : EntityFieldTypeEnum.values()) {
            if (entityFieldType.databaseType.equalsIgnoreCase(databaseType)) {
                return Optional.of(entityFieldType);
            }
        }

        return Optional.empty();
    }

    public static Optional<EntityFieldTypeEnum> ofJavaType(String javaType) {
        for (EntityFieldTypeEnum entityFieldType : EntityFieldTypeEnum.values()) {
            if (entityFieldType.javaType.equalsIgnoreCase(javaType)) {
                return Optional.of(entityFieldType);
            }
        }

        return Optional.empty();
    }


//    用来处理生成我们的枚举单例
//    public static void main(String[] args) {
//        String s = "VARCHAR\t        java.lang.String\n" +
//                "CHAR\t        java.lang.String\n" +
//                "BLOB\t        java.lang.byte[]\n" +
//                "TEXT\t        java.lang.String\n" +
//                "ID\t            java.lang.Long\n" +
//                "INT             java.lang.Integer\n" +
//                "INTEGER\t        java.lang.Integer\n" +
//                "BIGINT\t        java.math.BigInteger\n" +
//                "TINYINT\t        java.lang.Integer\n" +
//                "SMALLINT\t    java.lang.Integer\n" +
//                "MEDIUMINT\t    java.lang.Integer\n" +
//                "FLOAT\t        java.lang.Float\n" +
//                "DOUBLE\t        java.lang.Double\n" +
//                "DECIMAL\t        java.math.BigDecimal\n" +
//                "BOOLEAN         java.lang.Boolean\n" +
//                "BIT\t            java.lang.Boolean\n" +
//                "DATE\t        java.sql.Date\n" +
//                "TIME\t        java.sql.Time\n" +
//                "DATETIME        java.sql.Timestamp\n" +
//                "TIMESTAMP\t    java.sql.Timestamp\n" +
//                "YEAR\t        java.sql.Date";
//
//        String[] split = s.split("\n");
//
//        for (String s1 : split) {
//            String o1 = null;
//            String o2 = null;
//            List list = Collections.arrayToList(s1.trim().split(" "));
//            for (Object o : list) {
//                if (StringUtils.isNotBlank((String) o)) {
//                    if (StringUtils.isBlank(o1)) {
//                        o1 = ((String) o).trim();
//                    } else {
//                        o2 = ((String) o).trim();
//                        System.out.println(String.format("%s(\"%s\",\"%s\"),", o1, o1.toLowerCase(), o2));
//                        o1 = null;
//                        o2 = null;
//                    }
//                }
//            }
//
//
////            System.out.println(String.format("%s(\"%s\",\"%s\")", result, result.toLowerCase(), "result"));
//        }
//
//    }

}
