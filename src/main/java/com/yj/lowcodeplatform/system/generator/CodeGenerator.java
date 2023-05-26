package com.yj.lowcodeplatform.system.generator;

import com.yj.lowcodeplatform.common.entity.BaseEntity;
import com.yj.lowcodeplatform.system.exception.GenericException;
import com.yj.lowcodeplatform.system.exception.ResultCodeInfoEnum;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/5/26 12:22
 */
@Component
public class CodeGenerator {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public CodeGenerator(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public String underlineToCamel(String key) {

        StringBuilder result = new StringBuilder();
        String[] keyArray = key.split("_");

        for (String keySplit : keyArray) {
            if (keySplit.length() == 0) {
                result.append(keySplit.toLowerCase());
            } else {
                result.append(keySplit.substring(0, 1).toUpperCase());
                result.append(keySplit.substring(1).toLowerCase());
            }
        }

        return result.toString();
    }

    public void generateEntity(String entityPath, String basePackage, String tableName, String className) {
//      1.编写sql语句来找到类的所有字段和信息
        String sql = "select column_name, column_type, column_comment from information_schema.columns where table_name = \"{}\" and table_schema = (select database()) ";

        MessageFormatter.format(sql, tableName);
//      2.对类信息进行整理，过滤掉BaseEntity中的字段
        Field[] baseEntityFields = BaseEntity.class.getDeclaredFields();
        List<EntityField> fields = jdbcTemplate.queryForList(sql).stream().map(this::buildFiledFromMap).filter(field -> {
            if ("id".equalsIgnoreCase(field.getName())) {
                return true;
            }

            for (Field declaredField : baseEntityFields) {
                if (declaredField.getName().equalsIgnoreCase(((EntityField) field).getName())) {
                    return true;
                }
            }
            return false;
        }).collect(Collectors.toList());

        Map<String, Object> params = Map.of("fields", fields, "className", className, "tableName", tableName, "basePackage", basePackage);

        generateClass(entityPath, "entity.java.ftl", className, params);
    }

    private void generateClass(String entityPath, String templateName, String className, Map<String, Object> params) {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        configuration.setDefaultEncoding("utf-8");
        configuration.setClassLoaderForTemplateLoading(CodeGenerator.class.getClassLoader(), entityPath);

        try {
            Template template = configuration.getTemplate(templateName);

            template.process(params, Files.newBufferedWriter(Path.of(entityPath + className)));

        } catch (IOException | TemplateException e) {
            throw new GenericException(ResultCodeInfoEnum.CODE_GENERATOR_ERROR, e);
        }
    }

    private void generate(String basePath, String tableName, String className) {
        String entityPath = "src/main/java" + "basePath" + "/entity/";
        String basePackage = pathToPackage(basePath);

        generateEntity(entityPath, basePackage, tableName, className);

        String controllerPath = "src/main/java" + "basePath" + "/controller/";
        generateController(controllerPath, basePackage, className);

        String servicePath = "src/main/java" + "basePath" + "/service/";
        generateService(servicePath, basePackage, className);

        String serviceImplPath = "src/main/java" + "basePath" + "/service/impl/";
        generateServiceImpl(serviceImplPath, basePackage, className);

        String daoPath = "src/main/java" + "basePath" + "/dao/";
        generateDao(daoPath, basePackage, className);

    }

    private void generateDao(String controllerPath, String basePackage, String className) {
        Map<String, Object> params = Map.of("className", className, "basePackage", basePackage);
        generateClass(controllerPath, "dao.java.ftl", className + "Dao", params);
    }

    private void generateServiceImpl(String serviceImplPath, String basePackage, String className) {
        Map<String, Object> params = Map.of("className", className, "basePackage", basePackage);
        generateClass(serviceImplPath, "serviceImpl.java.ftl", className + "ServiceImpl", params);

    }

    private void generateService(String servicePath, String basePackage, String className) {
        Map<String, Object> params = Map.of("className", className, "basePackage", basePackage);
        generateClass(servicePath, "service.java.ftl", className + "Service", params);
    }

    private void generateController(String controllerPath, String basePackage, String className) {
        Map<String, Object> params = Map.of("className", className, "basePackage", basePackage);
        generateClass(controllerPath, "controller.java.ftl", className + "Controller", params);

    }
    private String pathToPackage(String basePath) {
        return basePath.replace("src/main/java/", "").replace("/", ".");
    }

    private EntityField buildFiledFromMap(Map<String, Object> map) {
        return new EntityField((String) map.get("column_name"), EntityFieldTypeEnum.ofDatabaseType((String) map.get("column_type")).orElse(EntityFieldTypeEnum.VARCHAR), (String) map.get("column_comment"));
    }

}
