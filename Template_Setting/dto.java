##引入宏定义
$!define

##使用宏定义设置回调（保存位置与文件后缀）
#save("/dto", ".java")

##使用宏定义设置包后缀
#setPackageSuffix("dto")

##使用全局变量实现默认包导入
$!autoImport
import java.io.Serializable;
import lombok.Data;
##使用宏定义实现类注释信息
#tableComment("接收类")
@Data
public class $!{tableInfo.name}Dto implements Serializable {
    private static final long serialVersionUID = $!tool.serial();
#foreach($column in $tableInfo.fullColumn)
    #if(${column.comment})/**
    * ${column.comment}
    */#end

    private $!{tool.getClsNameByFullName($column.type)} $!{column.name};
#end
    private String access_token;
}