##导入宏定义
$!define

##保存文件（宏定义）
#save("/entity", ".java")

##包路径（宏定义）
#setPackageSuffix("entity")

##自动导入包（全局变量）
$!autoImport

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
##使用宏定义实现类注释信息
#tableComment("表实体类")
@Data
@ApiModel(value="${tableInfo.name}对象", description="${tableInfo.comment}")
public class $!{tableInfo.name} implements Serializable {
    private static final long serialVersionUID = $!tool.serial();
#foreach($column in $tableInfo.fullColumn)
    #if(${column.comment})/**
    * ${column.comment}
    */#end
    
    @ApiModelProperty(value = " ${column.comment}")
    private $!{tool.getClsNameByFullName($column.type)} $!tool.firstLowerCase($!{column.name});
#end

###foreach($column in $tableInfo.fullColumn)
####使用宏定义实现get,set方法
###getSetMethod($column)
###end

}